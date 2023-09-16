
package vista;

import controlador.ControladorAsignatura;
import controlador.ControladorBloque;
import controlador.ControladorInterfaz;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import modelo.Asignatura;

public class VentanaAsignarHorarios extends javax.swing.JFrame {
    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorBloque cb = new ControladorBloque();
    ControladorAsignatura ca = new ControladorAsignatura();
    Asignatura asignaturaSeleccionada;
    public VentanaAsignarHorarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        pintarTablas();

    }
    public VentanaAsignarHorarios(Asignatura asignatura, String nombreCurso) {
        this.asignaturaSeleccionada = asignatura;
        initComponents();
        txt_asignatura.setText(asignatura.getNom_asignatura());
        txt_curso.setText(nombreCurso);
        this.setLocationRelativeTo(null);
        pintarTablas();
        cb.cargarTabla(tbl_lunes, tbl_martes, tbl_miercoles, tbl_jueves, tbl_viernes, tbl_sabado, tbl_domingo, asignatura.getId_asignatura());
        ci.addCheckBox(2, tbl_lunes);
        ci.addCheckBox(2, tbl_martes);
        ci.addCheckBox(2, tbl_miercoles);
        ci.addCheckBox(2, tbl_jueves);
        ci.addCheckBox(2, tbl_viernes);
        ci.addCheckBox(2, tbl_sabado);
        ci.addCheckBox(2, tbl_domingo);
        ci.addCheckBox(2, tbl_lunes);
    }
    
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }

    public void pintarTablas(){
        tbl_lunes.getTableHeader().setForeground(new Color(255,255,255));
        tbl_lunes.getTableHeader().setBackground(new Color(0,51,0));
        tbl_lunes.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_lunes.setRowHeight(30);
        
        tbl_martes.getTableHeader().setForeground(new Color(255,255,255));
        tbl_martes.getTableHeader().setBackground(new Color(0,51,0));
        tbl_martes.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_martes.setRowHeight(30);
        
        tbl_miercoles.getTableHeader().setForeground(new Color(255,255,255));
        tbl_miercoles.getTableHeader().setBackground(new Color(0,51,0));
        tbl_miercoles.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_miercoles.setRowHeight(30);
        
        
        tbl_jueves.getTableHeader().setForeground(new Color(255,255,255));
        tbl_jueves.getTableHeader().setBackground(new Color(0,51,0));
        tbl_jueves.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_jueves.setRowHeight(30);
        
        tbl_viernes.getTableHeader().setForeground(new Color(255,255,255));
        tbl_viernes.getTableHeader().setBackground(new Color(0,51,0));
        tbl_viernes.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_viernes.setRowHeight(30);
        
        tbl_sabado.getTableHeader().setForeground(new Color(255,255,255));
        tbl_sabado.getTableHeader().setBackground(new Color(0,51,0));
        tbl_sabado.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_sabado.setRowHeight(30);
        
        tbl_domingo.getTableHeader().setForeground(new Color(255,255,255));
        tbl_domingo.getTableHeader().setBackground(new Color(0,51,0));
        tbl_domingo.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_domingo.setRowHeight(30);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_lunes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_martes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_miercoles = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_viernes = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_jueves = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_domingo = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_sabado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_asignatura = new javax.swing.JTextField();
        txt_curso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_asignarhorario = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Bloque");
        setIconImage(getIconImage());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 102, 102));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        tbl_lunes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Lunes", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_lunes.setOpaque(false);
        tbl_lunes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_lunes.getTableHeader().setReorderingAllowed(false);
        tbl_lunes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_lunesMouseClicked(evt);
            }
        });
        tbl_lunes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_lunesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_lunes);
        if (tbl_lunes.getColumnModel().getColumnCount() > 0) {
            tbl_lunes.getColumnModel().getColumn(0).setMaxWidth(20);
            tbl_lunes.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_lunes.getColumnModel().getColumn(2).setMaxWidth(10);
        }

        tbl_martes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Martes", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_martes.setOpaque(false);
        tbl_martes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_martes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_martes);
        if (tbl_martes.getColumnModel().getColumnCount() > 0) {
            tbl_martes.getColumnModel().getColumn(0).setMaxWidth(20);
            tbl_martes.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_martes.getColumnModel().getColumn(2).setMaxWidth(10);
        }

        tbl_miercoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Miercoles", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_miercoles.setOpaque(false);
        tbl_miercoles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_miercoles.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbl_miercoles);
        if (tbl_miercoles.getColumnModel().getColumnCount() > 0) {
            tbl_miercoles.getColumnModel().getColumn(0).setMaxWidth(20);
            tbl_miercoles.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_miercoles.getColumnModel().getColumn(2).setMaxWidth(10);
        }

        tbl_viernes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Viernes", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_viernes.setOpaque(false);
        tbl_viernes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_viernes.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbl_viernes);
        if (tbl_viernes.getColumnModel().getColumnCount() > 0) {
            tbl_viernes.getColumnModel().getColumn(0).setMaxWidth(20);
            tbl_viernes.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_viernes.getColumnModel().getColumn(2).setMaxWidth(15);
        }

        tbl_jueves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Jueves", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_jueves.setOpaque(false);
        tbl_jueves.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_jueves.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tbl_jueves);
        if (tbl_jueves.getColumnModel().getColumnCount() > 0) {
            tbl_jueves.getColumnModel().getColumn(0).setMaxWidth(20);
            tbl_jueves.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_jueves.getColumnModel().getColumn(2).setMaxWidth(10);
        }

        tbl_domingo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Domingo", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_domingo.setOpaque(false);
        tbl_domingo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_domingo.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tbl_domingo);
        if (tbl_domingo.getColumnModel().getColumnCount() > 0) {
            tbl_domingo.getColumnModel().getColumn(0).setMaxWidth(20);
            tbl_domingo.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_domingo.getColumnModel().getColumn(2).setMaxWidth(15);
        }

        tbl_sabado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Sabado", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_sabado.setOpaque(false);
        tbl_sabado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_sabado.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tbl_sabado);
        if (tbl_sabado.getColumnModel().getColumnCount() > 0) {
            tbl_sabado.getColumnModel().getColumn(0).setMaxWidth(20);
            tbl_sabado.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_sabado.getColumnModel().getColumn(2).setMaxWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asignatura:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Curso:");

        txt_asignatura.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_asignatura.setEnabled(false);

        txt_curso.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_curso.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Asignar Horarios");

        btn_asignarhorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_save_40px.png"))); // NOI18N
        btn_asignarhorario.setText("Asignar este horario a asignatura");
        btn_asignarhorario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_asignarhorario.setkBackGroundColor(new java.awt.Color(0, 102, 102));
        btn_asignarhorario.setkEndColor(new java.awt.Color(0, 102, 0));
        btn_asignarhorario.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_asignarhorario.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_asignarhorario.setkStartColor(new java.awt.Color(0, 102, 0));
        btn_asignarhorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asignarhorarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(169, 169, 169)
                                .addComponent(btn_asignarhorario, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(jLabel3)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_asignarhorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_lunesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_lunesPropertyChange

    }//GEN-LAST:event_tbl_lunesPropertyChange

    private void tbl_lunesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_lunesMouseClicked

    }//GEN-LAST:event_tbl_lunesMouseClicked

    private void btn_asignarhorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asignarhorarioActionPerformed

        int validador1 = ca.eliminarBloqueAsignatura(asignaturaSeleccionada.getId_asignatura());
        int validadorlunes = -1;
        int validadormartes = -1;
        int validadormiercoles = -1;
        int validadorjueves = -1;
        int validadorviernes = -1;
        int validadorsabado = -1;
        int validadordomingo = -1;
        if (validador1 == 0){
            for (int i = 0; i < tbl_lunes.getRowCount(); i ++){
            try{
                Boolean seleccion = (Boolean)tbl_lunes.getValueAt(i, 2);
                System.out.println(tbl_lunes.getRowCount());
            if(seleccion){
                /*System.out.println("Lunes - Marcada posición=>" + tbl_lunes.getValueAt(i , 1) + "ID:"+ tbl_lunes.getValueAt(i , 0));
                System.out.println("Martes - Marcada posición=>" + tbl_martes.getValueAt(i , 1) + "ID:"+ tbl_martes.getValueAt(i , 0));
                System.out.println("Miercoles - Marcada posición=>" + tbl_miercoles.getValueAt(i , 1) + "ID:"+ tbl_miercoles.getValueAt(i , 0));
                System.out.println("Jueves - Marcada posición=>" + tbl_jueves.getValueAt(i , 1) + "ID:"+ tbl_jueves.getValueAt(i , 0));
                System.out.println("Viernes - Marcada posición=>" + tbl_viernes.getValueAt(i , 1) + "ID:"+ tbl_viernes.getValueAt(i , 0));
                System.out.println("Sabado - Marcada posición=>" + tbl_sabado.getValueAt(i , 1) + "ID:"+ tbl_sabado.getValueAt(i , 0));
                System.out.println("Domingo - Marcada posición=>" + tbl_domingo.getValueAt(i , 1) + "ID:"+ tbl_domingo.getValueAt(i , 0)); */
                
                validadorlunes = ca.insertarBloqueAsignatura(asignaturaSeleccionada.getId_asignatura(), Integer.parseInt(String.valueOf(tbl_lunes.getValueAt(i , 0))));
                }}
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            for (int i = 0; i < tbl_martes.getRowCount(); i ++){
                try{
                    Boolean seleccion = (Boolean)tbl_martes.getValueAt(i, 2);
                if(seleccion){
                    validadormartes = ca.insertarBloqueAsignatura(asignaturaSeleccionada.getId_asignatura(), Integer.parseInt(String.valueOf(tbl_martes.getValueAt(i , 0))));
                }}
                catch(Exception ex){
                    ex.printStackTrace();
                }

            }
            for (int i = 0; i < tbl_miercoles.getRowCount(); i ++){
                try{
                    Boolean seleccion = (Boolean)tbl_miercoles.getValueAt(i, 2);
                if(seleccion){
                    validadormiercoles = ca.insertarBloqueAsignatura(asignaturaSeleccionada.getId_asignatura(), Integer.parseInt(String.valueOf(tbl_miercoles.getValueAt(i , 0))));
                }}
                catch(Exception ex){
                    ex.printStackTrace();
                }

            }
            for (int i = 0; i < tbl_jueves.getRowCount(); i ++){
                try{
                    Boolean seleccion = (Boolean)tbl_jueves.getValueAt(i, 2);
                if(seleccion){
                    //System.out.println("Jueves - Marcada posición=>" + tbl_jueves.getValueAt(i , 1) + "ID:"+ tbl_jueves.getValueAt(i , 0));
                    validadorjueves = ca.insertarBloqueAsignatura(asignaturaSeleccionada.getId_asignatura(), Integer.parseInt(String.valueOf(tbl_jueves.getValueAt(i , 0))));
                }}
                catch(Exception ex){
                    ex.printStackTrace();
                }

            }
            for (int i = 0; i < tbl_viernes.getRowCount(); i ++){
                try{
                    Boolean seleccion = (Boolean)tbl_viernes.getValueAt(i, 2);
                if(seleccion){
                    //System.out.println("Viernes - Marcada posición=>" + tbl_viernes.getValueAt(i , 1) + "ID:"+ tbl_viernes.getValueAt(i , 0));
                    validadorviernes = ca.insertarBloqueAsignatura(asignaturaSeleccionada.getId_asignatura(), Integer.parseInt(String.valueOf(tbl_viernes.getValueAt(i , 0))));
                }}
                catch(Exception ex){
                    ex.printStackTrace();
                }

            }
             for (int i = 0; i < tbl_sabado.getRowCount(); i ++){
                try{
                    Boolean seleccion = (Boolean)tbl_sabado.getValueAt(i, 2);
                if(seleccion){
                    //System.out.println("Sabado - Marcada posición=>" + tbl_sabado.getValueAt(i , 1) + "ID:"+ tbl_sabado.getValueAt(i , 0));
                    validadorsabado = ca.insertarBloqueAsignatura(asignaturaSeleccionada.getId_asignatura(), Integer.parseInt(String.valueOf(tbl_sabado.getValueAt(i , 0))));
                }}
                catch(Exception ex){
                    ex.printStackTrace();
                }

            }

            for (int i = 0; i < tbl_domingo.getRowCount(); i ++){
                try{
                    Boolean seleccion = (Boolean)tbl_domingo.getValueAt(i, 2);
                if(seleccion){
                    //System.out.println("Domingo - Marcada posición=> " + tbl_domingo.getValueAt(i , 1) + "ID:"+ tbl_domingo.getValueAt(i , 0));
                    validadordomingo = ca.insertarBloqueAsignatura(asignaturaSeleccionada.getId_asignatura(), Integer.parseInt(String.valueOf(tbl_domingo.getValueAt(i , 0))));
                }}
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            if(validadorlunes==0 || validadormartes ==0 || validadormiercoles == 0 || validadorjueves == 0 || validadorviernes == 0 || validadorsabado==0
                    ||validadordomingo == 0
                  ){
                //JOptionPane.showMessageDialog(rootPane, "Bloques asignados exitosamente!");
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Bloques asignados exitosamente" , "Correcto");
                noti.showNotification(); 
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error" , "Ups!");
                noti.showNotification();                 
                //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, por favor reintente el guardado.");
            }
        
            
    }//GEN-LAST:event_btn_asignarhorarioActionPerformed
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
            java.util.logging.Logger.getLogger(VentanaAsignarHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignarHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignarHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignarHorarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAsignarHorarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_asignarhorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JTable tbl_domingo;
    private javax.swing.JTable tbl_jueves;
    private javax.swing.JTable tbl_lunes;
    private javax.swing.JTable tbl_martes;
    private javax.swing.JTable tbl_miercoles;
    private javax.swing.JTable tbl_sabado;
    private javax.swing.JTable tbl_viernes;
    private javax.swing.JTextField txt_asignatura;
    private javax.swing.JTextField txt_curso;
    // End of variables declaration//GEN-END:variables
}
