package enferm_y_sintomas;

import javax.swing.JTextField;


public class Super_Sint_Enf {
   public String cod,nom;
   private char ss='~';//separador de campos
   public char s=ss;
   //********** METODOS AUXILIARES *************
   //Codificación segun nom
   String codifica(String nom){
      return ""+nom.hashCode();
   }
   
   
}
