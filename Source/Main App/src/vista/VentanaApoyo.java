/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Adolfo Montes
 */
public class VentanaApoyo extends javax.swing.JFrame {

    /**
     * Creates new form VentanaApoyo
     */
    public VentanaApoyo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_guardar = new com.k33ptoo.components.KButton();
        btn_cancelar = new com.k33ptoo.components.KButton();
        btn_guardar1 = new com.k33ptoo.components.KButton();
        btn_cancelar1 = new com.k33ptoo.components.KButton();
        btn_limpiar = new com.k33ptoo.components.KButton();
        btn_excel = new javax.swing.JButton();
        button1 = new com.raven.swing.Button();
        menuButton1 = new com.raven.swing.MenuButton();
        buttomImage1 = new com.raven.swing.ButtomImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_edit_40px.png"))); // NOI18N
        btn_guardar.setText("Modificar");
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkStartColor(new java.awt.Color(204, 102, 0));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
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

        btn_guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar1.setText("Guardar");
        btn_guardar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar1.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar1.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar1.setkStartColor(new java.awt.Color(0, 102, 0));
        btn_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar1ActionPerformed(evt);
            }
        });

        btn_cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_refresh_40px.png"))); // NOI18N
        btn_cancelar1.setText("Cancelar");
        btn_cancelar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancelar1.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_cancelar1.setkHoverEndColor(new java.awt.Color(102, 0, 0));
        btn_cancelar1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_cancelar1.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_cancelar1.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar1ActionPerformed(evt);
            }
        });

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_broom_30px.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_limpiar.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_limpiar.setkHoverEndColor(new java.awt.Color(102, 0, 0));
        btn_limpiar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_limpiar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_limpiar.setkStartColor(new java.awt.Color(102, 102, 0));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_excel.setBackground(new java.awt.Color(51, 51, 51));
        btn_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_microsoft_excel_48px.png"))); // NOI18N
        btn_excel.setBorderPainted(false);

        button1.setText("button1");

        menuButton1.setText("menuButton1");

        buttomImage1.setText("buttomImage1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttomImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttomImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelar1ActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_limpiarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaApoyo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaApoyo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaApoyo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaApoyo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaApoyo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_cancelar;
    private com.k33ptoo.components.KButton btn_cancelar1;
    private javax.swing.JButton btn_excel;
    private com.k33ptoo.components.KButton btn_guardar;
    private com.k33ptoo.components.KButton btn_guardar1;
    private com.k33ptoo.components.KButton btn_limpiar;
    private com.raven.swing.ButtomImage buttomImage1;
    private com.raven.swing.Button button1;
    private com.raven.swing.MenuButton menuButton1;
    // End of variables declaration//GEN-END:variables
}
