
package vista;

import com.raven.datechooser.SelectedDate;
import controlador.ControladorInterfaz;
import controlador.ControladorLeccion;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import modelo.Asignatura;
import modelo.Curso;
import modelo.Leccion;
import modelo.Usuario;


public class VentanaLeccionario extends javax.swing.JFrame {
    ControladorLeccion cl = new ControladorLeccion();
    ControladorInterfaz ci = new ControladorInterfaz();
    Usuario usuarioLogueado;
    public VentanaLeccionario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public VentanaLeccionario(Usuario usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_historial.getTableHeader().setForeground(new Color(255,255,255));
        tbl_historial.getTableHeader().setBackground(new Color(0,51,0));
        tbl_historial.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        tbl_historial.setRowHeight(30);
        this.usuarioLogueado = usuario;
        lbl_contador.setText(txt_objetivo.getText().length() + " de 255 caracteres");
        ci.cargarCbCursoTodo(cb_curso);
        
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
        btn_firmar = new com.k33ptoo.components.KButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_historial = new dynamic_subjtable.TableCustom();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        txt_docente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fecha = new com.raven.datechooser.DateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_objetivo = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        cb_curso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_guardar1 = new com.k33ptoo.components.KButton();
        cb_asignatura = new javax.swing.JComboBox<>();
        lbl_contador = new javax.swing.JLabel();
        btn_actualizar = new com.k33ptoo.components.KButton();
        btn_listartodo = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Leccionario");
        setIconImage(getIconImage());

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 153, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Leccionario");

        btn_firmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_autograph_40px.png"))); // NOI18N
        btn_firmar.setText("Firmar");
        btn_firmar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_firmar.setkBackGroundColor(new java.awt.Color(0, 0, 51));
        btn_firmar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_firmar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_firmar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_firmar.setkStartColor(new java.awt.Color(153, 0, 153));
        btn_firmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firmarActionPerformed(evt);
            }
        });

        tbl_historial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "ID", "Código", "Asignatura", "Firmada", "Usuario Firma", "Fecha Firma", "Fecha Mod", "Usuario Mod", "Detalle", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_historial.setSelectionBackground(new java.awt.Color(0, 102, 0));
        tbl_historial.getTableHeader().setReorderingAllowed(false);
        tbl_historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_historialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_historial);
        if (tbl_historial.getColumnModel().getColumnCount() > 0) {
            tbl_historial.getColumnModel().getColumn(0).setMaxWidth(90);
            tbl_historial.getColumnModel().getColumn(1).setMaxWidth(35);
        }

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Histórico de lecciones");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_docente.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_docente.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Curso:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Asignatura:");

        fecha.setForeground(new java.awt.Color(0, 0, 0));
        fecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaPropertyChange(evt);
            }
        });

        txt_objetivo.setColumns(20);
        txt_objetivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_objetivo.setLineWrap(true);
        txt_objetivo.setRows(5);
        txt_objetivo.setWrapStyleWord(true);
        txt_objetivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_objetivoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txt_objetivo);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*Puede modificar una lección seleccionando una fecha existente y guardando.");

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Docente:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Objetivo de clase:");

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

        cb_asignatura.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cb_asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_asignaturaActionPerformed(evt);
            }
        });

        lbl_contador.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contador.setText("Contador");

        jLayeredPane1.setLayer(txt_docente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(fecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cb_curso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btn_guardar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cb_asignatura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_contador, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(44, 44, 44)
                        .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cb_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(txt_docente, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel5))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lbl_contador, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(cb_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(cb_asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(txt_docente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_contador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_refresh_40px.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_actualizar.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_actualizar.setkHoverEndColor(new java.awt.Color(102, 0, 0));
        btn_actualizar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_actualizar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_actualizar.setkStartColor(new java.awt.Color(0, 0, 0));
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_listartodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Bullet_List_35px.png"))); // NOI18N
        btn_listartodo.setText("Listar todo");
        btn_listartodo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_listartodo.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_listartodo.setkHoverEndColor(new java.awt.Color(102, 0, 0));
        btn_listartodo.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_listartodo.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_listartodo.setkStartColor(new java.awt.Color(204, 102, 0));
        btn_listartodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listartodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_firmar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btn_listartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                        .addGap(29, 29, 29)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_firmar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_listartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        Asignatura a = (Asignatura)cb_asignatura.getSelectedItem();
        int idAsignatura = 0;
        idAsignatura = a.getId_asignatura();
        String objetivo = txt_objetivo.getText();
        SelectedDate d = fecha.getSelectedDate();
        System.out.println(d.getDay() + "-" + d.getMonth() + "-" + d.getYear() );
        int validador = cl.almacenarLeccion(objetivo, d.getDay() + "-" + d.getMonth() + "-" + d.getYear(), usuarioLogueado.getCodUsuario(), idAsignatura);
        if(objetivo.equals("") || idAsignatura ==0){
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Debes llenar todos los campos", "Datos faltantes");
            noti.showNotification();
            //JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una asignatura y el detalle no puede estar vacío.");
        }
        else{
            if(validador == 0){
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Objetivo almacenado", "Correcto");
                noti.showNotification();
                txt_objetivo.setText("");
                //JOptionPane.showMessageDialog(rootPane, "Objetivo de clase almacenado correctamente");
                cl.listarLecciones(tbl_historial, idAsignatura);
                lbl_contador.setText(txt_objetivo.getText().length() + " de 255 caracteres");
            }else if(validador ==1 ){
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Objetivo actualizado", "Correcto");
                txt_objetivo.setText("");
                lbl_contador.setText(txt_objetivo.getText().length() + " de 255 caracteres");
                noti.showNotification();
                //JOptionPane.showMessageDialog(rootPane, "Ya existía una lección anterior, por lo que hemos modificado la existente.");
                cl.listarLecciones(tbl_historial, idAsignatura);
            }else if(validador==-2){
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Año seleccionado distinto al año de asignatura", "Año incorrecto");
                noti.showNotification();
                //JOptionPane.showMessageDialog(rootPane, "Año seleccionado distinto al año de asignatura, no es posible grabar.");
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error", "Error");
                noti.showNotification();
                //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, por favor intente nuevamente.");
            }
        }

            
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_firmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firmarActionPerformed
        int seleccion = tbl_historial.getSelectedRow();
        Asignatura asignatura = (Asignatura)cb_asignatura.getSelectedItem();
        int idDocente = asignatura.getRun();
        Usuario u = new Usuario();
        u.setRun(idDocente);
        if(seleccion != -1){
            Leccion l = new Leccion();
            if(idDocente == 0){
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Sin docente asignado", "Acción rechazada");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("AulaApp","No es posible firmar una lección si no tiene un docente asignado", DesktopNotify.ERROR, 3000L);
            }else{
                l.setIdLeccion(Integer.parseInt(String.valueOf(tbl_historial.getValueAt(seleccion, 1))));
                VentanaIngresePassword vip = new VentanaIngresePassword(u, l);
                vip.setVisible(true);
            }
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Debe selecionar una lección", "Selecciónar registro");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp","Debe seleccionar una lección desde la tabla.", DesktopNotify.ERROR, 3000L);
        }
    }//GEN-LAST:event_btn_firmarActionPerformed

    private void fechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaPropertyChange
        //fecha.toDay(true, Color.GREEN);
        
        
    }//GEN-LAST:event_fechaPropertyChange

    private void cb_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cursoActionPerformed
        cb_asignatura.removeAllItems();
        Curso cursocb=(Curso)cb_curso.getSelectedItem();
        
        ci.cargarCbAsignatura(cb_asignatura, cursocb);

    }//GEN-LAST:event_cb_cursoActionPerformed

    private void cb_cursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_cursoItemStateChanged
        
        
    }//GEN-LAST:event_cb_cursoItemStateChanged

    private void cb_asignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_asignaturaActionPerformed
        Asignatura asignatura = (Asignatura)cb_asignatura.getSelectedItem();
        if(asignatura!=null){
            txt_docente.setText("RUN:"+ asignatura.getRun() +" | " + asignatura.getPri_nom() + " " + asignatura.getSeg_nom() + " " + asignatura.getPri_ap() + " " + asignatura.getSeg_ap());
            cl.listarLecciones(tbl_historial, asignatura.getId_asignatura());
        }

        else{
            txt_docente.setText("");
        }
    }//GEN-LAST:event_cb_asignaturaActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        Asignatura asignatura = (Asignatura)cb_asignatura.getSelectedItem();
        cl.listarLecciones(tbl_historial, asignatura.getId_asignatura());
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void tbl_historialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_historialMouseClicked
        if (evt.getClickCount() == 2) {
            int filaSeleccionada = tbl_historial.getSelectedRow();

            if (filaSeleccionada != -1){
                String fecha = (String)tbl_historial.getValueAt(filaSeleccionada, 0);
                String asignatura = (String)tbl_historial.getValueAt(filaSeleccionada, 3);
                String codigo = (String)tbl_historial.getValueAt(filaSeleccionada, 2);
                String firmada = (String)tbl_historial.getValueAt(filaSeleccionada, 5);
                String fechaFirma = (String)tbl_historial.getValueAt(filaSeleccionada, 6);
                String usuarioMod = (String)tbl_historial.getValueAt(filaSeleccionada, 8);
                String fechaMod = (String)tbl_historial.getValueAt(filaSeleccionada, 7);
                String detalle = (String)tbl_historial.getValueAt(filaSeleccionada, 9);
                VentanaDetalleLeccion vd = new VentanaDetalleLeccion(fecha, asignatura, codigo, firmada, fechaFirma, usuarioMod,
                 fechaMod, detalle);
                vd.setVisible(true);
             }
        }
    }//GEN-LAST:event_tbl_historialMouseClicked

    private void btn_listartodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listartodoActionPerformed
        cl.listarTodasLecciones(tbl_historial);
    }//GEN-LAST:event_btn_listartodoActionPerformed

    private void txt_objetivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_objetivoKeyReleased
        ci.limiteCaracteres(txt_objetivo, 255);
        lbl_contador.setText(txt_objetivo.getText().length() + " de 255 caracteres");
    }//GEN-LAST:event_txt_objetivoKeyReleased

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
            java.util.logging.Logger.getLogger(VentanaLeccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLeccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLeccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLeccionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLeccionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_actualizar;
    private com.k33ptoo.components.KButton btn_firmar;
    private com.k33ptoo.components.KButton btn_guardar1;
    private com.k33ptoo.components.KButton btn_listartodo;
    private javax.swing.JComboBox<Object> cb_asignatura;
    private javax.swing.JComboBox<String> cb_curso;
    private com.raven.datechooser.DateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbl_contador;
    public static dynamic_subjtable.TableCustom tbl_historial;
    private javax.swing.JTextField txt_docente;
    private javax.swing.JTextArea txt_objetivo;
    // End of variables declaration//GEN-END:variables
}
