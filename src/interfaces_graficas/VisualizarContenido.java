package interfaces_graficas;

/*
Creado por DISC: ALejandro Huapaya Sánchez
 */
import enferm_y_sintomas.Sintomas_Enfermedades;
import javax.swing.JOptionPane;

public class VisualizarContenido extends javax.swing.JFrame {
   String anterior="";
   Sintomas_Enfermedades SE=new Sintomas_Enfermedades();

   void creaTabla(){
      String[] titulos = { "Descripcion", "#Enferm"};//"Codigo",
      SE.cargaData();
      String matriz[][]=new String [SE.N2-2][titulos.length];
      for(int i=2; i<SE.N2; i++){
         for(int j=2; j<=titulos.length+1;j++){
            matriz[i-2][j-2]=SE.S[i].dato(j);
         }
      }
      tablaSintomas.setModel(SE.creaTabla(titulos, matriz));
   }

   void limpiar() {
      txtNom.setText("");
   }

   /**
    * Creates new form personas
    */
   public VisualizarContenido() {
      initComponents();//INICIAR COMPONENTES
      creaTabla();//EJECUTAR VISTA DE LA JTABLE
      btnModificar.setEnabled(false);//DESHABILITAR BOTON MODIFICAR
      setLocationRelativeTo(null);
   }

   boolean hayErrores() {
      boolean error = false;
      String msg = "";
      
      if ("".equals(txtNom.getText())) {
         msg += "ER04 - No Ingreso Nombres\n";
      }
      
      if (msg.length() > 0) {
         javax.swing.JOptionPane.showMessageDialog(null, msg);
         error = true;
      }
      return error;
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        popmod = new javax.swing.JMenuItem();
        popdel = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSintomas = new javax.swing.JTable();
        labNombres = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

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
        setPreferredSize(new java.awt.Dimension(450, 450));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

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
        tablaSintomas.setComponentPopupMenu(jPopupMenu1);
        tablaSintomas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSintomasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSintomas);

        labNombres.setText("Descripcion");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Seleccione sintoma...");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Clic con boton derecho del mouse si desea Modificar/Borrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labNombres)
                        .addGap(189, 189, 189)
                        .addComponent(btnModificar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNombres)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void popmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popmodActionPerformed
      // ELEMENTO POP MODIFICAR
      int fila = tablaSintomas.getSelectedRow();
      String descrip = "";
      if (fila >= 0) {
         descrip = (tablaSintomas.getValueAt(fila, 0).toString());
      }
      //ASIGNAR LOS VALORES OBTENIDO A LAS VARIABLES STRING
      anterior=descrip;
      txtNom.setText(anterior);
      btnModificar.setText("Modificar");
      btnModificar.setEnabled(true);//BOTON MODIFICAR HABILITADO
      
   }//GEN-LAST:event_popmodActionPerformed

   @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
   private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
      if (!hayErrores()) {
         // MODIFICAR
         int fila = tablaSintomas.getSelectedRow();//VARIABLE TIPO INT PARA OBTENER VALOR DE JTABLE
         String id = "";//VARIABLE STRING
         //OBTENER VALOR ID DE LA TABLA
         if (fila >= 0) {
            id = (tablaSintomas.getValueAt(fila, 1).toString());
         }
         try {
            limpiar();//LIMPIAR CAMPOS
            btnModificar.setEnabled(false);//BOTON MODIFICAR DESHABILITADI
            creaTabla();//ACTUALIZAR VISTA DE LA TABLA
            JOptionPane.showMessageDialog(null, "Cambio exitoso ");//MENSAJE
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERR-BD02\nCambio NO realizado "
               + "\n" + e.toString());//OBTENER ERROR
         }
      }
   }//GEN-LAST:event_btnModificarActionPerformed

   @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
   private void popdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popdelActionPerformed
      //ELIMINAR POP
      int fila = tablaSintomas.getSelectedRow();//VARIABLE TIPO INT PARA OBTENER VALOR DE JTABLE
      String dni_ruc = "";//VARIABLE STRING
      //OBTENER VALOR ID DE LA TABLA
      dni_ruc = tablaSintomas.getValueAt(fila, 1).toString();
      try {
        
         creaTabla();//ACTUALIZAR VISTA DE LA TABLA
         JOptionPane.showMessageDialog(null, "Persona eliminada");//MENSAJE
      } catch (Exception e) {
         System.out.println(e.toString());//getCause());//OBTENER ERROR
      }
   }//GEN-LAST:event_popdelActionPerformed

   private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      System.exit(0);
   }//GEN-LAST:event_btnSalirActionPerformed

   private void tablaSintomasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSintomasMouseClicked
      int fila = tablaSintomas.getSelectedRow();
      if (fila > 0) {
         jPopupMenu1.show();
      }

   }//GEN-LAST:event_tablaSintomasMouseClicked

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
            new VisualizarContenido().setVisible(true);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labNombres;
    private javax.swing.JMenuItem popdel;
    private javax.swing.JMenuItem popmod;
    private javax.swing.JTable tablaSintomas;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
