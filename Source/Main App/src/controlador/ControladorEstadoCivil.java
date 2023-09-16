
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.EstadoCivil;


public class ControladorEstadoCivil {
    
   public ArrayList <EstadoCivil> estadoListar()
   {
       try
       {
           ArrayList<EstadoCivil> listaEstado = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_ESTADOCIVIL, NOM_ESTADO FROM ESTADO_CIVIL");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   EstadoCivil e = new EstadoCivil(rs.getInt(1), rs.getString(2));
                   listaEstado.add(e);
               }
               
               return listaEstado;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
    
}
