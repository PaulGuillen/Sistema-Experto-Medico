package personas.usuarios;


public class UsuariosApp extends javax.swing.JFrame {
   //************ PATRON SINGLETON ********************
   private static Usuarios INSTANCE = null;
   private Usuarios USS;
   // creador sincronizado para protegerse de posibles problemas  multi-hilo
   // otra prueba para evitar instanciación múltiple 
   private static void createInstance() {
      if (INSTANCE == null) {
         // Sólo se accede a la zona sincronizada
         // cuando la instancia no está creada
         synchronized (Usuarios.class) {
            // En la zona sincronizada sería necesario volver
            // a comprobar que no se ha creado la instancia
            if (INSTANCE == null) {
               INSTANCE = new Usuarios();
            }
         }
      }
   }

   public static Usuarios getInstance() {
      if (INSTANCE == null) {
         createInstance();
      }
      return INSTANCE;
   }

   public UsuariosApp() {
      initComponents();//INICIAR COMPONENTES
      USS = getInstance();
      USS.iniciar(dni, apeNom, logName, psw, tipoUser, estado, btnIMB,tabla);
      setLocationRelativeTo(null);
   }
   @SuppressWarnings("unchecked")
   private void initComponents() {//GEN-BEGIN:initComponents

      jPopupMenu1 = new javax.swing.JPopupMenu();
      popmod = new javax.swing.JMenuItem();
      popdel = new javax.swing.JMenuItem();
      btnIMB = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      tabla = new javax.swing.JTable();
      labNombres = new javax.swing.JLabel();
      dni = new javax.swing.JTextField();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      apeNom = new javax.swing.JTextField();
      jLabel6 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      logName = new javax.swing.JTextField();
      jLabel5 = new javax.swing.JLabel();
      psw = new javax.swing.JTextField();
      tipoUser = new javax.swing.JComboBox<>();
      estado = new javax.swing.JComboBox<>();

      popmod.setText("Modificar");
      popmod.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            popmodActionPerformed(evt);
         }
      });
      jPopupMenu1.add(popmod);

      popdel.setText("Borrar");
      popdel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            popdelActionPerformed(evt);
         }
      });
      jPopupMenu1.add(popdel);

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Subsistema: Mantenimiento de Usuarios");

      btnIMB.setText("Modificar");
      btnIMB.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnIMBActionPerformed(evt);
         }
      });

      tabla.setAutoCreateRowSorter(true);
      tabla.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
         },
         new String [] {
            "Title 1", "Title 2", "Title 3"
         }
      ));
      tabla.setComponentPopupMenu(jPopupMenu1);
      tabla.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tablaMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(tabla);

      labNombres.setText("DNI o CODIGO");

      dni.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            dniKeyPressed(evt);
         }
      });

      jLabel1.setForeground(new java.awt.Color(255, 0, 0));
      jLabel1.setText("Seleccione  USUARIO... luego");

      jLabel2.setForeground(new java.awt.Color(255, 0, 0));
      jLabel2.setText("Clic con boton derecho del mouse si desea Modificar/Borrar");

      jLabel3.setText("Apellidos y Nombres");

      jLabel6.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
      jLabel6.setForeground(new java.awt.Color(255, 0, 0));
      jLabel6.setText("Para Ingresar ... Escribir el DNI  o CODIGO y dar ENTER");

      jLabel4.setText("Nombre para logear");

      jLabel5.setText("Clvae de acceso");

      tipoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

      estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jLabel6)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(labNombres)
                  .addGap(29, 29, 29)
                  .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(139, 139, 139)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1)
                     .addComponent(jLabel2)))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel3)
                     .addComponent(apeNom, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(psw, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(tipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btnIMB))
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel6)
            .addGap(4, 4, 4)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(5, 5, 5)
                  .addComponent(labNombres))
               .addGroup(layout.createSequentialGroup()
                  .addGap(2, 2, 2)
                  .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addGap(6, 6, 6)
                  .addComponent(jLabel2)))
            .addGap(2, 2, 2)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel3)
                  .addGap(4, 4, 4)
                  .addComponent(apeNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(logName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel4))
                  .addGap(17, 17, 17)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel5)
                     .addComponent(psw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(15, 15, 15)
                  .addComponent(tipoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(18, 18, 18)
                  .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(30, 30, 30)
                  .addComponent(btnIMB))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGap(4, 4, 4)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
      );

      pack();
   }//GEN-END:initComponents

   private void popmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popmodActionPerformed
      USS.modifica(tabla, dni, apeNom, logName, psw, tipoUser, estado, btnIMB);
   }//GEN-LAST:event_popmodActionPerformed

   @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
   private void btnIMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIMBActionPerformed
      USS.clicBoton(evt, dni, apeNom, logName, psw, tipoUser, estado, tabla, btnIMB);
   }//GEN-LAST:event_btnIMBActionPerformed

   @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
   private void popdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popdelActionPerformed
      USS.borra(tabla,btnIMB);
   }//GEN-LAST:event_popdelActionPerformed

   private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
      int fila = tabla.getSelectedRow();
      if (fila > 0) {
         jPopupMenu1.show();
      }

   }//GEN-LAST:event_tablaMouseClicked

   private void dniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniKeyPressed
      USS.KeyPressed(evt, dni, apeNom, logName, psw, tipoUser, estado, tabla, btnIMB);
   }//GEN-LAST:event_dniKeyPressed

   /**
    * @param args the command line arguments
    */
   @SuppressWarnings("Convert2Lambda")
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
         // java.util.logging.Logger.getLAppPersonasrsonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         //java.util.logging.Logger.gAppPersonas(Personas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         //java.util.logging.LoggeAppPersonasger(Personas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         //java.util.logging.LoAppPersonasLogger(Personas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }


      /* Create and display thAppPersonas*/
      java.awt.EventQueue.invokeLater(new Runnable() {
         @SuppressWarnings("override")
         public void run() {
            new UsuariosApp().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField apeNom;
   private javax.swing.JButton btnIMB;
   private javax.swing.JTextField dni;
   private javax.swing.JComboBox<String> estado;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JPopupMenu jPopupMenu1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JLabel labNombres;
   private javax.swing.JTextField logName;
   private javax.swing.JMenuItem popdel;
   private javax.swing.JMenuItem popmod;
   private javax.swing.JTextField psw;
   private javax.swing.JTable tabla;
   private javax.swing.JComboBox<String> tipoUser;
   // End of variables declaration//GEN-END:variables
}
