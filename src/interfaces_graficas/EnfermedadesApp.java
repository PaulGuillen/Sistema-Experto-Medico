package interfaces_graficas;
/**
 * @author DISC: Alejandro Huapaya Sánchez 
 */
import enferm_y_sintomas.*;
public class EnfermedadesApp extends javax.swing.JFrame {
   
   //Enfermedad S_E=new Enfermedad();
   Sintomas_Enfermedades SE=new Sintomas_Enfermedades();
   void cargaSintomas(){
      SE.cargaSelSin(SelSint,1);
   }
   public EnfermedadesApp() {
      initComponents();
      setLocationRelativeTo(null);
      cargaSintomas();
   }
   private void grabaSint(){
      //BOTON: Graba Sintoma de la Enfermedad
      SE.ingresar(SelSint, Nom);
      SE.visualiza(Nom, Salida);
      Visualizar.setLocation(700, 300);
      Visualizar.setSize(360, 300);
      Visualizar.show(true);
   }
   @SuppressWarnings("unchecked")
   private void initComponents() {//GEN-BEGIN:initComponents

      Visualizar = new javax.swing.JFrame();
      jScrollPane1 = new javax.swing.JScrollPane();
      Salida = new javax.swing.JTextArea();
      Sintomas = new javax.swing.JFrame();
      jLabel2 = new javax.swing.JLabel();
      Sint = new javax.swing.JTextField();
      btnGrabaSintom = new javax.swing.JButton();
      jLabel1 = new javax.swing.JLabel();
      Nom = new javax.swing.JTextField();
      jButton1 = new javax.swing.JButton();
      SelSint = new javax.swing.JComboBox<>();
      jButton3 = new javax.swing.JButton();
      jButton4 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();

      Salida.setEditable(false);
      Salida.setColumns(20);
      Salida.setRows(5);
      jScrollPane1.setViewportView(Salida);

      Visualizar.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

      Sintomas.setResizable(false);

      jLabel2.setText("Ingrese descripcion del Sintoma");

      btnGrabaSintom.setText("Grabar Sintoma");
      btnGrabaSintom.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnGrabaSintomActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout SintomasLayout = new javax.swing.GroupLayout(Sintomas.getContentPane());
      Sintomas.getContentPane().setLayout(SintomasLayout);
      SintomasLayout.setHorizontalGroup(
         SintomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(SintomasLayout.createSequentialGroup()
            .addGroup(SintomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(SintomasLayout.createSequentialGroup()
                  .addGap(30, 30, 30)
                  .addGroup(SintomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(Sint, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel2)))
               .addGroup(SintomasLayout.createSequentialGroup()
                  .addGap(138, 138, 138)
                  .addComponent(btnGrabaSintom)))
            .addContainerGap(63, Short.MAX_VALUE))
      );
      SintomasLayout.setVerticalGroup(
         SintomasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(SintomasLayout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addComponent(Sint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31)
            .addComponent(btnGrabaSintom)
            .addContainerGap(70, Short.MAX_VALUE))
      );

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("SS-02: Mantenimiento de Enfermedades");

      jLabel1.setText("Nombre de la enfermedad");

      jButton1.setText("Grabar Enfermedad");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      SelSint.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      SelSint.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            SelSintItemStateChanged(evt);
         }
      });

      jButton3.setText("Nueva Enfermedad");
      jButton3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
         }
      });

      jButton4.setText("Visualizar");
      jButton4.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
         }
      });

      jButton2.setText("Graba Sintoma seleccionado");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(41, 41, 41)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1)
                     .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(layout.createSequentialGroup()
                  .addGap(133, 133, 133)
                  .addComponent(jButton1))
               .addGroup(layout.createSequentialGroup()
                  .addGap(73, 73, 73)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                     .addComponent(SelSint, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(layout.createSequentialGroup()
                  .addGap(110, 110, 110)
                  .addComponent(jButton2)))
            .addContainerGap(41, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jButton1)
            .addGap(18, 18, 18)
            .addComponent(SelSint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jButton2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton3)
               .addComponent(jButton4))
            .addGap(28, 28, 28))
      );

      pack();
   }//GEN-END:initComponents

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      // BOTON: Nueva Enfermedad
      Nom.setText("");
   }//GEN-LAST:event_jButton3ActionPerformed

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // BOTON: Graba Enfermedad
      SE.ingresar(1, Nom);
      Nom.setText(Nom.getText().toUpperCase());
   }//GEN-LAST:event_jButton1ActionPerformed

   private void SelSintItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SelSintItemStateChanged
      if(SelSint.getSelectedIndex() == 1){
         Sintomas.setLocation(700, 400);
         Sintomas.setSize(400,200);
         Sintomas.setVisible(true);
      } 
   }//GEN-LAST:event_SelSintItemStateChanged

   private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      //BOTON: Visualizar
      Visualizar.setBounds(700, 300, 360, 300);
      Visualizar.show(true);
   }//GEN-LAST:event_jButton4ActionPerformed

   private void btnGrabaSintomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabaSintomActionPerformed
      // BOTON: Grabar Sintoma
      SE.ingresar(2, Sint);
      Sint.setText("");
      SE.cargaSelSin(SelSint,1);
   }//GEN-LAST:event_btnGrabaSintomActionPerformed

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      //BOTON: Graba Sintoma de la Enfermedad
      grabaSint();
   }//GEN-LAST:event_jButton2ActionPerformed

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
         java.util.logging.Logger.getLogger(EnfermedadesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(EnfermedadesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(EnfermedadesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(EnfermedadesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new EnfermedadesApp().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField Nom;
   private javax.swing.JTextArea Salida;
   private javax.swing.JComboBox<String> SelSint;
   private javax.swing.JTextField Sint;
   private javax.swing.JFrame Sintomas;
   private javax.swing.JFrame Visualizar;
   private javax.swing.JButton btnGrabaSintom;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JButton jButton4;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JScrollPane jScrollPane1;
   // End of variables declaration//GEN-END:variables
}
