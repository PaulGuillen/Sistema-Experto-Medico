package biblioteca.archivos;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import interfaces_de_sistema.ManagerProcesos;
import javax.swing.*;
abstract public class Manager implements ManagerProcesos{

   private String unidadVia = "C:/DataBase", arch,ext="txt";
   public String dato;
   public int numReg;
   //public String cosa[];/* = new String [100000];*/
   
   private char ss='~';//separador de campos
   public char s=ss;
   
   @Override
   public void mensaje(String men){
      javax.swing.JOptionPane.showMessageDialog(null, men);
   }
   //Borra archivo
   public void borraArch(String archi){
      File archivo=new File(unidadVia+"/"+archi+"."+ext);
      archivo.delete();
   }
   public void borraArch(String via,String archi,String exten){
      File archivo=new File(via+"/"+archi+"."+exten);
      archivo.delete();
   }
   private void veriDir(){
      File dire = new File( unidadVia );
      if(!dire.exists()){
         dire.mkdirs();
      }
   }
   private String base(int i) {
      switch (i) {
         case 0: // usuarios
            arch = "/users"; break;
         case 1: // enfermeddes
            arch = "/enfermedades"; break;
         case 2: //sintomas
            arch = "/sintomas"; break;
         case 3: // relacional sintomas-enfermedades
            arch = "/sintEnf"; break;
         case 4: // paciente
            arch = "/paciente"; break;
         case 6: // dato
            arch = "/dato"; break;
         case 7: //diagnosticos
            arch = "/diagNost"; break;
      }
      arch+="."+ext;
      veriDir();
      return unidadVia + arch;
   }
   private String base(int i, String archi) {
      String aux=unidadVia;
      unidadVia+="/historias";
      veriDir();
      unidadVia=aux;
      switch (i) {
         case 5: // Historia Clinica--> "HC"+dni
            arch = "/historias/"+ archi; break;
      }
      arch+="."+ext;
      veriDir();
      return unidadVia + arch;
   }
   
   // Maneja DBF
   @Override
   public boolean veriArch(int cual){
      File a = new File( base(cual) );
      return a.exists();
   }
   public boolean veriArch(int cual, String archi){
      File a = new File( base(cual,archi) );
      return a.exists();
   }
   
   private void grabaRegistro(int cual, String que[]) {
      FileOutputStream fos = null;
      DataOutputStream out = null;
      String men="ERROR BD01\nNo se puede grabar\n";
      try {
         fos = new FileOutputStream(base(cual));
         out = new DataOutputStream(fos);
         out.writeUTF(""+que.length);
         for (int i = 0; i < que.length; i++) {
            out.writeUTF(que[i]);
         }
      } catch (FileNotFoundException ex) {
         //mensaje(men+ex.toString());
      } catch (IOException ex) {
         //mensaje(men+ex.toString());
      } finally {
         try {
            fos.close();
            out.close();
         } catch (IOException ex) {
            //mensaje(men+ex.toString());
         }
      }
   }
   private void grabaRegistro(int cual, String archi,String que[]) {
      FileOutputStream fos = null;
      DataOutputStream out = null;
      String men="ERROR BD01\nNo se puede grabar\n";
      try {
         fos = new FileOutputStream(base(cual,archi));
         out = new DataOutputStream(fos);
         out.writeUTF(""+que.length);
         for (int i = 0; i < que.length; i++) {
            out.writeUTF(que[i]);
         }
      } catch (FileNotFoundException ex) {
         mensaje(men+ex.toString());
      } catch (IOException ex) {
         mensaje(men+ex.toString());
      } finally {
         try {
            fos.close();
            out.close();
         } catch (IOException ex) {
            mensaje(men+ex.toString());
         }
      }
   }
   @Override
   public void grabaRegistros(int cual, String que[]) {
      grabaRegistro(cual, que);
   }
   public void grabaRegistros(int cual, String archi, String que[]) {
      grabaRegistro(cual, archi, que);
   }
   public void graba(String DATO) {
      try {
         veriDir();
         FileOutputStream fos = null;
         PrintWriter pw = null;
         fos = new FileOutputStream(unidadVia+"/dato.txt");
         pw = new PrintWriter(fos);
         pw.write(DATO);
         pw.close();
         try {
            fos.close();
         } catch (IOException ex) {
         }
      } catch (FileNotFoundException ex) {
      }
   }
   public void lee() {
      FileReader fr = null;
      BufferedReader br = null;
      try {
         fr = new FileReader("dato");
      } catch (FileNotFoundException ex) {
      }
      br = new BufferedReader(fr);
      try {
         dato = br.readLine();
      } catch (IOException ex) {
      }
      try {
         br.close();
         fr.close();
      } catch (IOException ex) {
      }
   }
   private void leeRegistro(int base) {
      FileInputStream fis = null;
      DataInputStream in = null;
      String men="ERROR BD02\nERROR DE LECTURA DE BD\n";
      try {
         fis = new FileInputStream(base(base));
         in = new DataInputStream(fis);
         try {
            numReg=Integer.parseInt(in.readUTF());
         } catch (IOException ex) {
            mensaje(men+"Numero de registros\n"+ ex.toString());
         }
         for(int i=0; i<numReg; i++){
            try {
               cosa[i] = in.readUTF();
            } catch (IOException ex) {
               mensaje(men+"Registros\n"+ ex.toString());
            }
         }  
      } catch (FileNotFoundException ex) {
         mensaje(men+ ex.toString());
      } finally {
         try {
            in.close();
            fis.close();
         } catch (IOException ex) {
            mensaje(men+"Cerrar BD\n"+ ex.toString());
         }
      }
   }
   private void leeRegistro(int base, String archi) {
      FileInputStream fis = null;
      DataInputStream in = null;
      String men="ERROR BD02\nERROR DE LECTURA DE BD\n";
      try {
         fis = new FileInputStream(base(base,archi));
         in = new DataInputStream(fis);
         try {
            numReg=Integer.parseInt(in.readUTF());
         } catch (IOException ex) {
            mensaje(men+"Numero de registros\n"+ ex.toString());
         }
         for(int i=0; i<numReg; i++){
            try {
               cosa[i] = in.readUTF();
            } catch (IOException ex) {
               mensaje(men+"Registros\n"+ ex.toString());
            }
         }  
      } catch (FileNotFoundException ex) {
         mensaje(men+ ex.toString());
      } finally {
         try {
            in.close();
            fis.close();
         } catch (IOException ex) {
            mensaje(men+"Cerrar BD\n"+ ex.toString());
         }
      }
   }
   @Override
   public void leeRegistros(int base) {
      leeRegistro(base);
   }
   public void leeRegistros(int base, String archi) {
      leeRegistro(base, archi);
   }
   //MANEJO DE OBJETOS
   //--------- JTable ---------
   @Override
   public DefaultTableModel creaTabla(String[] titulos, String[][] Datos){
      DefaultTableModel modelo = new DefaultTableModel();
      modelo = new DefaultTableModel(null, titulos);
      String Columna[] = new String[titulos.length];
      for(int i=0; i<Datos.length; i++){
         System.arraycopy(Datos[i], 0, Columna, 0, titulos.length);
         modelo.addRow(Columna);
      }
      return modelo;
   }
   //*********************
   public boolean mensaError(String mensa){
      boolean err=false;
      if(mensa.length()>0){
         mensaje(mensa);
         err=true;
      }
      return err;
   }
   //---------- JComboBox -------------
   public void cargaCombos(javax.swing.JComboBox JCB, String item[]){
      JCB.removeAllItems();
      JCB.addItem(item[0]);
      for(int i=1; i<item.length; i++){
         JCB.addItem(item[i]);
      }
   }
   
   private String errores(javax.swing.JComboBox JCB[], String QUE[]){
      String mensa = "";
      for(int j=0; j<JCB.length; j++){
         if(JCB[j].getSelectedIndex() < 1){
            mensa += "\nER-IO: No ha seleccionado "+QUE[j];
         }
      }
      return mensa;
   }
   @Override
   public String error(javax.swing.JComboBox JCB[], String QUE[]){
      return errores(JCB,QUE);
   }
   
   //---------- JTextField -------------
   private String errores(javax.swing.JTextField JTF[], String QUE[]){
      String mensa = "";
      for(int j=0; j<JTF.length; j++){
         if(JTF[j].getText().isEmpty()){
            mensa += "\nER-IO: No ha ingresado "+QUE[j];
         }
      }
      return mensa;
   }
   @Override
   public String error(javax.swing.JTextField JTF[], String QUE[]){
      return errores(JTF,QUE);
   }
   
   //******* DATOS GENERALES *********
   //------------- Fechas ---------
   public String fechaHoy(){
      // Lima, DIA_SEMANA d de mmmm del aaaa
      return new biblioteca.fechas.Fecha().fecha(1);
   }
   public String fecha(){
      // dd/mm/aa hh:mm:ss
      return new java.util.Date().toLocaleString();
   }
   //-------------- DNI --------------
   boolean errDNI(javax.swing.JTextField DNI){
      boolean error=false;
      String doc=DNI.getText();
      if ("".equals(doc)) {
         error=true;
         mensaje("ERIO\n  No Ingreso numero de DNI\n");
      }
      if (doc.length() != 8) {
         error=true;
         mensaje("ERIO\n  DNI no tiene 8 digitos\n");
      }else{
         int cuantos=0;
         for(char i='0'; i<='9'; i++){
            for(int j=0; j<8; j++){
               if(doc.charAt(j) == i)cuantos++;
            }
         }
         if(cuantos!=8){
            error=true;
            mensaje("ERIO\n  DNI debe tener solo digitos\n");
         }
      }
      return error;
   }
   @Override
   public boolean errorDNI(javax.swing.JTextField DNI){
      return errDNI(DNI);
   }
   //---------- EXPORTAR
   private void Exportar(String nombre,JTextArea TA) {
      try {
         JFileChooser archivo = new JFileChooser(System.getProperty(unidadVia+nombre+".doc"));
         archivo.showSaveDialog(TA);//this);
         if (archivo.getSelectedFile() != null) {
            try (FileWriter guardado = new FileWriter(archivo.getSelectedFile())) {
               guardado.write(TA.getText());
               mensaje("El archivo fue guardado con éxito en la ruta establecida");
            }
         }
      } catch (IOException ex) {
         
      }
   }
   public void Exporta(String nombre,JTextArea TA) {
      Exportar(nombre, TA);
   }
}