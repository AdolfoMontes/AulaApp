
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VerUpdate {
    public String nuevoUpdate()
    {
        
        try
        {
            Conexion conexion = new Conexion();
            String version = "";
            try (Connection con = conexion.getConnection()) 
            {
                PreparedStatement ps2 = con.prepareStatement("SELECT version from AAP_VERSION where archivo='AulaApp.exe' ");
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                rs.next();
                version = rs.getString("version");
            }
            return version;

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return "-1";
        }
    }
}
