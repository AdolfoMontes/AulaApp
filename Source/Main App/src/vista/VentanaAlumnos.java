
package vista;
import controlador.ControladorInterfaz;
import controlador.ControladorPersona;
import controlador.ExportarExcel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class VentanaAlumnos extends javax.swing.JFrame {
    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorPersona cp = new ControladorPersona();
    ExportarExcel ex = new ExportarExcel();
    public VentanaAlumnos() {
        initComponents();
        tbl_alumnos.getTableHeader().setForeground(new Color(255,255,255));
        tbl_alumnos.getTableHeader().setBackground(new Color(0,51,0));
        tbl_alumnos.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_alumnos.setRowHeight(30);
        this.setLocationRelativeTo(null);
        cp.listarAlumnosconCurso(tbl_alumnos);
        ci.cargarCbCurso2(cb_curso);
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
        btn_eliminaralumno.setEnabled(false);
        if(VentanaPrincipal.usuarioLogueado.getDescripcion()!=null){
            if(VentanaPrincipal.usuarioLogueado.getDescripcion().equals("Docente")){
                btn_nuevoalumno.setEnabled(false);
            }
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }
    
    
    public void newFilter(String box1, String box2, JTable jtable) {
        RowFilter<Object, Object> rf = null;
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jtable.getModel());
        List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);
        int cont = 0;
        if (!box1.isBlank()) {
            cont++;
            filters.add(RowFilter.regexFilter(box1, 2));
        }

        if (!box2.isBlank()) {
            cont++;
            filters.add(RowFilter.regexFilter(box2, 3));
        }


        try {
            rf = RowFilter.orFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        if (cont != 0) {
            sorter.setRowFilter(rf);
        }
        jtable.setRowSorter(sorter);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_alumnos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_nuevoalumno = new javax.swing.JButton();
        btn_eliminaralumno = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_runalumno = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        cb_curso = new javax.swing.JComboBox<>();
        btn_filtrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de alumnos");
        setIconImage(getIconImage());
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tbl_alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "RUN", "Nombre", "Estado", "Curso Asignado", "Año", "Sexo", "Edad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_alumnos.setGridColor(new java.awt.Color(204, 102, 0));
        tbl_alumnos.setSelectionBackground(new java.awt.Color(0, 51, 0));
        tbl_alumnos.setShowGrid(true);
        tbl_alumnos.getTableHeader().setReorderingAllowed(false);
        tbl_alumnos.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tbl_alumnosComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                tbl_alumnosComponentRemoved(evt);
            }
        });
        tbl_alumnos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbl_alumnosFocusGained(evt);
            }
        });
        tbl_alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_alumnosMouseClicked(evt);
            }
        });
        tbl_alumnos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_alumnosPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_alumnos);
        if (tbl_alumnos.getColumnModel().getColumnCount() > 0) {
            tbl_alumnos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_alumnos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_alumnos.getColumnModel().getColumn(2).setPreferredWidth(30);
            tbl_alumnos.getColumnModel().getColumn(3).setPreferredWidth(30);
            tbl_alumnos.getColumnModel().getColumn(4).setPreferredWidth(20);
            tbl_alumnos.getColumnModel().getColumn(5).setPreferredWidth(30);
            tbl_alumnos.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_microsoft_excel_48px.png"))); // NOI18N
        jButton1.setToolTipText("Exportar tabla a Excel");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_nuevoalumno.setBackground(new java.awt.Color(102, 102, 102));
        btn_nuevoalumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_nuevoalumno.setForeground(new java.awt.Color(255, 255, 255));
        btn_nuevoalumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_add_40px.png"))); // NOI18N
        btn_nuevoalumno.setText("Agregar alumno a curso");
        btn_nuevoalumno.setToolTipText("Agregar alumno");
        btn_nuevoalumno.setBorderPainted(false);
        btn_nuevoalumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoalumnoActionPerformed(evt);
            }
        });

        btn_eliminaralumno.setBackground(new java.awt.Color(153, 0, 0));
        btn_eliminaralumno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_eliminaralumno.setForeground(new java.awt.Color(255, 255, 255));
        btn_eliminaralumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_trash_40px.png"))); // NOI18N
        btn_eliminaralumno.setText("Quitar alumno de curso");
        btn_eliminaralumno.setBorderPainted(false);
        btn_eliminaralumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminaralumnoActionPerformed(evt);
            }
        });

        btn_refresh.setBackground(new java.awt.Color(51, 51, 51));
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_refresh_35px_1.png"))); // NOI18N
        btn_refresh.setToolTipText("Refrescar");
        btn_refresh.setBorderPainted(false);
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Resultados:");

        lbl_cantidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbl_cantidad.setText("cantidad");

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 51, 0));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(230, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alumnos");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RUT Alumno:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Curso:");

        txt_runalumno.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_runalumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_runalumnoActionPerformed(evt);
            }
        });
        txt_runalumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_runalumnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_runalumnoKeyTyped(evt);
            }
        });

        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });

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
        cb_curso.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cb_cursoPropertyChange(evt);
            }
        });

        btn_filtrar.setBackground(new java.awt.Color(204, 102, 0));
        btn_filtrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_filtrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_filtrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_filter_24px.png"))); // NOI18N
        btn_filtrar.setText("Filtrar");
        btn_filtrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 102, 0), 3, true));
        btn_filtrar.setBorderPainted(false);
        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombre)
                            .addComponent(cb_curso, 0, 136, Short.MAX_VALUE)
                            .addComponent(txt_runalumno))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_runalumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(btn_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_eliminaralumno)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_cantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                        .addComponent(btn_nuevoalumno)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eliminaralumno, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbl_cantidad))
                        .addComponent(btn_refresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_nuevoalumno, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_runalumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_runalumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_runalumnoActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed
        ci.filtro(String.valueOf(cb_curso.getSelectedItem()), tbl_alumnos, 3);
        btn_eliminaralumno.setEnabled(false);
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
        

    }//GEN-LAST:event_btn_filtrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            ex.exportarExcel(tbl_alumnos);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_nuevoalumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoalumnoActionPerformed
        VentanaAgregarAlumno vaa = new VentanaAgregarAlumno();
        vaa.setVisible(true);
    }//GEN-LAST:event_btn_nuevoalumnoActionPerformed

    private void txt_runalumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runalumnoKeyTyped
        
    }//GEN-LAST:event_txt_runalumnoKeyTyped

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyReleased
        ci.filtro(txt_nombre.getText(), tbl_alumnos, 1);
        btn_eliminaralumno.setEnabled(false);
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
    }//GEN-LAST:event_txt_nombreKeyReleased

    private void txt_runalumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runalumnoKeyReleased
        ci.filtro(txt_runalumno.getText(), tbl_alumnos, 0);
        btn_eliminaralumno.setEnabled(false);
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
    }//GEN-LAST:event_txt_runalumnoKeyReleased

    private void cb_cursoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cb_cursoPropertyChange
        
        
    }//GEN-LAST:event_cb_cursoPropertyChange

    private void cb_cursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_cursoItemStateChanged
        
    }//GEN-LAST:event_cb_cursoItemStateChanged

    private void cb_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cursoActionPerformed
        
    }//GEN-LAST:event_cb_cursoActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        cp.listarAlumnosconCurso(tbl_alumnos);
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_eliminaralumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminaralumnoActionPerformed
        int filaSeleccionada = tbl_alumnos.getSelectedRow();
        String runCompleto = (String)tbl_alumnos.getValueAt(filaSeleccionada, 0);
        String [] runParseado = runCompleto.split("-");

        int validador = cp.eliminarAlumnodeCurso(Integer.parseInt(runParseado[0]));
        int seleccion = JOptionPane.showConfirmDialog(null, "¿Realmente desea quitar al alumno RUN "+ runCompleto + " del curso ?", "Confirmar desactivación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(seleccion ==0){
            if(validador==0){
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "RUN " + runParseado[0]+ " eliminado" , "Correcto");
                noti.showNotification(); 
                //JOptionPane.showMessageDialog(rootPane,"El alumno de RUN "+ runParseado[0] + " fue eliminado del curso correctamente.");
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error" , "Error");
                noti.showNotification(); 
                //JOptionPane.showMessageDialog(rootPane,"Ha ocurrido un error, por favor reintente la operación");
            }
        }
        cp.listarAlumnosconCurso(tbl_alumnos);
        btn_eliminaralumno.setEnabled(false);
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
    }//GEN-LAST:event_btn_eliminaralumnoActionPerformed

    private void tbl_alumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_alumnosMouseClicked
        btn_eliminaralumno.setEnabled(true);
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
    }//GEN-LAST:event_tbl_alumnosMouseClicked

    private void tbl_alumnosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_alumnosFocusGained
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
    }//GEN-LAST:event_tbl_alumnosFocusGained

    private void tbl_alumnosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_alumnosPropertyChange
        
    }//GEN-LAST:event_tbl_alumnosPropertyChange

    private void tbl_alumnosComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tbl_alumnosComponentAdded
        
    }//GEN-LAST:event_tbl_alumnosComponentAdded

    private void tbl_alumnosComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tbl_alumnosComponentRemoved
        
    }//GEN-LAST:event_tbl_alumnosComponentRemoved

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        cp.listarAlumnosconCurso(tbl_alumnos);
        ci.contarRegistros(tbl_alumnos, lbl_cantidad);
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(VentanaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAlumnos().setVisible(true);            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminaralumno;
    private javax.swing.JButton btn_filtrar;
    private javax.swing.JButton btn_nuevoalumno;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JComboBox<String> cb_curso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbl_cantidad;
    public static javax.swing.JTable tbl_alumnos;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_runalumno;
    // End of variables declaration//GEN-END:variables
}
