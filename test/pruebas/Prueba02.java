package pruebas;

import enferm_y_sintomas.Sintomas_Enfermedades;


public class Prueba02 {
   public static void main(String a[]){
      Sintomas_Enfermedades SE= new Sintomas_Enfermedades();
      int largo=0;
      for(int i=0; i<SE.N2;i++){
         System.out.println(SE.SE[i].nom);
         int lon=SE.SE[i].nom.length();
         if(lon>largo)largo=lon;
      }
      SE.mensaje(""+largo);
   }
}
