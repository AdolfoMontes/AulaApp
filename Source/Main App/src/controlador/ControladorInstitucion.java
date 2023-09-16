
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Institucion;


public class ControladorInstitucion {
    public int institucionAlmacenar(Institucion institucion)
    {
        try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                PreparedStatement ps2 = con.prepareStatement("INSERT INTO INSTITUCION (COD_INSTITUCION, NOM_INSTITUCION, RUT , TIPO_ESTAB)VALUES(?,?,?,?)");
                ps2.setInt(1, institucion.getCodigo());
                ps2.setString(2, institucion.getNombre());
                ps2.setInt(3, institucion.getRut());
                ps2.setString(4, institucion.getTipo());
                ps2.executeUpdate();
            }
            return 0;
            
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
           
        }
    };
    public void truncarInstritucion(){
         try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                PreparedStatement ps2 = con.prepareStatement("DELETE FROM INSTITUCION");
                ps2.executeUpdate();
            }
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
  
        }
    }
    public Institucion mostrarInstitucion(){
        Institucion i = new Institucion();
        try
        {
            Conexion conexion = new Conexion();
            
            try (Connection con = conexion.getConnection()) 
            {
                
                PreparedStatement ps2 = con.prepareStatement("select cod_institucion, nom_institucion, rut, tipo_estab from institucion where rownum = 1");
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                if(rs.next())
                {
                    i.setCodigo(rs.getInt("cod_institucion"));
                    i.setNombre(rs.getString("nom_institucion"));
                    i.setRut(rs.getInt("rut"));
                    i.setTipo(rs.getString("tipo_estab"));
                };
                
            }
            return i;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return i;
        }
    };
    
    
    public int institucionActualizar(Institucion institucion)
    {
        try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                PreparedStatement ps2 = con.prepareStatement("UPDATE INSTITUCION SET COD_INSTITUCION =?, NOM_INSTITUCION=?, RUT=?, TIPO_ESTAB=?");
                ps2.setInt(1, institucion.getCodigo());
                ps2.setString(2, institucion.getNombre());
                ps2.setInt(3, institucion.getRut());
                ps2.setString(4, institucion.getTipo());
                ps2.executeUpdate();
            }
            return 0;
            
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
           
        }
    };
        
}
