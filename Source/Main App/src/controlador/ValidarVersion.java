
package controlador;


import static controlador.I_Aplicacion.VERSION;
import db.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ValidarVersion implements I_Aplicacion{
    
    public ValidarVersion() 
    {
        Properties connectionProps = new Properties();
       
        try {
            connectionProps.load(new FileInputStream(new File("configuracion.properties")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarVersion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarVersion.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectionProps.put("version", connectionProps.get("VERSION"));
    }
    public void registrarVersion() 
    {
        Properties connectionProps = new Properties();
        try {
            connectionProps.load(new FileInputStream(new File("configuracion.properties")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ValidarVersion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidarVersion.class.getName()).log(Level.SEVERE, null, ex);
        }
        connectionProps.put("VERSION", connectionProps.get("VERSION"));
        connectionProps.setProperty("VERSION", VERSION);
        try {
            connectionProps.store(new FileWriter("configuracion.properties"), "PARAMETROS DE CONEXION Y VERSION");
        } catch (IOException ex) {
            Logger.getLogger(ValidarVersion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String nuevoUpdate()
    {
        
        try
        {
            Conexion conexion = new Conexion();
            String version = "";
            String deprecado="";
            try (Connection con = conexion.getConnection()) 
            {
                PreparedStatement ps2 = con.prepareStatement("SELECT version, deprecado FROM AAP_VERSION where archivo='AulaApp.exe' order by fecha desc ");
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                rs.next();
                deprecado = rs.getString("deprecado");
                version = rs.getString("version");
                if (!deprecado.equals("0") && Integer.valueOf(VERSION.replaceAll("\\.", "")) <= Integer.valueOf(version.replaceAll("\\.", ""))){
                    version = "-2";
                }
            }
            return version;

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return "-1";
        }
    }
    
    public String mostrarChangelog()
    {
        
        try
        {
            Conexion conexion = new Conexion();
            String changelog = "";
            try (Connection con = conexion.getConnection()) 
            {
                PreparedStatement ps2 = con.prepareStatement("SELECT changelog from AAP_VERSION where archivo='AulaApp.exe' order by fecha desc");
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                rs.next();
                changelog = rs.getString("changelog");
            }
            return changelog;

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return "-1";
        }
    }
    
}
