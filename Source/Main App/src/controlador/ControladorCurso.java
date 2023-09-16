
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
import modelo.Curso;
import oracle.jdbc.OracleTypes;


public class ControladorCurso {
    public int almacenarCurso(int nivel, String codigo, String nombreCurso, int cantidadMax, int anio, int run_docente){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARCURSO(?,?,?,?,?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, nivel);
            callableStatement.setString(2, codigo);
            callableStatement.setString(3, nombreCurso);
            callableStatement.setInt(4, cantidadMax);
            callableStatement.setInt(5, anio);
            callableStatement.setInt(6, run_docente);
            callableStatement.registerOutParameter(7, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(7);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return 1;
       }
        
        
    }
    
    
    
    public int desactivarCurso(int idcurso){
         try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                PreparedStatement ps = con.prepareStatement("UPDATE CURSO SET ESTADO='X' WHERE ID_CURSO = ?");
                PreparedStatement ps2 = con.prepareStatement("UPDATE PERSONA SET ID_CURSO=null WHERE ID_CURSO = ?");
                ps.setInt(1,idcurso);
                ps2.setInt(1,idcurso);
                ps.executeUpdate();
                ps2.executeUpdate();
            }
            return 0;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return 1;
        }
    }
    
    public ArrayList <Curso> cursoListar()
   {
       try
       {
           ArrayList<Curso> listaCurso = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               
               PreparedStatement ps = con.prepareStatement("select id_curso, cod_curso, nom_curso, descripcion, anio, cantidad_max, alumnosactuales, compuesto, id_nivel from v_cursos where alumnosactuales<cantidad_max and estado='A' order by compuesto");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Curso c = new Curso();
                   c.setId(rs.getInt(1));
                   c.setCod_curso(rs.getString(8));
                   c.setNom_curso(rs.getString(3));
                   c.setDescripcion(rs.getString(4));
                   c.setAnio(rs.getInt(5));
                   c.setCantidad_max(rs.getInt(6));
                   c.setAlumnosActuales(rs.getInt(7));
                   c.setNivel(rs.getInt(9));
                   
                   listaCurso.add(c);
               }
               return listaCurso;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
    public void listarCursos(JTable tbl)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_CURSO, COD_CURSO, NOM_CURSO, DESCRIPCION, ANIO, RUN, NOMBREDOCENTE, "
                       + "                                  CANTIDAD_MAX, ALUMNOSACTUALES, ESTADO, COMPUESTO FROM V_CURSOS order by COMPUESTO ");
               
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
    
    public ArrayList <Curso> cursoListarTodo()
   {
       try
       {
           ArrayList<Curso> listaCurso = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               
               PreparedStatement ps = con.prepareStatement("select id_curso, cod_curso, nom_curso, descripcion, anio, cantidad_max, alumnosactuales, compuesto, id_nivel, nombredocente from v_cursos where estado='A' order by compuesto");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Curso c = new Curso();
                   c.setId(rs.getInt(1));
                   c.setCod_curso(rs.getString(8));
                   c.setNom_curso(rs.getString(3));
                   c.setDescripcion(rs.getString(4));
                   c.setAnio(rs.getInt(5));
                   c.setCantidad_max(rs.getInt(6));
                   c.setAlumnosActuales(rs.getInt(7));
                   c.setNivel(rs.getInt(9));
                   c.setNombreDocente(rs.getString(10));
                   listaCurso.add(c);
               }
               
               return listaCurso;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
    
    public int agregarAlumnoaCurso(int run, int idCurso){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_AGREGARALUMNOACURSO(?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, run);
            callableStatement.setInt(2, idCurso);
            callableStatement.registerOutParameter(3, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(3);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return 1;
       }
     }
    
    
   public ArrayList <Curso> cursoListarporDocenteoNivel(int rundocente, int idNivel)
   {
       try
       {
           ArrayList<Curso> listaCurso = new ArrayList<>();
           Conexion conexion = new Conexion();
           PreparedStatement ps = null;
           try (Connection con = conexion.getConnection()) {
               if(idNivel ==0){
                    ps = con.prepareStatement("select b.id_curso, b.cod_curso, b.compuesto, b.id_nivel, b.anio, b.alumnosactuales, b.cantidad_max  from asignatura a " +
                                                "join v_cursos b on a.id_curso = b.id_curso " +
                                                "where a.doc_asignado = ? group by b.id_curso, b.cod_curso, " +
                                                "b.compuesto, b.id_nivel, b.anio, b.alumnosactuales,b.cantidad_max order by b.compuesto");
                    ps.setInt(1, rundocente);
               }else if (rundocente ==0){
                    ps = con.prepareStatement("select b.id_curso, b.cod_curso, b.compuesto, b.id_nivel, b.anio, b.alumnosactuales, b.cantidad_max  from asignatura a " +
                                                "join v_cursos b on a.id_curso = b.id_curso " +
                                                "where b.id_nivel = ? group by b.id_curso, b.cod_curso, " +
                                                "b.compuesto, b.id_nivel, b.anio, b.alumnosactuales,b.cantidad_max order by b.compuesto");
                    ps.setInt(1, idNivel);
               }

               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Curso c = new Curso();
                   c.setId(rs.getInt(1));
                   c.setCod_curso(rs.getString(3));
                   c.setAnio(rs.getInt(5));
                   c.setNivel(rs.getInt(4));
                   c.setAlumnosActuales(rs.getInt(6));
                   c.setCantidad_max(rs.getInt(7));
                   
                   listaCurso.add(c);
               }
               
               return listaCurso;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
   
   
   public ArrayList <String> anioListar()
   {
       try
       {
           ArrayList<String> listaAnio = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               
               PreparedStatement ps = con.prepareStatement("select distinct(anio) from curso where estado in ('A', 'F')");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   
                   String resultado = rs.getString(1);
                   listaAnio.add(resultado);
               }
               return listaAnio;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
   
   public ArrayList <Curso> listarCursosPorAnio(int anio)
   {
       try
       {
           ArrayList<Curso> listaCursos = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               
               PreparedStatement ps = con.prepareStatement("select b.id_curso, b.cod_curso, b.compuesto, b.id_nivel, b.anio, b.alumnosactuales, b.cantidad_max  from asignatura a " +
                                                        "join v_cursos b on a.id_curso = b.id_curso " +
                                                        "where b.anio = ? group by b.id_curso, b.cod_curso, " +
                                                        "b.compuesto, b.id_nivel, b.anio, b.alumnosactuales,b.cantidad_max order by b.compuesto");
               
               ps.setInt(1, anio);
               ResultSet rs=ps.executeQuery();
               
               while (rs.next())
               {
                   
                   Curso c = new Curso();
                   c.setId(rs.getInt(1));
                   c.setCod_curso(rs.getString(3));
                   c.setNivel(rs.getInt(4));
                   c.setAnio(rs.getInt(5));
                   c.setAlumnosActuales(rs.getInt(6));
                   c.setCantidad_max(rs.getInt(7));
                   listaCursos.add(c);
               }
               return listaCursos;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
   

}