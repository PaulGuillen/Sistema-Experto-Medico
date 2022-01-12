/*
 * Genera historia de un paciente.
 */
package historias;

import biblioteca.archivos.Manager;
import javax.swing.JTextField;



public class Historia extends Manager{
   public String historia, dni;
   private int N=100;
   String que[]= new String [N];
   Historia(String dni){
      this.dni=dni;
      this.historia = "HC" + dni;
      for(int i=0; i<N; i++){
         que[i]="-";
      }
   }
   public Historia(JTextField DNI){
      this(DNI.getText());
   }
   public void creaHistoria(personas.pacientes.Paciente P){
      historia="HC"+P.dni;
      if(!veriArch(5,historia)){
         que[0] = "\nFECHA DE FILIACION: "+fechaHoy()+"\n\n"+P.datos();
         grabaRegistros(5, historia, que);
      }else {
         leeRegistros(5,historia);
         System.arraycopy(cosa, 0, que, 0, 100);
      }
   }
   
   public void agrega(int cual, String xx){
      switch(cual){
         case 1: que[1]="\nFecha: "+fecha()+"\tTipo de Sangre: "+xx+"\n"; break;
         case 2: que[2]="\nFecha: "+fecha()+"\tHemograma - Hematies: "+xx+"\n"; break;
         case 3: que[3]="\nFecha: "+fecha()+"\tExamen Fisico: "+xx+"\n"; break;
      }
      grabaRegistros(5, historia, que);
   }
}
