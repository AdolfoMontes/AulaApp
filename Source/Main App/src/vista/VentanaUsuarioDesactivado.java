
package vista;

import controlador.ControladorPersona;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import static vista.VentanaPrincipal.lbl_contadoractivos;
import static vista.VentanaPrincipal.lbl_contadoralumnos;
import static vista.VentanaPrincipal.lbl_contadordocentes;
import static vista.VentanaUsuarios.tbl_usuarios;


public class VentanaUsuarioDesactivado extends javax.swing.JFrame {
    ControladorPersona cp = new ControladorPersona();
    public VentanaUsuarioDesactivado() {
        initComponents();
        this.setLocationRelativeTo(null);
        cp.listarPersonasDesactivadas(tbl_usuariosdesactivados);
        btn_reactivar.setEnabled(false);
        tbl_usuariosdesactivados.getTableHeader().setForeground(new Color(255,255,255));
        tbl_usuariosdesactivados.getTableHeader().setBackground(new Color(51,51,51));
        tbl_usuariosdesactivados.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
    }

        @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_usuariosdesactivados = new javax.swing.JTable();
        btn_reactivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());

        tbl_usuariosdesactivados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RUN", "Nombre Completo", "Fecha Nac.", "Sexo", "Pueblo Indig.", "Dirección", "Mail", "Codigo usuario", "Rol", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_usuariosdesactivados.setSelectionBackground(new java.awt.Color(0, 51, 0));
        tbl_usuariosdesactivados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usuariosdesactivadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_usuariosdesactivados);
        if (tbl_usuariosdesactivados.getColumnModel().getColumnCount() > 0) {
            tbl_usuariosdesactivados.getColumnModel().getColumn(9).setPreferredWidth(45);
        }

        btn_reactivar.setBackground(new java.awt.Color(51, 102, 0));
        btn_reactivar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_reactivar.setForeground(new java.awt.Color(255, 255, 255));
        btn_reactivar.setText("Reactivar Usuario");
        btn_reactivar.setBorderPainted(false);
        btn_reactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reactivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_reactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_usuariosdesactivadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuariosdesactivadosMouseClicked
        btn_reactivar.setEnabled(true);
    }//GEN-LAST:event_tbl_usuariosdesactivadosMouseClicked

    private void btn_reactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reactivarActionPerformed
        int filaSeleccionada = tbl_usuariosdesactivados.getSelectedRow();
        String runCompleto = (String)tbl_usuariosdesactivados.getValueAt(filaSeleccionada, 0);
        String [] runParseado = runCompleto.split("-");
        int validador = cp.activarPersona(Integer.parseInt(runParseado[0]));
        btn_reactivar.setEnabled(true);
        int seleccion = JOptionPane.showConfirmDialog(null, "¿Realmente desea activar al usuario RUN "+ runCompleto + " ?", "Confirmar desactivación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (seleccion ==0){
            if (validador == 0){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Usuario "+ runCompleto + " activado", "Correcto");
            noti.showNotification();
            lbl_contadoractivos.setText(String.valueOf(cp.contarPersonas(1)));
            lbl_contadordocentes.setText(String.valueOf(cp.contarPersonas(2)));
            lbl_contadoralumnos.setText(String.valueOf(cp.contarPersonas(3)));
            //JOptionPane.showMessageDialog(rootPane, "Usuario "+ runCompleto + " activado correctamente");
            btn_reactivar.setEnabled(false);
            cp.listarPersonas(tbl_usuarios);
            
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error", "Error");
                noti.showNotification();
                //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, por favor intente nuevamente","Error",2);
            }
        }
        cp.listarPersonasDesactivadas(tbl_usuariosdesactivados);
    }//GEN-LAST:event_btn_reactivarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaUsuarioDesactivado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarioDesactivado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarioDesactivado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarioDesactivado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuarioDesactivado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reactivar;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbl_usuariosdesactivados;
    // End of variables declaration//GEN-END:variables
}
