package diagnosticos;

import biblioteca.archivos.Manager;
import historias.Historia;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import personas.pacientes.Pacientitos;

/* VER documento Sangre.docx
 * 
*/
public class DiagSangre extends Manager{
   // VARIABLES DE CLASE
   String tipo;
   DiagSangre DS;
   int pos;
   //****** MEtODOS CONSTRUCTORES ******
   //------ MC FINAL ---------
   DiagSangre(String tipo,String rh){
      this.tipo=tipo+rh;
   }
   //------ MC POR OMISION ---------
   public DiagSangre(){
      //this("","");
   }//------ MC INTERMEDIO -----------
   DiagSangre(JComboBox tipo, JComboBox rh){
      this(
         tipo.getSelectedItem().toString(),
         rh.getSelectedIndex()==1?"+":"-"
      );
   }
   public void diagSangre(JComboBox tipo, JComboBox rh, JTextField DNI){
      DS= new DiagSangre(tipo,rh);
      graba(DNI);
   }
   //****** METODOS PARTICULARES *******
   // -------- Determina + si es Positivo o - si es negativo
   String dameRh(JComboBox rh){
      String X="+";
      if(rh.getSelectedIndex()==2)X="-";
      return X;
   }
   // ---------- CARGA COMBOS ---------------
   public void cargaCombos(JComboBox tipo, JComboBox rh){
      String item1[]={"Tipo?","A","B ","AB","O "};
      cargaCombos(tipo,item1);
      String item2[]={"Rh?","Positivo","Negativo"};
      cargaCombos(rh,item2);
   }
   // ---------- VERIFICA ERRORES ---------------
   public boolean errores(JComboBox tipo, JComboBox rh){
      JComboBox JCB[]=new JComboBox[2];
      JCB[0]=tipo;JCB[1]=rh;
      String men[]={"TIPO","Rh"};
      return mensaError(error(JCB,men));
   }
   private void graba(JTextField DNI){
      Pacientitos P=new Pacientitos();
      Historia H=new Historia(DNI);
      H.creaHistoria(P.PA[pos]);
      H.agrega(1,DS.tipo);
   }
   public void grabar(JTextField DNI){
      graba(DNI);
   }
   
   public void veriDatos(JTextField DNI,JTextField paciente){
      Pacientitos PP=new Pacientitos();
         pos = PP.hallarDNI(DNI);
         if (pos < 0)mensaje("ErBD: No EXISTE DNI "+DNI.getText());
         else{
            String pac=PP.PA[pos].apeNom;
            paciente.setText(pac);
            paciente.setEnabled(true);
         }
   }
}
