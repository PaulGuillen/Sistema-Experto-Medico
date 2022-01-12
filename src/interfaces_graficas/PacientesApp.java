package interfaces_graficas;

import biblioteca.fechas.Fecha;
import biblioteca.ubigeo.Peru;
import java.awt.Color;
import personas.pacientes.*;

/**
 *
 * @author DISC: Alejandro Huapaya Sánchez
 */
public class PacientesApp extends javax.swing.JFrame {

   Pacientitos P=new Pacientitos();
   Peru peru=new Peru();
   Fecha fecha=new Fecha();
   public PacientesApp() {
      initComponents();
      setBounds(400, 150, 425, 400);
      FechaNac.setBounds(600, 150, 325, 170);
      iniciar();
      P.iniciar(ubigeoNac, ubigeoDom, fechaNac, dni, edad, apeNom, direc, 
         numHijos, fono, estCiv);
   }
   void iniciar(){
      fecha.cargaAa(aa, 60);
      aa.setSelectedIndex(0);
      fecha.cargaMm(mm);
      mm.setSelectedIndex(0);
      dd.setSelectedIndex(0);
      Ubigeo.setLocationRelativeTo(null);
      Ubigeo.setBounds(600, 100, 270, 320);
      sexo.setSelectedIndex(0);
   }
   boolean errorUbigeo(){
      boolean err=false;
      String mensa="";
      if(Dep.getSelectedIndex()<1)mensa+="\nERIO: No selecciono Departamento";
      if(Pro.getSelectedIndex()<1)mensa+="\nERIO: No selecciono Provincia";
      if(Dis.getSelectedIndex()<1)mensa+="\nERIO: No selecciono Distrito";
      if(mensa.length()>1){
         err=true;
         P.mensaje(mensa);
      }
      return err;
   }
   boolean errorFecha(){
      boolean err=false;
      String mensa="";
      if(aa.getSelectedIndex()<1)mensa+="\nERIO: No selecciono AÑO";
      if(mm.getSelectedIndex()<1)mensa+="\nERIO: No selecciono MES";
      if(dd.getSelectedIndex()<1)mensa+="\nERIO: No selecciono DIA";
      if(mensa.length()>1){
         err=true;
         P.mensaje(mensa);
      }
      return err;
   }
   
  @SuppressWarnings("unchecked")
   private void initComponents() {//GEN-BEGIN:initComponents

      Ubigeo = new javax.swing.JFrame();
      Dep = new javax.swing.JComboBox<>();
      Pro = new javax.swing.JComboBox<>();
      Dis = new javax.swing.JComboBox<>();
      Codigo = new javax.swing.JTextField();
      labUbigeo = new javax.swing.JLabel();
      jButton2 = new javax.swing.JButton();
      FechaNac = new javax.swing.JFrame();
      aa = new javax.swing.JComboBox<>();
      mm = new javax.swing.JComboBox<>();
      dd = new javax.swing.JComboBox<>();
      botAceptaFNac = new javax.swing.JButton();
      etiketaFNac = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      dni = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      apeNom = new javax.swing.JTextField();
      ubigeoNac = new javax.swing.JTextField();
      jLabel4 = new javax.swing.JLabel();
      ubigeoDom = new javax.swing.JTextField();
      btnUbigeoNac = new javax.swing.JButton();
      btnUbigeoDom = new javax.swing.JButton();
      direc = new javax.swing.JTextField();
      jLabel6 = new javax.swing.JLabel();
      jButton1 = new javax.swing.JButton();
      fechaNac = new javax.swing.JTextField();
      jButton3 = new javax.swing.JButton();
      jLabel3 = new javax.swing.JLabel();
      edad = new javax.swing.JTextField();
      sexo = new javax.swing.JComboBox<>();
      estCiv = new javax.swing.JComboBox<>();
      jLabel7 = new javax.swing.JLabel();
      fono = new javax.swing.JTextField();
      jLabel8 = new javax.swing.JLabel();
      numHijos = new javax.swing.JTextField();

      Ubigeo.setTitle("SubSist: Ubigeos");
      Ubigeo.setResizable(false);

      Dep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      Dep.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            DepItemStateChanged(evt);
         }
      });

      Pro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      Pro.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            ProItemStateChanged(evt);
         }
      });

      Dis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      Dis.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            DisItemStateChanged(evt);
         }
      });

      labUbigeo.setText("Ubigeo de Nacimiento");

      jButton2.setText("Aceptar");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout UbigeoLayout = new javax.swing.GroupLayout(Ubigeo.getContentPane());
      Ubigeo.getContentPane().setLayout(UbigeoLayout);
      UbigeoLayout.setHorizontalGroup(
         UbigeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(UbigeoLayout.createSequentialGroup()
            .addGroup(UbigeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(UbigeoLayout.createSequentialGroup()
                  .addGap(34, 34, 34)
                  .addGroup(UbigeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                     .addComponent(Pro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(Dis, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UbigeoLayout.createSequentialGroup()
                        .addComponent(labUbigeo)
                        .addGap(18, 18, 18)
                        .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(Dep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
               .addGroup(UbigeoLayout.createSequentialGroup()
                  .addGap(88, 88, 88)
                  .addComponent(jButton2)))
            .addContainerGap(41, Short.MAX_VALUE))
      );
      UbigeoLayout.setVerticalGroup(
         UbigeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(UbigeoLayout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addComponent(Dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(33, 33, 33)
            .addComponent(Pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(38, 38, 38)
            .addComponent(Dis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31)
            .addGroup(UbigeoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(labUbigeo))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
            .addComponent(jButton2)
            .addGap(31, 31, 31))
      );

      aa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      aa.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            aaItemStateChanged(evt);
         }
      });

      mm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
      mm.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            mmItemStateChanged(evt);
         }
      });

      dd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia" }));

      botAceptaFNac.setText("Aceptar");
      botAceptaFNac.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            botAceptaFNacActionPerformed(evt);
         }
      });

      etiketaFNac.setText("Fecha de Nacimiento");

      javax.swing.GroupLayout FechaNacLayout = new javax.swing.GroupLayout(FechaNac.getContentPane());
      FechaNac.getContentPane().setLayout(FechaNacLayout);
      FechaNacLayout.setHorizontalGroup(
         FechaNacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(FechaNacLayout.createSequentialGroup()
            .addGap(45, 45, 45)
            .addGroup(FechaNacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(etiketaFNac)
               .addGroup(FechaNacLayout.createSequentialGroup()
                  .addGroup(FechaNacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(botAceptaFNac)
                     .addGroup(FechaNacLayout.createSequentialGroup()
                        .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addGap(28, 28, 28)
                  .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(64, Short.MAX_VALUE))
      );
      FechaNacLayout.setVerticalGroup(
         FechaNacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(FechaNacLayout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(etiketaFNac)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(FechaNacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(mm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(botAceptaFNac)
            .addContainerGap(33, Short.MAX_VALUE))
      );

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Subsistema: Pacientes");

      jLabel1.setText("DNI");

      dni.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            dniKeyPressed(evt);
         }
      });

      jLabel2.setText("Apellidos y Nombres");

      jLabel4.setText("Domicilio");

      btnUbigeoNac.setText("Ubigeo Nacimiento");
      btnUbigeoNac.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUbigeoNacActionPerformed(evt);
         }
      });

      btnUbigeoDom.setText("Ubigeo domicilio");
      btnUbigeoDom.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUbigeoDomActionPerformed(evt);
         }
      });

      jLabel6.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
      jLabel6.setForeground(new java.awt.Color(255, 0, 0));
      jLabel6.setText("Escribir el DNI y dar ENTER");

      jButton1.setText("Grabar");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton3.setText("Fecha de Nacimiento");
      jButton3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
         }
      });

      jLabel3.setText("Edad");

      sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo", "Masculino", "Femenino" }));

      estCiv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado Civil", "Soltero(a)", "Casado(a)", "Viudo(a)", "Divorciado(a)", "Conviviente" }));

      jLabel7.setText("Telefono");

      jLabel8.setText("Num. Hijos");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel2)
                     .addComponent(jLabel6))
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUbigeoNac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubigeoNac, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(direc, javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(apeNom, javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                           .addGroup(layout.createSequentialGroup()
                              .addComponent(jLabel4)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(btnUbigeoDom)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(ubigeoDom, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                 .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(edad))
                                 .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGap(65, 65, 65)
                              .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addGroup(layout.createSequentialGroup()
                              .addGap(0, 0, Short.MAX_VALUE)
                              .addComponent(jButton1))
                           .addGroup(layout.createSequentialGroup()
                              .addComponent(estCiv, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addComponent(jLabel8)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(numHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fono, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addGap(50, 50, 50))))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(ubigeoNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btnUbigeoNac))
            .addGap(10, 10, 10)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(apeNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jButton3)
               .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(4, 4, 4)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(ubigeoDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btnUbigeoDom))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(direc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(estCiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel7)
               .addComponent(fono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel8)
               .addComponent(numHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jButton1)
            .addContainerGap(27, Short.MAX_VALUE))
      );

      pack();
   }//GEN-END:initComponents

   private void btnUbigeoNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbigeoNacActionPerformed
      peru.inicia(Dis, Pro, Dep);
      labUbigeo.setText("Ubigeo de Nacimiento");
      Codigo.setText("");
      Ubigeo.show();
      apeNom.setEnabled(true);
   }//GEN-LAST:event_btnUbigeoNacActionPerformed

   private void btnUbigeoDomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbigeoDomActionPerformed
      peru.inicia(Dis, Pro, Dep);
      labUbigeo.setText("Ubigeo de Domicilio");
      Codigo.setText("");
      Ubigeo.show();
      direc.setEnabled(true);
      numHijos.setEnabled(true);
      fono.setEnabled(true);
   }//GEN-LAST:event_btnUbigeoDomActionPerformed

   private void dniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniKeyPressed
      if(evt.getExtendedKeyCode() == 10){
         if(!P.errorDNI(dni)){
            int pos=P.hallarDNI(dni);
            if(pos<0){
               P.P.dni=dni.getText();
               dni.setBackground(Color.yellow);
               dni.setEditable(false);
               ubigeoNac.setEnabled(true);
            }else{
               P.mensaje(" YA EXISTE ESTE DNI\nCorresponde a:\n"+ P.PA[pos].datos());
               dni.setText("");
            }
         }
      }
   }//GEN-LAST:event_dniKeyPressed

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      P.ingresa(dni, ubigeoNac, apeNom, fechaNac, sexo, ubigeoDom, direc,
         estCiv, numHijos, fono, edad);
      iniciar();
   }//GEN-LAST:event_jButton1ActionPerformed

   private void DepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DepItemStateChanged
      peru.cargaCombo(Pro, Dep);
   }//GEN-LAST:event_DepItemStateChanged

   private void ProItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProItemStateChanged
      peru.cargaCombo(Dis, Pro, Dep);
   }//GEN-LAST:event_ProItemStateChanged

   private void DisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DisItemStateChanged
      Codigo.setText(peru.dameCod(Dep, Pro, Dis));
   }//GEN-LAST:event_DisItemStateChanged

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(!errorUbigeo()){
         
         if (labUbigeo.getText().equalsIgnoreCase("Ubigeo de Nacimiento")) {
            ubigeoNac.setText(Codigo.getText());
            ubigeoNac.setEnabled(true);
         } else {
            ubigeoDom.setText(Codigo.getText());
            ubigeoDom.setEnabled(true);
         }
         Codigo.setText("");
         Ubigeo.hide();
      }
   }//GEN-LAST:event_jButton2ActionPerformed

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      FechaNac.show();
   }//GEN-LAST:event_jButton3ActionPerformed

   private void aaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_aaItemStateChanged
      fecha.cargaMm(mm);
   }//GEN-LAST:event_aaItemStateChanged

   private void mmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mmItemStateChanged
      if(aa.getSelectedIndex()>0 && mm.getSelectedIndex()>0)fecha.cargaDd(dd, mm, aa);
   }//GEN-LAST:event_mmItemStateChanged

   private void botAceptaFNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAceptaFNacActionPerformed
      if(!errorFecha()){
         fecha=new Fecha(dd,mm,aa);
         String fNac=fecha.fecha;
         fechaNac.setText(fNac);
         fechaNac.setEnabled(true);
         //edad.setText(fecha.difHoyAFecha(fNac));
         edad.setText(fecha.diferenciaHoyFechas(fechaNac));
         edad.setEnabled(true);
         FechaNac.hide();
      }
   }//GEN-LAST:event_botAceptaFNacActionPerformed

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
         java.util.logging.Logger.getLogger(PacientesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(PacientesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(PacientesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(PacientesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new PacientesApp().show();//.setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField Codigo;
   private javax.swing.JComboBox<String> Dep;
   private javax.swing.JComboBox<String> Dis;
   private javax.swing.JFrame FechaNac;
   private javax.swing.JComboBox<String> Pro;
   private javax.swing.JFrame Ubigeo;
   private javax.swing.JComboBox<String> aa;
   private javax.swing.JTextField apeNom;
   private javax.swing.JButton botAceptaFNac;
   private javax.swing.JButton btnUbigeoDom;
   private javax.swing.JButton btnUbigeoNac;
   private javax.swing.JComboBox<String> dd;
   private javax.swing.JTextField direc;
   private javax.swing.JTextField dni;
   private javax.swing.JTextField edad;
   private javax.swing.JComboBox<String> estCiv;
   private javax.swing.JLabel etiketaFNac;
   private javax.swing.JTextField fechaNac;
   private javax.swing.JTextField fono;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel labUbigeo;
   private javax.swing.JComboBox<String> mm;
   private javax.swing.JTextField numHijos;
   private javax.swing.JComboBox<String> sexo;
   private javax.swing.JTextField ubigeoDom;
   private javax.swing.JTextField ubigeoNac;
   // End of variables declaration//GEN-END:variables
}
