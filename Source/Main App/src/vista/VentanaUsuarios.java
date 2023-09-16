
package vista;

import controlador.ControladorDireccion;
import controlador.ControladorInterfaz;
import controlador.ControladorPersona;
import controlador.ControladorPuebloOriginario;
import controlador.ControladorRol;
import controlador.ControladorSexo;
import controlador.ExportarExcel;
import controlador.TextPrompt;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Notification;
import javax.swing.JOptionPane;
import modelo.Comuna;
import modelo.Direccion;
import modelo.PuebloOriginario;
import modelo.Region;
import modelo.Rol;
import modelo.Sexo;
import modelo.Usuario;
import static vista.VentanaPrincipal.lbl_contadoractivos;
import static vista.VentanaPrincipal.lbl_contadoralumnos;
import static vista.VentanaPrincipal.lbl_contadordocentes;
import static vista.VentanaUsuarioDesactivado.tbl_usuariosdesactivados;


public class VentanaUsuarios extends javax.swing.JFrame {

   
    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorPuebloOriginario cs = new ControladorPuebloOriginario();
    ControladorPersona cp = new ControladorPersona();
    public VentanaUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        tbl_usuarios.getTableHeader().setForeground(new Color(255,255,255));
        tbl_usuarios.getTableHeader().setBackground(new Color(0,0,0));
        tbl_usuarios.setRowHeight(30);
        tbl_usuarios.getTableHeader().setFont(new Font("SegoeUI",Font.PLAIN, 12));
        ci.cargarCbSexo(cb_sexo);
        ci.cargarCbPueblo(cb_pueblo);
        cargarCbRegion();
        cargarCbRol(2);
        cb_pueblo.setEnabled(false);
        cp.listarPersonas(tbl_usuarios);
        btn_desactivarusuario.setEnabled(false);
        new TextPrompt("Sin símbolos", txt_run);
        new TextPrompt("Obligatorio", txt_prinom);
        new TextPrompt("Obligatorio", txt_priap);
        new TextPrompt("ej: Jperez ", txt_usuario);
        new TextPrompt("Escribe tu contraseña ", txt_contrasena);
        new TextPrompt("Confirma la contraseña ", txt_contrasena2);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }
    public void cargarCbSexo(){
        ControladorSexo cs = new ControladorSexo();
        ArrayList<Sexo> lista = cs.sexoListar();
        for (Sexo s : lista) {
                cb_sexo.addItem(s);
        }
    }
    public void limpiarCampos(){
        txt_run.setText("");
        txt_dv.setText("");
        txt_prinom.setText("");
        txt_segnom.setText("");
        txt_priap.setText("");
        txt_segap.setText("");
        txt_fecnac.setDate(new Date());
        txt_direccion.setText("");
        txt_mail.setText("");
        txt_usuario.setText("");
        txt_contrasena.setText("");
        txt_contrasena2.setText("");
    }
    
    public void cargarCbPueblo(){
        
        ArrayList<PuebloOriginario> lista = cs.puebloListar();
        for (PuebloOriginario p : lista) {
                cb_pueblo.addItem(p);
        }
    }
    
    public void cargarCbRegion(){
        ControladorDireccion cs = new ControladorDireccion();
        ArrayList<Region> lista = cs.regionListar();
        for (Region r : lista) {
                cb_region.addItem(r);
        }
    }
    
    public void cargarCbComuna(int regionId){
        ControladorDireccion cs = new ControladorDireccion();
        ArrayList<Comuna> lista = cs.comunaListar(regionId);
        for (Comuna r : lista) {
                cb_comuna.addItem(r);
        }
    }
    public void cargarCbRol(int tipo){
        ControladorRol cs = new ControladorRol();
        ArrayList<Rol> lista = cs.rolListar(tipo);
        for (Rol r : lista) {
                cb_rol.addItem(r);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_usuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txt_runfiltro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_nombrefiltro = new javax.swing.JTextField();
        txt_codfiltro = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        btn_desactivarusuario1 = new javax.swing.JButton();
        btn_desactivarusuario = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_cambiarclave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_guardar = new com.k33ptoo.components.KButton();
        jLabel12 = new javax.swing.JLabel();
        txt_dv = new javax.swing.JTextField();
        cb_sexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_contrasena2 = new javax.swing.JPasswordField();
        cb_rol = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txt_segnom = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_run = new javax.swing.JTextField();
        cb_comuna = new javax.swing.JComboBox<>();
        txt_segap = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fecnac = new com.toedter.calendar.JDateChooser();
        txt_priap = new javax.swing.JTextField();
        chk_pueblo = new javax.swing.JCheckBox();
        txt_prinom = new javax.swing.JTextField();
        cb_region = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_pueblo = new javax.swing.JComboBox<>();
        txt_contrasena = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios");
        setIconImage(getIconImage());
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        kGradientPanel1.setkBorderRadius(0);
        kGradientPanel1.setkEndColor(new java.awt.Color(204, 51, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        jPanel1.setOpaque(false);

        tbl_usuarios.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbl_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RUN", "Nombre Completo", "Fecha Nac.", "Sexo", "Pueblo Indig.", "Dirección", "Mail", "Codigo usuario", "Rol", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_usuarios.setGridColor(new java.awt.Color(204, 102, 0));
        tbl_usuarios.setSelectionBackground(new java.awt.Color(204, 102, 0));
        tbl_usuarios.setShowGrid(true);
        tbl_usuarios.getTableHeader().setReorderingAllowed(false);
        tbl_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_usuarios);
        if (tbl_usuarios.getColumnModel().getColumnCount() > 0) {
            tbl_usuarios.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbl_usuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbl_usuarios.getColumnModel().getColumn(2).setPreferredWidth(70);
            tbl_usuarios.getColumnModel().getColumn(3).setPreferredWidth(70);
            tbl_usuarios.getColumnModel().getColumn(4).setPreferredWidth(70);
            tbl_usuarios.getColumnModel().getColumn(5).setPreferredWidth(200);
            tbl_usuarios.getColumnModel().getColumn(6).setPreferredWidth(150);
            tbl_usuarios.getColumnModel().getColumn(7).setPreferredWidth(75);
            tbl_usuarios.getColumnModel().getColumn(8).setPreferredWidth(75);
            tbl_usuarios.getColumnModel().getColumn(9).setPreferredWidth(30);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);

        txt_runfiltro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_runfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_runfiltroActionPerformed(evt);
            }
        });
        txt_runfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_runfiltroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_runfiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_runfiltroKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("RUN:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nombre:");

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

        txt_codfiltro.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_codfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codfiltroActionPerformed(evt);
            }
        });
        txt_codfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codfiltroKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Cod. Usuario:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_runfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nombrefiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_runfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(txt_nombrefiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_refresh.setBackground(new java.awt.Color(102, 102, 102));
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_refresh_35px_1.png"))); // NOI18N
        btn_refresh.setToolTipText("Refrescar");
        btn_refresh.setBorderPainted(false);
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_desactivarusuario1.setBackground(new java.awt.Color(102, 102, 102));
        btn_desactivarusuario1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_desactivarusuario1.setForeground(new java.awt.Color(255, 255, 255));
        btn_desactivarusuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_user_24px.png"))); // NOI18N
        btn_desactivarusuario1.setText("Usuarios Desactivados");
        btn_desactivarusuario1.setBorderPainted(false);
        btn_desactivarusuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desactivarusuario1ActionPerformed(evt);
            }
        });

        btn_desactivarusuario.setBackground(new java.awt.Color(204, 0, 0));
        btn_desactivarusuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_desactivarusuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_desactivarusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_trash_40px.png"))); // NOI18N
        btn_desactivarusuario.setText("Desactivar Usuario");
        btn_desactivarusuario.setBorderPainted(false);
        btn_desactivarusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desactivarusuarioActionPerformed(evt);
            }
        });

        btn_modificar.setBackground(new java.awt.Color(0, 153, 0));
        btn_modificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_edit_40px.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setBorderPainted(false);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setForeground(new java.awt.Color(0, 102, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_microsoft_excel_48px.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_cambiarclave.setBackground(new java.awt.Color(153, 153, 153));
        btn_cambiarclave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cambiarclave.setForeground(new java.awt.Color(255, 255, 255));
        btn_cambiarclave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_password_40px.png"))); // NOI18N
        btn_cambiarclave.setText("Cambiar Clave");
        btn_cambiarclave.setBorderPainted(false);
        btn_cambiarclave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cambiarclaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cambiarclave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_desactivarusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btn_desactivarusuario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_desactivarusuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_modificar)
                        .addComponent(btn_cambiarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_desactivarusuario)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mail:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Rol:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Sexo:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Dirección:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Segundo Nombre:");

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Contraseña:");

        txt_dv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dvActionPerformed(evt);
            }
        });
        txt_dv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dvKeyReleased(evt);
            }
        });

        cb_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sexoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Primer Apellido:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Comuna:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fec. Nacimiento:");

        txt_contrasena2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contrasena2KeyReleased(evt);
            }
        });

        cb_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_rolActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("-");

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

        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Pueblo:");

        txt_mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_mailKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuarios");

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

        cb_comuna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));

        txt_segap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_segapKeyReleased(evt);
            }
        });

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Primer Nombre:");

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

        chk_pueblo.setBackground(new java.awt.Color(255, 255, 255));
        chk_pueblo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        chk_pueblo.setForeground(new java.awt.Color(255, 255, 255));
        chk_pueblo.setText("Pueblo indígena");
        chk_pueblo.setContentAreaFilled(false);
        chk_pueblo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_puebloActionPerformed(evt);
            }
        });

        txt_prinom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_prinomKeyReleased(evt);
            }
        });

        cb_region.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
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

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Región:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RUN:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Repita Contraseña:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Segundo Apellido:");

        cb_pueblo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--" }));
        cb_pueblo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_puebloActionPerformed(evt);
            }
        });

        txt_contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contrasenaActionPerformed(evt);
            }
        });
        txt_contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contrasenaKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre Usuario:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jLabel17)
                    .addGap(155, 155, 155))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_run, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jLabel13)
                            .addGap(4, 4, 4)
                            .addComponent(txt_dv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_prinom, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_segnom, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_priap, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_segap, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_fecnac, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(chk_pueblo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cb_pueblo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cb_region, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cb_comuna, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_contrasena2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(txt_direccion)))
                    .addContainerGap()))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_run, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel13))
                    .addComponent(txt_dv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_prinom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_segnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_priap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_segap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_fecnac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(chk_pueblo)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_pueblo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_region, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_comuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_contrasena2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void txt_dvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dvActionPerformed
       
    }//GEN-LAST:event_txt_dvActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
         int filaSeleccionada = tbl_usuarios.getSelectedRow(); //OBTIENE POSICION DE LA FILA SELECCIONADA
                                                           //si no se selecciona nada devuelve -1
            if (filaSeleccionada != -1 )
            {
                Usuario u = new Usuario();
                String runCompleto = (String)tbl_usuarios.getValueAt(filaSeleccionada, 0);
                String[]lista = runCompleto.split("-");
                int run = Integer.parseInt(lista [0]);
                u = cp.seleccionarUsuario(run);
                //u.setFec_nac((String)tbl_usuarios.getValueAt(filaSeleccionada, 2));
                String direccionCompleta = (String)tbl_usuarios.getValueAt(filaSeleccionada, 5);
                String[]seleccion = direccionCompleta.split(",");
                String direccion1 = seleccion[0];
                String comunanombre = seleccion[1];
                String region = seleccion[2];
                Direccion dir = new Direccion();
                dir.setDescripcion(direccion1);
                dir.setNom_comuna(comunanombre);
                dir.setNom_region(region);
                if(u.getRun()>0){
                    VentanaModificarUsuario vm = new VentanaModificarUsuario(u, dir);
                    vm.setVisible(true);
                }
            }else{
                Notification noti= new Notification(this, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Debe seleccionar un usuario de la lista" , "Importante");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("AulaApp"," Debe seleccionar un usuario de la lista", DesktopNotify.FAIL, 3000L);
            }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void txt_runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_runActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_runActionPerformed

    private void btn_cambiarclaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cambiarclaveActionPerformed
           int filaSeleccionada = tbl_usuarios.getSelectedRow(); //OBTIENE POSICION DE LA FILA SELECCIONADA
                                                           //si no se selecciona nada devuelve -1
            if (filaSeleccionada != -1 )
            {
                Usuario u = new Usuario();
                String runCompleto = (String)tbl_usuarios.getValueAt(filaSeleccionada, 0);
                String[]lista = runCompleto.split("-");
                int run = Integer.parseInt(lista [0]);
                u.setRun(run);
                String codigo = (String)tbl_usuarios.getValueAt(filaSeleccionada, 7);
                u.setCodUsuario(codigo);
                VentanaCambiarClave vc= new VentanaCambiarClave(u);
                vc.setVisible(true);
            }else{
                Notification noti= new Notification(this, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Debe seleccionar un usuario de la lista" , "Importante");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("AulaApp"," Debe seleccionar un usuario de la lista", DesktopNotify.FAIL, 3000L);
            }
    }//GEN-LAST:event_btn_cambiarclaveActionPerformed

    private void cb_regionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_regionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_regionActionPerformed

    private void cb_regionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_regionItemStateChanged
        cb_comuna.removeAllItems();
        Region region = (Region)cb_region.getSelectedItem();
        cargarCbComuna(region.getId());
    }//GEN-LAST:event_cb_regionItemStateChanged

    private void txt_priapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priapActionPerformed

    private void chk_puebloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_puebloActionPerformed
        if (!chk_pueblo.isSelected())
        {
            cb_pueblo.setEnabled(false);
            cb_pueblo.removeAllItems();
            cb_pueblo.addItem("--Seleccione--");
        }

        else
        {
            cb_pueblo.setEnabled(true);
            cargarCbPueblo();
            
        }
           
                     
        
    }//GEN-LAST:event_chk_puebloActionPerformed

    private void txt_codfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codfiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codfiltroActionPerformed

    private void txt_runfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_runfiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_runfiltroActionPerformed

    private void txt_runfiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runfiltroKeyTyped
        
    }//GEN-LAST:event_txt_runfiltroKeyTyped

    private void txt_runfiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runfiltroKeyPressed
        
    }//GEN-LAST:event_txt_runfiltroKeyPressed

    private void txt_runfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runfiltroKeyReleased
        ci.newFilter(txt_runfiltro.getText(), txt_nombrefiltro.getText(), txt_codfiltro.getText(), tbl_usuarios);
        btn_desactivarusuario.setEnabled(false);
    }//GEN-LAST:event_txt_runfiltroKeyReleased

    private void txt_nombrefiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombrefiltroKeyReleased
        ci.newFilter(txt_runfiltro.getText(), txt_nombrefiltro.getText(), txt_codfiltro.getText(), tbl_usuarios);
        btn_desactivarusuario.setEnabled(false);
    }//GEN-LAST:event_txt_nombrefiltroKeyReleased

    private void txt_codfiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codfiltroKeyReleased
        ci.newFilter(txt_runfiltro.getText(), txt_nombrefiltro.getText(), txt_codfiltro.getText(), tbl_usuarios);
        btn_desactivarusuario.setEnabled(false);
    }//GEN-LAST:event_txt_codfiltroKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ExportarExcel e = new ExportarExcel();
        try {
            e.exportarExcel(tbl_usuarios);
        } catch (IOException ex) {
            Logger.getLogger(VentanaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contrasenaActionPerformed

    private void tbl_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usuariosMouseClicked
        btn_desactivarusuario.setEnabled(true);
    }//GEN-LAST:event_tbl_usuariosMouseClicked

    private void btn_desactivarusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarusuarioActionPerformed
        int filaSeleccionada = tbl_usuarios.getSelectedRow();
        String runCompleto = (String)tbl_usuarios.getValueAt(filaSeleccionada, 0);
        String [] runParseado = runCompleto.split("-");
        btn_desactivarusuario.setEnabled(true);
        int seleccion = JOptionPane.showConfirmDialog(null, "¿Realmente desea desactivar al usuario RUN "+ runCompleto + " ?", "Confirmar desactivación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (seleccion ==0){
            int validador = cp.desactivarPersona(Integer.parseInt(runParseado[0]));
            if (validador == 0){
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Usuario "+ runCompleto + " desactivado" , "Correcto");
                noti.showNotification();
                lbl_contadoractivos.setText(String.valueOf(cp.contarPersonas(1)));
                lbl_contadordocentes.setText(String.valueOf(cp.contarPersonas(2)));
                lbl_contadoralumnos.setText(String.valueOf(cp.contarPersonas(3)));
                //JOptionPane.showMessageDialog(rootPane, "Usuario "+ runCompleto + " eliminado correctamente");
            if(tbl_usuariosdesactivados!=null){
                cp.listarPersonasDesactivadas(tbl_usuariosdesactivados);
            }
            cp.listarPersonas(tbl_usuarios);
            btn_desactivarusuario.setEnabled(false);
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error, intente nuevamente" , "Error");
                noti.showNotification();
                //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, por favor intente nuevamente","Error",2);
            }
        }
        
        cp.listarPersonas(tbl_usuarios);
    }//GEN-LAST:event_btn_desactivarusuarioActionPerformed

    private void btn_desactivarusuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarusuario1ActionPerformed
        VentanaUsuarioDesactivado vu = new VentanaUsuarioDesactivado();
        vu.setVisible(true);
    }//GEN-LAST:event_btn_desactivarusuario1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void cb_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sexoActionPerformed

    private void txt_runKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_runKeyReleased
        ci.limiteCaracteres(txt_run, 10);
    }//GEN-LAST:event_txt_runKeyReleased

    private void txt_dvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dvKeyReleased
        ci.limiteCaracteres(txt_dv, 1);
    }//GEN-LAST:event_txt_dvKeyReleased

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

    private void txt_mailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mailKeyReleased
        ci.limiteCaracteres(txt_mail, 100);
    }//GEN-LAST:event_txt_mailKeyReleased

    private void txt_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyReleased
        ci.limiteCaracteres(txt_usuario, 20);
    }//GEN-LAST:event_txt_usuarioKeyReleased

    private void txt_contrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contrasenaKeyReleased
        ci.limiteCaracteres(txt_contrasena, 50);
    }//GEN-LAST:event_txt_contrasenaKeyReleased

    private void txt_contrasena2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contrasena2KeyReleased
        ci.limiteCaracteres(txt_contrasena, 50);
    }//GEN-LAST:event_txt_contrasena2KeyReleased

    private void cb_puebloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_puebloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_puebloActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        
        cp.listarPersonas(tbl_usuarios);
        Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Lista actualizada" , "Correcto");
        noti.showNotification();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void cb_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_rolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_rolActionPerformed

    private void txt_nombrefiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombrefiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombrefiltroActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        String contrasena = String.valueOf(txt_contrasena.getPassword());
        String contrasena2 = String.valueOf(txt_contrasena2.getPassword());
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(contrasena.getBytes());
        ControladorPersona cp = new ControladorPersona();
        if (contrasena.equals(contrasena2)){
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
                int run = Integer.parseInt(txt_run.getText());
                String dv = txt_dv.getText().toUpperCase();
                String pri_nom=txt_prinom.getText();
                String seg_nom=txt_segnom.getText();
                String pri_ap = txt_priap.getText();
                String seg_ap = txt_segap.getText();
                Rol rol = (Rol)cb_rol.getSelectedItem();

                int rol1 = rol.getId();
                String fec_nac = "";
                Date date = txt_fecnac.getDate();
                fec_nac= sdf.format(date);
                Sexo sexo = (Sexo)cb_sexo.getSelectedItem();
                String sexo1 = String.valueOf(sexo.getId());
                int pueblo1=0;
                if(cb_pueblo.getSelectedItem().equals("")|| cb_pueblo.getSelectedItem() == null|| cb_pueblo.getSelectedItem().equals("--Seleccione--")){
                    pueblo1=0;
                }else{
                    PuebloOriginario pueblo = (PuebloOriginario)cb_pueblo.getSelectedItem();
                    pueblo1 = pueblo.getId();
                }
                String direccion = txt_direccion.getText();
                Comuna comuna = (Comuna)cb_comuna.getSelectedItem();
                int comuna1 = comuna.getId();
                String mail = txt_mail.getText();
                String nombre_usuario = txt_usuario.getText();
                Notification noti;
                int resultado = cp.almacenarPersona(run, dv, pri_nom, seg_nom, pri_ap, seg_ap, "A", fec_nac, rol1, sexo1,pueblo1, 0, 0, comuna1, direccion, nombre_usuario, mail, encodedString);
                switch (resultado) {
                    case 0:
                        noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "El usuario se ha creado exitosamente" , "Correcto");
                        noti.showNotification();
                        lbl_contadoractivos.setText(String.valueOf(cp.contarPersonas(1)));
                        lbl_contadordocentes.setText(String.valueOf(cp.contarPersonas(2)));
                        lbl_contadoralumnos.setText(String.valueOf(cp.contarPersonas(3)));
                    //JOptionPane.showMessageDialog(rootPane, "El usuario se ha creado exitosamente", "Correcto", 1);
                    limpiarCampos();
                    cp.listarPersonas(tbl_usuarios);
                    break;
                    case 2:
                        noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "El usuario ya existe" , "Error");
                        noti.showNotification();
                        //JOptionPane.showMessageDialog(rootPane, "El usuario ya existe", "Error", 2);
                    break;
                    case 1:
                        noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "El RUN ya existe" , "Error");
                        noti.showNotification();
                    break;
                    default:
                        noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ingrese todos los campos" , "Ups!");
                        noti.showNotification();
                    //JOptionPane.showMessageDialog(this, "Ha ocurrido un error, por favor valide que ingresó todos los campos y reintente","Algo salió mal", 0);
                    break;
                    
                }
            }catch(HeadlessException | NumberFormatException ex){
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ingrese todos los campos" , "Ups!");
                noti.showNotification();
                //JOptionPane.showMessageDialog(this, "Ha ocurrido un error, por favor valide que ingresó todos los campos y reintente","Algo salió mal", 0);

                ex.printStackTrace();
            }
            cp.listarPersonas(tbl_usuarios);
        }else
        {
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Las contraseñas no coinciden" , "Ups!");
            noti.showNotification();
            //JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
        }
       
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_segnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_segnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_segnomActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cambiarclave;
    private javax.swing.JButton btn_desactivarusuario;
    private javax.swing.JButton btn_desactivarusuario1;
    private com.k33ptoo.components.KButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JComboBox<Object> cb_comuna;
    private javax.swing.JComboBox<Object> cb_pueblo;
    private javax.swing.JComboBox<Object> cb_region;
    private javax.swing.JComboBox<Object> cb_rol;
    private javax.swing.JComboBox<Object> cb_sexo;
    private javax.swing.JCheckBox chk_pueblo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    public static javax.swing.JTable tbl_usuarios;
    private javax.swing.JTextField txt_codfiltro;
    private javax.swing.JPasswordField txt_contrasena;
    private javax.swing.JPasswordField txt_contrasena2;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_dv;
    private com.toedter.calendar.JDateChooser txt_fecnac;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombrefiltro;
    private javax.swing.JTextField txt_priap;
    private javax.swing.JTextField txt_prinom;
    private javax.swing.JTextField txt_run;
    private javax.swing.JTextField txt_runfiltro;
    private javax.swing.JTextField txt_segap;
    private javax.swing.JTextField txt_segnom;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
