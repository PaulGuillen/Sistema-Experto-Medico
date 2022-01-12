package interfaces_de_sistema;


import javax.swing.table.DefaultTableModel;


public interface ManagerProcesos {
   //Archivos
   public String cosa[] = new String [1000000];
   public void mensaje(String men);
   public boolean veriArch(int cual);
   public void grabaRegistros(int cual, String que[]);
   public void leeRegistros(int base);
   public DefaultTableModel creaTabla(String[] titulos, String[][] Datos);
   public boolean errorDNI(javax.swing.JTextField DNI);
   public String error(javax.swing.JComboBox JCB[], String QUE[]);
   public String error(javax.swing.JTextField JTF[], String QUE[]);
}
