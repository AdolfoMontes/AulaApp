
package controlador;

import com.raven.theme.ImageAvatar;
import db.Conexion;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import modelo.Usuario;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ControladorUsuario {
     public Usuario usuarioValidar(Usuario usuario)
    {   
        Usuario u = new Usuario();
        try
        {
            Conexion conexion = new Conexion();
            
            try (Connection con = conexion.getConnection()) 
            {
                Base64.Encoder encoder = Base64.getEncoder();
                String encodedString = encoder.encodeToString(usuario.getPassword().getBytes());
                System.out.println(encodedString);
                PreparedStatement ps2 = con.prepareStatement("SELECT u.run,u.cod_usuario,u.mail,u.estado, r.descripcion, p.pri_nom, p.seg_nom, p.pri_ap, p.seg_ap FROM USUARIO u left join PERSONA P ON u.run = p.run  "
                        + "                                     left join ROL r on p.id_rol = r.id_rol "
                        + "                                     WHERE (u.cod_usuario = ? AND u.PASSWORD = ?) and u.estado in ('A', 'I')");
                ps2.setString(1, usuario.getCodUsuario());
                ps2.setString(2, encodedString);
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                if(rs.next())
                {
                    
                    u.setRun(rs.getInt(1));
                    u.setCodUsuario(rs.getString(2));
                    u.setMail(rs.getString(3)); 
                    u.setEstado(rs.getString(4).charAt(0));
                    u.setPri_nom(rs.getString(6));
                    u.setSeg_nom(rs.getString(7));
                    u.setPri_ap(rs.getString(8));
                    u.setSeg_ap(rs.getString(9));
                    u.setDescripcion(rs.getString(5));
                };
                
            }
            return u;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return u;
        }
                
    };
     
     
    public Usuario usuarioValidarconRun(Usuario usuario)
    {   
        Usuario u = new Usuario();
        try
        {
            Conexion conexion = new Conexion();
            
            try (Connection con = conexion.getConnection()) 
            {
                Base64.Encoder encoder = Base64.getEncoder();
                String encodedString = encoder.encodeToString(usuario.getPassword().getBytes());
                System.out.println(encodedString);
                PreparedStatement ps2 = con.prepareStatement("SELECT u.run,u.cod_usuario,u.mail,u.estado, r.descripcion, p.pri_nom, p.seg_nom, p.pri_ap, p.seg_ap FROM USUARIO u left join PERSONA P ON u.run = p.run  "
                        + "                                     left join ROL r on p.id_rol = r.id_rol "
                        + "                                     WHERE (u.run = ? AND u.PASSWORD = ?) and u.estado in ('A', 'I')");
                ps2.setInt(1, usuario.getRun());
                ps2.setString(2, encodedString);
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                if(rs.next())
                {
                    
                    u.setRun(rs.getInt(1));
                    u.setCodUsuario(rs.getString(2));
                    u.setMail(rs.getString(3)); 
                    u.setEstado(rs.getString(4).charAt(0));
                    u.setPri_nom(rs.getString(6));
                    u.setSeg_nom(rs.getString(7));
                    u.setPri_ap(rs.getString(8));
                    u.setSeg_ap(rs.getString(9));
                    u.setDescripcion(rs.getString(5));
                };
                
            }
            return u;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return u;
        }
                
    };
     
     
    public int usuarioAlmacenar(Usuario usuario)
    {
        try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                Base64.Encoder encoder = Base64.getEncoder();
                String encodedString = encoder.encodeToString(usuario.getPassword().getBytes());
                PreparedStatement ps2 = con.prepareStatement("INSERT INTO USUARIO (RUN, COD_USUARIO, MAIL , PASSWORD, ESTADO)VALUES(?,?,?,?,'I')");
                ps2.setInt(1, usuario.getRut());
                ps2.setString(2, usuario.getCodUsuario());
                ps2.setString(3, usuario.getMail());
                ps2.setString(4, encodedString);
                ps2.executeUpdate();
            }
            return 0;
            
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
           
        }
    };
    
    public int contarUsuarios(){
        try
        {
            Conexion conexion = new Conexion();
            int contador = 0;
            try (Connection con = conexion.getConnection()) 
            {
                
                PreparedStatement ps2 = con.prepareStatement("SELECT count(*) as contador from usuario");
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                if(rs.next())
                {
                    contador = rs.getInt("contador");
        
                };
                
            }
            return contador;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }
    };
    
     public int actualizarClave(Usuario usuario)
    {
        try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                Base64.Encoder encoder = Base64.getEncoder();
                String encodedString = encoder.encodeToString(usuario.getPassword().getBytes());
                PreparedStatement ps2 = con.prepareStatement("UPDATE USUARIO SET PASSWORD=? WHERE RUN=? and COD_USUARIO=?");
                ps2.setString(1, encodedString);
                ps2.setInt(2, usuario.getRun());
                ps2.setString(3, usuario.getCodUsuario());
                ps2.executeUpdate();
            }
            return 0;
            
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
           
        }
    };
    
    public void recuperarImagen(String codigoUsuario, ImageAvatar label, int pixeles){
        try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) 
            {
                
                PreparedStatement ps2 = con.prepareStatement("SELECT foto from usuario where cod_usuario = ?");
                ps2.setString(1, codigoUsuario);
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                Image img = null;
                ImageIcon img2= null;
                if(rs.next())
                {
                    Blob foto = rs.getBlob("foto");
                    if(foto != null){
                        byte[] recuperado = foto.getBytes(1, (int) foto.length());
                        BufferedImage imagen = ImageIO.read(new ByteArrayInputStream(recuperado));
                        img = imagen.getScaledInstance(pixeles, pixeles, Image.SCALE_SMOOTH);
          
                        img2 = new ImageIcon(img);
                    }else{                       
                        img2 = new ImageIcon(getClass().getResource("/iconos/icons8_user_71px.png"));
                        
                    }
                    label.setImage(img2);
                    System.out.println("Acceso a metodo cargarImagen");
                };
                
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    };
    
    

    
    public void ponerImagenenLabel(String ruta, ImageAvatar label){
         try {
            BufferedImage bufferedImage = ImageIO.read(new File(ruta));
            Image image = bufferedImage.getScaledInstance(179, 179, Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(image);
            label.setImage(icon);
         } catch (IOException ex) {
             Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("No se ha encontrado el archivo en ruta "+ ruta);
         }
        
        
    }
}
