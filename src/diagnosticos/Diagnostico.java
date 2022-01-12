package diagnosticos;

import javax.swing.*;


public class Diagnostico {
   String dni,posibles,dato;
   private char s='~';
   Diagnostico(String dni, String posibles){
      this.dni=dni; this.posibles=posibles;
      this.dato=dni+s+posibles;
   }
   Diagnostico(){
      this("","");
   }
   Diagnostico(JTextField DNI, JTextArea POSIB){
      this(DNI.getText(),POSIB.getText());
   }
   
}
