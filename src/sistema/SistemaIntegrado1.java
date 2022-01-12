package sistema;

//import interfaces_de_sistema.*;
import personas.usuarios.UsuariosApp;
import interfaces_graficas.*;


public class SistemaIntegrado1 extends javax.swing.JFrame {
   //public IntegracionDeSistemas SI=new IntegracionDeSistemas();
   String Procesos[]={"Usuarios","Filiacion","-------------",
               "Examen Fisico","Tipo de Sangre","Hemograma","----------",
               "Sintomas","Enfermedades","Diagnosticar"};
   char tipoUser;
   UsuariosApp U= new UsuariosApp();
   PacientesApp P = new PacientesApp();//Filiacion
   DiagAntecedentesApp DA = new DiagAntecedentesApp();//Antecedentes
   DiagPesoApp DP = new DiagPesoApp();//Examen Fisico
   DiagSangreApp DS = new DiagSangreApp();//Tipo de Sangre
   DiagHemogrmaApp DH = new DiagHemogrmaApp();//Hemograma
   DiagBioquimicaApp DB = new DiagBioquimicaApp();//Bioquímica 
   SintomasApp S=new SintomasApp();//Sintomas
   EnfermedadesApp E=new EnfermedadesApp();//Enfermedades
   DiagnosticarApp D=new DiagnosticarApp();//Diagnosticar
   int conteo=0;
   public SistemaIntegrado1() {
      initComponents();
      setLocationRelativeTo(null);
      setBounds(454,10,459,330);
      corre();
   }
   void corre(){
      LOGEO.setLocationRelativeTo(null);
      LOGEO.show();
   }
   
   String TipoUser(int i){
      return new personas.usuarios.User().TipoUser(i);
   }
   
   void cargaProceso(){
      String procesar[]=new String[20];
      switch(tipoUser){
         case '1':{//ADMINISTRADOR
            procesar=Procesos;
         }break;
         case '2':{//SUPERVISOR
            String procesos[]={"Examen Fisico","Tipo de Sangre","Hemograma","Bioquímica",
               "Sintomas","Enfermedades","Diagnosticar"};
            procesar=new String[procesos.length];
            procesar=procesos;
         }break;
         case '3':{//OPERADOR
            String procesos[]={"Examen Fisico","Tipo de Sangre","Hemograma","Bioquímica"};
            procesar=new String[procesos.length];
            procesar=procesos;
         }break;
         case '4':{//Invitado
            String procesos[]={"Diagnosticar"};
            procesar=new String[procesos.length];
            procesar=procesos;
         }break;
      }
      Proceso.removeAllItems();
      Proceso.addItem("Proceso????");
      for(int i=0; i<procesar.length;i++)Proceso.addItem(procesar[i]);
   }
   
   void Procesar(){
      String Proc=Proceso.getSelectedItem().toString();
      if(Proc.equals(Procesos[0]))U.show();//Usuarios
      if(Proc.equals(Procesos[1]))P.show();//Filiacion Pacientes
      if(Proc.equals(Procesos[3]))DP.show();//Diag fiscio
      if(Proc.equals(Procesos[4]))DS.show();//Diag Sangre
      if(Proc.equals(Procesos[5]))DH.show();//Hemograma
      if(Proc.equals(Procesos[7]))S.show();//Sintomas
      if(Proc.equals(Procesos[8]))E.show();//Enfermedades
      if(Proc.equals(Procesos[9]))D.show();//Diagnosticar
   }
   public void Procesa(){
      if(Proceso.getComponentCount()>0)Procesar();
   }
   void logeo(){
      boolean pasa=false;
      personas.usuarios.Usuarios UX= new personas.usuarios.Usuarios();
      int pos=UX.buscarLogin(logName.getText());
      if(conteo== 2){
         UX.mensaje("Usted tuvo 3 Oportunidades\n"
            + "Comuniquese con el administrador del sistema");
         System.exit(0);
      }
      
      if(pos < 0){
         UX.mensaje("ERIO:\n Su Login Name es INCORRECTO!!!");
         conteo++;
      }else{
         if(UX.US[pos].psw.equals(psw.getText())){
            pasa=true;
         }else{
            conteo++;
            UX.mensaje("ERIO:\n Contraseña errada");
         }
      }
      if(!pasa){
         UX.mensaje("Tiene "+(3-conteo)+" oportunidades mas");
      }else{
         String mensa="BIENVENIDO "+UX.US[pos].dameTipoUser()+":\n    "+
            UX.US[pos].apeNom;
         tipoUser=UX.US[pos].tipoUser.charAt(0);
         String EST=UX.US[pos].estado;
         if("I".equals(EST)){
            mensa+="Lamentablemente su estado es "+UX.US[pos].dameEstado()+
               "\n Comuniquese con el Administrador del sistema";
            pasa=false;
         }
         UX.mensaje(mensa);
         if(!pasa)System.exit(0);
         else{
            LOGEO.dispose();
            tipoUser=UX.US[pos].tipoUser.charAt(0);
            cargaProceso();
            show();
         }
      }
      
   }
   public void logear(){
      logeo();
   }
   
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LOGEO = new javax.swing.JFrame();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        logName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        psw = new javax.swing.JPasswordField();
        Acceso = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Proceso = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        LOGEO.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        LOGEO.setName("logeo"); // NOI18N
        LOGEO.setResizable(false);
        LOGEO.setSize(new java.awt.Dimension(450, 350));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enfermedades-infecciosas.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SIDIMEV");
        jLabel6.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel7.setForeground(new java.awt.Color(51, 0, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sistema Inteligente de Diagnóstico Médico Virtual");

        jLabel8.setText("Usuario");

        jLabel9.setText("Clave");

        Acceso.setText("Acceder");
        Acceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LOGEOLayout = new javax.swing.GroupLayout(LOGEO.getContentPane());
        LOGEO.getContentPane().setLayout(LOGEOLayout);
        LOGEOLayout.setHorizontalGroup(
            LOGEOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGEOLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LOGEOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LOGEOLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(psw, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(LOGEOLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LOGEOLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LOGEOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Acceso)
                    .addComponent(jLabel5))
                .addGap(22, 22, 22))
        );
        LOGEOLayout.setVerticalGroup(
            LOGEOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGEOLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(LOGEOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(logName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(psw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Acceso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA INTEGRADO DE DIAGNOSTICO");

        jLabel1.setText("Elija un Proceso >>>");
        jPanel1.add(jLabel1);

        Proceso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProcesoItemStateChanged(evt);
            }
        });
        Proceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcesoActionPerformed(evt);
            }
        });
        jPanel1.add(Proceso);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enfermedades-infecciosas.jpg"))); // NOI18N
        jPanel2.add(jLabel2, java.awt.BorderLayout.NORTH);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("BIENVENIDOS AL SISTEMA INTEGRAL");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText(" DE DIAGNOSTICO MEDICO INTELIGENTE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(139, 139, 139))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void ProcesoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProcesoItemStateChanged
      Procesa();
   }//GEN-LAST:event_ProcesoItemStateChanged

   private void AccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccesoActionPerformed
      
      logear();
   }//GEN-LAST:event_AccesoActionPerformed

    private void ProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcesoActionPerformed

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
         java.util.logging.Logger.getLogger(SistemaIntegrado1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(SistemaIntegrado1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(SistemaIntegrado1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(SistemaIntegrado1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new SistemaIntegrado1().setVisible(false);
         }
      });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Acceso;
    private javax.swing.JFrame LOGEO;
    private javax.swing.JComboBox<String> Proceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField logName;
    private javax.swing.JPasswordField psw;
    // End of variables declaration//GEN-END:variables
}
