package diagnosticos;

import biblioteca.archivos.Manager;
import javax.swing.JTextField;
import personas.pacientes.Pacientitos;

/*VER Hemograma.docx
 * 
 * 
 */
public class DiagHemograma extends Manager{
      // VARIABLES DE CLASE
   float GR,HB,FR;
   int HTO,VCM,HCM,GBL,GB,GBN,GBE,PQT,SVG;
   float LI=0,LS=0; //NIVELES Limite Inferior, Limite Superior
   int nA; //numero de Analisis 
   int pos; // posicion dentro de la BD del paciente
   String texto="";//Para grabar en la historia
   //****** MEtODOS CONSTRUCTORES ******
   //------ MC POR OMISION ---------
   public DiagHemograma(){
      
   }//------ MC INTERMEDIO -----------
   void GR(JTextField gr){
      GR=Float.valueOf(gr.getText());
      nA=2;
   }
   void HB(JTextField gr){
      this.HB=Float.valueOf(gr.getText());
   }
   //****** METODOS PARTICULARES *******
   public void veriDatos(JTextField DNI,JTextField paciente){
      Pacientitos PP=new Pacientitos();
         pos = PP.hallarDNI(DNI);
         if (pos < 0)mensaje("ErBD: No EXISTE DNI "+DNI.getText());
         else{
            paciente.setText(PP.PA[pos].apeNom);
            paciente.setEnabled(true);
         }
   }
}
