
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Ocupacion;


public class ControladorOcupacion {
public ArrayList <Ocupacion> ocupacionListar()
   {
       try
       {
           ArrayList<Ocupacion> listaOcupacion = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_OCUPACION, DESCRIPCION FROM OCUPACION");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Ocupacion e = new Ocupacion(rs.getInt(1), rs.getString(2));
                   listaOcupacion.add(e);
               }
               
               return listaOcupacion;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
}
