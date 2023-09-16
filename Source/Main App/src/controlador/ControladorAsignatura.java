

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
import oracle.jdbc.OracleTypes;
import modelo.Asignatura;
import modelo.Curso;

public class ControladorAsignatura {
    public void listarCursos(JTable tbl)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select id_asignatura, nom_asignatura, cod_asignatura, anio, compuesto, nivel, doc_asignado, nombre_docente, estado, cod_sala, calculo from v_asignaturas order by id_asignatura");
               
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
    
    public int insertarAsignatura(String nombreAsignatura, String codigoAsignatura, int anio, int runDocente,
                                int idSala, int idCurso, int tipoCalculo, String usuario){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARASIGNATURA(?,?,?,?,?,?,?,?,?); END;";
            //10 parametros 1 salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setString(1, nombreAsignatura);
            callableStatement.setString(2, codigoAsignatura);
            callableStatement.setInt(3, anio);
            callableStatement.setInt(4, runDocente);
            callableStatement.setInt(5, idSala);
            callableStatement.setInt(6, idCurso);
            callableStatement.setInt(7, tipoCalculo);
            callableStatement.setString(8, usuario);
            callableStatement.registerOutParameter(9, OracleTypes.INTEGER);
            callableStatement.execute();
            int Respuesta = callableStatement.getInt(9);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return 1;
       }
        
        
    }
    public Asignatura listarAsignaturaExistente(String codigoAsignatura)
    {
       Asignatura a = new Asignatura();
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select id_asignatura, nom_asignatura, cod_asignatura, anio, compuesto, nivel, doc_asignado, nombre_docente, estado, cod_sala, calculo from v_asignaturas where cod_asignatura = ? and rownum = 1");
               ps.setString(1, codigoAsignatura);
               ResultSet rs=ps.executeQuery();
               while (rs.next())
               {
                   a.setId_asignatura(rs.getInt(1));
                   a.setNom_asignatura(rs.getString(2));
                   a.setCod_asignatura(rs.getString(3));
                   a.setAnio(rs.getInt(4));
                   a.setCalculo(rs.getInt(11));
               }
           }
           return a;
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return a;
       }
   }
    
    public Asignatura listarAsignaturaActiva()
    {
       Asignatura a = new Asignatura();
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select id_asignatura, nom_asignatura, cod_asignatura, anio, compuesto, nivel, doc_asignado, nombre_docente, estado, cod_sala, calculo from v_asignaturas where estado='A' order by id_asignatura");
               ResultSet rs=ps.executeQuery();
               while (rs.next())
               {
                   a.setId_asignatura(rs.getInt(1));
                   a.setNom_asignatura(rs.getString(2));
                   a.setCod_asignatura(rs.getString(3));
                   a.setAnio(rs.getInt(4));
                   a.setCalculo(rs.getInt(11));
               }
           }
           return a;
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return a;
       }
   }
    public int eliminarAsignatura(int idAsignatura){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_ELIMINARASIGNATURA(?,?); END;";
            //10 parametros 1 salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, idAsignatura);
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
    
    
    public int insertarBloqueAsignatura(int idAsignatura, int idBloquehorario){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_AGREGARBLOQUEASIGNATURA(?,?); END;";
            //2 parametros 
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, idAsignatura);
            callableStatement.setInt(2, idBloquehorario);
            callableStatement.execute();

            return 0; 
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
        
        
    }
    
    public int eliminarBloqueAsignatura(int idAsignatura){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_ELIMINARBLOQUEASIGNATURA(?); END;";
            //2 parametros 
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, idAsignatura);
            callableStatement.execute();

            return 0; 
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
        
        
    }

    public ArrayList<Asignatura> listarAsignaturaPorCurso(Curso curso)
    {
       try
       { 
           ArrayList<Asignatura> list = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select a.id_asignatura, a.nom_asignatura, a.cod_asignatura, c.run, c.pri_nom, nvl(c.seg_nom,' ') as seg_nom , c.pri_ap , nvl(c.seg_ap, ' ') as seg_ap, a.anio, a.estado from asignatura a join curso b on a.id_curso = b.id_curso left join persona c on a.doc_asignado = c.run where b.id_curso = ? and a.estado in  ('A', 'F')");
               ps.setInt(1, curso.getId());
               ResultSet rs=ps.executeQuery();
               while (rs.next())
               {
                   Asignatura a = new Asignatura();
                   a.setId_asignatura(rs.getInt(1));
                   a.setNom_asignatura(rs.getString(2));
                   a.setCod_asignatura(rs.getString(3));
                   a.setRun(rs.getInt(4));
                   a.setPri_nom(rs.getString(5));
                   a.setSeg_nom(rs.getString(6));
                   a.setPri_ap(rs.getString(7));
                   a.setSeg_ap(rs.getString(8));
                   a.setAnio(rs.getInt(9));
                   a.setEstado(rs.getString(10).charAt(0));
                   list.add(a);
                   System.out.println(a.getCod_asignatura());
               }
               return list;
           }
           
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
}