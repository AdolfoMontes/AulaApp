

package controlador;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Evento;
import oracle.jdbc.OracleTypes;


public class ControladorEvento {
    public ArrayList <Evento> eventoListar()
           {
               try
               {
                   ArrayList<Evento> listaEvento = new ArrayList<>();
                   Conexion conexion = new Conexion();
                   try (Connection con = conexion.getConnection()) {
                       PreparedStatement ps = con.prepareStatement("select * from (select a.id_evento, a.titulo, a.detalle, a.tipo, TO_CHAR(a.fecha_ins, 'dd/mm/yyyy hh:mi:ss AM'), " +
                                                                    "a.estado, a.usr_creacion, nvl(c.pri_nom,' '), nvl(c.seg_nom,' '), nvl(c.pri_ap,' '), nvl(c.seg_ap,' ') " +
                                                                    "from evento a join usuario b on a.usr_creacion= b.cod_usuario " +
                                                                    "join persona c on b.run = c.run where a.estado = 'A' " +
                                                                    "order by a.fecha_ins desc) WHERE ROWNUM <= 10");
                       ResultSet rs=ps.executeQuery();
                       while (rs.next())
                       {
                           Evento e = new Evento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                           rs.getString(6).charAt(0), rs.getString(7));
                           e.setPri_nom(rs.getString(8));
                           e.setSeg_nom(rs.getString(9));
                           e.setPri_ap(rs.getString(10));
                           e.setSeg_ap(rs.getString(11));
                           listaEvento.add(e);
                       }
                       return listaEvento;
                   }
               }
               catch(Exception ex)
               {
                   ex.printStackTrace();
                   return new ArrayList <>();
               }
           }
    
    
     public int agregarEvento(Evento evento ){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_AGREGARANUNCIO(?, ?, ?, ?, ?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setString(1, evento.getTitulo());
            callableStatement.setString(2, evento.getDetalle()); 
            callableStatement.setInt(3, evento.getTipo());
            callableStatement.setString(4, evento.getUsr_creacion()); 
            callableStatement.registerOutParameter(5, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(5);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
    }
}