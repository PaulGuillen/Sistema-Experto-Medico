package personas.usuarios;

import javax.swing.*;
import personas.Persona;


public class User extends Persona{
   public String logName,psw, tipoUser,estado;
   public String data;
   private String TU[]={"Administrador","Supervisor","Operador","Invitado"};
   private String EST[]={"Activo","Inactivo"};
   User(String dni,String apeNom,String logName, String psw, String tipoUser, String estado){
      this.dni=dni;
      this.apeNom=apeNom;
      this.logName=logName;
      this.psw=psw;
      this.tipoUser=tipoUser;
      this.estado=estado;
      this.data=data()+s+logName+s+psw+s+tipoUser+s+estado;
   }
   public User(){
      this("","","","","","");
   }
   public User(JTextField code, JTextField apeNom, JTextField logName, 
      JTextField psw, JComboBox tipoUser, JComboBox estado){
      this(code.getText(),apeNom.getText(),logName.getText(),psw.getText(),
         ""+tipoUser.getSelectedIndex(),""+estado.getSelectedIndex());
   }
   public String datos(){
      return dato()+"\nNombre de logeo: "+logName+"\nContraseña: "+psw;
   }
   public String TipoUser(int i){
      return TU[i];
   }
   public void cargaTipoUser(JComboBox tu){
      tu.removeAllItems();
      tu.addItem("Tipo Usuario?");
      for(int i=0;i<TU.length;i++)tu.addItem(TU[i]);
   }
   public void cargaEstado(JComboBox est){
      est.removeAllItems();
      est.addItem("Estado?");
      for(int i=0;i<EST.length;i++)est.addItem(EST[i]);
   }
   private void carga(String que){
      String cosa="";
      int numCampo=0;
      data=que;
      for(int i=0; i<que.length();i++){
         if(que.charAt(i) != s){
            cosa+=que.charAt(i);
            if(i+1 == que.length()) estado=cosa;
         }else{
            numCampo++;
            switch(numCampo){
               case 1: dni=cosa; break;
               case 2: apeNom=cosa; break;
               case 3: logName=cosa;break;
               case 4: psw=cosa; break;
               case 5: tipoUser=cosa; break;
            }
            cosa="";
         }
      }
   }
   public void cargaData(String que){
      carga(que);
   }
   private String datos(int i){
      String XX="";
      switch(i){
         case 1: XX=dni; break;
         case 2: XX=apeNom; break;
         case 3: XX=logName;break;
         case 4: XX=psw; break;
         case 5: XX=dameTipoUser();break;//tipoUser; break;
         case 6: XX=dameEstado();
      }
      return XX;
   }
   public String dato(int i){
      return datos(i);
   }
   public String dameTipoUser(){
      int tipo=Integer.parseInt(tipoUser);
      return TU[tipo-1];
   }
   public String dameEstado(){
      return EST[Integer.parseInt(estado)-1];
   }
   
}
