
package vista;

import controlador.ControladorInterfaz;
import controlador.ControladorNota;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javaswingdev.Notification;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Asignatura;
import modelo.Curso;
import modelo.Nota;


public class VentanaNotas extends javax.swing.JFrame {
    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorNota cn = new ControladorNota();
    public VentanaNotas() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_semestre1.getTableHeader().setForeground(new Color(255,255,255));
        tbl_semestre1.getTableHeader().setBackground(new Color(0,51,0));
        tbl_semestre1.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_semestre1.setRowHeight(30);
        
        tbl_semestre2.getTableHeader().setForeground(new Color(255,255,255));
        tbl_semestre2.getTableHeader().setBackground(new Color(0,51,0));
        tbl_semestre2.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_semestre2.setRowHeight(30);
        ci.cargarCbCursoTodo(cb_cursos);
    }
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }
    private void mostrarNotas(JTable table, MouseEvent evt, int semestre){
        int column=table.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/table.getRowHeight();
        if(row<table.getRowCount()&& row >=0 && column < table.getColumnCount()&& column>=0){
            Object value=table.getValueAt(row,column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton=(JButton)value;
                Nota n = new Nota();
                Asignatura a = (Asignatura)cb_asignatura.getSelectedItem();
                int run = Integer.parseInt(String.valueOf(table.getValueAt(row, 1)));
                float n1 = Float.parseFloat(String.valueOf(table.getValueAt(row, 3)));
                float n2 = Float.parseFloat(String.valueOf(table.getValueAt(row, 4)));
                float n3 = Float.parseFloat(String.valueOf(table.getValueAt(row, 5)));
                float n4 = Float.parseFloat(String.valueOf(table.getValueAt(row, 6)));
                float n5 = Float.parseFloat(String.valueOf(table.getValueAt(row, 7)));
                float n6 = Float.parseFloat(String.valueOf(table.getValueAt(row, 8)));
                float n7 = Float.parseFloat(String.valueOf(table.getValueAt(row, 9)));
                float n8 = Float.parseFloat(String.valueOf(table.getValueAt(row, 10)));
                float n9 = Float.parseFloat(String.valueOf(table.getValueAt(row, 11)));
                float n10 = Float.parseFloat(String.valueOf(table.getValueAt(row, 12)));
                float p1 = Float.parseFloat(String.valueOf(table.getValueAt(row, 13)));
                n.setRun(run);
                n.setId_asignatura(a.getId_asignatura());
                n.setAnio(a.getAnio());
                n.setN1(n1);
                n.setN2(n2);
                n.setN3(n3);
                n.setN4(n4);
                n.setN5(n5);
                n.setN6(n6);
                n.setN7(n7);
                n.setN8(n8);
                n.setN9(n9);
                n.setN10(n10);
                n.setP1(p1);
                System.out.println(String.valueOf(tbl_semestre2.getValueAt(row, 15)));
                if(String.valueOf(tbl_semestre2.getValueAt(row, 15)).equals("En curso")){
                    VentanaCambiodeNotas vcn = new VentanaCambiodeNotas(n, semestre);
                    vcn.setVisible(true);
                }else{
                    Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Curso cerrado", "Acción rechazada");
                    noti.showNotification();
                    //DesktopNotify.showDesktopMessage("AulaApp","No puedes editar notas de un curso cerrado", DesktopNotify.ERROR, 3000L);
                }

            }
        }
    }
            

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        cb_asignatura = new combo_suggestion.ComboBoxSuggestion();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_semestre1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_semestre2 = new javax.swing.JTable();
        btn_guardar = new com.k33ptoo.components.KButton();
        jLabel5 = new javax.swing.JLabel();
        cb_cursos = new combo_suggestion.ComboBoxSuggestion();
        lbl_profesorjefe = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_profesorasignatura = new javax.swing.JLabel();
        btn_cancelar2 = new com.k33ptoo.components.KButton();
        btn_refresh = new com.k33ptoo.components.KButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asistencias");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Notas");
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(960, 600));

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 51, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Notas");

        cb_asignatura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_asignaturaItemStateChanged(evt);
            }
        });
        cb_asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_asignaturaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Asignaturas:");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(550, 64));

        kGradientPanel3.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setPreferredSize(new java.awt.Dimension(550, 64));

        tbl_semestre1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "RUN", "Nombre Alumno", "N1", "N2", "N3", "N4", "N5", "N6", "N7", "N8", "N9", "N10", "P1", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_semestre1.setSelectionBackground(new java.awt.Color(204, 102, 0));
        tbl_semestre1.getTableHeader().setReorderingAllowed(false);
        tbl_semestre1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_semestre1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_semestre1);
        if (tbl_semestre1.getColumnModel().getColumnCount() > 0) {
            tbl_semestre1.getColumnModel().getColumn(0).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(1).setMaxWidth(200);
            tbl_semestre1.getColumnModel().getColumn(3).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(4).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(5).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(6).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(7).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(8).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(9).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(10).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(11).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(12).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(13).setMaxWidth(30);
            tbl_semestre1.getColumnModel().getColumn(14).setMaxWidth(40);
        }

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        jTabbedPane1.addTab("Semestre 1", kGradientPanel3);

        jPanel1.setPreferredSize(new java.awt.Dimension(550, 64));

        tbl_semestre2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "RUN", "Nombre Alumno", "N1", "N2", "N3", "N4", "N5", "N6", "N7", "N8", "N9", "N10", "P2", "PF", "Estado", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_semestre2.setSelectionBackground(new java.awt.Color(204, 102, 0));
        tbl_semestre2.getTableHeader().setReorderingAllowed(false);
        tbl_semestre2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_semestre2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_semestre2);
        if (tbl_semestre2.getColumnModel().getColumnCount() > 0) {
            tbl_semestre2.getColumnModel().getColumn(0).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(1).setMaxWidth(200);
            tbl_semestre2.getColumnModel().getColumn(3).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(4).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(5).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(6).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(7).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(8).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(9).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(10).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(11).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(12).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(13).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(14).setMaxWidth(30);
            tbl_semestre2.getColumnModel().getColumn(15).setMaxWidth(100);
            tbl_semestre2.getColumnModel().getColumn(16).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        jTabbedPane1.addTab("Semestre 2", jPanel1);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar.setText("Realizar cierre de asignatura");
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkStartColor(new java.awt.Color(51, 102, 0));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cursos:");

        cb_cursos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_cursosItemStateChanged(evt);
            }
        });
        cb_cursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cursosActionPerformed(evt);
            }
        });

        lbl_profesorjefe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_profesorjefe.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Profesor Jefe:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Profesor Asignatura:");

        lbl_profesorasignatura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_profesorasignatura.setForeground(new java.awt.Color(255, 255, 255));

        btn_cancelar2.setText("Asignatura por Alumno");
        btn_cancelar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancelar2.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_cancelar2.setkHoverEndColor(new java.awt.Color(102, 0, 0));
        btn_cancelar2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_cancelar2.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_cancelar2.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar2ActionPerformed(evt);
            }
        });

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_refresh_40px.png"))); // NOI18N
        btn_refresh.setText("Refrescar");
        btn_refresh.setToolTipText("Actualizar");
        btn_refresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_refresh.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_refresh.setkHoverEndColor(new java.awt.Color(102, 0, 0));
        btn_refresh.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_refresh.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_refresh.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_profesorjefe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_cursos, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_asignatura, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(lbl_profesorasignatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(116, 116, 116))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(338, 338, 338)
                                .addComponent(btn_cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cb_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cb_cursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_profesorjefe, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_profesorasignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        Asignatura asignatura = (Asignatura)cb_asignatura.getSelectedItem();
        if(asignatura.getEstado() =='A'){
            int seleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro de realizar cierre de asignatura? Esta acción no puede deshacerse", "Confirmar cierre asignatura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (seleccion ==0 ){
                
                ArrayList<Nota> alumnosInsuficientes = cn.listarAlumnosInsuficientes(asignatura.getId_asignatura());
                System.out.println("id asignatura->" + asignatura.getId_asignatura());
                if(alumnosInsuficientes.size()>0){
                    String listado = "";
                    for(Nota n: alumnosInsuficientes){
                        listado = listado + "\n" + n.toString() ;
                    }
                    int seleccion2 = JOptionPane.showConfirmDialog(null, "Los siguientes alumnos tienen una nota insuficiente, por lo que al cerrar la asignatura"
                            + " quedarán en calidad de reprobados. "
                            + listado + "\nEstá seguro de continuar?" , "Confirmar cierre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(seleccion2 ==0 ){
                        int validador = cn.generarCierreAsignatura(asignatura.getId_asignatura());
                        if(validador == 0 ){
                            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Asignatura cerrada exitosamente", "Correcto");
                            noti.showNotification();
                            cn.listarNotas(tbl_semestre1, tbl_semestre2, asignatura.getId_asignatura());
                            //DesktopNotify.showDesktopMessage("AulaApp","Asignatura cerrada exitosamente!", DesktopNotify.SUCCESS, 3000L);
                        }

                        }else
                            {Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error", "Error");
                            noti.showNotification();}
                        }
                            //DesktopNotify.showDesktopMessage("AulaApp","Ha ocurrido un error, por favor reintente", DesktopNotify.ERROR, 3000L);}
                else{
                    int seleccion2 = JOptionPane.showConfirmDialog(null, "¿Realmente está seguro de continuar?", "Confirmar cierre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(seleccion2 ==0 ){
                        int validador = cn.generarCierreAsignatura(asignatura.getId_asignatura());
                        if(validador == 0 )
                            {Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Asignatura cerrada", "Correcto");
                            noti.showNotification();
                            cn.listarNotas(tbl_semestre1, tbl_semestre2, asignatura.getId_asignatura());}
                           //DesktopNotify.showDesktopMessage("AulaApp","Asignatura cerrada exitosamente!", DesktopNotify.SUCCESS, 3000L);
                        else{
                            {Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error", "Error");
                            noti.showNotification();}
                        }
                           //DesktopNotify.showDesktopMessage("AulaApp","Ha ocurrido un error, por favor reintente", DesktopNotify.ERROR, 3000L);
                        }
                }
            }
        }else if(asignatura.getEstado() =='F'){
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Asignatura ya finalizada", "Acción rechazada");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp","No puedes cerrar una asignatura ya finalizada.", DesktopNotify.ERROR, 3000L);
        }
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void cb_cursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cursosActionPerformed
        Curso c = (Curso)cb_cursos.getSelectedItem();
        cb_asignatura.removeAllItems();
        DefaultTableModel dtm = (DefaultTableModel) tbl_semestre1.getModel();
        DefaultTableModel dtm2 = (DefaultTableModel) tbl_semestre2.getModel();
        dtm.setRowCount(0);
        dtm2.setRowCount(0);
        ci.cargarCbAsignatura(cb_asignatura, c);
        lbl_profesorjefe.setText(c.getNombreDocente());

        
    }//GEN-LAST:event_cb_cursosActionPerformed

    private void cb_cursosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_cursosItemStateChanged

    }//GEN-LAST:event_cb_cursosItemStateChanged

    private void cb_asignaturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_asignaturaItemStateChanged
        Asignatura asignatura = (Asignatura)cb_asignatura.getSelectedItem();
        if(asignatura != null){
            int idAsignatura = asignatura.getId_asignatura();
            cn.listarNotas(tbl_semestre1, tbl_semestre2, idAsignatura);
            lbl_profesorasignatura.setText(asignatura.getPri_ap() + " " + asignatura.getSeg_ap()+ ", " + asignatura.getPri_nom() + " " + asignatura.getSeg_nom());
        }
              
    }//GEN-LAST:event_cb_asignaturaItemStateChanged

    private void tbl_semestre2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_semestre2MouseClicked
        mostrarNotas(tbl_semestre2, evt, 2);
    }//GEN-LAST:event_tbl_semestre2MouseClicked

    private void tbl_semestre1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_semestre1MouseClicked
        mostrarNotas(tbl_semestre1, evt, 1);
    }//GEN-LAST:event_tbl_semestre1MouseClicked

    private void cb_asignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_asignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_asignaturaActionPerformed

    private void btn_cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar2ActionPerformed
        VentanaNotasAsignaturas vn = new VentanaNotasAsignaturas();
        vn.setVisible(true);
    }//GEN-LAST:event_btn_cancelar2ActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        Asignatura asignatura = (Asignatura)cb_asignatura.getSelectedItem();
        if(asignatura != null)
            cn.listarNotas(tbl_semestre1, tbl_semestre2, asignatura.getId_asignatura());
    }//GEN-LAST:event_btn_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_cancelar2;
    private com.k33ptoo.components.KButton btn_guardar;
    private com.k33ptoo.components.KButton btn_refresh;
    private combo_suggestion.ComboBoxSuggestion cb_asignatura;
    private combo_suggestion.ComboBoxSuggestion cb_cursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel lbl_profesorasignatura;
    private javax.swing.JLabel lbl_profesorjefe;
    public static javax.swing.JTable tbl_semestre1;
    public static javax.swing.JTable tbl_semestre2;
    // End of variables declaration//GEN-END:variables
}
