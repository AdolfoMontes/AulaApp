
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ValidarConexion 
{
    public int validarConexion()
    {
        try
        {
        
         Conexion conexion = new Conexion();
         int validador;
            try (Connection con = conexion.getConnection()) {
                PreparedStatement ps = con.prepareStatement("SELECT 1 as validador from dual"); //Si devuelve 1, hay conexiÃ³n al servidor.
                ResultSet rs=ps.executeQuery();
                rs.next();
                validador = rs.getInt("validador");
            } //Si devuelve 1, hay conexiÃ³n al servidor.
         return validador;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }
}
