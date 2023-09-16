

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


public class ControladorAsistencia {
    public void listarAsistencia(JTable tbl, int idCurso, String fecha)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement(" SELECT " +
                                                            "    NVL((SELECT A.FECHA_CREACION FROM ASISTENCIA A WHERE  A.RUN = P.RUN AND a.fecha_asistencia = ? AND P.ESTADO ='A'),'' ) AS FECHA_CREACION, " +
                                                            "    NVL((SELECT TO_CHAR(A.FECHA_ASISTENCIA, 'DD-MM-YYYY') FROM ASISTENCIA A WHERE  A.RUN = P.RUN AND a.fecha_asistencia = ? AND P.ESTADO ='A'),'') AS FECHA_ASISTENCIA, " +
                                                            "    NVL((SELECT CASE WHEN A.ESTADO in ('P', '1') THEN 1 " +
                                                            "            WHEN A.ESTADO in ('X', '0') THEN 0 END FROM ASISTENCIA A WHERE A.RUN = P.RUN AND a.fecha_asistencia = ? AND P.ESTADO ='A'), 0 ) AS PRESENTE, " +
                                                            "    NVL((SELECT A.USR_CREACION FROM ASISTENCIA A WHERE  A.RUN = P.RUN AND a.fecha_asistencia = ? AND P.ESTADO ='A'),'' ) AS USR_CREACION," +
                                                            "    P.RUN," +
                                                            "    P.ID_CURSO," +
                                                            "    P.PRI_NOM," +
                                                            "    NVL(P.SEG_NOM, ' ')," +
                                                            "    P.PRI_AP, " +
                                                            "    NVL(P.SEG_AP, ' ') " +
                                                            "FROM PERSONA P " +
                                                            "JOIN CURSO C ON P.ID_CURSO = C.ID_CURSO WHERE P.ID_CURSO = ? AND P.ESTADO ='A'");
                   
               ps.setString(1, fecha);
               ps.setString(2, fecha);
               ps.setString(3, fecha);
               ps.setString(4, fecha);
               ps.setInt(5, idCurso);
               
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               String auxiliar = "";
               Object[] fila = new Object[7]; // columnas en la tabla
               while (rs.next()) {
                if(rs.getObject(2) == null){
                    auxiliar = fecha;
                }else
                    auxiliar =rs.getString(2);
                

                // Se rellena cada posiciÃ³n del array con las columnas de la db
                fila[0] = rs.getObject(1);
                fila[1] = auxiliar;
                fila[2] = rs.getObject(4);
                fila[3] = rs.getObject(5);
                fila[4] = rs.getObject(6);
                fila[5] = rs.getString(9) + " " + rs.getString(10) + ", " +rs.getString(7) + " " + rs.getString(8) ;
                fila[6] = rs.getBoolean(3);
                //fila[7] = rs.getBoolean(7);
                
                modelo.addRow(fila);
                }
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
   }
    
   
    
    public String guardarAsistencia(String fechaAsistencia, String estado, String userCreacion, int run,
                                int idCurso, int diasBloqueo){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARASISTENCIA(?,?,?,?,?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setString(1, fechaAsistencia);
            callableStatement.setString(2, estado);
            callableStatement.setString(3, userCreacion);
            callableStatement.setInt(4, run);
            callableStatement.setInt(5, idCurso);
            callableStatement.setInt(6, diasBloqueo);
            callableStatement.registerOutParameter(7, OracleTypes.VARCHAR);
            callableStatement.execute();
            
            String Respuesta = callableStatement.getString(7);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return "-1";
       }

    }
    
    public int validarSiTieneAsistencia(int run, int idCurso)
   {
       int respuesta = 0;
       try
       {
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement(" select count(id_asistencia) as contador from asistencia where run=? and id_curso=?");
                   
               ps.setInt(1, run);
               ps.setInt(2, idCurso);

               ResultSet rs=ps.executeQuery();


               while (rs.next()) {
                   respuesta = rs.getInt(1);
                }
           }
           return respuesta;
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
       
   }
   public int diasBloqueo(int idParam)
   {
       int respuesta = 7;
       try
       {
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement(" select valor from params where id_param = ?");
               
               ps.setInt(1, idParam);


               ResultSet rs=ps.executeQuery();


               while (rs.next()) {
                   respuesta = rs.getInt(1);

                }
           }
           return respuesta;
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
       
   }
      public int cambiarDiasBloqueo(int idParam, int valor)
   {
       try
       {
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement(" update params set valor= ? where id_param = ?");
               
               ps.setInt(1, valor);
               ps.setInt(2, idParam);
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
    
