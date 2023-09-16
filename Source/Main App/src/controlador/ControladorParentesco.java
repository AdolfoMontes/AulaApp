
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Parentesco;


public class ControladorParentesco {

   public ArrayList <Parentesco> parentescoListar()
   {
       try
       {
           ArrayList<Parentesco> listaEstado = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_PARENTESCO, NOM_PARENTESCO FROM PARENTESCO");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Parentesco e = new Parentesco(rs.getInt(1), rs.getString(2));
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
