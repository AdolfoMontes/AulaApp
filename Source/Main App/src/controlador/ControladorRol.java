
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Rol;



public class ControladorRol {
     public ArrayList <Rol> rolListar(int tipo)
   {
       try
       {
           ArrayList<Rol> listaRol = new ArrayList<>();
           Conexion conexion = new Conexion();
           PreparedStatement ps = null;
           try (Connection con = conexion.getConnection()) {
               if (tipo==1)
                  ps = con.prepareStatement("SELECT ID_ROL, DESCRIPCION FROM ROL"); //Devuelve rol alumno
               else if(tipo==2)
                  ps = con.prepareStatement("SELECT ID_ROL, DESCRIPCION FROM ROL WHERE ID_ROL <> 5"); //Quito rol alumno
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Rol r = new Rol(rs.getInt(1),rs.getString(2) );
   
                   listaRol.add(r);
               }
               
               return listaRol;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
    }
}
