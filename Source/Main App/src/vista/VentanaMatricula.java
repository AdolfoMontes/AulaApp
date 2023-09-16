
package vista;

import controlador.ControladorInterfaz;
import controlador.ControladorMatricula;
import controlador.ControladorPersona;
import controlador.ExportarExcel;
import controlador.TextPrompt;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import modelo.Comuna;
import modelo.EstadoCivil;
import modelo.Nivel;
import modelo.Ocupacion;
import modelo.Parentesco;
import modelo.PuebloOriginario;
import modelo.Region;
import modelo.Sexo;
import modelo.Usuario;
import static vista.VentanaPrincipal.lbl_contadoractivos;
import static vista.VentanaPrincipal.lbl_contadoralumnos;
import static vista.VentanaPrincipal.lbl_contadordocentes;

public class VentanaMatricula extends javax.swing.JFrame {

    ControladorPersona cp = new ControladorPersona();
    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorMatricula m = new ControladorMatricula();
    Usuario usuarioLogueado;
    Usuario u = new Usuario();
    public VentanaMatricula(Usuario usuarioLogueado) {
        initComponents();
        tbl_alumno.getTableHeader().setForeground(new Color(255,255,255));
        tbl_alumno.getTableHeader().setBackground(new Color(32,136,203));
        tbl_alumno.setRowHeight(30);
        tbl_alumno.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        
        new TextPrompt("Obligatorio", txt_prinom);
        new TextPrompt("Obligatorio", txt_priap);
        new TextPrompt("Sin símbolos", txt_run);
        new TextPrompt("Obligatorio", txt_direccion);
        new TextPrompt("Obligatorio", txt_direccionapoderado);
        new TextPrompt("Sin símbolos", txt_runapoderado);
        new TextPrompt("Obligatorio", txt_pnombreapoderado);
        new TextPrompt("Obligatorio", txt_priapapoderado);
        new TextPrompt("ejemplo@123.com", txt_mail);
        new TextPrompt("Obligatorio", txt_telefono);

        this.usuarioLogueado = usuarioLogueado;
        txt_fechainicio.setDate(new Date());
        txt_fechatermino.setDate(new Date());
        m.listarAlumnosActivos(tbl_alumno);
        this.setLocationRelativeTo(null);
        cb_pueblo.setEnabled(false);
        ci.cargarCbSexo(cb_sexo);
        ci.cargarCbRegion(cb_region);
        ci.cargarCbRegion(cb_regionapoderado);
        ci.cargarCbEstadoCivil(cb_estadocivil);
        ci.cargarCbParentesco(cb_parentesco);
        ci.cargarCbOcupacion(cb_ocupacion);
        ci.cargarCbNivel(cb_nivel);
        ci.cargarCbNivel(cb_nivelfiltro);
        ci.cargarCbNivel(cb_nivelapoderado);
        txt_discapacidad.setEnabled(false);
        ci.contarRegistros(tbl_alumno, lbl_resultados);
        ci.eliminarColumna(tbl_alumno, 7);  // oculta discapacidad
        ci.eliminarColumna(tbl_alumno, 10); //oculta pueblo
        ci.eliminarColumna(tbl_alumno, 12); //oculta run apoderado 
        ci.eliminarColumna(tbl_alumno, 13); //oculta nombre apoderado
        ci.eliminarColumna(tbl_alumno, 14); //oculta ocupacion 
        ci.eliminarColumna(tbl_alumno, 15); //Oculta parentesco
        ci.eliminarColumna(tbl_alumno, 16); //oculta direccion apoderado
        ci.eliminarColumna(tbl_alumno, 17); //oculta nivel
        ci.eliminarColumna(tbl_alumno, 20); //oculta telefono
        ci.eliminarColumna(tbl_alumno, 21); //oculta mail
    }
    public VentanaMatricula() {
        initComponents();
        this.setLocationRelativeTo(null);
        cb_pueblo.setEnabled(false);
        ci.cargarCbSexo(cb_sexo);
        ci.cargarCbRegion(cb_region);
        ci.cargarCbRegion(cb_regionapoderado);
        ci.cargarCbEstadoCivil(cb_estadocivil);
        ci.cargarCbParentesco(cb_parentesco);
        ci.cargarCbOcupacion(cb_ocupacion);
        ci.cargarCbNivel(cb_nivel);
        ci.cargarCbNivel(cb_nivelapoderado);
        txt_discapacidad.setEnabled(false);
                
    }
    
    private void limpiarCampos(){
        txt_run.setText("");
        txt_dv.setText("");
        txt_prinom.setText("");
        txt_segnom.setText("");
        txt_priap.setText("");
        txt_segap.setText("");
        txt_direccion.setText("");
        txt_discapacidad.setText("");
        txt_runapoderado.setText("");
        txt_dvapoderado.setText("");
        txt_pnombreapoderado.setText("");
        txt_snombreapoderado.setText("");
        txt_priapapoderado.setText("");
        txt_segapapoderado.setText("");
        txt_mail.setText("");
        txt_telefono.setText("");
        txt_direccionapoderado.setText("");
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
        tbl_alumno = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        lbl_resultados = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txt_runfiltro = new javax.swing.JTextField();
        txt_nombrefiltro = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txt_fechainicio = new com.toedter.calendar.JDateChooser();
        txt_fechatermino = new com.toedter.calendar.JDateChooser();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cb_estadofiltro = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        cb_nivelfiltro = new javax.swing.JComboBox<>();
        btn_filtro = new javax.swing.JButton();
        btn_refrescar = new javax.swing.JButton();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txt_telefono = new javax.swing.JTextField();
        cb_regionapoderado = new javax.swing.JComboBox<>();
        txt_fecnacapoderado = new com.toedter.calendar.JDateChooser();
        cb_nivelapoderado = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_direccionapoderado = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cb_comunaapoderado = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        btn_guardar = new com.k33ptoo.components.KButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cb_estadocivil = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cb_ocupacion = new javax.swing.JComboBox<>();
        txt_dvapoderado = new javax.swing.JTextField();
        txt_pnombreapoderado = new javax.swing.JTextField();
        txt_segapapoderado = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cb_parentesco = new javax.swing.JComboBox<>();
        txt_priapapoderado = new javax.swing.JTextField();
        txt_runapoderado = new javax.swing.JTextField();
        txt_snombreapoderado = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        chk_discapacidad = new javax.swing.JCheckBox();
        txt_discapacidad = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txt_priap = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txt_dv = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_segnom = new javax.swing.JTextField();
        cb_nivel = new javax.swing.JComboBox<>();
        txt_prinom = new javax.swing.JTextField();
        txt_segap = new javax.swing.JTextField();
        txt_run = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        cb_comuna = new javax.swing.JComboBox<>();
        txt_fecnac = new com.toedter.calendar.JDateChooser();
        txt_anio = new com.toedter.calendar.JYearChooser();
        chk_pueblo = new javax.swing.JCheckBox();
        cb_pueblo = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cb_region = new javax.swing.JComboBox<>();
        cb_sexo = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Matriculas");
        setIconImage(getIconImage());

        tbl_alumno.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_alumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° Matricula", "RUN", "Nombre alumno", "Estado", "Curso actual", "Direccion", "Sexo", "Discapacidad", "Nivel matriculado", "Fecha nacimiento", "Pueblo originario", "Edad", "RUN apoderado", "Nombre apoderado", "Ocupacion", "Parentesco", "Direccion Apoderado", "Nivel educativo apoderado", "Fecha Matricula", "Usuario creacion", "Teléfono", "Mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_alumno.setToolTipText("Doble click para mas información...");
        tbl_alumno.setGridColor(new java.awt.Color(204, 102, 0));
        tbl_alumno.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tbl_alumno.setShowGrid(true);
        tbl_alumno.getTableHeader().setReorderingAllowed(false);
        tbl_alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_alumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_alumno);
        if (tbl_alumno.getColumnModel().getColumnCount() > 0) {
            tbl_alumno.getColumnModel().getColumn(0).setPreferredWidth(45);
            tbl_alumno.getColumnModel().getColumn(11).setPreferredWidth(45);
            tbl_alumno.getColumnModel().getColumn(11).setMaxWidth(45);
        }

        jLabel29.setText("Resultados:");

        lbl_resultados.setText("XX");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel34.setText("RUN:");

        txt_runfiltro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_runfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_runfiltroActionPerformed(evt);
            }
        });
        txt_runfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_runfiltroKeyReleased(evt);
            }
        });

        txt_nombrefiltro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_nombrefiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombrefiltroActionPerformed(evt);
            }
        });
        txt_nombrefiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombrefiltroKeyReleased(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel35.setText("Nombre:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel36.setText("Hasta:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel37.setText("Desde:");

        cb_estadofiltro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cb_estadofiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Eliminado", "Retirado", "Expulsado" }));
        cb_estadofiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_estadofiltroItemStateChanged(evt);
            }
        });
        cb_estadofiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_estadofiltroActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel38.setText("Estado:");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel40.setText("Nivel:");

        cb_nivelfiltro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cb_nivelfiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_nivelfiltroItemStateChanged(evt);
            }
        });
        cb_nivelfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nivelfiltroActionPerformed(evt);
            }
        });

        btn_filtro.setBackground(new java.awt.Color(204, 102, 0));
        btn_filtro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_filtro.setForeground(new java.awt.Color(255, 255, 255));
        btn_filtro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_filter_24px.png"))); // NOI18N
        btn_filtro.setText("Filtrar");
        btn_filtro.setBorderPainted(false);
        btn_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel34)
                        .addGap(4, 4, 4)
                        .addComponent(txt_runfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel35)
                        .addGap(4, 4, 4)
                        .addComponent(txt_nombrefiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel37)
                        .addGap(4, 4, 4)
                        .addComponent(txt_fechainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel36)
                        .addGap(4, 4, 4)
                        .addComponent(txt_fechatermino, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel38)
                        .addGap(4, 4, 4)
                        .addComponent(cb_estadofiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel40)
                        .addGap(4, 4, 4)
                        .addComponent(cb_nivelfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_runfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nombrefiltro)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_fechainicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_fechatermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_estadofiltro)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_nivelfiltro)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btn_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_refrescar.setBackground(new java.awt.Color(0, 102, 102));
        btn_refrescar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_refrescar.setForeground(new java.awt.Color(255, 255, 255));
        btn_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_refresh_16px.png"))); // NOI18N
        btn_refrescar.setText("Refrescar");
        btn_refrescar.setBorderPainted(false);
        btn_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrescarActionPerformed(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 102));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 102, 102));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Apoderado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setOpaque(false);

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_telefono.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyReleased(evt);
            }
        });
        jPanel5.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 41, 160, -1));

        cb_regionapoderado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_regionapoderadoItemStateChanged(evt);
            }
        });
        cb_regionapoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_regionapoderadoActionPerformed(evt);
            }
        });
        jPanel5.add(cb_regionapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 159, 159, -1));
        jPanel5.add(txt_fecnacapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 71, 160, -1));

        jPanel5.add(cb_nivelapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 99, 160, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Comuna:");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 189, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("E-Mail:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 11, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Teléfono:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 41, -1, -1));

        txt_direccionapoderado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_direccionapoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionapoderadoActionPerformed(evt);
            }
        });
        txt_direccionapoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_direccionapoderadoKeyReleased(evt);
            }
        });
        jPanel5.add(txt_direccionapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 129, 160, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Región:");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 159, 41, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("F.Nacimiento:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, -1, -1));

        cb_comunaapoderado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_comunaapoderadoItemStateChanged(evt);
            }
        });
        jPanel5.add(cb_comunaapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 189, 159, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nivel educación:");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Dirección:");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 129, -1, -1));

        txt_mail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mailActionPerformed(evt);
            }
        });
        txt_mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mailKeyReleased(evt);
            }
        });
        jPanel5.add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 11, 160, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkStartColor(new java.awt.Color(0, 102, 0));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel5.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 229, 159, -1));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Ocupación:");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 161, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Parentezco:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 221, -1, -1));

        jPanel6.add(cb_estadocivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 191, 130, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Estado Civíl:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 191, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("P. Apellido:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 101, -1, -1));

        cb_ocupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cb_ocupacionKeyReleased(evt);
            }
        });
        jPanel6.add(cb_ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 161, 130, -1));

        txt_dvapoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dvapoderadoKeyReleased(evt);
            }
        });
        jPanel6.add(txt_dvapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 11, 32, -1));

        txt_pnombreapoderado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_pnombreapoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pnombreapoderadoActionPerformed(evt);
            }
        });
        txt_pnombreapoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pnombreapoderadoKeyReleased(evt);
            }
        });
        jPanel6.add(txt_pnombreapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 41, 130, -1));

        txt_segapapoderado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_segapapoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_segapapoderadoActionPerformed(evt);
            }
        });
        txt_segapapoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_segapapoderadoKeyReleased(evt);
            }
        });
        jPanel6.add(txt_segapapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 131, 130, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("RUN:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 11, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Segundo Nombre:");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Primer Nombre:");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 41, -1, -1));

        jPanel6.add(cb_parentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 221, 130, -1));

        txt_priapapoderado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_priapapoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priapapoderadoActionPerformed(evt);
            }
        });
        txt_priapapoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_priapapoderadoKeyReleased(evt);
            }
        });
        jPanel6.add(txt_priapapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 101, 130, -1));

        txt_runapoderado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_runapoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_runapoderadoActionPerformed(evt);
            }
        });
        txt_runapoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_runapoderadoKeyReleased(evt);
            }
        });
        jPanel6.add(txt_runapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 11, 88, -1));

        txt_snombreapoderado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_snombreapoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_snombreapoderadoActionPerformed(evt);
            }
        });
        txt_snombreapoderado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_snombreapoderadoKeyReleased(evt);
            }
        });
        jPanel6.add(txt_snombreapoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 71, 130, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("S. Apellido:");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 131, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setOpaque(false);

        chk_discapacidad.setBackground(new java.awt.Color(0, 102, 102));
        chk_discapacidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        chk_discapacidad.setForeground(new java.awt.Color(255, 255, 255));
        chk_discapacidad.setText("Declara enfermedad o discapacidad");
        chk_discapacidad.setContentAreaFilled(false);
        chk_discapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_discapacidadActionPerformed(evt);
            }
        });

        txt_discapacidad.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_discapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_discapacidadActionPerformed(evt);
            }
        });
        txt_discapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_discapacidadKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Especificar enfermedad:");

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_priap.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_priap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priapActionPerformed(evt);
            }
        });
        txt_priap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_priapKeyReleased(evt);
            }
        });
        jPanel7.add(txt_priap, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 95, 137, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Nivel:");
        jPanel7.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 157, -1, -1));

        txt_dv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dvKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dvKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dvKeyTyped(evt);
            }
        });
        jPanel7.add(txt_dv, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 13, 30, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("RUN:");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 14, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Primer Nombre:");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 42, -1, -1));

        txt_segnom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_segnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_segnomActionPerformed(evt);
            }
        });
        txt_segnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_segnomKeyReleased(evt);
            }
        });
        jPanel7.add(txt_segnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 67, 137, -1));

        cb_nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nivelActionPerformed(evt);
            }
        });
        jPanel7.add(cb_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 151, 137, -1));

        txt_prinom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_prinom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_prinomActionPerformed(evt);
            }
        });
        txt_prinom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_prinomKeyReleased(evt);
            }
        });
        jPanel7.add(txt_prinom, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 39, 137, -1));

        txt_segap.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_segap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_segapActionPerformed(evt);
            }
        });
        txt_segap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_segapKeyReleased(evt);
            }
        });
        jPanel7.add(txt_segap, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 123, 137, -1));

        txt_run.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_runActionPerformed(evt);
            }
        });
        txt_run.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_runKeyReleased(evt);
            }
        });
        jPanel7.add(txt_run, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 11, 96, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("P. Apellido:");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 98, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("S. Apellido:");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 126, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Segundo Nombre:");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Comuna:");
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 156, -1, -1));

        jPanel8.add(cb_comuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 154, 171, -1));
        jPanel8.add(txt_fecnac, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 16, 171, -1));
        jPanel8.add(txt_anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        chk_pueblo.setBackground(new java.awt.Color(0, 102, 102));
        chk_pueblo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        chk_pueblo.setForeground(new java.awt.Color(255, 255, 255));
        chk_pueblo.setText("Pueblo Originario:");
        chk_pueblo.setContentAreaFilled(false);
        chk_pueblo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chk_puebloMousePressed(evt);
            }
        });
        chk_pueblo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_puebloActionPerformed(evt);
            }
        });
        jPanel8.add(chk_pueblo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 42, -1, -1));

        jPanel8.add(cb_pueblo, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 42, 171, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Dirección:");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 101, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Sexo:");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 72, -1, -1));

        cb_region.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_regionItemStateChanged(evt);
            }
        });
        cb_region.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_regionActionPerformed(evt);
            }
        });
        jPanel8.add(cb_region, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 126, 171, -1));

        cb_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sexoActionPerformed(evt);
            }
        });
        jPanel8.add(cb_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 70, 171, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Región:");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 128, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("F.Nacimiento");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 20, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Año de matrícula:");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        txt_direccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_direccionKeyReleased(evt);
            }
        });
        jPanel8.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 98, 171, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_discapacidad)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(4, 4, 4)
                        .addComponent(txt_discapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(chk_discapacidad)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(txt_discapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Matriculas");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_microsoft_excel_16px.png"))); // NOI18N
        jButton1.setText("Exportar a Excel");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_resultados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_resultados)
                            .addComponent(jLabel29)
                            .addComponent(btn_refrescar)
                            .addComponent(jButton1))
                        .addGap(3, 3, 3))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_runfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_runfiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_runfiltroActionPerformed

    private void txt_nombrefiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombrefiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombrefiltroActionPerformed

    private void txt_runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_runActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_runActionPerformed

    private void cb_nivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_nivelActionPerformed

    private void cb_regionapoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_regionapoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_regionapoderadoActionPerformed

    private void txt_direccionapoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionapoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionapoderadoActionPerformed

    private void cb_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sexoActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_segnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_segnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_segnomActionPerformed

    private void txt_discapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_discapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_discapacidadActionPerformed

    private void chk_discapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_discapacidadActionPerformed
        if(chk_discapacidad.isSelected()){
            txt_discapacidad.setEnabled(true);
        }else{
            txt_discapacidad.setEnabled(false);
            txt_discapacidad.setText("");
        }
    }//GEN-LAST:event_chk_discapacidadActionPerformed

    private void txt_runapoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_runapoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_runapoderadoActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_pnombreapoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pnombreapoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pnombreapoderadoActionPerformed

    private void txt_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mailActionPerformed

    private void txt_segapapoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_segapapoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_segapapoderadoActionPerformed

    private void txt_snombreapoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_snombreapoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_snombreapoderadoActionPerformed

    private void txt_priapapoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priapapoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priapapoderadoActionPerformed

    private void txt_segapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_segapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_segapActionPerformed

    private void txt_prinomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_prinomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_prinomActionPerformed

    private void txt_priapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priapActionPerformed

    private void chk_puebloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_puebloActionPerformed
         if(chk_pueblo.isSelected()){
            ci.cargarCbPueblo(cb_pueblo);
            cb_pueblo.setEnabled(true);
        }else{
            cb_pueblo.removeAllItems();
            cb_pueblo.setEnabled(false);
        }
    }//GEN-LAST:event_chk_puebloActionPerformed

    private void chk_puebloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chk_puebloMousePressed
       
            
    }//GEN-LAST:event_chk_puebloMousePressed

    private void cb_regionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_regionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_regionActionPerformed

    private void cb_regionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_regionItemStateChanged
        cb_comuna.removeAllItems();
        Region region = (Region)cb_region.getSelectedItem();
        ci.cargarCbComuna(cb_comuna, region.getId());
    }//GEN-LAST:event_cb_regionItemStateChanged

    private void cb_comunaapoderadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_comunaapoderadoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_comunaapoderadoItemStateChanged

    private void cb_regionapoderadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_regionapoderadoItemStateChanged
        cb_comunaapoderado.removeAllItems();
        Region region = (Region)cb_regionapoderado.getSelectedItem();
        ci.cargarCbComuna(cb_comunaapoderado, region.getId());
    }//GEN-LAST:event_cb_regionapoderadoItemStateChanged

    private void txt_dvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dvKeyTyped

        
    }//GEN-LAST:event_txt_dvKeyTyped

    private void txt_dvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dvKeyPressed
 
    }//GEN-LAST:event_txt_dvKeyPressed

    private void txt_dvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dvKeyReleased
        ci.limiteCaracteres(txt_dv, 1);
    }//GEN-LAST:event_txt_dvKeyReleased

    private void txt_dvapoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dvapoderadoKeyReleased
        ci.limiteCaracteres(txt_dvapoderado, 1);
    }//GEN-LAST:event_txt_dvapoderadoKeyReleased

    private void txt_runKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runKeyReleased
        ci.limiteCaracteres(txt_run, 10);
    }//GEN-LAST:event_txt_runKeyReleased

    private void txt_prinomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_prinomKeyReleased
        ci.limiteCaracteres(txt_prinom, 30);
    }//GEN-LAST:event_txt_prinomKeyReleased

    private void txt_segnomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_segnomKeyReleased
        ci.limiteCaracteres(txt_segnom, 30);
    }//GEN-LAST:event_txt_segnomKeyReleased

    private void txt_priapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priapKeyReleased
        ci.limiteCaracteres(txt_priap, 30);
    }//GEN-LAST:event_txt_priapKeyReleased

    private void txt_segapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_segapKeyReleased
        ci.limiteCaracteres(txt_segap, 30);
    }//GEN-LAST:event_txt_segapKeyReleased

    private void txt_direccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyReleased
        ci.limiteCaracteres(txt_direccion, 150);
    }//GEN-LAST:event_txt_direccionKeyReleased

    private void txt_discapacidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_discapacidadKeyReleased
        ci.limiteCaracteres(txt_discapacidad, 100);
    }//GEN-LAST:event_txt_discapacidadKeyReleased

    private void txt_runapoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runapoderadoKeyReleased
        ci.limiteCaracteres(txt_runapoderado, 10);
    }//GEN-LAST:event_txt_runapoderadoKeyReleased

    private void txt_pnombreapoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pnombreapoderadoKeyReleased
        ci.limiteCaracteres(txt_pnombreapoderado, 30);
    }//GEN-LAST:event_txt_pnombreapoderadoKeyReleased

    private void txt_snombreapoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_snombreapoderadoKeyReleased
        ci.limiteCaracteres(txt_snombreapoderado, 30);
    }//GEN-LAST:event_txt_snombreapoderadoKeyReleased

    private void txt_priapapoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_priapapoderadoKeyReleased
        ci.limiteCaracteres(txt_priapapoderado, 30);
    }//GEN-LAST:event_txt_priapapoderadoKeyReleased

    private void txt_segapapoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_segapapoderadoKeyReleased
        ci.limiteCaracteres(txt_segapapoderado, 30);
    }//GEN-LAST:event_txt_segapapoderadoKeyReleased

    private void cb_ocupacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb_ocupacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_ocupacionKeyReleased

    private void txt_mailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mailKeyReleased
        ci.limiteCaracteres(txt_mail, 100);
    }//GEN-LAST:event_txt_mailKeyReleased

    private void txt_telefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyReleased
        ci.limiteCaracteres(txt_telefono, 20);
    }//GEN-LAST:event_txt_telefonoKeyReleased

    private void txt_direccionapoderadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionapoderadoKeyReleased
        ci.limiteCaracteres(txt_direccionapoderado, 150);
    }//GEN-LAST:event_txt_direccionapoderadoKeyReleased

    private void btn_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtroActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String fecha_inicio = "";
        String fecha_termino = "";
        Date fechaini = txt_fechainicio.getDate();
        Date fechater = txt_fechatermino.getDate();
        fecha_inicio= sdf.format(fechaini);
        fecha_termino= sdf.format(fechater);
        Nivel n = (Nivel)cb_nivelfiltro.getSelectedItem();
        String nivel = n.getDescripcion();
        m.listarAlumnosActivosPorFecha(tbl_alumno, fecha_inicio, fecha_termino, nivel);
        ci.contarRegistros(tbl_alumno, lbl_resultados);
    }//GEN-LAST:event_btn_filtroActionPerformed

    private void txt_runfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runfiltroKeyReleased
        ci.filtro(txt_runfiltro.getText(), tbl_alumno, 1);
        ci.contarRegistros(tbl_alumno, lbl_resultados);
    }//GEN-LAST:event_txt_runfiltroKeyReleased

    private void txt_nombrefiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombrefiltroKeyReleased
        ci.filtro(txt_nombrefiltro.getText(), tbl_alumno, 2);
        ci.contarRegistros(tbl_alumno, lbl_resultados);
    }//GEN-LAST:event_txt_nombrefiltroKeyReleased

    private void cb_estadofiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_estadofiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_estadofiltroActionPerformed

    private void cb_estadofiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_estadofiltroItemStateChanged
        ci.filtro(cb_estadofiltro.getSelectedItem().toString(), tbl_alumno, 3);
        ci.contarRegistros(tbl_alumno, lbl_resultados);
    }//GEN-LAST:event_cb_estadofiltroItemStateChanged

    private void cb_nivelfiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_nivelfiltroItemStateChanged
        
    }//GEN-LAST:event_cb_nivelfiltroItemStateChanged

    private void tbl_alumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_alumnoMouseClicked
        
        if (evt.getClickCount() == 2) {
            int filaSeleccionada = tbl_alumno.getSelectedRow();

            if (filaSeleccionada != -1) {
                //Integer numeroMatricula = (Integer)tbl_alumno.getValueAt(filaSeleccionada,0);
                int numeroMatricula=0;
                String runAlumno = (String)tbl_alumno.getValueAt(filaSeleccionada,1);
                String nombreAlumno = (String)tbl_alumno.getValueAt(filaSeleccionada,2);
                String estadoAlumno = (String)tbl_alumno.getValueAt(filaSeleccionada,3);
                String cursoAlumno = (String)tbl_alumno.getValueAt(filaSeleccionada,4);
                String direccionAlumno = (String)tbl_alumno.getValueAt(filaSeleccionada,5);
                String sexo = (String)tbl_alumno.getValueAt(filaSeleccionada,6);
                String discapacidad = (String)tbl_alumno.getValueAt(filaSeleccionada,7);
                String nivelAlumno = (String)tbl_alumno.getValueAt(filaSeleccionada,8);
                String fechaNacimiento = (String)tbl_alumno.getValueAt(filaSeleccionada,9);
                String pueblo = (String)tbl_alumno.getValueAt(filaSeleccionada,10);
                //String edad = (String)tbl_alumno.getValueAt(filaSeleccionada,11);
                String edad="0";
                String runApoderado = (String)tbl_alumno.getValueAt(filaSeleccionada,12);
                String nombreApoderado = (String)tbl_alumno.getValueAt(filaSeleccionada,13);
                String ocupacion = (String)tbl_alumno.getValueAt(filaSeleccionada,14);
                String parentesco = (String)tbl_alumno.getValueAt(filaSeleccionada,15);
                String direccionApoderado = (String)tbl_alumno.getValueAt(filaSeleccionada,16);
                String nivelApoderado = (String)tbl_alumno.getValueAt(filaSeleccionada,17);
                
                String fechaMatricula = String.valueOf(tbl_alumno.getValueAt(filaSeleccionada,18));
                //String fechaMatricula="";
                String usuarioCreacion = (String)tbl_alumno.getValueAt(filaSeleccionada,19);
                String telefono = (String)tbl_alumno.getValueAt(filaSeleccionada,20);
                String mail = (String)tbl_alumno.getValueAt(filaSeleccionada,21);
                //descripcion = (String) tbl_updates.getValueAt(filaSeleccionada, 8);
                //PanelDescripcion panel = new PanelDescripcion(descripcion);
                VentanaResumen panel  = new VentanaResumen(numeroMatricula, runAlumno, nombreAlumno, estadoAlumno,
                cursoAlumno, direccionAlumno, sexo, discapacidad, nivelAlumno, fechaNacimiento, pueblo,edad,runApoderado, nombreApoderado,
                ocupacion,parentesco, direccionApoderado, nivelApoderado, fechaMatricula, usuarioCreacion, telefono, mail);
                panel.setVisible(true);

            }

        }
    }//GEN-LAST:event_tbl_alumnoMouseClicked

    private void btn_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrescarActionPerformed
        m.listarAlumnosActivos(tbl_alumno);
        ci.contarRegistros(tbl_alumno, lbl_resultados);
    }//GEN-LAST:event_btn_refrescarActionPerformed

    private void cb_nivelfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nivelfiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_nivelfiltroActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
            int runalumno = Integer.parseInt(txt_run.getText());
            String dvalumno= txt_dv.getText().toUpperCase();
            String prinomalumno=txt_prinom.getText();
            String segnomalumno = txt_segnom.getText();
            String priapalumno = txt_priap.getText();
            String segapalumno= txt_segap.getText();
            Nivel nivel = (Nivel)cb_nivel.getSelectedItem();
            int idnivel=nivel.getId();
            System.out.println(idnivel);
            String fec_nac = "";
            Date date = txt_fecnac.getDate();
            fec_nac= sdf.format(date);
            PuebloOriginario pueblo = (PuebloOriginario)cb_pueblo.getSelectedItem();
            int pueblo1=0;
            if (cb_pueblo.getSelectedItem()==null || cb_pueblo.getSelectedItem().equals("") ){
                pueblo1 = 0;
            }else{
                pueblo1 = pueblo.getId();
            }
            Sexo sexo = (Sexo)cb_sexo.getSelectedItem();
            String idsexo = String.valueOf(sexo.getId());
            System.out.println(idsexo);
            String direccion = txt_direccion.getText();
            Comuna comuna = (Comuna)cb_comuna.getSelectedItem();
            int idcomuna = comuna.getId();
            String discapacidad = txt_discapacidad.getText();
            if(discapacidad.isBlank()){
                discapacidad = null;
            }
            int anio=0;
            anio = (txt_anio.getYear());
            //Recuperar datos de apartado Apoderado
            int runapoderado = Integer.parseInt(txt_runapoderado.getText());
            String dvapoderado= txt_dvapoderado.getText().toUpperCase();
            String prinomapoderado=txt_pnombreapoderado.getText();
            String segnomapoderado= txt_snombreapoderado.getText();
            String priapapoderado = txt_priapapoderado.getText();
            String segapapoderado= txt_segapapoderado.getText();
            Ocupacion ocupacion = (Ocupacion)cb_ocupacion.getSelectedItem();
            int idocupacion = ocupacion.getId();
            EstadoCivil estadocivil = (EstadoCivil)cb_estadocivil.getSelectedItem();
            int idestadocivil = estadocivil.getId();
            Parentesco parentesco = (Parentesco)cb_parentesco.getSelectedItem();
            int idparentesco = parentesco.getId();
            String mail = txt_mail.getText();
            String telefono = txt_telefono.getText();
            String fec_nacapoderado = "";
            Date dateapoderado = txt_fecnacapoderado.getDate();
            fec_nacapoderado = sdf.format(dateapoderado);
            Nivel nivelapoderado = (Nivel)cb_nivelapoderado.getSelectedItem();
            int idnivelapoderado = nivelapoderado.getId();
            String direccionapoderado = txt_direccionapoderado.getText();
            Comuna comunaapoderado = (Comuna)cb_comunaapoderado.getSelectedItem();
            int idcomunaapoderado = comunaapoderado.getId();
            ControladorPersona cp = new ControladorPersona();
            if(prinomalumno.isEmpty() || priapalumno.isEmpty() || fec_nac.isEmpty() || dvapoderado.isEmpty() || prinomapoderado.isEmpty() || priapapoderado.isEmpty() || fec_nacapoderado.isEmpty() ||
                    mail.isEmpty() || telefono.isEmpty()){
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER,"Debe llenar todos los campos", "Faltan datos");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("AulaApp","Los campos obligatorios no pueden estar vacíos, por favor verifíque y reintente.", DesktopNotify.ERROR, 3000L);
            }else{
                int insertar_alumno = cp.almacenarAlumno(runalumno, dvalumno, prinomalumno, segnomalumno, priapalumno, segapalumno,
                                    "A", fec_nac, idsexo, pueblo1, idnivel, idcomuna, direccion , discapacidad, anio, usuarioLogueado.getCodUsuario());
                if(insertar_alumno==0){
                    int insertar_apoderado = cp.almacenarApoderado(runapoderado, dvapoderado, prinomapoderado, segnomapoderado, priapapoderado, segapapoderado,
                                        idocupacion, idestadocivil, idparentesco, mail, telefono
                                        , fec_nacapoderado, idnivelapoderado ,direccionapoderado, idcomunaapoderado);
                    int insertar_matricula = m.almacenarMatriculaenUsuario(runalumno, anio, usuarioLogueado.getCodUsuario(), idnivel);
                    if (insertar_matricula!=-1){
                        m.fInsertarMatricula(runalumno, insertar_matricula);
                    }
                    if(insertar_apoderado!=2 ){
                        cp.almacenarAlumnoApoderado(runalumno, runapoderado);
                        Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER,"Registro correcto", "Correcto");
                        noti.showNotification();
                        lbl_contadoractivos.setText(String.valueOf(cp.contarPersonas(1)));
                        lbl_contadordocentes.setText(String.valueOf(cp.contarPersonas(2)));
                        lbl_contadoralumnos.setText(String.valueOf(cp.contarPersonas(3)));
                        //DesktopNotify.showDesktopMessage("AulaApp","Alumno y apoderado registrados correctamente.", DesktopNotify.SUCCESS, 3000L);
                        limpiarCampos();

                    };
                }else if(insertar_alumno==-1){
                    Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER,"El RUN de alumno ya existe", "Ya existe");
                    noti.showNotification();
                    //DesktopNotify.showDesktopMessage("AulaApp","El RUN de alumno ya existe", DesktopNotify.ERROR, 3000L);

                }else{
                    Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER,"Ha ocurrido un error", "Error");
                    noti.showNotification();
                    //DesktopNotify.showDesktopMessage("AulaApp","Ha ocurrido un error, por favor reintente la operación", DesktopNotify.ERROR, 3000L);
                }
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        m.listarAlumnosActivos(tbl_alumno);
        ci.contarRegistros(tbl_alumno, lbl_resultados);
        
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ExportarExcel.exportarExcel(tbl_alumno);
        } catch (IOException ex) {
            Logger.getLogger(VentanaMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMatricula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMatricula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_filtro;
    private com.k33ptoo.components.KButton btn_guardar;
    private javax.swing.JButton btn_refrescar;
    private javax.swing.JComboBox<String> cb_comuna;
    private javax.swing.JComboBox<String> cb_comunaapoderado;
    private javax.swing.JComboBox<String> cb_estadocivil;
    private javax.swing.JComboBox<String> cb_estadofiltro;
    private javax.swing.JComboBox<String> cb_nivel;
    private javax.swing.JComboBox<String> cb_nivelapoderado;
    private javax.swing.JComboBox<String> cb_nivelfiltro;
    private javax.swing.JComboBox<String> cb_ocupacion;
    private javax.swing.JComboBox<String> cb_parentesco;
    private javax.swing.JComboBox<String> cb_pueblo;
    private javax.swing.JComboBox<String> cb_region;
    private javax.swing.JComboBox<String> cb_regionapoderado;
    private javax.swing.JComboBox<String> cb_sexo;
    private javax.swing.JCheckBox chk_discapacidad;
    private javax.swing.JCheckBox chk_pueblo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lbl_resultados;
    private javax.swing.JTable tbl_alumno;
    private com.toedter.calendar.JYearChooser txt_anio;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_direccionapoderado;
    private javax.swing.JTextField txt_discapacidad;
    private javax.swing.JTextField txt_dv;
    private javax.swing.JTextField txt_dvapoderado;
    private com.toedter.calendar.JDateChooser txt_fechainicio;
    private com.toedter.calendar.JDateChooser txt_fechatermino;
    private com.toedter.calendar.JDateChooser txt_fecnac;
    private com.toedter.calendar.JDateChooser txt_fecnacapoderado;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombrefiltro;
    private javax.swing.JTextField txt_pnombreapoderado;
    private javax.swing.JTextField txt_priap;
    private javax.swing.JTextField txt_priapapoderado;
    private javax.swing.JTextField txt_prinom;
    private javax.swing.JTextField txt_run;
    private javax.swing.JTextField txt_runapoderado;
    private javax.swing.JTextField txt_runfiltro;
    private javax.swing.JTextField txt_segap;
    private javax.swing.JTextField txt_segapapoderado;
    private javax.swing.JTextField txt_segnom;
    private javax.swing.JTextField txt_snombreapoderado;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
