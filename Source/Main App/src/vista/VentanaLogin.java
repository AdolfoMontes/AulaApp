
package vista;

import controlador.TextPrompt;
import controlador.ControladorUsuario;
import ds.desktop.notify.DesktopNotify;
import java.awt.event.KeyEvent;
import modelo.Usuario;
import controlador.I_Aplicacion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Notification;

public class VentanaLogin extends javax.swing.JFrame implements I_Aplicacion{
    int x=0;
    int y=0;
    public VentanaLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        txt_userlogin.requestFocus();
        new TextPrompt("Escribe tu usuario", txt_userlogin);
        new TextPrompt("Escribe tu contraseña", txt_passwordlogin);
        lbl_version.setText(VERSION+ "(" + TYPE + ")");
        
    }
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_passwordlogin = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        txt_userlogin = new javax.swing.JTextField();
        btn_restablecerclave = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btn_iniciarsesion = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        lbl_version = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso Usuarios");
        setIconImage(getIconImage());
        setIconImages(null);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/logo.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_user_24px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_password_24px.png"))); // NOI18N

        txt_passwordlogin.setBackground(new java.awt.Color(102, 102, 102));
        txt_passwordlogin.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_passwordlogin.setForeground(new java.awt.Color(255, 255, 255));
        txt_passwordlogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_passwordlogin.setBorder(null);
        txt_passwordlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordloginActionPerformed(evt);
            }
        });
        txt_passwordlogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordloginKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_eye_24px.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_userlogin.setBackground(new java.awt.Color(102, 102, 102));
        txt_userlogin.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_userlogin.setForeground(new java.awt.Color(255, 255, 255));
        txt_userlogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_userlogin.setBorder(null);
        txt_userlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userloginActionPerformed(evt);
            }
        });

        btn_restablecerclave.setBackground(new java.awt.Color(204, 102, 0));
        btn_restablecerclave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_restablecerclave.setForeground(new java.awt.Color(255, 255, 255));
        btn_restablecerclave.setText("Olvidaste tu contraseña?");
        btn_restablecerclave.setBorderPainted(false);
        btn_restablecerclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restablecerclaveActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));

        jSeparator3.setBackground(new java.awt.Color(102, 102, 102));

        btn_iniciarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_login_40px.png"))); // NOI18N
        btn_iniciarsesion.setText("Iniciar Sesión");
        btn_iniciarsesion.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_iniciarsesion.setkEndColor(new java.awt.Color(204, 102, 0));
        btn_iniciarsesion.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_iniciarsesion.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_iniciarsesion.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_iniciarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarsesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Acceso Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_iniciarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_restablecerclave, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(4, 4, 4)
                            .addComponent(txt_passwordlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_userlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txt_userlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_passwordlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btn_iniciarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btn_restablecerclave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 500));

        btn_salir.setBackground(new java.awt.Color(255, 255, 255));
        btn_salir.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_circled_x_24px_1.png"))); // NOI18N
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 30, 20));

        lbl_version.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_version.setText("version");
        getContentPane().add(lbl_version, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 470, 99, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel7.setText("educación");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setText("La ");

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel8.setText("es la llave de la libertad.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel7))
                    .addComponent(jLabel8))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(2, 2, 2)
                .addComponent(jLabel8)
                .addContainerGap(395, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 500));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/background.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_userloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_userloginActionPerformed

    private void btn_restablecerclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restablecerclaveActionPerformed
        try {
            VentanaRestablecerClave vrc = new VentanaRestablecerClave();
            vrc.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_restablecerclaveActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        txt_passwordlogin.setEchoChar((char)0);
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        txt_passwordlogin.setEchoChar('•');
    }//GEN-LAST:event_jButton1MouseReleased

    private void txt_passwordloginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordloginKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Usuario u = new Usuario(0,txt_userlogin.getText(),"", String.valueOf(txt_passwordlogin.getPassword()));
            ControladorUsuario cu = new ControladorUsuario();
            Usuario usuarioLogueado = new Usuario();
            usuarioLogueado = cu.usuarioValidar(u);
            if (usuarioLogueado.getRun()>=1){
                VentanaPrincipal vp = new VentanaPrincipal(usuarioLogueado);
                vp.setVisible(true);
                dispose();
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Bienvenido otra vez " + txt_userlogin.getText(), "Bienvenid@");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("AulaApp","Bienvenido otra vez " + txt_userlogin.getText() + "! \n :)", DesktopNotify.SUCCESS, 15000L);
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Credenciales incorrectas", "Incorrecto");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("AulaApp","El usuario o contraseña es incorrecto, por favor reintente", DesktopNotify.ERROR, 3000L);
            }
        }
        
    }//GEN-LAST:event_txt_passwordloginKeyPressed

    private void txt_passwordloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordloginActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void btn_iniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarsesionActionPerformed
        Usuario u = new Usuario(0,txt_userlogin.getText(),"", String.valueOf(txt_passwordlogin.getPassword()));
        ControladorUsuario cu = new ControladorUsuario();
        Usuario usuarioLogueado = new Usuario();
        usuarioLogueado = cu.usuarioValidar(u);
        if (usuarioLogueado.getRun()>=1){
            VentanaPrincipal vp = new VentanaPrincipal(usuarioLogueado);
            vp.setVisible(true);
            dispose();
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Bienvenido otra vez " + txt_userlogin.getText(), "Bienvenid@");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp","Bienvenido otra vez " + txt_userlogin.getText() + "! \n :)", DesktopNotify.SUCCESS, 15000L);
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Credenciales incorrectas", "Incorrecto");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp","El usuario o contraseña es incorrecto, por favor reintente", DesktopNotify.ERROR, 3000L);
        }
    }//GEN-LAST:event_btn_iniciarsesionActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new VentanaLogin().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_iniciarsesion;
    private javax.swing.JButton btn_restablecerclave;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_version;
    private javax.swing.JPasswordField txt_passwordlogin;
    private javax.swing.JTextField txt_userlogin;
    // End of variables declaration//GEN-END:variables
}
