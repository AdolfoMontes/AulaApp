
package vista;

import controlador.ControladorSala;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import modelo.Sala;


public class VentanaSalas extends javax.swing.JFrame {

    ControladorSala cs = new ControladorSala();
    public VentanaSalas() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_salas.getTableHeader().setForeground(new Color(255,255,255));
        tbl_salas.getTableHeader().setBackground(new Color(0,0,0));
        tbl_salas.setRowHeight(30);
        tbl_salas.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        cs.salaListar(tbl_salas);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));

    return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componentResizerUtil1 = new com.k33ptoo.utils.ComponentResizerUtil();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_eliminar = new com.k33ptoo.components.KButton();
        btn_modificar = new com.k33ptoo.components.KButton();
        btn_agregar = new com.k33ptoo.components.KButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_salas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Salas");
        setIconImage(getIconImage());

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(102, 102, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(230, 438));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Salas");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_classroom_48px.png"))); // NOI18N

        btn_eliminar.setForeground(new java.awt.Color(0, 0, 0));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_trash_40px.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_eliminar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_eliminar.setkHoverColor(new java.awt.Color(204, 102, 0));
        btn_eliminar.setkHoverEndColor(new java.awt.Color(102, 0, 102));
        btn_eliminar.setkHoverForeGround(new java.awt.Color(204, 102, 0));
        btn_eliminar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_eliminar.setkSelectedColor(new java.awt.Color(153, 51, 0));
        btn_eliminar.setkStartColor(new java.awt.Color(153, 0, 51));
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseClicked(evt);
            }
        });
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_modificar.setForeground(new java.awt.Color(0, 0, 0));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_edit_40px.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_modificar.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_modificar.setkHoverColor(new java.awt.Color(204, 102, 0));
        btn_modificar.setkHoverEndColor(new java.awt.Color(102, 0, 102));
        btn_modificar.setkHoverForeGround(new java.awt.Color(204, 102, 0));
        btn_modificar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_modificar.setkSelectedColor(new java.awt.Color(153, 51, 0));
        btn_modificar.setkStartColor(new java.awt.Color(0, 0, 102));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_add_40px.png"))); // NOI18N
        btn_agregar.setText("Agregar Sala");
        btn_agregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_agregar.setkEndColor(new java.awt.Color(204, 204, 204));
        btn_agregar.setkHoverColor(new java.awt.Color(204, 102, 0));
        btn_agregar.setkHoverEndColor(new java.awt.Color(102, 0, 102));
        btn_agregar.setkHoverForeGround(new java.awt.Color(204, 102, 0));
        btn_agregar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_agregar.setkSelectedColor(new java.awt.Color(153, 51, 0));
        btn_agregar.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_salas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Código de Sala", "Piso", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_salas.setGridColor(new java.awt.Color(204, 102, 0));
        tbl_salas.setSelectionBackground(new java.awt.Color(102, 102, 0));
        tbl_salas.setShowGrid(true);
        tbl_salas.getTableHeader().setReorderingAllowed(false);
        tbl_salas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl_salasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_salas);
        if (tbl_salas.getColumnModel().getColumnCount() > 0) {
            tbl_salas.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_salas.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbl_salas.getColumnModel().getColumn(2).setPreferredWidth(30);
            tbl_salas.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        Sala s = new Sala();
        int filaSeleccionada = tbl_salas.getSelectedRow();
        if (filaSeleccionada != -1){
            Integer id = Integer.parseInt(String.valueOf(tbl_salas.getValueAt(filaSeleccionada, 0)));
            String codSala = (String)tbl_salas.getValueAt(filaSeleccionada, 1);
            String piso = (String)tbl_salas.getValueAt(filaSeleccionada, 2);
            s.setIdSala(id);
            s.setPiso(piso);
            s.setCodSala(codSala);
            VentanaModificarSala vm = new VentanaModificarSala(s);
            vm.setVisible(true);

        }else{
            DesktopNotify.showDesktopMessage("AulaApp", "Debe seleccionar un registro", DesktopNotify.ERROR, 5000L);
        }
        
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        VentanaAgregarSala vas = new VentanaAgregarSala();
        vas.setVisible(true);
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void tbl_salasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_salasFocusGained
        cs.salaListar(tbl_salas);
    }//GEN-LAST:event_tbl_salasFocusGained

    private void btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseClicked
    }//GEN-LAST:event_btn_eliminarMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        int filaSeleccionada = tbl_salas.getSelectedRow();
        if (filaSeleccionada != -1){
            Sala s = new Sala();
            Integer id = Integer.parseInt(String.valueOf(tbl_salas.getValueAt(filaSeleccionada, 0)));
            String codSala = (String)tbl_salas.getValueAt(filaSeleccionada, 1);
            String piso = (String)tbl_salas.getValueAt(filaSeleccionada, 2);
            s.setIdSala(id);
            s.setCodSala(codSala);
            s.setPiso(piso);
            int seleccion = JOptionPane.showConfirmDialog(null, "¿Realmente desea desactivar la sala "+ codSala + " ?", "Confirmar desactivación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (seleccion == 0 ){
                int validador = cs.desactivarSala(s);
                if(validador == 0){
                    JOptionPane.showMessageDialog(rootPane, "Sala " + codSala + " desactivada correctamente.");
                    cs.salaListar(tbl_salas);
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error desactivando la sala, por favor intente nuevamente.");
            }
           }
        }else{
            DesktopNotify.showDesktopMessage("AulaApp", "Debe seleccionar un registro", DesktopNotify.ERROR, 5000L);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSalas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSalas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_agregar;
    private com.k33ptoo.components.KButton btn_eliminar;
    private com.k33ptoo.components.KButton btn_modificar;
    private com.k33ptoo.utils.ComponentResizerUtil componentResizerUtil1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    public static javax.swing.JTable tbl_salas;
    // End of variables declaration//GEN-END:variables
}
