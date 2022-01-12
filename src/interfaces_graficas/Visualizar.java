package interfaces_graficas;

import enferm_y_sintomas.Sintomas_Enfermedades;
import javax.swing.table.DefaultTableModel;
/**
 * @author DISC: Alejandro Huapaya Sánchez 
 */

public class Visualizar extends javax.swing.JFrame {

   String anterior="";
   DefaultTableModel modelo = new DefaultTableModel();
   Sintomas_Enfermedades SE=new Sintomas_Enfermedades();
   
   public Visualizar() {
      initComponents();
      setLocation(476, 230);
      setSize(400,450);
      btnModificar.setText("???????");
      btnModificar.setEnabled(false);//DESHABILITAR BOTON MODIFICAR
      creaTabla();
   }
   
   void creaTabla(){
      //CREANDO UN STRING PARA LO TITULOS
      String[] titulos = { "Descripcion", "#Enferm"};//"Codigo",
      //DEFINIR EL TAMAÑO DE LA MATRIZ QUE COLUMNAS
      String[] Columna = new String[2];
      //ASIGNAR LA MATRIZ TITUTLO A NUESTRO MODELO DEL JTABLE
      modelo = new DefaultTableModel(null, titulos);
      SE.cargaData();
      for(int i=2; i<SE.N2; i++){
         //Columna[0] = SE.S[i].dato(1);
         Columna[0] = SE.S[i].dato(2);
         Columna[1] = SE.S[i].dato(3);
         modelo.addRow(Columna);
      }
      tablaSintomas.setModel(modelo);
   }
   
   @SuppressWarnings("unchecked")
   private void initComponents() {//GEN-BEGIN:initComponents

      jPopupMenu1 = new javax.swing.JPopupMenu();
      jMenuModificar = new javax.swing.JMenuItem();
      jMenuBorrar = new javax.swing.JMenuItem();
      jLabel1 = new javax.swing.JLabel();
      Sint2 = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tablaSintomas = new javax.swing.JTable();
      btnModificar = new javax.swing.JButton();

      jMenuModificar.setText("Modificar");
      jPopupMenu1.add(jMenuModificar);

      jMenuBorrar.setForeground(new java.awt.Color(255, 0, 0));
      jMenuBorrar.setText("Borrar");
      jPopupMenu1.add(jMenuBorrar);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setText("Descripcion del sintoma");

      jLabel2.setForeground(new java.awt.Color(255, 0, 0));
      jLabel2.setText("Seleccione un sintoma ");

      jLabel3.setForeground(new java.awt.Color(255, 0, 0));
      jLabel3.setText("Clic con boton derecho del mouse para Modificar/Borrar");

      tablaSintomas.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
         }
      ));
      tablaSintomas.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaSintomasMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(tablaSintomas);

      btnModificar.setText("jButton1");
      btnModificar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnModificarActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(jLabel1)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(btnModificar))
                  .addComponent(Sint2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel2)
               .addComponent(jLabel3))
            .addContainerGap(89, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(btnModificar))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Sint2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }//GEN-END:initComponents

   private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_btnModificarActionPerformed

   private void tablaSintomasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSintomasMouseClicked
      int fila = tablaSintomas.getSelectedRow();
      //if (fila > 0) {
         System.out.println(fila);
         jPopupMenu1.show();
      //}
   }//GEN-LAST:event_tablaSintomasMouseClicked

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(Visualizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new Visualizar().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField Sint2;
   private javax.swing.JButton btnModificar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JMenuItem jMenuBorrar;
   private javax.swing.JMenuItem jMenuModificar;
   private javax.swing.JPopupMenu jPopupMenu1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tablaSintomas;
   // End of variables declaration//GEN-END:variables
}
