package enferm_y_sintomas;

import javax.swing.JTextField;

public class Sintoma extends Super_Sint_Enf{
   int cant;
   //********** METODOS CONSTRUCTORES ***************
   Sintoma(String nom){//Para sintoma
      this.cod=codifica(nom.toUpperCase());
      this.nom=nom.toUpperCase();
      this.cant=0;
   }
   
   public Sintoma(){
      this("");
   }
   Sintoma(JTextField nom){
      this(nom.getText());
   }
   //********** METODOS AUXILIARES *************
   //Registro para grabar en base de datos
   String data(){
      return cod+s+nom+s+cant;
   }
   //Desglosa el registro en campos
   private void carga(String que){
      String cosaX="";
      int numCampo=0;
      for(int i=0; i<que.length();i++){
         if(que.charAt(i) != s){
            cosaX+=que.charAt(i);
            if(i+1 == que.length()) cant=Integer.parseInt(cosaX);
         }else{
            numCampo++;
            switch(numCampo){
               case 1: cod=cosaX; break;
               case 2: nom=cosaX; break;
            }
            cosaX="";
         }
      }
   }
   public void cargaData(String que){
      carga(que);
   }
   
   public String dato(int i){
      String dat=cod;
      switch(i){
         case 2: dat = nom; break;
         case 3: dat = ""+cant;
      }
      return dat;
   }
}
