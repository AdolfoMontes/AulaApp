
package controlador;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Sala;
import oracle.jdbc.OracleTypes;


public class ControladorSala {

    public int agregarSala(Sala sala ){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_AGREGARSALA(?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setString(1, sala.getCodSala());
            callableStatement.setString(2, sala.getPiso());
            callableStatement.registerOutParameter(3, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(3);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
    }
    
    
     public int desactivarSala(Sala sala ){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_DESACTIVARSALA(?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, sala.getIdSala());
            callableStatement.registerOutParameter(2, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(2);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
    }
     
   public void salaListar(JTable tbl)
   {
       try
       {
           Conexion conexion = new Conexion();
           PreparedStatement ps = null;
           try (Connection con = conexion.getConnection()) {
               ps = con.prepareStatement("SELECT ID_SALA, COD_SALA, PISO, ESTADO FROM SALA WHERE ESTADO = 'A' order by id_sala"); //Devuelve rol alumno
               ResultSet rs=ps.executeQuery();

               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[4]; // columnas en la tabla

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                modelo.addRow(fila);
           }
       }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }
   
   
    public ArrayList <Sala> salaListar()
   {
       try
       {
           ArrayList<Sala> listaSala = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_SALA, COD_SALA, PISO, ESTADO FROM SALA WHERE ESTADO = 'A' order by id_sala");
          
               ResultSet rs=ps.executeQuery();
               while (rs.next())
               {
                   Sala p = new Sala(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4).charAt(0) );
                   listaSala.add(p);
               }
               return listaSala;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
    
    public int actualizarSala(Sala sala)
   {
       try
       {
           Conexion conexion = new Conexion();
           PreparedStatement ps = null;
           PreparedStatement ps2 = null;
           try (Connection con = conexion.getConnection()) {
               ps = con.prepareStatement("UPDATE SALA SET COD_SALA=?, PISO=? WHERE ID_SALA = ?"); 
               ps2 = con.prepareStatement("SELECT COD_SALA FROM SALA WHERE COD_SALA = ? AND ESTADO = 'A'"); 
               
               ps.setString(1, sala.getCodSala());
               ps2.setString(1, sala.getCodSala());
               ps.setString(2, sala.getPiso());
               ps.setInt(3, sala.getIdSala());
               ResultSet rs=ps.executeQuery();
               
               return 0;
            }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
    }
   
}