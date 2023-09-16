


import javax.swing.UIManager;
import vista.VentanaLogin;
import com.formdev.flatlaf.*;
import controlador.ControladorPersona;
import controlador.ControladorUsuario;
import controlador.ValidarConexion;
import controlador.VentanaSinConexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import vista.VentanaInicial;


public class Main {

   
    public static void main(String[] args) {
        ValidarConexion vc = new ValidarConexion();
        int validadorConexion = vc.validarConexion();
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");          
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(validadorConexion == 1){
            
            ControladorUsuario cu=new ControladorUsuario();
            int validador = cu.contarUsuarios();
            if(validador > 0){
                VentanaLogin v = new VentanaLogin();
                v.setVisible(true);

            }
            else{
                VentanaInicial vi = new VentanaInicial();
                vi.setVisible(true);
            }
        }else{
            VentanaSinConexion vsc = new VentanaSinConexion();
            vsc.setVisible(true);
        }
          
    

    }

}
