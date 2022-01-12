package diagnosticos;

import biblioteca.archivos.*;
import javax.swing.*;


public class Diagnosticar extends Manager{
   Diagnostico DS[];
   int N;
   int numArch=7;
   public Diagnosticar(){
      
   }
   void exporta(JTextField dni, JComboBox apeNom, JTextArea salida){
      Exporta(apeNom.getSelectedItem().toString(),salida);
   }
}
