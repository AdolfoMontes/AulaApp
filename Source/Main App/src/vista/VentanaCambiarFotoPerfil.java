
package vista;

import controlador.ControladorInterfaz;
import controlador.ControladorUsuario;
import java.io.File;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import modelo.Usuario;



public class VentanaCambiarFotoPerfil extends javax.swing.JFrame {

    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorUsuario cu = new ControladorUsuario();
    Usuario usuarioLogueado = null;
    File file;
    public VentanaCambiarFotoPerfil(Usuario usuario) {
        usuarioLogueado = usuario;
        initComponents();
        this.setLocationRelativeTo(null);
        cu.recuperarImagen(usuarioLogueado.getCodUsuario(), lbl_imagen, 179);
    }
    public VentanaCambiarFotoPerfil(){
        initComponents();
        this.setLocationRelativeTo(null);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_examinar = new javax.swing.JButton();
        txt_ruta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_camara = new javax.swing.JLabel();
        btn_quitar = new javax.swing.JButton();
        btn_cancelar = new com.k33ptoo.components.KButton();
        btn_guardar = new com.k33ptoo.components.KButton();
        lbl_imagen = new com.raven.theme.ImageAvatar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));

        btn_examinar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_examinar.setForeground(new java.awt.Color(0, 51, 153));
        btn_examinar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_upload_24px.png"))); // NOI18N
        btn_examinar.setText("Cargar Imagen");
        btn_examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_examinarActionPerformed(evt);
            }
        });

        txt_ruta.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_ruta.setForeground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel1.setText("Selecciona tu nueva foto de perfil.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ruta:");

        lbl_camara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_camera_60px.png"))); // NOI18N

        btn_quitar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_quitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Remove_24px.png"))); // NOI18N
        btn_quitar.setText("Quitar foto");
        btn_quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitarActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_cancel_40px.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancelar.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_cancelar.setkHoverEndColor(new java.awt.Color(102, 0, 0));
        btn_cancelar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_cancelar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_cancelar.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkStartColor(new java.awt.Color(0, 102, 0));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        lbl_imagen.setGradientColor1(new java.awt.Color(204, 102, 0));
        lbl_imagen.setGradientColor2(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_camara))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_examinar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_cancelar, btn_guardar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_camara, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(btn_examinar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lbl_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_quitar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_cancelar, btn_guardar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_examinarActionPerformed
        file = ci.abrirFileChooser(this, txt_ruta, lbl_imagen);
    }//GEN-LAST:event_btn_examinarActionPerformed

    private void btn_quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitarActionPerformed
        int seleccion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea quitar la imagen de perfil?", "Confirmar desactivación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(seleccion ==0){
            int validador = ci.borrarImagen(usuarioLogueado.getRun());
            if(validador == 0){
               lbl_imagen.setImage(null);
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Imagen quitada" , "Correcto");
                noti.showNotification(); 
               //JOptionPane.showMessageDialog(rootPane, "Imagen quitada correctamente.");
               cu.recuperarImagen(usuarioLogueado.getCodUsuario(), VentanaPrincipal.lbl_foto, 71);
               dispose();
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error al eliminar" , "Error");
                noti.showNotification(); 
                //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error al eliminar la imagen");
            }
        }
        
    }//GEN-LAST:event_btn_quitarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if(txt_ruta.getText().isBlank())
            JOptionPane.showMessageDialog(rootPane,"Seleccione una imagen para guardar.");
        else{
            int validador = ci.guardarImagen(file, usuarioLogueado.getRun(), lbl_imagen);
        if (validador == 0){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Imagen actualizada" , "Correcto");
            noti.showNotification(); 
            //JOptionPane.showMessageDialog(rootPane, "Imagen actualizada correctamente.");
            cu.recuperarImagen(usuarioLogueado.getCodUsuario(), VentanaPrincipal.lbl_foto, 71);
            dispose();
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Error cargando la imagen" , "Archivo no válido");
            noti.showNotification(); 
            //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error cargando la imagen, valide que la imagen sea valida y reintente.");
        }
        }
        
    }//GEN-LAST:event_btn_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaCambiarFotoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiarFotoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiarFotoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiarFotoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCambiarFotoPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_cancelar;
    private javax.swing.JButton btn_examinar;
    private com.k33ptoo.components.KButton btn_guardar;
    private javax.swing.JButton btn_quitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_camara;
    private com.raven.theme.ImageAvatar lbl_imagen;
    private javax.swing.JTextField txt_ruta;
    // End of variables declaration//GEN-END:variables
}
