
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Nivel;


public class ControladorNivel {
    public ArrayList <Nivel> nivelListar()
       {
           try
           {
               ArrayList<Nivel> listaNivel = new ArrayList<>();
               Conexion conexion = new Conexion();
               try (Connection con = conexion.getConnection()) {
                   PreparedStatement ps = con.prepareStatement("SELECT ID_NIVEL, DESCRIPCION FROM NIVEL_EDUCACION order by id_nivel");

                   ResultSet rs=ps.executeQuery();


                   while (rs.next())
                   {
                       Nivel e = new Nivel(rs.getInt(1), rs.getString(2));
                       listaNivel.add(e);
                   }

                   return listaNivel;
               }
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
               return new ArrayList <>();
           }
       }
}
