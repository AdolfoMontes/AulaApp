
package vista;

import controlador.ControladorEvento;
import controlador.ControladorInterfaz;
import java.awt.Image;
import java.awt.Toolkit;
import javaswingdev.Notification;
import modelo.Evento;


public class VentanaAgregarAnuncio extends javax.swing.JFrame {
    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorEvento ce = new ControladorEvento();
    public VentanaAgregarAnuncio() {
        initComponents();
        lbl_contador.setText(txt_detalle.getText().length() + " de 1500 caracteres");
        
        
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_titulo = new textfield.TextField();
        btn_publicar = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_detalle = new javax.swing.JTextArea();
        lbl_contador = new javax.swing.JLabel();
        rb_informativo = new javax.swing.JRadioButton();
        rb_urgente = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear anuncio");
        setIconImage(getIconImage());
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 102));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear anuncio");

        txt_titulo.setLabelText("Titulo");
        txt_titulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tituloKeyReleased(evt);
            }
        });

        btn_publicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_publicar.setText("Publicar");
        btn_publicar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_publicar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_publicar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_publicar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_publicar.setkSelectedColor(new java.awt.Color(102, 102, 102));
        btn_publicar.setkStartColor(new java.awt.Color(102, 102, 102));
        btn_publicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_publicarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Escribe aquí tu anuncio");

        txt_detalle.setColumns(20);
        txt_detalle.setLineWrap(true);
        txt_detalle.setRows(5);
        txt_detalle.setWrapStyleWord(true);
        txt_detalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_detalleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_detalleKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txt_detalle);

        lbl_contador.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_contador.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contador.setText("contador");

        buttonGroup1.add(rb_informativo);
        rb_informativo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rb_informativo.setForeground(new java.awt.Color(255, 255, 255));
        rb_informativo.setSelected(true);
        rb_informativo.setText("Informativo");
        rb_informativo.setOpaque(false);

        buttonGroup1.add(rb_urgente);
        rb_urgente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rb_urgente.setForeground(new java.awt.Color(255, 255, 255));
        rb_urgente.setText("Urgente");
        rb_urgente.setOpaque(false);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_contador, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(btn_publicar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(rb_informativo)
                .addGap(54, 54, 54)
                .addComponent(rb_urgente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_informativo)
                    .addComponent(rb_urgente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_publicar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_contador))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_publicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_publicarActionPerformed
        Evento evento = new Evento();
        evento.setTitulo(txt_titulo.getText());
        evento.setDetalle(txt_detalle.getText());
        int tipo = 0;
        if(rb_informativo.isSelected())
            tipo = 2;
        else if(rb_urgente.isSelected())
            tipo = 1;
        evento.setTipo(tipo);
        evento.setUsr_creacion(VentanaPrincipal.usuarioLogueado.getCodUsuario());
        
        int validador = ce.agregarEvento(evento);
        if(txt_titulo.getText().isBlank() || txt_detalle.getText().isBlank()){
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Llene todos los campos" , "Campos faltantes");
            noti.showNotification();
        }else{
            if(validador ==0){
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "El anuncio será visible para todos en unos momentos" , "Anuncio guardado");
                noti.showNotification();
                txt_titulo.setText("");
                txt_detalle.setText("");
                VentanaPrincipal.cargarEventos();
                lbl_contador.setText(txt_detalle.getText().length() + " de 1500 caracteres");
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error" , "Error");
                noti.showNotification();
            }
        }

    }//GEN-LAST:event_btn_publicarActionPerformed

    private void txt_detalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_detalleKeyTyped
        
    }//GEN-LAST:event_txt_detalleKeyTyped

    private void txt_detalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_detalleKeyReleased
        ci.limiteCaracteres(txt_detalle, 1500);
        lbl_contador.setText(txt_detalle.getText().length() + " de 1500 caracteres");
    }//GEN-LAST:event_txt_detalleKeyReleased

    private void txt_tituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tituloKeyReleased
        ci.limiteCaracteres(txt_titulo, 255);
    }//GEN-LAST:event_txt_tituloKeyReleased

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
            java.util.logging.Logger.getLogger(VentanaAgregarAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarAnuncio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarAnuncio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_publicar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbl_contador;
    private javax.swing.JRadioButton rb_informativo;
    private javax.swing.JRadioButton rb_urgente;
    private javax.swing.JTextArea txt_detalle;
    private textfield.TextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
