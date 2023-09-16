
package vista;

import controlador.ControladorAsistencia;
import controlador.ControladorInstitucion;
import controlador.ControladorInterfaz;
import controlador.ControladorNota;
import ds.desktop.notify.DesktopNotify;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JOptionPane;
import modelo.Institucion;
import vista.VentanaPrincipal;
import javaswingdev.Notification;
public class VentanaConfiguracion extends javax.swing.JFrame {

    ControladorInterfaz ci = new ControladorInterfaz();
    ControladorInstitucion cins = new ControladorInstitucion();
    ControladorNota cn = new ControladorNota();
    ControladorAsistencia ca = new ControladorAsistencia();
    Institucion i;
    File file;
    public VentanaConfiguracion() {
        initComponents();
        ci.recuperarLogo(lbl_logo, 71);
        i = cins.mostrarInstitucion();
        txt_codinst.setText(String.valueOf(i.getCodigo()));
        txt_nombreins.setText(i.getNombre());
        txt_rutinst.setText(String.valueOf(i.getRut()));
        cb_establecimiento.setSelectedItem(i.getTipo());
        txt_param1.setText(String.valueOf(cn.getParametro(1)));
        txt_param2.setText(String.valueOf(cn.getParametro(2)));
        txt_param3.setText(String.valueOf(cn.getParametro(3)));
        txt_diasasistencia.setValue(ca.diasBloqueo(4));
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_param1 = new javax.swing.JFormattedTextField();
        btn_guardar2 = new com.k33ptoo.components.KButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_param2 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_param3 = new javax.swing.JFormattedTextField();
        btn_guardar3 = new com.k33ptoo.components.KButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_diasasistencia = new javax.swing.JSpinner();
        btn_guardar4 = new com.k33ptoo.components.KButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nombreins = new javax.swing.JTextField();
        txt_rutinst = new javax.swing.JTextField();
        txt_codinst = new javax.swing.JTextField();
        lbl_logo = new com.raven.theme.ImageAvatar();
        btn_subirimagen = new com.raven.swing.Button();
        txt_ruta = new javax.swing.JTextField();
        btn_examinar = new com.raven.swing.Button();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_establecimiento = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_guardar1 = new com.k33ptoo.components.KButton();
        btn_cancelar = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración");
        setIconImage(getIconImage());
        setResizable(false);

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignaturas"));

        jLabel1.setText("Nota mínima de Aprobación asignaturas:");

        try {
            txt_param1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_param1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_param1.setToolTipText("Utiliza este valor para definir el umbral de aprobación. Si defines un 5.0, entonces al realizar cierres de asignatura quienes tengan una nota promedio menor, reprobarán. Este cambio no afecta los cierres de asignatura ya realizados ni el estado de los alumnos antiguos.");
        txt_param1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_param1ActionPerformed(evt);
            }
        });

        btn_guardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar2.setText("Guardar");
        btn_guardar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar2.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar2.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar2.setkStartColor(new java.awt.Color(0, 102, 0));
        btn_guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_param1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_param1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cierre de año"));

        jLabel2.setText("Nota mínima de Aprobación cursos:");

        try {
            txt_param2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_param2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_param2.setToolTipText("Utiliza este valor para definir el umbral de aprobación. Si defines un 5.0, entonces al realizar cierres de año quienes tengan una nota promedio menor, reprobarán. Este cambio no afecta los cierres de asignatura ya realizados ni el estado de los alumnos antiguos.");
        txt_param2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_param2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tolerancia de cursos reprobados para aprobación de alumno:");

        txt_param3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txt_param3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_param3.setToolTipText("Ej: si alumno reprueba X cantidad de asignaturas, entonces no será promovido");
        txt_param3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_param3ActionPerformed(evt);
            }
        });

        btn_guardar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar3.setText("Guardar");
        btn_guardar3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar3.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar3.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar3.setkStartColor(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_param2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_param3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(btn_guardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_guardar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_param2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_param3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Asistencia"));

        jLabel7.setText("Dias máximo permitido ingresar asistencia: ");

        txt_diasasistencia.setModel(new javax.swing.SpinnerNumberModel(1, 0, 300, 1));

        btn_guardar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        btn_guardar4.setText("Guardar");
        btn_guardar4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_guardar4.setkEndColor(new java.awt.Color(0, 0, 0));
        btn_guardar4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar4.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar4.setkStartColor(new java.awt.Color(0, 102, 0));
        btn_guardar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_diasasistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardar4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txt_diasasistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_guardar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Parámetros", jPanel1);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Nombre Institución:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel5.setText("RUT:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel6.setText("Código:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));
        jPanel4.add(txt_nombreins, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 287, -1));
        jPanel4.add(txt_rutinst, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 287, -1));
        jPanel4.add(txt_codinst, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 287, -1));
        jPanel4.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 160, 130));

        btn_subirimagen.setText("Subir Imagen");
        btn_subirimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_subirimagenActionPerformed(evt);
            }
        });
        jPanel4.add(btn_subirimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 115, -1));
        jPanel4.add(txt_ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 234, -1));

        btn_examinar.setText("Examinar");
        btn_examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_examinarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_examinar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 117, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_opened_folder_24px.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, -1, -1));

        jLabel9.setText("Tipo:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        cb_establecimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Municipal", "Subvencionado", "Particular", "Otro" }));
        jPanel4.add(cb_establecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 287, -1));

        jLabel10.setText("Código numérico. Ej:13025631");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel11.setText("RUT sin dígito verificador ni puntos. Ej:78962152");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

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
        jPanel4.add(btn_guardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 141, -1));

        jTabbedPane1.addTab("Institución", jPanel4);

        kGradientPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, -1, -1));

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
        kGradientPanel1.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 141, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_param1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_param1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_param1ActionPerformed

    private void txt_param2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_param2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_param2ActionPerformed

    private void txt_param3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_param3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_param3ActionPerformed

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        Institucion ins = new Institucion();
        ins.setCodigo(Integer.parseInt(txt_codinst.getText()));
        ins.setRut(Integer.parseInt(txt_rutinst.getText()));
        ins.setNombre(txt_nombreins.getText());
        ins.setTipo(cb_establecimiento.getSelectedItem().toString());
        int validador = cins.institucionActualizar(ins);
        if(validador ==0){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Cambios guardados correctamente", "Correcto");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp","Cambios guardados correctamente", DesktopNotify.SUCCESS, 15000L);
            //JOptionPane.showMessageDialog(rootPane, "Cambios guardados correctamente");
            Institucion institucion = cins.mostrarInstitucion();
            VentanaPrincipal.lbl_institucion.setText(institucion.ToString());
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error, por favor intente nuevamente", "Ups!");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp","Ha ocurrido un error, por favor intente nuevamente", DesktopNotify.ERROR, 15000L);
        }
            
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_examinarActionPerformed
        file = ci.abrirFileChooser(this, txt_ruta, lbl_logo);
    }//GEN-LAST:event_btn_examinarActionPerformed

    private void btn_subirimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_subirimagenActionPerformed
        int validador = ci.guardarLogo(file, lbl_logo);
        if (validador == 0){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Imagen actualizada correctamente", "Correcto");
            noti.showNotification();
            //JOptionPane.showMessageDialog(rootPane, "Imagen actualizada correctamente.");
            ci.recuperarLogo(lbl_logo, 71);
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Debes subir una imagen válida", "Ups!");
            noti.showNotification();
            //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error cargando la imagen, valide que la imagen sea valida y reintente.");
        }
    }//GEN-LAST:event_btn_subirimagenActionPerformed

    private void btn_guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar2ActionPerformed
        float param = (Float.parseFloat(txt_param1.getText()));
        System.out.println(param);
        int validador = cn.guardarParametro(1, param);
        
        
        if (validador == 0 || validador ==1){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Valor actualizado corectamente", "Correcto");
            noti.showNotification();
            //JOptionPane.showMessageDialog(rootPane, "Valor actualizado corectamente");
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error, por favor reintente", "Ups!");
            noti.showNotification();
            //JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error, por favor reintente");
        }
    }//GEN-LAST:event_btn_guardar2ActionPerformed

    private void btn_guardar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar4ActionPerformed
        int validador = ca.cambiarDiasBloqueo(4, (int)txt_diasasistencia.getValue());
        if (validador==0){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Valor actualizado corectamente", "Correcto");
            noti.showNotification();
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error, por favor reintente", "Ups!");
            noti.showNotification();
        }
    }//GEN-LAST:event_btn_guardar4ActionPerformed

    
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
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConfiguracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_cancelar;
    private com.raven.swing.Button btn_examinar;
    private com.k33ptoo.components.KButton btn_guardar1;
    private com.k33ptoo.components.KButton btn_guardar2;
    private com.k33ptoo.components.KButton btn_guardar3;
    private com.k33ptoo.components.KButton btn_guardar4;
    private com.raven.swing.Button btn_subirimagen;
    private javax.swing.JComboBox<String> cb_establecimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.raven.theme.ImageAvatar lbl_logo;
    private javax.swing.JTextField txt_codinst;
    private javax.swing.JSpinner txt_diasasistencia;
    private javax.swing.JTextField txt_nombreins;
    private javax.swing.JFormattedTextField txt_param1;
    private javax.swing.JFormattedTextField txt_param2;
    private javax.swing.JFormattedTextField txt_param3;
    private javax.swing.JTextField txt_ruta;
    private javax.swing.JTextField txt_rutinst;
    // End of variables declaration//GEN-END:variables
}
