package personas.usuarios;

import biblioteca.archivos.Manager;
import java.awt.Color;
import javax.swing.*;


public class Usuarios extends Manager{
   public User[] US;
   int N=0;
   int numArch=0;
   //JTable tabla;
   //JMenuItem popmod = new JMenuItem();
   //JMenuItem popdel = new JMenuItem();
   //JTextField dni,apeNom;
   public Usuarios(){
      cargaData();
   }
   void datos(){
      N=4;
      US=new User[N];
      US[0] = new User("00000000", "ADMINISTRADOR","Admin","admin","1","1");
      US[1] = new User("00000001", "SUPERVISOR","Supervisa","super","2","1");
      US[2] = new User("00000002", "OPERADOR","Opera","opera","3","1");
      US[3] = new User("00000003", "INVITADO","Invita","invita","4","1");
   }
   void cargaData() {
      if (!veriArch(numArch)) {
         datos();
         ordena();
         String que[] = new String[N];
         for (int i = 0; i < N; i++) {
            que[i]=US[i].data;
         }
         grabaRegistros(numArch, que);//Metodo heredado de Manager
      } else {
         leeRegistros(numArch);//Metodo heredado de Manager
         N = numReg;
         US = new User[N];
         for (int i = 0; i < N; i++) {
            US[i] = new User();
            US[i].cargaData(cosa[i]);
         }
      }
   }
   void ordena(){
      for(int i=0; i<N-1; i++){
         for(int j=i+1; j<N; j++){
            if(US[i].dato(2).compareTo(US[j].dato(2))>0){
               User CX=US[i];
               US[i]=US[j];
               US[j]=CX;
            }
         }
      }
   }
   int buscaLogin(String logName) {
      cargaData();
      int pos = -1;
      for (int i = 0; i < N; i++) {
         if (US[i].dato(3).equals(logName)) {
            pos = i;
            break;
         }
      }
      return pos;
   }
   public int buscarLogin(String logName) {
      return buscaLogin(logName);
   }
   int buscaUser(String dni) {
      cargaData();
      int pos = -1;
      for (int i = 0; i < N; i++) {
         if (US[i].dato(1).equals(dni)) {
            pos = i;
            break;
         }
      }
      return pos;
   }
   public int buscaUser(JTextField dni) {
      return buscaUser(dni.getText());
   }
   //---------- ERRORES -------------
   boolean errores(JTextField dni, JTextField apeNom,JTextField logName, JTextField psw,
      JComboBox tipoUser, JComboBox estado){
      JTextField TF[]={dni,apeNom,logName,psw};
      String queTF[]={"DNI","Aellidos y Nombres","Nombre de acceso","CLAVE"};
      JComboBox CB[]={tipoUser,estado};
      String queCB[]={"Tipo de Usuario","Estado"};
      String err=error(TF,queTF)+error(CB,queCB);
      if(err.length()>0) mensaje(err);
      return err.length()>0;
   }
   private void creaTabla(JTable TABLA) {
      //User(String dni,String apeNom,String logName, String psw, String tipoUser, String estado)
      String[] titulos = {"> DNI <","-> Apellidos y Nombres <-","LogName","PassWord",
      "Tipo Usuario","Estado"};
      cargaData();
      ordena();
      String matriz[][] = new String[N][titulos.length];
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < titulos.length; j++) {
            matriz[i][j] = US[i].dato(j + 1);
         }
      }
      TABLA.setModel(creaTabla(titulos, matriz));//creaTabla de Manager
      TABLA.sizeColumnsToFit(0);
   }

   public void crearTabla(JTable TABLA) {
      creaTabla(TABLA);
   }
   
   void iniciar(JTextField dni, JTextField apeNom,JTextField logName, JTextField psw,
      JComboBox tipoUser, JComboBox estado, JButton btnIMB, JTable tabla){
      dni.setText(""); dni.setEditable(true); dni.setBackground(Color.white);
      apeNom.setText("");
      apeNom.setEnabled(false);
      logName.setText("");
      logName.setEnabled(false);
      psw.setText("");
      psw.setEnabled(false);
      US[0].cargaTipoUser(tipoUser);
      US[0].cargaEstado(estado);
      tipoUser.setSelectedIndex(0);
      estado.setSelectedIndex(0);
      btnIMB.setEnabled(false);
      btnIMB.setText("??????");
      creaTabla(tabla);
   }
   void activa(JTextField dni, JTextField apeNom,JTextField logName, JTextField psw,
      JComboBox tipoUser, JComboBox estado, JButton btnIMB){
      dni.setBackground(Color.yellow);
      dni.setEditable(false);
      apeNom.requestFocus();
      apeNom.setEnabled(true);
      logName.setEnabled(true);
      psw.setEnabled(true);
   }
   void grabaQue(){
      ordena();
      String que[] = new String[N];
      for (int i = 0; i < N; i++) {
         que[i] = US[i].data;
      }
      grabaRegistros(numArch, que);
   }
   //**************** PROCESOS *******************
   // Al presionar enter
   void KeyPressed(java.awt.event.KeyEvent evt, JTextField dni, 
      JTextField apeNom,JTextField logName,
      JTextField psw,JComboBox tipoUser,JComboBox estado,
      JTable tabla,JButton btnIMB) {
      if (evt.getExtendedKeyCode() == 10) {
         if (!errorDNI(dni)) {
            if (buscaUser(dni) < 0) {
               activa(dni, apeNom, logName, psw, tipoUser, estado, btnIMB);
               btnIMB.setText("Ingresar");
               btnIMB.setEnabled(true);
            } else {
               mensaje("ERIO:\n Dato DNI ya existe");
            }
         }
      }
   }
   //--------- Clic sobre Boton MULTIFUNCIONAL
   void clicBoton(java.awt.event.ActionEvent evt,JTextField dni, 
      JTextField apeNom,JTextField logName,
      JTextField psw,JComboBox tipoUser,JComboBox estado,
      JTable tabla,JButton btnIMB) {
      if (btnIMB.getText().equals("Ingresar")) {
         ingresar(dni, apeNom, logName, psw, tipoUser, estado, tabla, btnIMB);
      }
      if (btnIMB.getText().equals("Modificar")) {
         modificar(tabla, dni, apeNom, logName, psw, tipoUser, estado, btnIMB);
      }
      
   }
   // .............. Ingreso de datos ...............
   void ingresar(JTextField dni, JTextField apeNom,JTextField logName,
      JTextField psw,JComboBox tipoUser,JComboBox estado,
      JTable tabla,JButton btnIMB){
         if (!errores(dni, apeNom,logName, psw, tipoUser, estado)) {
            cargaData();
               N = numReg+1;
               User CX[]=new User[N];
               System.arraycopy(US, 0, CX, 0, US.length);
               CX[N-1]=new User(dni, apeNom,logName, psw, tipoUser, estado);
               US=new User[N];
               System.arraycopy(CX, 0, US, 0, N);
               grabaQue();
               mensaje("Se ingreso datos con EXITO!!!");
               iniciar(dni, apeNom,logName, psw, tipoUser, estado, btnIMB,tabla);
               crearTabla(tabla);
         }
   }
   // .............. Modificación de datos ...............
   // ------ Seleccion de dato ---------------
   int fila=-1; String dniAnt="";
   void modifica(JTable tabla,JTextField dni,JTextField apeNom,JTextField logName,
      JTextField psw,JComboBox tipoUser,JComboBox estado,JButton btnIMB){
      fila = tabla.getSelectedRow();
      if (fila >= 0 ) {
         dni.setText(tabla.getValueAt(fila, 0).toString());
         dniAnt=dni.getText();
         apeNom.setText(tabla.getValueAt(fila, 1).toString());
         logName.setText(tabla.getValueAt(fila, 2).toString());
         psw.setText(tabla.getValueAt(fila, 3).toString());
         tipoUser.setSelectedItem(tabla.getValueAt(fila, 4).toString());
         estado.setSelectedItem(tabla.getValueAt(fila, 5).toString());
         btnIMB.setText("Modificar");
         btnIMB.setEnabled(true);
         activa(dni, apeNom, logName, psw, tipoUser, estado, btnIMB);
         dni.setBackground(Color.white);
         dni.setEditable(true);
      }
   }
   // ---------- MODIFICA DATOS
   void modificar(JTable tabla,JTextField dni,JTextField apeNom,JTextField logName,
      JTextField psw,JComboBox tipoUser,JComboBox estado,JButton btnIMB){
      if (!errorDNI(dni)&& !errores(dni, apeNom,logName, psw, tipoUser, estado)) {
         boolean procesa=false;
         int pos=buscaUser(dni);
         if(dni.getText().equals(dniAnt)){
            procesa=true;
         }else{
            if(pos<0){
               pos=buscaUser(dniAnt);
               procesa=true;
            }else{
               mensaje("ERIO:\n El DNI YA EXISTE\nPertenece a "+US[pos].apeNom);
            }
         }
         if(procesa){
            US[pos]=new User(dni,apeNom,logName, psw, tipoUser, estado);
            grabaQue();
            mensaje("Se MODIFICARON datos con EXITO!!!");
            iniciar(dni, apeNom,logName, psw, tipoUser, estado, btnIMB,tabla);
            crearTabla(tabla);
         }
      }
   }
   // ------ Seleccion de dato ---------------
   void borra(JTable tabla, JButton btnIMB){
      fila = tabla.getSelectedRow();
      String DNI = tabla.getValueAt(fila, 0).toString();
      String AP = tabla.getValueAt(fila, 1).toString();
      int opc = javax.swing.JOptionPane.showConfirmDialog
   (null, "Seguro de borrar:\nDNI: " + DNI + "\n" + AP);
      if (opc == 0) {
         JTextField aux=new JTextField();
         aux.setText(DNI);
         int pos=buscaUser(aux);
         N--;
         for (int i = pos; i < N; i++) {
            US[i] = US[i + 1];
         }
         grabaQue();
         mensaje("Se BORRARON datos con EXITO!!!");
         crearTabla(tabla);
      }
   }   
}
