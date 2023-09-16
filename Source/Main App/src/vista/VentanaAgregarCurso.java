
package vista;

import controlador.ControladorCurso;
import controlador.ControladorInterfaz;

import java.awt.Image;
import java.awt.Toolkit;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import modelo.Nivel;
import modelo.Persona;
import static vista.VentanaCursos.tbl_cursos;


public class VentanaAgregarCurso extends javax.swing.JFrame {

    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorCurso cc = new ControladorCurso();
    public VentanaAgregarCurso() {
        initComponents();
        this.setLocationRelativeTo(null);
        ci.cargarCbNivel(cb_nivel);
        ci.cargarCbDocente(cb_docente);
        
        
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spin_cant_max = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        cb_nivel = new javax.swing.JComboBox<>();
        txt_anio = new com.toedter.calendar.JYearChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nombrecurso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cb_docente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_aceptar = new com.k33ptoo.components.KButton();
        btn_cancelar = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear nuevo curso");
        setIconImage(getIconImage());

        txt_codigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Código o letra identificadora de curso:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad máxima de alumnos:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Nivel:");

        cb_nivel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txt_anio.setEndYear(2050);
        txt_anio.setStartYear(2020);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Año:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Crear nuevo curso");

        txt_nombrecurso.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_nombrecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombrecursoActionPerformed(evt);
            }
        });
        txt_nombrecurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombrecursoKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Nombre curso:");

        cb_docente.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cb_docente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
        cb_docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_docenteActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("Docente a cargo (opcional):");

        btn_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_aceptar.setText("Guardar");
        btn_aceptar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_aceptar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_aceptar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_aceptar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_aceptar.setkStartColor(new java.awt.Color(0, 102, 0));
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_nombrecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cb_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spin_cant_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombrecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spin_cant_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_docente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyReleased
        ci.limiteCaracteres(txt_codigo, 15);
    }//GEN-LAST:event_txt_codigoKeyReleased

    private void txt_nombrecursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombrecursoKeyReleased

    }//GEN-LAST:event_txt_nombrecursoKeyReleased

    private void txt_nombrecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombrecursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombrecursoActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        Nivel nivel = (Nivel)cb_nivel.getSelectedItem();
        int idnivel = nivel.getId();
        String codigo = txt_codigo.getText().toUpperCase();
        String nombre_curso = txt_nombrecurso.getText();
        int cantidad_max = (Integer)spin_cant_max.getValue();
        int anio = txt_anio.getYear();
        
        int docente = 0;
        if(cb_docente.getSelectedItem().equals("--Seleccione--")){
            docente = 0;
        }else{
            Persona d = (Persona)cb_docente.getSelectedItem();
            if (d != null){
            docente = d.getRun();
            }
        }
        if(cantidad_max <=0){
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Cantidad de alumnos no válida" , "Error");
            noti.showNotification();
           //JOptionPane.showMessageDialog(rootPane, "Cantidad de alumnos no válida");
        }
        else{
            int resultado = cc.almacenarCurso(idnivel, codigo, nombre_curso, cantidad_max, anio, docente);
            if(resultado ==0)
            {
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Curso almacenado correctamente" , "Correcto");
                noti.showNotification();
                //JOptionPane.showMessageDialog(rootPane, "Curso almacenado correctamente");
                cc.listarCursos(tbl_cursos);
                dispose();
            }else if(resultado ==1){
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Curso ya existe" , "Error");
                noti.showNotification();
                //JOptionPane.showMessageDialog(rootPane, "El curso ya existe, por favor modifique el código, nivel o año para continuar");
            }
            else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error inesperado" , "Error");
                noti.showNotification();
                //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, por favor reintente la operación", "Algo ha salido mal :(", 3);
            }
        }
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void cb_docenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_docenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_docenteActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAgregarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_aceptar;
    private com.k33ptoo.components.KButton btn_cancelar;
    private javax.swing.JComboBox<String> cb_docente;
    private javax.swing.JComboBox<Object> cb_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner spin_cant_max;
    private com.toedter.calendar.JYearChooser txt_anio;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nombrecurso;
    // End of variables declaration//GEN-END:variables
}
