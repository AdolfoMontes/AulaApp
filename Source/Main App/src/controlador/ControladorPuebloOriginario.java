
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.PuebloOriginario;


public class ControladorPuebloOriginario {
   public ArrayList <PuebloOriginario> puebloListar()
   {
       try
       {
           ArrayList<PuebloOriginario> listaPueblo = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_PUEBLO, NOM_PUEBLO FROM PUEBLO_ORIGINARIO");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   PuebloOriginario p = new PuebloOriginario(rs.getInt(1),rs.getString(2) );
   
                   listaPueblo.add(p);
               }
               
               return listaPueblo;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
}
