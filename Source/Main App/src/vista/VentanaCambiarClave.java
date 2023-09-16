
package vista;

import controlador.ControladorInterfaz;
import controlador.ControladorUsuario;
import controlador.TextPrompt;
import ds.desktop.notify.DesktopNotify;
import java.awt.Image;
import java.awt.Toolkit;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import modelo.Usuario;


public class VentanaCambiarClave extends javax.swing.JFrame {
    int x=0;
    int y=0;
    public Usuario usuarioSeleccionado;
    ControladorInterfaz ci = new ControladorInterfaz();
    public VentanaCambiarClave() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public VentanaCambiarClave(Usuario usuario) {
        initComponents();

        this.usuarioSeleccionado = usuario;
        this.setLocationRelativeTo(null);
        lbl_usuario.setText(usuario.getRun() + " | " +usuario.getCodUsuario());
        txt_passwordanterior.requestFocus();
        new TextPrompt("Largo 50 máximo", txt_password1);
        new TextPrompt("Largo 50 máximo", txt_password2);
    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_passwordanterior = new javax.swing.JPasswordField();
        txt_password1 = new javax.swing.JPasswordField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        txt_password2 = new javax.swing.JPasswordField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_ojo1 = new javax.swing.JButton();
        btn_ojo2 = new javax.swing.JButton();
        btn_ojo3 = new javax.swing.JButton();
        btn_guardar = new com.k33ptoo.components.KButton();
        btn_cancelar = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Contraseña anterior:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Repita Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txt_passwordanterior.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_passwordanterior.setBorder(null);
        txt_passwordanterior.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordanteriorFocusGained(evt);
            }
        });
        txt_passwordanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordanteriorActionPerformed(evt);
            }
        });
        txt_passwordanterior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordanteriorKeyTyped(evt);
            }
        });
        getContentPane().add(txt_passwordanterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 214, 20));

        txt_password1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_password1.setBorder(null);
        txt_password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password1ActionPerformed(evt);
            }
        });
        txt_password1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_password1KeyReleased(evt);
            }
        });
        getContentPane().add(txt_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 214, 20));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 214, 10));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 214, 10));

        txt_password2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_password2.setBorder(null);
        txt_password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password2ActionPerformed(evt);
            }
        });
        txt_password2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_password2KeyReleased(evt);
            }
        });
        getContentPane().add(txt_password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 214, 20));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 214, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Nueva contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Usuario Seleccionado:");

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_usuario.setText("usuario");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel4.setText("Cambio de contraseña");

        btn_ojo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_eye_24px.png"))); // NOI18N
        btn_ojo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ojo1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_ojo1MouseReleased(evt);
            }
        });

        btn_ojo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_eye_24px.png"))); // NOI18N
        btn_ojo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ojo2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_ojo2MouseReleased(evt);
            }
        });

        btn_ojo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_eye_24px.png"))); // NOI18N
        btn_ojo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ojo3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_ojo3MouseReleased(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar.setkHoverEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar.setkHoverStartColor(new java.awt.Color(0, 51, 0));
        btn_guardar.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_cancel_40px.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancelar.setkEndColor(new java.awt.Color(204, 0, 0));
        btn_cancelar.setkHoverEndColor(new java.awt.Color(0, 0, 0));
        btn_cancelar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_cancelar.setkHoverStartColor(new java.awt.Color(153, 0, 0));
        btn_cancelar.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(lbl_usuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_ojo2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ojo3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ojo1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lbl_usuario))
                .addGap(13, 13, 13)
                .addComponent(btn_ojo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ojo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_ojo3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordanteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordanteriorActionPerformed

    private void txt_password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password2ActionPerformed

    private void txt_passwordanteriorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordanteriorFocusGained
     
    }//GEN-LAST:event_txt_passwordanteriorFocusGained

    private void btn_ojo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ojo1MousePressed
        txt_passwordanterior.setEchoChar((char)0);
    }//GEN-LAST:event_btn_ojo1MousePressed

    private void btn_ojo1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ojo1MouseReleased
        txt_passwordanterior.setEchoChar('•');
    }//GEN-LAST:event_btn_ojo1MouseReleased

    private void btn_ojo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ojo2MousePressed
        txt_password1.setEchoChar((char)0);
    }//GEN-LAST:event_btn_ojo2MousePressed

    private void btn_ojo2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ojo2MouseReleased
        txt_password1.setEchoChar('•');
    }//GEN-LAST:event_btn_ojo2MouseReleased

    private void btn_ojo3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ojo3MousePressed
        txt_password2.setEchoChar((char)0);
    }//GEN-LAST:event_btn_ojo3MousePressed

    private void btn_ojo3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ojo3MouseReleased
        txt_password2.setEchoChar('•');
    }//GEN-LAST:event_btn_ojo3MouseReleased

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        
    }//GEN-LAST:event_formWindowLostFocus

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void txt_passwordanteriorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordanteriorKeyTyped
        
    }//GEN-LAST:event_txt_passwordanteriorKeyTyped

    private void txt_password2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_password2KeyReleased
        ci.limiteCaracteres(txt_password2, 50);
    }//GEN-LAST:event_txt_password2KeyReleased

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        ControladorUsuario cu = new ControladorUsuario();
        String claveanterior = String.valueOf(txt_passwordanterior.getPassword());
        int run = usuarioSeleccionado.getRun();
        String nuevaClave = String.valueOf(txt_password1.getPassword());
        String nuevaClave2 = String.valueOf(txt_password2.getPassword());
        if(nuevaClave.isBlank() || nuevaClave2.isBlank()){
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Las contraseñas no pueden ser vacías" , "Campos vacíos");
            noti.showNotification(); 
            //JOptionPane.showMessageDialog(rootPane, "Las contraseñas no pueden ser vacías.");
        }else{
            Usuario user = new Usuario();
            user.setRun(run);
            user.setCodUsuario(usuarioSeleccionado.getCodUsuario());
            user.setPassword(claveanterior);
            Usuario u = cu.usuarioValidar(user);
            System.out.println(u.getRun());
            if (u.getRun()>0){
                if(nuevaClave.equals(nuevaClave2)){
                    user.setPassword(nuevaClave);
                    int validador = cu.actualizarClave(user);
                    if (validador == 0){
                        Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Contraseña cambiada" , "Correcto");
                        noti.showNotification(); 
                        //DesktopNotify.showDesktopMessage("AulaApp","Contraseña cambiada exitosamente!", DesktopNotify.SUCCESS, 4000L);
                        //JOptionPane.showMessageDialog(rootPane, "La clave de usuario " + usuarioSeleccionado.getRun() + " ha sido cambiada correctamente");
                        dispose();
                    }else{
                        Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error" , "Error");
                        noti.showNotification(); 
                        //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, por favor reintente la operación", "Error",2);
                    }
                }else{
                    Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Las contraseñas no son iguales" , "Error");
                    noti.showNotification(); 
                    //JOptionPane.showMessageDialog(rootPane, "Las contraseñas no son iguales.");
                }
                
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Contraseña anterior incorrecta" , "Incorrecto");
                noti.showNotification(); 
                //JOptionPane.showMessageDialog(rootPane, "La contraseña anterior es incorrecta, por favor reintente.");
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        dispose();
    }//GEN-LAST:event_formFocusLost

    private void txt_password1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_password1KeyReleased
        ci.limiteCaracteres(txt_password1, 50);
    }//GEN-LAST:event_txt_password1KeyReleased

    private void txt_password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaCambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCambiarClave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_cancelar;
    private com.k33ptoo.components.KButton btn_guardar;
    private javax.swing.JButton btn_ojo1;
    private javax.swing.JButton btn_ojo2;
    private javax.swing.JButton btn_ojo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPasswordField txt_password1;
    private javax.swing.JPasswordField txt_password2;
    private javax.swing.JPasswordField txt_passwordanterior;
    // End of variables declaration//GEN-END:variables
}
