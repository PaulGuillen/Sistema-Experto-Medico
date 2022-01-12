package personas.pacientes;

import biblioteca.archivos.Manager;
import historias.Historia;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * public Paciente(JTextField code, JTextField apeNom, JTextField direc,
 * JTextField fono,JTextField ubigeoNac, JTextField ubigeoDom, String fechaNac,
 * JTextField numHijos, JComboBox sexo, JComboBox estCiv, String grupSangre)
 */
public class Pacientitos extends Manager{
   public Paciente P=new Paciente();
   int N=0;
   private int numArch=4;//número de archivo en Manager
   public Paciente PA[];//=new Paciente();
   //private biblioteca.ubigeo.Peru UP =new biblioteca.ubigeo.Peru();
   public Pacientitos(){
      cargaDatos();
   }
   // ----- Manejan Base de Datos
   void cargaDatos(){
      if(!veriArch(numArch)){
         N=0;
        String que[] = new String[0];
        grabaRegistros(numArch,que);//Metodo heredado de Manager
      }else{
        leeRegistros(numArch);//Metodo heredado de Manager
        N=numReg;
        PA=new Paciente[N];
        for(int i=0; i<N; i++){
           PA[i]=new Paciente();
           PA[i].cargaData(cosa[i]);
        }
     }
   }
   //********** PROCESOS DE MANTENIMIENTO
   /* FORMA CLASICA
      boolean err=false;
      String mensa="";
      if(ubigeoNac.getText().isEmpty())mensa+="\nERIO: No selecciono Ubigeo de Nacimiento";
      if(apeNom.getText().isEmpty())mensa+="\nERIO: No ingreso Apellidos y Nombres";
      if(fechaNac.getText().isEmpty())mensa+="\nERIO: No ingreso Fecha de Nacimiento";
      if(sexo.getSelectedIndex()<1)mensa+="\nERIO: No Selecciono Sexo";
      if(ubigeoDom.getText().isEmpty())mensa+="\nERIO: No selecciono Ubigeo de Domicilio";
      if(dire.getText().isEmpty())mensa+="\nERIO: No ingreso Direccion";
      if(estCiv.getSelectedIndex()<1)mensa+="\nERIO: No Selecciono Estado Civil";
      if(mensa.length()>1){
         err=true;
         mensaje(mensa);
      }
      return err;
   */
   // ------------ Errores
   boolean errorIng( JTextField ubigeoNac, JTextField apeNom, 
      JTextField fechaNac, JComboBox sexo, JTextField ubigeoDom, JTextField dire,
      JComboBox estCiv){
      JTextField JTF[]={ubigeoNac,apeNom,fechaNac,ubigeoDom,dire};
      String queTF[]={"Seleccion de Ubigeo de Nacimiento","Apellidos y Nombres",
      "Fecha de Nacimiento","Seleccion de Ubigeo de Domicilio","Direccion"};
      JComboBox JCB[]={sexo,estCiv};
      String queCB[]={"SEXO","ESTADO CIVIL"};
      return mensaError(error(JCB,queCB)+error(JTF,queTF));
   }
   //--------- BUSQUEDA -------------
   int hallarDNI(String DNI){
      cargaDatos();
      int pos=-1;
      for(int i=0; i<N; i++){
         if(PA[i].dni.equals(DNI)){
            pos=i; break;
         }
      }
      return pos;
   }
   public int hallarDNI(JTextField DNI){
      return hallarDNI(DNI.getText());
   }

   //....... iniciar BEANS
   public void iniciar(JTextField ubigeoNac, JTextField ubigeoDom, JTextField fechaNac,
      JTextField dni, JTextField edad, JTextField apeNom,JTextField direc,
      JTextField numHijos, JTextField fono, JComboBox estCiv){
      ubigeoNac.setEditable(false); ubigeoNac.setEnabled(false);
      ubigeoNac.setBackground(Color.yellow); ubigeoNac.setText("");
      ubigeoDom.setEditable(false); ubigeoDom.setEnabled(false);
      ubigeoDom.setBackground(Color.yellow); ubigeoDom.setText("");
      fechaNac.setEditable(false); fechaNac.setEnabled(false);
      fechaNac.setBackground(Color.yellow); fechaNac.setText("");
      dni.setEditable(true); dni.setBackground(Color.white);
      dni.setText(""); 
      edad.setEditable(false);
      edad.setEnabled(false);
      edad.setBackground(Color.yellow);
      edad.setText("");
      apeNom.setEnabled(false);
      apeNom.setText("");
      direc.setEnabled(false);
      direc.setText("");
      numHijos.setEnabled(false);
      numHijos.setText("");
      fono.setEnabled(false);
      fono.setText("");
      estCiv.setSelectedIndex(0);
   }
   //---------- INGRESAR
   void ingresar(JTextField dni, JTextField ubigeoNac, JTextField apeNom, 
      JTextField fechaNac, JComboBox sexo, JTextField ubigeoDom,
      JTextField dire, JComboBox estCiv, JTextField numHijos, JTextField fono,
      JTextField edad){
      if(!errorIng(ubigeoNac, apeNom, fechaNac, sexo, ubigeoDom, dire,estCiv)){
         if(numHijos.getText().isEmpty())numHijos.setText("0");
         if(fono.getText().isEmpty())fono.setText("---------");
         P = new Paciente(dni, apeNom, dire, fono, ubigeoNac, ubigeoDom,
            fechaNac, numHijos, sexo, estCiv);
         Paciente X[] = new Paciente[N];
         System.arraycopy(PA, 0, X, 0, N);
         N++;
         PA = new Paciente[N];
         System.arraycopy(X, 0, PA, 0, N - 1);
         PA[N - 1] = P;
         String que[] = new String[N];
         for (int i = 0; i < N; i++) que[i] = PA[i].data;
         grabaRegistros(numArch, que); graba(dni.getText());
         mensaje("Se GRABO con EXITO la informacion");
         //Historia H = new Historia(dni);   //H.creaHistoria();
         new Historia(dni).creaHistoria(P);
         iniciar(ubigeoNac, ubigeoDom, fechaNac, dni, edad, apeNom, dire,
            numHijos, fono, estCiv);      
      }
   }
   public void ingresa(JTextField dni, JTextField ubigeoNac, JTextField apeNom, 
      JTextField fechaNac, JComboBox sexo, JTextField ubigeoDom,
      JTextField dire, JComboBox estCiv, JTextField numHijos, JTextField fono,
      JTextField edad){
      ingresar(dni, ubigeoNac, apeNom, fechaNac, sexo, ubigeoDom,
      dire, estCiv, numHijos, fono, edad);
   }
}
