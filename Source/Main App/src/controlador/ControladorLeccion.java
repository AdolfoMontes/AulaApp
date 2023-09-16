

package controlador;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import oracle.jdbc.OracleTypes;


public class ControladorLeccion {
    public int almacenarLeccion(String descripcion, String date, String usuario, int idAsignatura ){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARLECCION(?,?,?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setString(1, descripcion);
            callableStatement.setString(2, date);
            callableStatement.setString(3, usuario);
            callableStatement.setInt(4, idAsignatura);
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
    
        
   public void listarLecciones(JTable tbl, int idasignatura)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select TO_CHAR(a.fecha,'dd/MM/YYYY') as fecha, a.id_leccion, b.cod_asignatura, b.nom_asignatura, " +
                                                    "case when a.firma is null then 'Sin firmar' else 'Firmada' end firmada, " +
                                                    "case when a.firma is null then ' ' " +
                                                    "else a.firma end usuario_firma, " +
                                                     "  to_char(a.fecha_creacion,'dd/MM/YYYY HH:MI:SS') AS fecha_firma," +                                                    
                                                    "nvl(TO_CHAR(a.fecha_mod,'dd/MM/YYYY HH:MI:SS' ), ' ') as fecha_mod, nvl(a.usuario_mod, ' ') as usuario_mod, " +
                                                    " a.descripcion,  c.compuesto " +
                                                     "from leccionario a join asignatura b on a.id_asignatura = b.id_asignatura "
                       + " join v_cursos c on b.id_curso = c.id_curso where a.id_asignatura = ? order by a.fecha desc");
               ps.setInt(1, idasignatura);
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[11]; // columnas en la tabla

                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 11; i++) {
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
   
   
   public void listarTodasLecciones(JTable tbl)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select TO_CHAR(a.fecha,'dd/MM/YYYY') as fecha, a.id_leccion, b.cod_asignatura, b.nom_asignatura, " +
                                                    "case when a.firma is null then 'Sin firmar' else 'Firmada' end firmada, " +
                                                    "case when a.firma is null then ' ' " +
                                                    "else a.firma end usuario_firma, " +
                                                     "  to_char(a.fecha_creacion,'dd/MM/YYYY HH:MI:SS') AS fecha_firma," +                                                    
                                                    "nvl(TO_CHAR(a.fecha_mod,'dd/MM/YYYY HH:MI:SS' ), ' ') as fecha_mod, nvl(a.usuario_mod, ' ') as usuario_mod, " +
                                                    " a.descripcion,  c.compuesto  " +
                                                     "from leccionario a join asignatura b on a.id_asignatura = b.id_asignatura "
                                                    + "join v_cursos c on b.id_curso = c.id_curso order by a.fecha desc");
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[11]; // columnas en la tabla

                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 11; i++) {
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
   public int firmarLeccion(String codUsuario, int idLeccion){
         try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                PreparedStatement ps = con.prepareStatement("UPDATE LECCIONARIO SET FIRMA = ?, FECHA_FIRMA = CURRENT_TIMESTAMP WHERE ID_LECCION = ?");
                ps.setString(1,codUsuario);
                ps.setInt(2, idLeccion);
                ps.executeUpdate();
            }
            return 0;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }
}