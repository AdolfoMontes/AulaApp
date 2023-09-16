
package vista;

import controlador.ControladorInterfaz;
import controlador.ControladorMail;
import controlador.TextPrompt;
import ds.desktop.notify.DesktopNotify;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Notification;
import modelo.Usuario;
import org.json.JSONException;
import org.json.JSONObject;

public class VentanaRestablecerClave extends javax.swing.JFrame {
    private static HttpURLConnection conn;
    Usuario u = new Usuario();
    String codigoOtp;
    ControladorInterfaz ci = new ControladorInterfaz();
    public VentanaRestablecerClave() throws Exception {
        initComponents();
        this.setLocationRelativeTo(null);
        new TextPrompt("tucorreo@dominio.com", txt_mail);
        
        
        
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("iconos/logo.png"));


        return retValue;
    }
    
    public void enviarMailAPI(String mail) throws Exception{
        ControladorMail cm = new ControladorMail();
        u = cm.mailValidar(mail);
        if(u.getRun() > 0){
            codigoOtp = cm.crearCodigoOtp(u);
            if(!codigoOtp.equals("-1")){
                try { 
                URL url = new URL("http://localhost:3000/send-email/");
                Map<String, Object> params = new LinkedHashMap<>();
                params.put("nombres", u.getPri_nom()+" " +u.getPri_ap());
                params.put("mail", u.getMail());
                params.put("codigoOtp", codigoOtp);
                StringBuilder postData = new StringBuilder();
                for(Map.Entry<String,Object>param:params.entrySet()){
                    if(postData.length()!=0)postData.append('&');
                    postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
                    postData.append('=');
                    postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
                }
                byte[] postDataBytes = postData.toString().getBytes("UTF-8");
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length",String.valueOf(postDataBytes.length));
                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);
                Reader in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
                StringBuilder sb = new StringBuilder();
                for (int c; (c = in.read()) >= 0;)
                    sb.append((char)c);
                String response = sb.toString();
                System.out.println(response);
                JSONObject myResponse =null;

                myResponse = new JSONObject(response.toString());
                Notification noti= new Notification(this, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Revisa tu bandeja de entrada", "Mail enviado");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("AulaApp","Te hemos enviado un correo, revisa tu bandeja de entrada!", DesktopNotify.SUCCESS, 4000L);
                System.out.println("result after Reading JSON Response");
                /*
                System.out.println("origin- "+myResponse.getString("origin"));
                System.out.println("url- "+myResponse.getString("url"));
                JSONObject form_data = myResponse.getJSONObject("form");
                System.out.println("CODE- "+form_data.getString("CODE"));
                System.out.println("email- "+form_data.getString("email"));
                System.out.println("message- "+form_data.getString("message"));
                System.out.println("name"+form_data.getString("name"));*/
                } catch (MalformedURLException ex) {
                    Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "No se ha podido enviar el correo", "Servicio no disponible");
                    noti.showNotification();    
                    //DesktopNotify.showDesktopMessage("AulaApp","No se ha podido enviar el correo, intenta mas tarde.", DesktopNotify.ERROR, 4000L);
                } catch (IOException ex) {
                    Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "No se ha podido enviar el correo", "Servicio no disponible");
                    noti.showNotification();
                    //DesktopNotify.showDesktopMessage("AulaApp","No se ha podido enviar el correo, intenta mas tarde.", DesktopNotify.ERROR, 4000L);
                }
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "No se ha pudo generar código", "Intente mas tarde");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("AulaApp","No se ha podido generar el código de autorización.", DesktopNotify.ERROR, 4000L);
            }
            
        }else{
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Correo no registrado", "Acción no finalizada");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("AulaApp"," El correo no se encuentra en nuestros registros.", DesktopNotify.ERROR, 4000L);
        }
        
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        kButton1 = new com.k33ptoo.components.KButton();
        txt_codigo = new javax.swing.JTextField();
        txt_validar = new com.k33ptoo.components.KButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restablecer Contraseña");
        setIconImage(getIconImage());
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(153, 51, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Restablecer Contraseña");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Paso 1 :");

        txt_mail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mailKeyTyped(evt);
            }
        });

        kButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_mail_40px.png"))); // NOI18N
        kButton1.setText("Enviar código de Autorización");
        kButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(102, 102, 102));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(51, 102, 0));
        kButton1.setkSelectedColor(new java.awt.Color(102, 102, 102));
        kButton1.setkStartColor(new java.awt.Color(0, 0, 0));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        txt_codigo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoKeyTyped(evt);
            }
        });

        txt_validar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_ok_40px.png"))); // NOI18N
        txt_validar.setText("Validar Código");
        txt_validar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_validar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        txt_validar.setkHoverStartColor(new java.awt.Color(102, 0, 51));
        txt_validar.setkSelectedColor(new java.awt.Color(102, 0, 0));
        txt_validar.setkStartColor(new java.awt.Color(0, 0, 0));
        txt_validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_validarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("El código tiene una duración de 10 minutos.");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Revisa la bandeja de entrada.");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Por favor ingresa tu correo electrónico.");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Paso 3 :");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingresa tu código de autorización.");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Si no encuentras nada, revisa en la carpeta de spam.");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Paso 2 :");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_codigo)
                                    .addComponent(txt_validar, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(116, 116, 116))))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                            .addComponent(txt_mail)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(129, 129, 129))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel9))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_validar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        try {
            enviarMailAPI(txt_mail.getText());
        } catch (Exception ex) {
            Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "No se ha podido enviar el correo", "Servicio no disponible");
            noti.showNotification();
            //DesktopNotify.showDesktopMessage("Oops!","No fue posible conectar con el servidor de correos. Por favor intenta mas tarde.", DesktopNotify.ERROR, 4000L);
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void txt_validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_validarActionPerformed
            ControladorMail cm = new ControladorMail();
            codigoOtp = txt_codigo.getText();
            int resultado = cm.validarCodigoOtp(u, codigoOtp);
            if(resultado==0){
                VentanaNuevaClave vcc = new VentanaNuevaClave(u);
                vcc.setVisible(true);
            }else{
                Notification noti= new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Intenta nuevamente", "Código incorrecto");
                noti.showNotification();
                //DesktopNotify.showDesktopMessage("Oops!","El código es incorrecto :(", DesktopNotify.ERROR, 4000L);
            }
            
    }//GEN-LAST:event_txt_validarActionPerformed

    private void txt_mailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mailKeyTyped
        ci.limiteCaracteres(txt_mail, 150);
    }//GEN-LAST:event_txt_mailKeyTyped

    private void txt_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyTyped
        
        ci.limiteCaracteres(txt_codigo, 50);
    }//GEN-LAST:event_txt_codigoKeyTyped

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
            java.util.logging.Logger.getLogger(VentanaRestablecerClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRestablecerClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRestablecerClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRestablecerClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaRestablecerClave().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(VentanaRestablecerClave.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_mail;
    private com.k33ptoo.components.KButton txt_validar;
    // End of variables declaration//GEN-END:variables
}
