
package vista;

import controlador.ControladorAsistencia;
import controlador.ControladorInterfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.Nivel;
import modelo.Persona;
import modelo.Usuario;


public class VentanaAsistencia extends javax.swing.JFrame {

    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorAsistencia ca = new ControladorAsistencia();
    Usuario usuarioLogueado;
    public VentanaAsistencia() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_asistencia.getTableHeader().setForeground(new Color(255,255,255));
        tbl_asistencia.getTableHeader().setBackground(new Color(0,51,0));
        tbl_asistencia.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_asistencia.setRowHeight(50);
        ci.cargarCbDocente(cb_docente);
        
     
        ci.eliminarColumna(tbl_asistencia, 0);
        ci.eliminarColumna(tbl_asistencia, 2);
        ci.eliminarColumna(tbl_asistencia, 4);
        

       
    }
    public VentanaAsistencia(Usuario usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        usuarioLogueado = usuario;
        tbl_asistencia.getTableHeader().setForeground(new Color(255,255,255));
        tbl_asistencia.getTableHeader().setBackground(new Color(0,51,0));
        tbl_asistencia.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_asistencia.setRowHeight(50);
        ci.cargarCbDocente(cb_docente);
        
        ci.eliminarColumna(tbl_asistencia, 0);
        ci.eliminarColumna(tbl_asistencia, 2);
        ci.eliminarColumna(tbl_asistencia, 4);
        DefaultTableModel modelo = (DefaultTableModel) tbl_asistencia.getModel();
        modelo.setRowCount(0);

       
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_asistencia = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        fecha = new com.raven.datechooser.DateChooser();
        cb_docente = new combo_suggestion.ComboBoxSuggestion();
        cb_nivel = new combo_suggestion.ComboBoxSuggestion();
        cb_curso = new combo_suggestion.ComboBoxSuggestion();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_cargar = new com.k33ptoo.components.KButton();
        jLabel5 = new javax.swing.JLabel();
        btn_guardar = new com.k33ptoo.components.KButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asistencias");
        setIconImage(getIconImage());

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 0, 51));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asistencias");

        tbl_asistencia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tbl_asistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha Creacion", "Fecha Asistencia", "Usuario Creación", "RUN", "ID curso", "Nombre Alumno", "Presente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_asistencia.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tbl_asistencia.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbl_asistencia);
        if (tbl_asistencia.getColumnModel().getColumnCount() > 0) {
            tbl_asistencia.getColumnModel().getColumn(1).setPreferredWidth(90);
            tbl_asistencia.getColumnModel().getColumn(1).setMaxWidth(120);
            tbl_asistencia.getColumnModel().getColumn(3).setPreferredWidth(90);
            tbl_asistencia.getColumnModel().getColumn(5).setPreferredWidth(250);
            tbl_asistencia.getColumnModel().getColumn(6).setPreferredWidth(60);
        }

        fecha.setForeground(new java.awt.Color(102, 0, 102));

        cb_docente.setEditable(false);
        cb_docente.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cb_docente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cb_docentePopupMenuWillBecomeVisible(evt);
            }
        });
        cb_docente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_docenteActionPerformed(evt);
            }
        });

        cb_nivel.setEditable(false);
        cb_nivel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cb_nivel.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cb_nivelPopupMenuWillBecomeVisible(evt);
            }
        });
        cb_nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nivelActionPerformed(evt);
            }
        });

        cb_curso.setEditable(false);
        cb_curso.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecciona un docente para ver sus cursos:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("O selecciona un nivel:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Finalmente, selecciona el curso:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Selecciona la fecha:");

        btn_cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_refresh_40px.png"))); // NOI18N
        btn_cargar.setText("Cargar Alumnos");
        btn_cargar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cargar.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_cargar.setkHoverEndColor(new java.awt.Color(102, 0, 0));
        btn_cargar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_cargar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_cargar.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(fecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cb_docente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cb_nivel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cb_curso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btn_cargar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2)
            .addComponent(cb_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3)
            .addComponent(cb_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel6)
            .addComponent(jLabel4)
            .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_cargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(cb_docente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(cb_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Listado de Alumnos");

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar.setText("Guardar Asistencia");
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar.setkBackGroundColor(new java.awt.Color(153, 0, 51));
        btn_guardar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkSelectedColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkStartColor(new java.awt.Color(0, 102, 0));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(204, 204, 204)))))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(358, 358, 358))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLayeredPane1)
                        .addGap(22, 22, 22))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String fechaAsistencia = fecha.getSelectedDate().getDay() + "-" +  
        fecha.getSelectedDate().getMonth() + "-" + fecha.getSelectedDate().getYear();
        Curso c = (Curso)cb_curso.getSelectedItem();
        int idCurso = c.getId();
        String validador1 ="-1";
        for (int i = 0; i < tbl_asistencia.getRowCount(); i ++){
             Boolean seleccion = (Boolean)tbl_asistencia.getValueAt(i, 6);
             //int fila = (int)tbl_asistencia.getSelectedRow();
             //int id = (int)tbl_asistencia.getValueAt(fila, 0 );
             int run = Integer.parseInt(String.valueOf(tbl_asistencia.getValueAt(i, 3 )));
             String estado = "0";
             if(seleccion){
                 estado = "1";
             }else{
                 estado = "0";
             }
             int diasbloqueo = ca.diasBloqueo(4);
             validador1 = ca.guardarAsistencia(fechaAsistencia, estado, usuarioLogueado.getCodUsuario(), run, idCurso, diasbloqueo);
             System.out.println("Marcada asistencia-> ID:" +  run + " Presente: " + seleccion);
         }
        if(validador1.equals("0")){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Asistencia registrada" , "Correcto");
            noti.showNotification(); 
            //JOptionPane.showMessageDialog(rootPane, "Asistencia registrada exitosamente");
        }else if(validador1.equals("1")){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Asistencia actualizada" , "Correcto");
            noti.showNotification(); 
            //JOptionPane.showMessageDialog(rootPane, "La asistencia ya existía, por lo que lo hemos actualizado.");
        }else if(validador1.equals("-2")){
            Notification noti= new Notification(this, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Fecha anterior a 7 días" , "Acción rechazada");
            noti.showNotification(); 
            //JOptionPane.showMessageDialog(rootPane, "No puedes insertar asistencia a una fecha anterior a 7 días.");
        }else if(validador1.equals("-3")){
            Notification noti= new Notification(this, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Fecha futura" , "Acción rechazada");
            noti.showNotification();    
            //JOptionPane.showMessageDialog(rootPane, "La asistencia no se puede insertar en fechas futuras.");
        }
        else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error, cod:" + validador1, "Error");
            noti.showNotification();    
            //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, por favor reintente. Código de error:" + validador1);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void cb_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cursoActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_cb_cursoActionPerformed

    private void cb_docenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_docenteActionPerformed
        cb_curso.removeAllItems();
        Persona docente = (Persona)cb_docente.getSelectedItem();
        int idDocente = docente.getRun();
        cb_nivel.removeAllItems();
        ci.cargarCbcursosPorDocenteoNivel(cb_curso, idDocente, 0);
    }//GEN-LAST:event_cb_docenteActionPerformed

    private void cb_nivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nivelActionPerformed
        cb_curso.removeAllItems();
        Nivel n= (Nivel)cb_nivel.getSelectedItem();
        int idNivel = n.getId();
        ci.cargarCbcursosPorDocenteoNivel(cb_curso, 0, idNivel);
    }//GEN-LAST:event_cb_nivelActionPerformed

    private void cb_nivelPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_nivelPopupMenuWillBecomeVisible
        cb_docente.removeAllItems();
        ci.cargarCbNivel(cb_nivel);
    }//GEN-LAST:event_cb_nivelPopupMenuWillBecomeVisible

    private void cb_cursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_cursoItemStateChanged

    }//GEN-LAST:event_cb_cursoItemStateChanged

    private void cb_docentePopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cb_docentePopupMenuWillBecomeVisible
        cb_docente.removeAllItems();
        ci.cargarCbDocente(cb_docente);
    }//GEN-LAST:event_cb_docentePopupMenuWillBecomeVisible

    private void btn_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarActionPerformed
        if(cb_curso.getSelectedItem() != null){
            Curso curso = (Curso)cb_curso.getSelectedItem();
            int idCurso = curso.getId();
            System.out.println("ID:" + idCurso);
            ca.listarAsistencia(tbl_asistencia, idCurso, String.format("%02d",fecha.getSelectedDate().getDay()) + "-" +  
                     String.format("%02d",fecha.getSelectedDate().getMonth()) + "-" + fecha.getSelectedDate().getYear());
        }
    }//GEN-LAST:event_btn_cargarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAsistencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_cargar;
    private com.k33ptoo.components.KButton btn_guardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private combo_suggestion.ComboBoxSuggestion cb_curso;
    private combo_suggestion.ComboBoxSuggestion cb_docente;
    private combo_suggestion.ComboBoxSuggestion cb_nivel;
    private com.raven.datechooser.DateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JTable tbl_asistencia;
    // End of variables declaration//GEN-END:variables
}
