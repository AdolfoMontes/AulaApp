
package vista;

import controlador.ControladorEvento;
import controlador.ControladorInstitucion;
import controlador.ControladorInterfaz;
import controlador.ControladorPersona;
import controlador.ControladorUsuario;
import controlador.I_Aplicacion;
import controlador.ValidarConexion;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Notification;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import modelo.Evento;
import modelo.Institucion;
import modelo.Usuario;

public class VentanaPrincipal extends javax.swing.JFrame implements I_Aplicacion {

    public static Usuario usuarioLogueado ;
    ControladorUsuario cu = new ControladorUsuario();
    ControladorPersona cp = new ControladorPersona();
    ControladorInterfaz cinterfaz = new ControladorInterfaz();
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        ControladorInstitucion ci = new controlador.ControladorInstitucion();
        Institucion i = ci.mostrarInstitucion();
        lbl_institucion.setText(i.ToString());
    }
    
    public VentanaPrincipal(Usuario usuario) {
       
        initComponents();
        this.setLocationRelativeTo(null);
        timer.start();
        this.usuarioLogueado = usuario;
        lbl_usuario.setText(usuarioLogueado.toString());
        System.out.println(usuarioLogueado.getEstado());
        if(usuarioLogueado.getEstado()=='I')
            lbl_rol.setText("Superusuario | Administrador");
        else{
            lbl_rol.setText(usuarioLogueado.getDescripcion());
            if(usuarioLogueado.getDescripcion().equals("Docente")){
                btn_usuarios.setEnabled(false);
                btn_matriculas.setEnabled(false);
                btn_cursos.setEnabled(false);
                btn_asignaturas.setEnabled(false);
                menu_configuracion.setEnabled(false);
                btn_agregaranuncio.setEnabled(false);
                btn_salas.setEnabled(false);
            }
        }
        

        ControladorInstitucion ci = new controlador.ControladorInstitucion();
        cu.recuperarImagen(usuarioLogueado.getCodUsuario(), lbl_foto, 71);
        Institucion i = ci.mostrarInstitucion();
        lbl_institucion.setText(i.ToString());
        lbl_contadoractivos.setText(String.valueOf(cp.contarPersonas(1)));
        lbl_contadordocentes.setText(String.valueOf(cp.contarPersonas(2)));
        lbl_contadoralumnos.setText(String.valueOf(cp.contarPersonas(3)));

        
        
        cargarEventos();
        try {
            
            int nuevaVersion = cinterfaz.mostrarupdate(this);
            
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Iconos/logo.png"));
        return retValue;
    }
    
    Timer timer = new Timer(1000 * 30, new ActionListener() //Timer que corre cada 30 segundos para validar la conexión
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Thread hilo = new Thread() {

                @Override
                public void run() {
                    estadoConexion();
                    cargarContadores();
                    cargarEventos();
                }
            };
            hilo.start();
        }
    });
    

    
 
                
    public void cargarContadores(){
        lbl_contadoractivos.setText(String.valueOf(cp.contarPersonas(1)));
        lbl_contadordocentes.setText(String.valueOf(cp.contarPersonas(2)));
        lbl_contadoralumnos.setText(String.valueOf(cp.contarPersonas(3)));
    }
 
    public static void cargarEventos(){
        ControladorEvento ce = new ControladorEvento();
        ArrayList <Evento> listaEvento = new ArrayList<>();
        listaEvento = ce.eventoListar();
        String texto = "";
        String color = "";
        for(Evento e: listaEvento){
            if(e.getTipo()==1){
                color="style=\"color:red\"";
            }else{
                color="style=\"color:green\"";
            }
            texto = texto + "Creado el: " + e.getFecha_ins()+ "<br> Por: " + e.getUsr_creacion()  
                    + "("+e.getPri_nom() +" " +e.getSeg_nom()+" " + e.getPri_ap()+" " + e.getSeg_ap()
                    + ") <br> <h2 "+ color + "> "+e.getTitulo() + " </h2> <br>" + e.getDetalle() +"<br>____________________________________<br>" ;
        }
        txt_anuncios.setText("<html>" + texto + "</html>");
        System.out.println(texto);
    }
            
    public void estadoConexion() {
        ValidarConexion ctrlconexion = new ValidarConexion();
        int validador = ctrlconexion.validarConexion();

        if (validador == 1) {

            lbl_conexion.setText("Conexión establecida con el servidor");
            ImageIcon imagen = new ImageIcon(getClass().getResource("/Iconos/icons8_ok_20px.png"));
            lbl_icono.setIcon(imagen);

        } else {
            lbl_conexion.setText("No hay conexión con el servidor");
            ImageIcon imagen = new ImageIcon(getClass().getResource("/Iconos/icons8_cancel_20px.png"));
            lbl_icono.setIcon(imagen);
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "No hay conexión con el servidor", "Desconectado");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp", "No hay conexión con el servidor. \nNo tiene conexión de red o el servidor no está disponible.", DesktopNotify.ERROR, 5000L);
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curvesPanel1 = new splashscreen.CurvesPanel();
        lbl_conexion = new javax.swing.JLabel();
        lbl_icono = new javax.swing.JLabel();
        lbl_institucion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_rol = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_contadoractivos = new javax.swing.JLabel();
        btn_usuarios = new javax.swing.JButton();
        btn_reportes = new javax.swing.JButton();
        btn_salas = new javax.swing.JButton();
        btn_asignaturas = new javax.swing.JButton();
        btn_cursos = new javax.swing.JButton();
        btn_hojadevida = new javax.swing.JButton();
        btn_cerrarsesion = new javax.swing.JButton();
        btn_alumnos = new javax.swing.JButton();
        kGradientPanel4 = new com.k33ptoo.components.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        lbl_contadordocentes = new javax.swing.JLabel();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        lbl_contadoralumnos = new javax.swing.JLabel();
        btn_notas = new com.raven.swing.Button();
        btn_leccionario = new com.raven.swing.Button();
        btn_observaciones = new com.raven.swing.Button();
        btn_asistencias = new com.raven.swing.Button();
        btn_matriculas = new javax.swing.JButton();
        panelGlowingGradient1 = new javaswingdev.pggb.PanelGlowingGradient();
        jLabel7 = new javax.swing.JLabel();
        btn_agregaranuncio = new com.raven.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_anuncios = new javax.swing.JTextPane();
        lbl_foto = new com.raven.theme.ImageAvatar();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_heramientas = new javax.swing.JMenu();
        menu_configuracion = new javax.swing.JMenuItem();
        menu_actualizacion = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AulaApp v"+ VERSION);
        setIconImages(null);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        curvesPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lbl_conexion.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lbl_conexion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_conexion.setText("Conexión establecida con el servidor");

        lbl_icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_20px.png"))); // NOI18N

        lbl_institucion.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        lbl_institucion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_institucion.setText("liceo");

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¿Qué quieres hacer hoy?");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Google_Home_80px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Hola de nuevo.");

        lbl_usuario.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Usuario");

        lbl_rol.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lbl_rol.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rol.setText("Rol");

        jPanel5.setOpaque(false);

        kGradientPanel2.setkBorderRadius(0);
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 102));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 153, 51));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Alumnos activos");

        lbl_contadoractivos.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        lbl_contadoractivos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contadoractivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbl_contadoractivos, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbl_contadoractivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(19, 19, 19))
        );

        btn_usuarios.setBackground(new java.awt.Color(102, 102, 102));
        btn_usuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_usuarios.setForeground(new java.awt.Color(255, 255, 255));
        btn_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_User_Locked_35px_1.png"))); // NOI18N
        btn_usuarios.setText("Usuarios");
        btn_usuarios.setToolTipText("Crear/administrar Usuarios");
        btn_usuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_usuarios.setIconTextGap(30);
        btn_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuariosActionPerformed(evt);
            }
        });

        btn_reportes.setBackground(new java.awt.Color(102, 102, 102));
        btn_reportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reportes.setForeground(new java.awt.Color(255, 255, 255));
        btn_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_pie_chart_35px.png"))); // NOI18N
        btn_reportes.setText("Reportes");
        btn_reportes.setToolTipText("Generar reportes/certificados");
        btn_reportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_reportes.setIconTextGap(30);
        btn_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportesActionPerformed(evt);
            }
        });

        btn_salas.setBackground(new java.awt.Color(102, 102, 102));
        btn_salas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_salas.setForeground(new java.awt.Color(255, 255, 255));
        btn_salas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_classroom_35px.png"))); // NOI18N
        btn_salas.setText("Salas");
        btn_salas.setToolTipText("Gestiona las salas disponibles");
        btn_salas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_salas.setIconTextGap(30);
        btn_salas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salasActionPerformed(evt);
            }
        });

        btn_asignaturas.setBackground(new java.awt.Color(102, 102, 102));
        btn_asignaturas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_asignaturas.setForeground(new java.awt.Color(255, 255, 255));
        btn_asignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_course_assign_35px.png"))); // NOI18N
        btn_asignaturas.setText("Asignaturas");
        btn_asignaturas.setToolTipText("Administración de Asignaturas");
        btn_asignaturas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_asignaturas.setIconTextGap(30);
        btn_asignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asignaturasActionPerformed(evt);
            }
        });

        btn_cursos.setBackground(new java.awt.Color(102, 102, 102));
        btn_cursos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cursos.setForeground(new java.awt.Color(255, 255, 255));
        btn_cursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_people_working_together_35px_1.png"))); // NOI18N
        btn_cursos.setText("Cursos");
        btn_cursos.setToolTipText("Agregar/modificar observaciones");
        btn_cursos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cursos.setIconTextGap(30);
        btn_cursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cursosActionPerformed(evt);
            }
        });

        btn_hojadevida.setBackground(new java.awt.Color(102, 102, 102));
        btn_hojadevida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_hojadevida.setForeground(new java.awt.Color(255, 255, 255));
        btn_hojadevida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_spreadsheet_file_35px.png"))); // NOI18N
        btn_hojadevida.setText("Hoja de vida");
        btn_hojadevida.setToolTipText("");
        btn_hojadevida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_hojadevida.setIconTextGap(30);
        btn_hojadevida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hojadevidaActionPerformed(evt);
            }
        });

        btn_cerrarsesion.setBackground(new java.awt.Color(102, 0, 0));
        btn_cerrarsesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cerrarsesion.setForeground(new java.awt.Color(255, 255, 255));
        btn_cerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_sign_35px.png"))); // NOI18N
        btn_cerrarsesion.setText("Cerrar sesión");
        btn_cerrarsesion.setToolTipText("Cerrar sesión");
        btn_cerrarsesion.setContentAreaFilled(false);
        btn_cerrarsesion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cerrarsesion.setIconTextGap(30);
        btn_cerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarsesionActionPerformed(evt);
            }
        });

        btn_alumnos.setBackground(new java.awt.Color(102, 102, 102));
        btn_alumnos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_alumnos.setForeground(new java.awt.Color(255, 255, 255));
        btn_alumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_graduate_35px.png"))); // NOI18N
        btn_alumnos.setText("Alumnos");
        btn_alumnos.setToolTipText("Agregar/quitar alumnos de cursos");
        btn_alumnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_alumnos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_alumnos.setIconTextGap(30);
        btn_alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alumnosActionPerformed(evt);
            }
        });

        kGradientPanel4.setkBorderRadius(0);
        kGradientPanel4.setkEndColor(new java.awt.Color(255, 255, 102));
        kGradientPanel4.setkStartColor(new java.awt.Color(204, 102, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Docentes activos");

        lbl_contadordocentes.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        lbl_contadordocentes.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contadordocentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbl_contadordocentes, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbl_contadordocentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        kGradientPanel3.setkBorderRadius(0);
        kGradientPanel3.setkEndColor(new java.awt.Color(255, 204, 204));
        kGradientPanel3.setkStartColor(new java.awt.Color(153, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alumnos sin curso");

        lbl_contadoralumnos.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        lbl_contadoralumnos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contadoralumnos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_contadoralumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbl_contadoralumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btn_notas.setBackground(new java.awt.Color(153, 153, 153));
        btn_notas.setForeground(new java.awt.Color(255, 255, 255));
        btn_notas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_grades_80px_3.png"))); // NOI18N
        btn_notas.setText("Notas");
        btn_notas.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        btn_notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notasActionPerformed(evt);
            }
        });

        btn_leccionario.setBackground(new java.awt.Color(51, 51, 51));
        btn_leccionario.setForeground(new java.awt.Color(255, 255, 255));
        btn_leccionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_classroom_80px.png"))); // NOI18N
        btn_leccionario.setText("Leccionario");
        btn_leccionario.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        btn_leccionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_leccionarioActionPerformed(evt);
            }
        });

        btn_observaciones.setBackground(new java.awt.Color(153, 153, 153));
        btn_observaciones.setForeground(new java.awt.Color(255, 255, 255));
        btn_observaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_thumbs_up_down_80px_1.png"))); // NOI18N
        btn_observaciones.setText("Observaciones");
        btn_observaciones.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        btn_observaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_observacionesActionPerformed(evt);
            }
        });

        btn_asistencias.setBackground(new java.awt.Color(51, 51, 51));
        btn_asistencias.setForeground(new java.awt.Color(255, 255, 255));
        btn_asistencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_attendance_80px.png"))); // NOI18N
        btn_asistencias.setText("Asistencias");
        btn_asistencias.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        btn_asistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asistenciasActionPerformed(evt);
            }
        });

        btn_matriculas.setBackground(new java.awt.Color(102, 102, 102));
        btn_matriculas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_matriculas.setForeground(new java.awt.Color(255, 255, 255));
        btn_matriculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_form_35px.png"))); // NOI18N
        btn_matriculas.setText("Matrículas");
        btn_matriculas.setToolTipText("Agregar/quitar alumnos de cursos");
        btn_matriculas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_matriculas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_matriculas.setIconTextGap(30);
        btn_matriculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_matriculasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_usuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_reportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_salas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cursos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cerrarsesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(btn_hojadevida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_asignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_alumnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_matriculas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_observaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_leccionario, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_notas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_asistencias, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_asistencias, btn_notas});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_matriculas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_cursos)
                        .addGap(0, 0, 0)
                        .addComponent(btn_salas)
                        .addGap(0, 0, 0)
                        .addComponent(btn_asignaturas)
                        .addGap(0, 0, 0)
                        .addComponent(btn_alumnos)
                        .addGap(0, 0, 0)
                        .addComponent(btn_reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_hojadevida, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_cerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_leccionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_notas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_asistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        btn_usuarios.getAccessibleContext().setAccessibleParent(jPanel5);
        btn_reportes.getAccessibleContext().setAccessibleParent(jPanel5);
        btn_salas.getAccessibleContext().setAccessibleParent(jPanel5);
        btn_asignaturas.getAccessibleContext().setAccessibleParent(jPanel5);
        btn_cursos.getAccessibleContext().setAccessibleParent(jPanel5);
        btn_hojadevida.getAccessibleContext().setAccessibleParent(jPanel5);
        btn_cerrarsesion.getAccessibleContext().setAccessibleParent(jPanel5);
        btn_alumnos.getAccessibleContext().setAccessibleParent(jPanel5);

        panelGlowingGradient1.setGradientColor1(new java.awt.Color(255, 102, 0));
        panelGlowingGradient1.setGradientColor2(new java.awt.Color(0, 0, 0));
        panelGlowingGradient1.setShadowSize(10);

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Anuncios");
        panelGlowingGradient1.add(jLabel7);
        jLabel7.setBounds(30, 30, 190, 25);

        btn_agregaranuncio.setBackground(new java.awt.Color(0, 102, 0));
        btn_agregaranuncio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_comment_medical_30px.png"))); // NOI18N
        btn_agregaranuncio.setToolTipText("Crear anuncio");
        btn_agregaranuncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregaranuncioActionPerformed(evt);
            }
        });
        panelGlowingGradient1.add(btn_agregaranuncio);
        btn_agregaranuncio.setBounds(180, 500, 40, 30);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        txt_anuncios.setEditable(false);
        txt_anuncios.setBackground(new java.awt.Color(51, 51, 51));
        txt_anuncios.setBorder(null);
        txt_anuncios.setContentType("text/html"); // NOI18N
        txt_anuncios.setForeground(new java.awt.Color(255, 255, 255));
        txt_anuncios.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txt_anuncios);

        panelGlowingGradient1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 200, 420);

        lbl_foto.setBorderSize(4);
        lbl_foto.setGradientColor1(new java.awt.Color(204, 153, 0));
        lbl_foto.setGradientColor2(new java.awt.Color(102, 0, 0));
        lbl_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_fotoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_fotoMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout curvesPanel1Layout = new javax.swing.GroupLayout(curvesPanel1);
        curvesPanel1.setLayout(curvesPanel1Layout);
        curvesPanel1Layout.setHorizontalGroup(
            curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, curvesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(curvesPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rol)
                            .addGroup(curvesPanel1Layout.createSequentialGroup()
                                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_institucion, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(curvesPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_conexion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_icono)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, curvesPanel1Layout.createSequentialGroup()
                        .addComponent(panelGlowingGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        curvesPanel1Layout.setVerticalGroup(
            curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanel1Layout.createSequentialGroup()
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(curvesPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(curvesPanel1Layout.createSequentialGroup()
                                    .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(curvesPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbl_usuario)
                                            .addGap(6, 6, 6))
                                        .addGroup(curvesPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(9, 9, 9)))
                                    .addComponent(lbl_rol))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(curvesPanel1Layout.createSequentialGroup()
                        .addComponent(panelGlowingGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_icono)
                            .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_conexion)
                                .addComponent(lbl_institucion)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(curvesPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 580));

        menu_heramientas.setText("Herramientas");

        menu_configuracion.setText("Configuración");
        menu_configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_configuracionActionPerformed(evt);
            }
        });
        menu_heramientas.add(menu_configuracion);

        menu_actualizacion.setText("Buscar actualizaciones");
        menu_actualizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_actualizacionActionPerformed(evt);
            }
        });
        menu_heramientas.add(menu_actualizacion);

        jMenuBar1.add(menu_heramientas);

        jMenu2.setText("Ayuda");

        jMenuItem1.setText("Acerca de AulaApp");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_alumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alumnosActionPerformed
        VentanaAlumnos va = new VentanaAlumnos();
        va.setVisible(true);
    }//GEN-LAST:event_btn_alumnosActionPerformed

    private void btn_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosActionPerformed

        VentanaUsuarios vu = new VentanaUsuarios();
        vu.setVisible(true);
    }//GEN-LAST:event_btn_usuariosActionPerformed

    private void btn_asignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asignaturasActionPerformed
        VentanaAsignaturas va = new VentanaAsignaturas(usuarioLogueado);
        va.setVisible(true);
    }//GEN-LAST:event_btn_asignaturasActionPerformed

    private void btn_hojadevidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hojadevidaActionPerformed
        VentanaHojadeVida vh = new VentanaHojadeVida();
        vh.setVisible(true);
    }//GEN-LAST:event_btn_hojadevidaActionPerformed

    private void btn_cursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cursosActionPerformed
        VentanaCursos vc = new VentanaCursos();
        vc.setVisible(true);
    }//GEN-LAST:event_btn_cursosActionPerformed

    private void btn_salasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salasActionPerformed
        VentanaSalas vs = new VentanaSalas();
        vs.setVisible(true);
    }//GEN-LAST:event_btn_salasActionPerformed

    private void btn_cerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarsesionActionPerformed
        dispose();
        VentanaLogin vl = new VentanaLogin();
        vl.setVisible(true);
    }//GEN-LAST:event_btn_cerrarsesionActionPerformed

    private void menu_actualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_actualizacionActionPerformed
        VentanaActualizacion va = new VentanaActualizacion();
        va.setVisible(true);
    }//GEN-LAST:event_menu_actualizacionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        VentanaAcercaDe va = new VentanaAcercaDe();
        va.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
        VentanaReportes vr = new VentanaReportes();
        vr.setVisible(true);
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void lbl_fotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_fotoMouseClicked
        VentanaCambiarFotoPerfil vcf = new VentanaCambiarFotoPerfil(usuarioLogueado);
        vcf.setVisible(true);
    }//GEN-LAST:event_lbl_fotoMouseClicked

    private void lbl_fotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_fotoMouseEntered
        lbl_foto.setCursor(new Cursor(HAND_CURSOR));
    }//GEN-LAST:event_lbl_fotoMouseEntered

    private void btn_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notasActionPerformed
        VentanaNotas vn = new VentanaNotas();
        vn.setVisible(true);
    }//GEN-LAST:event_btn_notasActionPerformed

    private void btn_leccionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_leccionarioActionPerformed
        VentanaLeccionario cl = new VentanaLeccionario(usuarioLogueado);
        cl.setVisible(true);
        //VentanaMatricula vm = new VentanaMatricula(usuarioLogueado);
        //vm.setVisible(true);
    }//GEN-LAST:event_btn_leccionarioActionPerformed

    private void btn_observacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_observacionesActionPerformed
        VentanaObservaciones vo = new VentanaObservaciones(usuarioLogueado);
        vo.setVisible(true);

    }//GEN-LAST:event_btn_observacionesActionPerformed

    private void btn_asistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asistenciasActionPerformed
        VentanaAsistencia va = new VentanaAsistencia(usuarioLogueado);
        va.setVisible(true);
    }//GEN-LAST:event_btn_asistenciasActionPerformed

    private void menu_configuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_configuracionActionPerformed
        VentanaConfiguracion vc = new VentanaConfiguracion();
        vc.setVisible(true);
    }//GEN-LAST:event_menu_configuracionActionPerformed

    private void btn_matriculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_matriculasActionPerformed
        VentanaMatricula vm = new VentanaMatricula(usuarioLogueado);
        vm.setVisible(true);
    }//GEN-LAST:event_btn_matriculasActionPerformed

    private void btn_agregaranuncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregaranuncioActionPerformed
        VentanaAgregarAnuncio vau = new VentanaAgregarAnuncio();
        vau.setVisible(true);
    }//GEN-LAST:event_btn_agregaranuncioActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.swing.Button btn_agregaranuncio;
    private javax.swing.JButton btn_alumnos;
    private javax.swing.JButton btn_asignaturas;
    private com.raven.swing.Button btn_asistencias;
    private javax.swing.JButton btn_cerrarsesion;
    private javax.swing.JButton btn_cursos;
    private javax.swing.JButton btn_hojadevida;
    private com.raven.swing.Button btn_leccionario;
    private javax.swing.JButton btn_matriculas;
    private com.raven.swing.Button btn_notas;
    private com.raven.swing.Button btn_observaciones;
    private javax.swing.JButton btn_reportes;
    private javax.swing.JButton btn_salas;
    private javax.swing.JButton btn_usuarios;
    private splashscreen.CurvesPanel curvesPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel4;
    private javax.swing.JLabel lbl_conexion;
    public static javax.swing.JLabel lbl_contadoractivos;
    public static javax.swing.JLabel lbl_contadoralumnos;
    public static javax.swing.JLabel lbl_contadordocentes;
    public static com.raven.theme.ImageAvatar lbl_foto;
    private javax.swing.JLabel lbl_icono;
    public static javax.swing.JLabel lbl_institucion;
    private javax.swing.JLabel lbl_rol;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JMenuItem menu_actualizacion;
    private javax.swing.JMenuItem menu_configuracion;
    private javax.swing.JMenu menu_heramientas;
    private javaswingdev.pggb.PanelGlowingGradient panelGlowingGradient1;
    public static javax.swing.JTextPane txt_anuncios;
    // End of variables declaration//GEN-END:variables
}
