/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorAsistencia;
import controlador.ControladorInterfaz;
import db.Conexion;
import ds.desktop.notify.DesktopNotify;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Notification;
import modelo.Curso;
import modelo.Persona;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.view.JasperViewer;


public class VentanaReportes extends javax.swing.JFrame {
    int x=0;
    int y=0;
    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorAsistencia ca = new ControladorAsistencia();
    public VentanaReportes() {
        initComponents();
        this.setLocationRelativeTo(null);
        ci.cargarCbanios(cb_anio);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlowingGradient1 = new javaswingdev.pggb.PanelGlowingGradient();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_reporteobservaciones = new com.raven.swing.Button();
        btn_informeasistencia = new com.raven.swing.Button();
        btn_certificadodenotas = new com.raven.swing.Button();
        cb_alumno = new combo_suggestion.ComboBoxSuggestion();
        cb_anio = new combo_suggestion.ComboBoxSuggestion();
        cb_curso = new combo_suggestion.ComboBoxSuggestion();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reportes");
        setBackground(new java.awt.Color(102, 102, 102));
        setIconImage(getIconImage());
        setType(java.awt.Window.Type.POPUP);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        panelGlowingGradient1.setBackground(new java.awt.Color(102, 102, 102));
        panelGlowingGradient1.setToolTipText("");
        panelGlowingGradient1.setBackgroundLight(new java.awt.Color(102, 102, 102));
        panelGlowingGradient1.setGradientColor1(new java.awt.Color(204, 102, 0));
        panelGlowingGradient1.setOpaque(true);
        panelGlowingGradient1.setShadowSize(10);
        panelGlowingGradient1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelGlowingGradient1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelGlowingGradient1MouseMoved(evt);
            }
        });
        panelGlowingGradient1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelGlowingGradient1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Curso:");
        panelGlowingGradient1.add(jLabel1);
        jLabel1.setBounds(40, 130, 34, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alumno:");
        panelGlowingGradient1.add(jLabel2);
        jLabel2.setBounds(30, 170, 46, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Año:");
        panelGlowingGradient1.add(jLabel3);
        jLabel3.setBounds(50, 90, 25, 30);

        btn_reporteobservaciones.setBackground(new java.awt.Color(153, 0, 0));
        btn_reporteobservaciones.setForeground(new java.awt.Color(255, 255, 255));
        btn_reporteobservaciones.setText("Reporte de Observaciones");
        btn_reporteobservaciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_reporteobservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reporteobservacionesActionPerformed(evt);
            }
        });
        panelGlowingGradient1.add(btn_reporteobservaciones);
        btn_reporteobservaciones.setBounds(80, 320, 210, 40);

        btn_informeasistencia.setBackground(new java.awt.Color(204, 102, 0));
        btn_informeasistencia.setForeground(new java.awt.Color(255, 255, 255));
        btn_informeasistencia.setText("Certificado de Asistencia");
        btn_informeasistencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_informeasistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_informeasistenciaActionPerformed(evt);
            }
        });
        panelGlowingGradient1.add(btn_informeasistencia);
        btn_informeasistencia.setBounds(80, 220, 210, 40);

        btn_certificadodenotas.setBackground(new java.awt.Color(0, 102, 0));
        btn_certificadodenotas.setForeground(new java.awt.Color(255, 255, 255));
        btn_certificadodenotas.setText("Certificado de Notas");
        btn_certificadodenotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_certificadodenotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_certificadodenotasActionPerformed(evt);
            }
        });
        panelGlowingGradient1.add(btn_certificadodenotas);
        btn_certificadodenotas.setBounds(80, 270, 210, 40);
        panelGlowingGradient1.add(cb_alumno);
        cb_alumno.setBounds(90, 170, 230, 26);

        cb_anio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_anioActionPerformed(evt);
            }
        });
        panelGlowingGradient1.add(cb_anio);
        cb_anio.setBounds(90, 90, 230, 26);

        cb_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cursoActionPerformed(evt);
            }
        });
        panelGlowingGradient1.add(cb_curso);
        cb_curso.setBounds(90, 130, 230, 26);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Reportes");
        panelGlowingGradient1.add(jLabel6);
        jLabel6.setBounds(70, 20, 230, 38);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGlowingGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlowingGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
   
    }//GEN-LAST:event_formWindowLostFocus

    private void panelGlowingGradient1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelGlowingGradient1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panelGlowingGradient1MousePressed

    private void panelGlowingGradient1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelGlowingGradient1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_panelGlowingGradient1MouseDragged

    private void panelGlowingGradient1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelGlowingGradient1MouseMoved
        
    }//GEN-LAST:event_panelGlowingGradient1MouseMoved

    private void btn_certificadodenotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_certificadodenotasActionPerformed
        Persona alumno = (Persona)cb_alumno.getSelectedItem();
        Curso c = (Curso)cb_curso.getSelectedItem();
        try {
            Conexion conn = new Conexion();
            JasperReport archivo = JasperCompileManager.compileReport("reports\\certificado_nota.jrxml");
            Map<String, Object> map = new HashMap<String, Object>();
            String path = "reports\\Certificado_Notas_Header.jasper";
            String pathSubReportTabla = "reports\\tabla_notas_sub.jasper";
            map.put("runAlumno",alumno.getRun());
            map.put("idCurso",c.getId());
            map.put("subReport", path);
            map.put("subReportTabla", pathSubReportTabla);
            JasperPrint print = JasperFillManager.fillReport(archivo, map,conn.getConnection() );
            JasperViewer view = new JasperViewer(print,false);
            //JasperExportManager print = JasperFillManager.fillReport(archivo, map, con.getConnection());
            view.setVisible(true);
        }catch (JRException ex) {
            Logger.getLogger(VentanaReportes.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btn_certificadodenotasActionPerformed

    private void cb_anioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_anioActionPerformed
        cb_curso.removeAllItems();
        int anio = Integer.parseInt(String.valueOf(cb_anio.getSelectedItem()));
        ci.cargarCbcursoporAnio(cb_curso, anio);
    }//GEN-LAST:event_cb_anioActionPerformed

    private void cb_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cursoActionPerformed
        cb_alumno.removeAllItems();
        Curso c = (Curso)cb_curso.getSelectedItem();
        if(c!=null)
            ci.cargarCbAlumnosporCurso(cb_alumno, c.getId());
    }//GEN-LAST:event_cb_cursoActionPerformed

    private void btn_informeasistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_informeasistenciaActionPerformed
        Persona alumno = (Persona)cb_alumno.getSelectedItem();
        Curso c = (Curso)cb_curso.getSelectedItem();
        int validador = ca.validarSiTieneAsistencia(alumno.getRun(), c.getId());
        System.out.println("RUN->" + alumno.getRun() + " IDCURSO->" + c.getId());
        System.out.println(validador);
        if(validador>0){
            try {
            Conexion conn = new Conexion();
            JasperReport archivo = JasperCompileManager.compileReport("reports\\certificado_asistencia.jrxml");
            Map<String, Object> map = new HashMap<>();
            String path = "reports\\Certificado_Notas_Header.jasper";
            map.put("runAlumno",alumno.getRun());
            map.put("idCurso",c.getId());
            map.put("subReport", path);
            JasperPrint print = JasperFillManager.fillReport(archivo, map,conn.getConnection() );
            JasperViewer view = new JasperViewer(print,false);
            //JasperExportManager print = JasperFillManager.fillReport(archivo, map, con.getConnection());
            view.setVisible(true);
            }catch (JRException ex) {
                Logger.getLogger(VentanaReportes.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Sin asistencias", "No hay datos");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp","El alumno no tiene asistencias para mostrar.", DesktopNotify.ERROR, 15000L);
        }
        
    }//GEN-LAST:event_btn_informeasistenciaActionPerformed

    private void btn_reporteobservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reporteobservacionesActionPerformed
        Persona alumno = (Persona)cb_alumno.getSelectedItem();
        Curso c = (Curso)cb_curso.getSelectedItem();
        try {
            Conexion conn = new Conexion();
            JasperReport archivo = JasperCompileManager.compileReport("reports\\reporte_observaciones.jrxml");
            Map<String, Object> map = new HashMap<>();
            map.put("runAlumno",alumno.getRun());
            map.put("idCurso",c.getId());
            JasperPrint print = JasperFillManager.fillReport(archivo, map,conn.getConnection() );
            JasperViewer view = new JasperViewer(print,false);
            //JasperExportManager print = JasperFillManager.fillReport(archivo, map, con.getConnection());
            view.setVisible(true);
            }catch (JRException ex) {
                Logger.getLogger(VentanaReportes.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }//GEN-LAST:event_btn_reporteobservacionesActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button btn_certificadodenotas;
    private com.raven.swing.Button btn_informeasistencia;
    private com.raven.swing.Button btn_reporteobservaciones;
    private combo_suggestion.ComboBoxSuggestion cb_alumno;
    private combo_suggestion.ComboBoxSuggestion cb_anio;
    private combo_suggestion.ComboBoxSuggestion cb_curso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient1;
    // End of variables declaration//GEN-END:variables
}
