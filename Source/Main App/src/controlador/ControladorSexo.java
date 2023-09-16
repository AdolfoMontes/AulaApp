
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Sexo;


public class ControladorSexo {
   public ArrayList <Sexo> sexoListar()
   {
       try
       {
           ArrayList<Sexo> listaSexo = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_SEXO, DESCRIPCION FROM SEXO");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Sexo s = new Sexo(rs.getString(1).charAt(0),rs.getString(2) );
   
                   listaSexo.add(s);
               }
               
               return listaSexo;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
    
}
