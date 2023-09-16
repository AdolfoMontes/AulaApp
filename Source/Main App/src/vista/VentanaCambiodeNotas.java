
package vista;


import controlador.ControladorNota;
import ds.desktop.notify.DesktopNotify;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javaswingdev.Notification;
import javax.swing.JTextField;
import modelo.Nota;
import static vista.VentanaNotas.tbl_semestre1;
import static vista.VentanaNotas.tbl_semestre2;


public class VentanaCambiodeNotas extends javax.swing.JFrame {
    int x=0;
    int y=0;
    Nota nota;
    int semestre =0;
    ControladorNota cn = new ControladorNota();
    public VentanaCambiodeNotas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public  VentanaCambiodeNotas(Nota nota, int semestre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.nota = nota;
        this.semestre = semestre;
        txt_n1.setValue(String.valueOf(nota.getN1()));
        txt_n2.setValue(String.valueOf(nota.getN2()));
        txt_n3.setValue(String.valueOf(nota.getN3()));
        txt_n4.setValue(String.valueOf(nota.getN4()));
        txt_n5.setValue(String.valueOf(nota.getN5()));
        txt_n6.setValue(String.valueOf(nota.getN6()));
        txt_n7.setValue(String.valueOf(nota.getN7()));
        txt_n8.setValue(String.valueOf(nota.getN8()));
        txt_n9.setValue(String.valueOf(nota.getN9()));
        txt_n10.setValue(String.valueOf(nota.getN10()));
        pintarTxt(txt_n1);
        pintarTxt(txt_n2);
        pintarTxt(txt_n3);
        pintarTxt(txt_n4);
        pintarTxt(txt_n5);
        pintarTxt(txt_n6);
        pintarTxt(txt_n7);
        pintarTxt(txt_n8);
        pintarTxt(txt_n9);
        pintarTxt(txt_n10);
        

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }
    public static void pintarTxt(JTextField txt){
        int valor = Integer.parseInt(txt.getText().replace(".", ""));
        if(valor <40){
            txt.setForeground(Color.red);
            if(valor == 0)
                txt.setForeground(Color.black);
        }else if(valor >=40){
            txt.setForeground(Color.green);
        }
        
    }
    public void limitedeNota(JTextField txt){

        if(Integer.parseInt(txt.getText().replace(".", ""))>70 ){
            txt.setText("");
            Notification noti= new Notification(this, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Nota máxima 7.0" , "Supera límite");
            noti.showNotification(); 
            //DesktopNotify.showDesktopMessage("AulaApp","Las notas no pueden superar el máximo de 7.0", DesktopNotify.ERROR, 3000L);
        }
        pintarTxt(txt);
        
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        btn_guardar = new com.k33ptoo.components.KButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_n1 = new javax.swing.JFormattedTextField();
        txt_n2 = new javax.swing.JFormattedTextField();
        txt_n3 = new javax.swing.JFormattedTextField();
        txt_n4 = new javax.swing.JFormattedTextField();
        txt_n5 = new javax.swing.JFormattedTextField();
        txt_n6 = new javax.swing.JFormattedTextField();
        txt_n7 = new javax.swing.JFormattedTextField();
        txt_n9 = new javax.swing.JFormattedTextField();
        txt_n8 = new javax.swing.JFormattedTextField();
        txt_n10 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 102, 0));
        kGradientPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel1MouseDragged(evt);
            }
        });
        kGradientPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kGradientPanel1MousePressed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_save_40px.png"))); // NOI18N
        btn_guardar.setkBackGroundColor(new java.awt.Color(102, 102, 102));
        btn_guardar.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_guardar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_guardar.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkSelectedColor(new java.awt.Color(0, 0, 0));
        btn_guardar.setkStartColor(new java.awt.Color(102, 102, 102));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("N1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("N2");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("N3");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("N4");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("N5");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("N6");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("N7");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("N8");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("N9");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("N10");

        try {
            txt_n1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n1FocusLost(evt);
            }
        });
        txt_n1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_n1ActionPerformed(evt);
            }
        });

        try {
            txt_n2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n2FocusLost(evt);
            }
        });

        try {
            txt_n3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n3FocusLost(evt);
            }
        });

        try {
            txt_n4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n4FocusLost(evt);
            }
        });

        try {
            txt_n5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n5FocusLost(evt);
            }
        });

        try {
            txt_n6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n6FocusLost(evt);
            }
        });

        try {
            txt_n7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n7FocusLost(evt);
            }
        });

        try {
            txt_n9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n9FocusLost(evt);
            }
        });

        try {
            txt_n8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n8FocusLost(evt);
            }
        });

        try {
            txt_n10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_n10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_n10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_n10FocusLost(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(txt_n1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_n2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_n3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(txt_n4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_n5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_n6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_n7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_n8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_n9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_n10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_n1, txt_n10, txt_n2, txt_n3, txt_n4, txt_n5, txt_n6, txt_n7, txt_n8, txt_n9});

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel10, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_n1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_n1, txt_n10, txt_n2, txt_n3, txt_n4, txt_n5, txt_n6, txt_n7, txt_n8, txt_n9});

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel10, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        dispose();
    }//GEN-LAST:event_formWindowLostFocus

    private void kGradientPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_kGradientPanel1MousePressed

    private void kGradientPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_kGradientPanel1MouseDragged

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        int idAsignatura = nota.getId_asignatura();
        int anio = nota.getAnio();
        int run = Integer.parseInt(String.valueOf(nota.getRun()));
        float n1 = Float.parseFloat(txt_n1.getText());
        float n2 = Float.parseFloat(txt_n2.getText());
        float n3 = Float.parseFloat(txt_n3.getText());
        float n4 = Float.parseFloat(txt_n4.getText());
        float n5 = Float.parseFloat(txt_n5.getText());
        float n6 = Float.parseFloat(txt_n6.getText());
        float n7 = Float.parseFloat(txt_n7.getText());
        float n8 = Float.parseFloat(txt_n8.getText());
        float n9 = Float.parseFloat(txt_n9.getText());
        float n10 = Float.parseFloat(txt_n10.getText());
        System.out.println("ID Asignatura->" + idAsignatura);
        System.out.println("Año->" + anio);
        System.out.println("RUN->"+ run);
        System.out.println("N1->" + n1);
        System.out.println("N2->"+n2);
        System.out.println("N3->"+n3);
        System.out.println("N4->"+n4);
        System.out.println("N5->"+n5);
        System.out.println("N6->"+n6);
        System.out.println("Semestre->" + semestre );
        int validador = cn.almacenarNota(run, idAsignatura, anio, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, semestre);
        if(validador == 0 || validador == 1){
            Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Notas actualizadas" , "Correcto");
            noti.showNotification(); 
            //DesktopNotify.showDesktopMessage("AulaApp","Notas actualizadas correctamente", DesktopNotify.SUCCESS, 3000L);
            dispose();
            cn.calcularNotaSemestre(run, idAsignatura);
            cn.calcularNotaSemestre2(run, idAsignatura);
            cn.listarNotas(tbl_semestre1, tbl_semestre2, idAsignatura);
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Ha ocurrido un error" , "Error");
            noti.showNotification(); 
            //DesktopNotify.showDesktopMessage("AulaApp","Ha ocurrido un error, por favor reintente", DesktopNotify.ERROR, 3000L);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_n1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n1FocusLost
        limitedeNota(txt_n1);
        System.out.println(txt_n1.getText());
    }//GEN-LAST:event_txt_n1FocusLost

    private void txt_n1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_n1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_n1ActionPerformed

    private void txt_n2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n2FocusLost
        limitedeNota(txt_n2);
    }//GEN-LAST:event_txt_n2FocusLost

    private void txt_n3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n3FocusLost
        limitedeNota(txt_n3);
    }//GEN-LAST:event_txt_n3FocusLost

    private void txt_n4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n4FocusLost
        limitedeNota(txt_n4);
    }//GEN-LAST:event_txt_n4FocusLost

    private void txt_n5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n5FocusLost
        limitedeNota(txt_n5);
    }//GEN-LAST:event_txt_n5FocusLost

    private void txt_n6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n6FocusLost
        limitedeNota(txt_n6);
    }//GEN-LAST:event_txt_n6FocusLost

    private void txt_n7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n7FocusLost
        limitedeNota(txt_n7);
    }//GEN-LAST:event_txt_n7FocusLost

    private void txt_n8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n8FocusLost
        limitedeNota(txt_n8);
    }//GEN-LAST:event_txt_n8FocusLost

    private void txt_n9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n9FocusLost
        limitedeNota(txt_n9);
    }//GEN-LAST:event_txt_n9FocusLost

    private void txt_n10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_n10FocusLost
        limitedeNota(txt_n10);
    }//GEN-LAST:event_txt_n10FocusLost

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        
    }//GEN-LAST:event_formFocusLost

  
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
            java.util.logging.Logger.getLogger(VentanaCambiodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCambiodeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCambiodeNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JFormattedTextField txt_n1;
    private javax.swing.JFormattedTextField txt_n10;
    private javax.swing.JFormattedTextField txt_n2;
    private javax.swing.JFormattedTextField txt_n3;
    private javax.swing.JFormattedTextField txt_n4;
    private javax.swing.JFormattedTextField txt_n5;
    private javax.swing.JFormattedTextField txt_n6;
    private javax.swing.JFormattedTextField txt_n7;
    private javax.swing.JFormattedTextField txt_n8;
    private javax.swing.JFormattedTextField txt_n9;
    // End of variables declaration//GEN-END:variables
}
