
package vista;

import controlador.ControladorInterfaz;
import controlador.ControladorPersona;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import modelo.Comuna;
import modelo.Direccion;
import modelo.PuebloOriginario;
import modelo.Region;
import modelo.Rol;
import modelo.Sexo;
import modelo.Usuario;
import static vista.VentanaUsuarios.tbl_usuarios;


public class VentanaModificarUsuario extends javax.swing.JFrame{
    
    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorPersona cp = new ControladorPersona();
    String pattern ="yyyy-MM-dd"; 
    public VentanaModificarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    public VentanaModificarUsuario(Usuario usuario, Direccion direccion) {
        initComponents();
        this.setLocationRelativeTo(null);
        txt_codusuario.setText(usuario.getCodUsuario());
        txt_run.setText(String.valueOf(usuario.getRun()));
        ci.cargarCbRegion(cb_region);
        ci.cargarCbRol(cb_rol, 2);
        ci.cargarCbSexo(cb_sexo);
        txt_prinom.setText(usuario.getPri_nom());
        txt_segnom.setText(usuario.getSeg_nom());
        txt_priap.setText(usuario.getPri_ap());
        txt_segap.setText(usuario.getSeg_ap());
        txt_mail.setText(usuario.getMail());
        String fec_nac = "";
        Date fec_nac2 = null;
        fec_nac= usuario.getFec_nac();
        System.out.println(fec_nac);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try{
            Date date = simpleDateFormat.parse(fec_nac);
            txt_fechanac.setDateFormatString(pattern);
            txt_fechanac.setDate(date);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ci.cargarCbPueblo(cb_pueblo);
        cb_pueblo.setEnabled(false);
        int validador = ci.setSelectedValue(cb_pueblo, usuario.getId_pueblo());
        if(validador==0)
           cb_pueblo.removeAllItems();
        ci.setSelectedValueSexo(cb_sexo, usuario.getId_sexo());
        txt_direccion.setText(direccion.getDescripcion());
        ci.setSelectedValueRegion(cb_region, direccion.getNom_region());
        ci.setSelectedValueComuna(cb_comuna, direccion.getNom_comuna());
        ci.setSelectedValueRol(cb_rol, usuario.getId_rol());
        
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cb_rol = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_fechanac = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_run = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txt_prinom = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txt_segnom = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txt_priap = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txt_segap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txt_direccion = new javax.swing.JTextField();
        cb_sexo = new javax.swing.JComboBox<>();
        cb_pueblo = new javax.swing.JComboBox<>();
        chk_pueblo = new javax.swing.JCheckBox();
        cb_region = new javax.swing.JComboBox<>();
        cb_comuna = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        txt_mail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txt_codusuario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btn_cancelar = new com.k33ptoo.components.KButton();
        btn_aceptar = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Usuario");
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(cb_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 135, 158, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Rol:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 137, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("RUN:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 89, -1, -1));

        txt_fechanac.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(txt_fechanac, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 379, 157, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Primer nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 181, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Segundo nombre:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 237, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Primer apellido:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 281, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Segundo apellido:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 329, -1, -1));

        txt_run.setEditable(false);
        txt_run.setBorder(null);
        getContentPane().add(txt_run, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 83, 157, 22));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 108, 157, 13));

        txt_prinom.setBorder(null);
        txt_prinom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_prinomKeyReleased(evt);
            }
        });
        getContentPane().add(txt_prinom, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 179, 157, 22));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 204, 157, 13));

        txt_segnom.setBorder(null);
        txt_segnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_segnomKeyReleased(evt);
            }
        });
        getContentPane().add(txt_segnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 235, 157, 22));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 260, 157, 13));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 304, 157, 13));

        txt_priap.setBorder(null);
        txt_priap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_priapKeyReleased(evt);
            }
        });
        getContentPane().add(txt_priap, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 279, 157, 22));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 348, 157, 13));

        txt_segap.setBorder(null);
        txt_segap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_segapKeyReleased(evt);
            }
        });
        getContentPane().add(txt_segap, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 323, 157, 22));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Fecha nacimiento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 379, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Sexo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 193, -1, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 304, 157, 13));

        txt_direccion.setBorder(null);
        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_direccionKeyReleased(evt);
            }
        });
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 279, 157, 22));

        getContentPane().add(cb_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 191, 157, -1));

        getContentPane().add(cb_pueblo, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 235, 157, -1));

        chk_pueblo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        chk_pueblo.setText("Pueblo Indígena:");
        chk_pueblo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_puebloActionPerformed(evt);
            }
        });
        getContentPane().add(chk_pueblo, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 233, -1, -1));

        cb_region.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_regionItemStateChanged(evt);
            }
        });
        getContentPane().add(cb_region, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 323, 157, -1));

        getContentPane().add(cb_comuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 377, 157, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Región:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 325, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Comuna:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 379, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setText("Dirección:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 281, -1, -1));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 160, 157, 13));

        txt_mail.setBorder(null);
        txt_mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mailKeyReleased(evt);
            }
        });
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 135, 157, 22));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setText("Mail:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 137, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setText("Código de usuario:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 85, -1, -1));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 108, 157, 13));

        txt_codusuario.setEditable(false);
        txt_codusuario.setBorder(null);
        getContentPane().add(txt_codusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 83, 157, 22));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setText("Modificar Usuario");

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_cancel_40px.png"))); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancelar.setkEndColor(new java.awt.Color(153, 153, 153));
        btn_cancelar.setkHoverEndColor(new java.awt.Color(0, 0, 0));
        btn_cancelar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_cancelar.setkHoverStartColor(new java.awt.Color(102, 0, 0));
        btn_cancelar.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_aceptar.setText("Aceptar");
        btn_aceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_aceptar.setkHoverColor(new java.awt.Color(0, 51, 0));
        btn_aceptar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_aceptar.setkHoverStartColor(new java.awt.Color(51, 51, 51));
        btn_aceptar.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chk_puebloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_puebloActionPerformed
        
        if(chk_pueblo.isSelected()){
            cb_pueblo.setEnabled(true);
            ci.cargarCbPueblo(cb_pueblo);
        }else{
            cb_pueblo.removeAllItems();
            cb_pueblo.setEnabled(false);
        }
    }//GEN-LAST:event_chk_puebloActionPerformed

    private void cb_regionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_regionItemStateChanged
       cb_comuna.removeAllItems();
       Region r = (Region)cb_region.getSelectedItem();
       ci.cargarCbComuna(cb_comuna, r.getId());
    }//GEN-LAST:event_cb_regionItemStateChanged

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        int run=Integer.parseInt(txt_run.getText());
        String pri_nom = txt_prinom.getText();
        String seg_nom= txt_segnom.getText();
        String pri_ap = txt_priap.getText();
        String seg_ap = txt_segap.getText();
        Rol rol = (Rol)cb_rol.getSelectedItem();
        int rol1 = rol.getId();
        String fec_nac = "";
        Date date = txt_fechanac.getDate();
        fec_nac= sdf.format(date);
        Sexo sexo = (Sexo)cb_sexo.getSelectedItem();
        String sexo1 = String.valueOf(sexo.getId());
        int pueblo1=0;
        if(cb_pueblo.getSelectedItem() == null|| cb_pueblo.getSelectedItem().equals("--Seleccione--")){
            pueblo1=0;
        }else{
            PuebloOriginario pueblo = (PuebloOriginario)cb_pueblo.getSelectedItem();
            pueblo1 = pueblo.getId();
        }
        String direccion = txt_direccion.getText();
        Comuna comuna = (Comuna)cb_comuna.getSelectedItem();
        int comuna1 = comuna.getId();
        String mail = txt_mail.getText();
        int validador = cp.modificarPersona(run, pri_nom, seg_nom, pri_ap,  seg_ap,
                                fec_nac, rol1, sexo1, pueblo1
                                , comuna1, direccion, mail);
        if(validador == 0){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER,"Usuario actualizado", "Correcto");
            noti.showNotification();
            //JOptionPane.showMessageDialog(rootPane, "Usuario actualizado correctamente.");
            cp.listarPersonas(tbl_usuarios);

            dispose();
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER,"Ha ocurrido un error, llene todos los campos", "Error");
            noti.showNotification();
            //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, asegurese de haber llenado todos los campos y reintente la operación.");
        }
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void txt_mailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mailKeyReleased
        ci.limiteCaracteres(txt_mail, 100);
    }//GEN-LAST:event_txt_mailKeyReleased

    private void txt_prinomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_prinomKeyReleased
        ci.limiteCaracteres(txt_prinom, 30);
    }//GEN-LAST:event_txt_prinomKeyReleased

    private void txt_segnomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_segnomKeyReleased
        ci.limiteCaracteres(txt_segnom, 30);
    }//GEN-LAST:event_txt_segnomKeyReleased

    private void txt_priapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priapKeyReleased
        ci.limiteCaracteres(txt_priap, 30);
    }//GEN-LAST:event_txt_priapKeyReleased

    private void txt_segapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_segapKeyReleased
        ci.limiteCaracteres(txt_segap, 30);
    }//GEN-LAST:event_txt_segapKeyReleased

    private void txt_direccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyReleased
        ci.limiteCaracteres(txt_direccion, 150);
    }//GEN-LAST:event_txt_direccionKeyReleased

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
            java.util.logging.Logger.getLogger(VentanaModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaModificarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_aceptar;
    private com.k33ptoo.components.KButton btn_cancelar;
    private javax.swing.JComboBox<String> cb_comuna;
    private javax.swing.JComboBox<String> cb_pueblo;
    private javax.swing.JComboBox<String> cb_region;
    private javax.swing.JComboBox<String> cb_rol;
    private javax.swing.JComboBox<String> cb_sexo;
    private javax.swing.JCheckBox chk_pueblo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField txt_codusuario;
    private javax.swing.JTextField txt_direccion;
    private com.toedter.calendar.JDateChooser txt_fechanac;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_priap;
    private javax.swing.JTextField txt_prinom;
    private javax.swing.JTextField txt_run;
    private javax.swing.JTextField txt_segap;
    private javax.swing.JTextField txt_segnom;
    // End of variables declaration//GEN-END:variables
}
