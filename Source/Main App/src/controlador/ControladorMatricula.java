
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


public class ControladorMatricula {
    public int almacenarMatriculaenUsuario(int runAlumno, int anio, String usr_creacion, int nivel){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARMATRICULA(?,?,?,?,?); END;";
            //4 parametros 1 de salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, runAlumno);
            callableStatement.setInt(2, anio);
            callableStatement.setString(3, usr_creacion);
            callableStatement.setInt(4, nivel);
 
            callableStatement.registerOutParameter(5, OracleTypes.INTEGER);
            callableStatement.executeUpdate();
           
            int Respuesta = callableStatement.getInt(5);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return 1;
       }
        
        
    }
    
    public void fInsertarMatricula(int run, int numeroMatricula)
    {
        try
        {
            Conexion conexion = new Conexion();
            
            try (Connection con = conexion.getConnection()) {
                con.setAutoCommit(false);
                PreparedStatement ps = con.prepareStatement("UPDATE PERSONA SET NUM_MATRICULA = ? WHERE RUN = ?");

                ps.setInt(1,numeroMatricula);
                ps.setInt(2,run);
                con.setAutoCommit(true);
                ps.executeUpdate();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void listarAlumnosActivos(JTable tbl)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT NUMEROMATRICULA ,RUNALUMNO, NOMBREALUMNO, ESTADO, CURSOACTUAL, DIRECCION, SEXO, DISCAPACIDAD, NIVELALUMNO, FECHANACIMIENTO,PUEBLOORIGINARIO, EDAD"
                       + " , RUNAPODERADO, NOMBREAPODERADO, OCUPACIONAPODERADO, PARENTESCOAPODERADO, DIRECCIONAPODERADO, NIVELAPODERADO, FECHAMATRICULA, USUARIOCREACION, TELEFONO, MAIL FROM V_ALUMNOS order by NUMEROMATRICULA");
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[22]; // columnas en la tabla

                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 22; i++) {
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

   public void listarAlumnosActivosPorFecha(JTable tbl, String fechaini, String fechatermino,  String nivel)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT NUMEROMATRICULA ,RUNALUMNO, NOMBREALUMNO, ESTADO, CURSOACTUAL, DIRECCION, SEXO, DISCAPACIDAD, NIVELALUMNO, FECHANACIMIENTO,PUEBLOORIGINARIO, EDAD"
                       + " , RUNAPODERADO, NOMBREAPODERADO, OCUPACIONAPODERADO, PARENTESCOAPODERADO, DIRECCIONAPODERADO, NIVELAPODERADO, FECHAMATRICULA, USUARIOCREACION, TELEFONO FROM V_ALUMNOS WHERE "
                       + "FECHAMATRICULA BETWEEN ? and ?  and nivelalumno=?  order by NUMEROMATRICULA ");
               ps.setString(1,fechaini);
               ps.setString(2,fechatermino);
               ps.setString(3, nivel );
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[21]; // columnas en la tabla

                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 21; i++) {
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

}
