
package vista;

import controlador.ControladorInterfaz;
import controlador.ControladorObservacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.Nivel;
import modelo.Persona;



public class VentanaHojadeVida extends javax.swing.JFrame {

    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorObservacion co = new ControladorObservacion();
    public VentanaHojadeVida() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        /* tbl_observaciones.getTableHeader().setForeground(new Color(255,255,255));
        tbl_observaciones.getTableHeader().setBackground(new Color(0,0,0));
        tbl_observaciones.setRowHeight(100);
        tbl_observaciones.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));*/
        ci.cargarCbNivel(cb_nivel);
        tbl_positiva.getTableHeader().setForeground(new Color(255,255,255));
        tbl_positiva.getTableHeader().setBackground(new Color(51,102,0));
        tbl_positiva.setRowHeight(150);
        tbl_positiva.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        
        tbl_negativa.getTableHeader().setForeground(new Color(255,255,255));
        tbl_negativa.getTableHeader().setBackground(new Color(204,0,0));
        tbl_negativa.setRowHeight(150);
        tbl_negativa.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        DefaultTableModel model1 = (DefaultTableModel) tbl_positiva.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tbl_negativa.getModel();
        model1.setRowCount(0);
        model2.setRowCount(0);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        cb_nivel = new combo_suggestion.ComboBoxSuggestion();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_curso = new combo_suggestion.ComboBoxSuggestion();
        cb_alumno = new combo_suggestion.ComboBoxSuggestion();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_positiva = new dynamic_subjtable.TableCustom();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_negativa = new dynamic_subjtable.TableCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hoja de Vida");
        setIconImage(getIconImage());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hoja de vida");

        cb_nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nivelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nivel:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Curso:");

        cb_curso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_cursoItemStateChanged(evt);
            }
        });
        cb_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cursoActionPerformed(evt);
            }
        });

        cb_alumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_alumnoItemStateChanged(evt);
            }
        });
        cb_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_alumnoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alumno:");

        tbl_positiva.setForeground(new java.awt.Color(51, 102, 0));
        tbl_positiva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Positiva"
            }
        ));
        tbl_positiva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_positiva.setMaximumSize(new java.awt.Dimension(450, 250));
        tbl_positiva.setSelectionBackground(new java.awt.Color(51, 102, 0));
        tbl_positiva.setShowGrid(true);
        jScrollPane1.setViewportView(tbl_positiva);

        tbl_negativa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Negativa"
            }
        ));
        tbl_negativa.setCellSelectionEnabled(true);
        tbl_negativa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_negativa.setMaximumSize(new java.awt.Dimension(450, 250));
        tbl_negativa.setName(""); // NOI18N
        tbl_negativa.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tbl_negativa.setShowGrid(true);
        jScrollPane2.setViewportView(tbl_negativa);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jLabel1))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_curso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_nivel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cb_nivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nivelActionPerformed
        Nivel n = (Nivel)cb_nivel.getSelectedItem();
        cb_curso.removeAllItems();
        ci.cargarCbcursosPorDocenteoNivel(cb_curso, 0, n.getId());
    }//GEN-LAST:event_cb_nivelActionPerformed

    private void cb_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cursoActionPerformed
        Curso c = (Curso)cb_curso.getSelectedItem();
        if(c != null)
            ci.cargarCbAlumnosporCurso(cb_alumno, c.getId());
            
        

    }//GEN-LAST:event_cb_cursoActionPerformed

    private void cb_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_alumnoActionPerformed
        listarObservaciones(tbl_positiva , tbl_negativa);
    }//GEN-LAST:event_cb_alumnoActionPerformed

    private void cb_alumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_alumnoItemStateChanged
        listarObservaciones(tbl_positiva , tbl_negativa);
    }//GEN-LAST:event_cb_alumnoItemStateChanged

    private void cb_cursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_cursoItemStateChanged

    }//GEN-LAST:event_cb_cursoItemStateChanged
    private void listarObservaciones(JTable tbl1, JTable tbl2){
        Curso c = (Curso)cb_curso.getSelectedItem();
        Persona p = (Persona)cb_alumno.getSelectedItem();
        if(p != null)
            co.observacionListar(p.getRun(), c.getId(), tbl1, tbl2);
        

        
    }
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
            java.util.logging.Logger.getLogger(VentanaHojadeVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaHojadeVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaHojadeVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaHojadeVida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaHojadeVida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private combo_suggestion.ComboBoxSuggestion cb_alumno;
    private combo_suggestion.ComboBoxSuggestion cb_curso;
    private combo_suggestion.ComboBoxSuggestion cb_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private dynamic_subjtable.TableCustom tbl_negativa;
    private dynamic_subjtable.TableCustom tbl_positiva;
    // End of variables declaration//GEN-END:variables
}
