
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Comuna;
import modelo.Region;



public class ControladorDireccion {
     public ArrayList <Region> regionListar()
   {
       try
       {
           ArrayList<Region> listaRegion = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_REGION, NOM_REGION FROM REGION");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Region p = new Region(rs.getInt(1),rs.getString(2) );
   
                   listaRegion.add(p);
               }
               
               return listaRegion;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
     
   public ArrayList <Comuna> comunaListar(int idRegion)
   {
       try
       {
           ArrayList<Comuna> listaComuna = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_COMUNA, NOM_COMUNA, ID_REGION FROM COMUNA WHERE ID_REGION = ?");
               ps.setInt(1, idRegion);
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Comuna p = new Comuna(rs.getInt(1),rs.getString(2) );
   
                   listaComuna.add(p);
               }
               
               return listaComuna;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
}
