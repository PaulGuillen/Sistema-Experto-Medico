package enferm_y_sintomas;

import javax.swing.JTextField;

public class Enfermedad extends Super_Sint_Enf {
   //********** METODOS CONSTRUCTORES ***************
   Enfermedad(String nom){
      this.cod=codifica(nom.toUpperCase());
      this.nom=nom.toUpperCase();
   }
   Enfermedad(String enf, String sin){//METODO enlace Enfermedad-Sintoma
      this.cod=enf;
      this.nom=sin;
   }
   public Enfermedad(){
      this("");
   }
   Enfermedad(JTextField nom){
      this(nom.getText());
   }
   //********** METODOS AUXILIARES *************
  //Registro para grabar en base de datos
   String data(){
      return cod+s+nom;
   }
   //Desglosa el registro en campos
   private void carga(String que){
      String cosaX="";
      int numCampo=0;
      //data=que;
      for(int i=0; i<que.length();i++){
         if(que.charAt(i) != s){
            cosaX+=que.charAt(i);
            if(i+1 == que.length()) nom=cosaX;
         }else{
            numCampo++;
            switch(numCampo){
               case 1: cod=cosaX; break;
            }
            cosaX="";
         }
      }
   }

   public void cargaData(String que){
      carga(que);
   }

   
   
}
