

package controlador;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Nota;
import oracle.jdbc.OracleTypes;
import vista.Render;


public class ControladorNota {
    public void listarNotas(JTable tbl, JTable tbl2, int idAsignatura )
   {
       try
       {   Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select " +
                                                        "     rownum, " +
                                                        "     run," +
                                                        "     pri_ap ||' ' || seg_ap || ', '|| pri_nom || ' ' || seg_nom as nombrecompleto," +
                                                        "     id_asignatura," +
                                                        "     anio," +
                                                        "     id_nota," +
                                                        "     n1," +
                                                        "     n2," +
                                                        "     n3," +
                                                        "     n4," +
                                                        "     n5," +
                                                        "     n6," +
                                                        "     n7," +
                                                        "     n8," +
                                                        "     n9," +
                                                        "     n10," +
                                                        "     n11," +
                                                        "     n12," +
                                                        "     n13," +
                                                        "     n14," +
                                                        "     n15," +
                                                        "     n16," +
                                                        "     n17," +
                                                        "     n18," +
                                                        "     n19," +
                                                        "     n20," +
                                                        "     p1," +
                                                        "     p2," +
                                                        "     pf," +
                                                        "     estado " +
                                                        " from v_notas where id_asignatura = ? ");
               ps.setInt(1, idAsignatura);
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               DefaultTableModel modelo2 = (DefaultTableModel) tbl2.getModel();
               tbl.setDefaultRenderer(Object.class, new Render());
               tbl2.setDefaultRenderer(Object.class, new Render());
               JButton btn_modificar = new JButton();
               insertarIcono(btn_modificar, "/iconos/editar.png");
               modelo.setRowCount(0);
               modelo2.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[15]; // columnas en la tabla
                Object[] fila2 = new Object[17]; // columnas en la tabla
                
                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 17; i++) {
                    fila[0] = rs.getObject(1);
                    fila[1] = rs.getObject(2);
                    fila[2] = rs.getObject(3);
                    fila[3] = rs.getObject(7);
                    fila[4] = rs.getObject(8);
                    fila[5] = rs.getObject(9);
                    fila[6] = rs.getObject(10);
                    fila[7] = rs.getObject(11);
                    fila[8] = rs.getObject(12);
                    fila[9] = rs.getObject(13);
                    fila[10] = rs.getObject(14);
                    fila[11] = rs.getObject(15);
                    fila[12] = rs.getObject(16);
                    fila[13] = rs.getObject(27);
                    fila[14] = btn_modificar;
                    
                    fila2[0] = rs.getObject(1);
                    fila2[1] = rs.getObject(2);
                    fila2[2] = rs.getObject(3);
                    fila2[3] = rs.getObject(17);
                    fila2[4] = rs.getObject(18);
                    fila2[5] = rs.getObject(19);
                    fila2[6] = rs.getObject(20);
                    fila2[7] = rs.getObject(21);
                    fila2[8] = rs.getObject(22);
                    fila2[9] = rs.getObject(23);
                    fila2[10] = rs.getObject(24);
                    fila2[11] = rs.getObject(25);
                    fila2[12] = rs.getObject(26);
                    fila2[13] = rs.getObject(28);
                    fila2[14] = rs.getObject(29);
                    fila2[15] = rs.getObject(30);
                    fila2[16] = btn_modificar;
               

                }
                modelo.addRow(fila);
                modelo2.addRow(fila2);
                
            }
        }
    }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
    }
    
    public void insertarIcono(JButton btn, String ruta){
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
    }
    
    
    public int almacenarNota(int run, int idAsignatura, int anio, float n1, float n2, float n3, float n4, float n5,
                        float n6, float n7, float n8, float n9, float n10, int semestre){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARNOTASEMESTRE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, run);
            callableStatement.setInt(2, idAsignatura);
            callableStatement.setInt(3, anio);
            callableStatement.setFloat(4, n1);
            callableStatement.setFloat(5, n2);
            callableStatement.setFloat(6, n3);
            callableStatement.setFloat(7, n4);
            callableStatement.setFloat(8, n5);
            callableStatement.setFloat(9, n6);
            callableStatement.setFloat(10, n7);
            callableStatement.setFloat(11, n8);
            callableStatement.setFloat(12, n9);
            callableStatement.setFloat(13, n10);
            callableStatement.setInt(14, semestre);
            
            
            callableStatement.registerOutParameter(15, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(15);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }

    }
    
    public int calcularNotaSemestre(int run, int idAsignatura){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_CALCULARNOTA1SEMESTRE(?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, run);
            callableStatement.setInt(2, idAsignatura);

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
    
    public int calcularNotaSemestre2(int run, int idAsignatura){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_CALCULARNOTA2SEMESTRE(?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, run);
            callableStatement.setInt(2, idAsignatura);

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
    
    
   public ArrayList <Nota> listarAlumnosInsuficientes(int idAsignatura)
   {
       try
       {
           ArrayList<Nota> listaAlumnos = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select " +
                                                            "    p.run, p.pri_nom, nvl(p.seg_nom,' ') as seg_nom, p.pri_ap, nvl(p.seg_ap, ' ') as seg_ap, round((a.p1 + a.p2)/2, 1) as nota " +
                                                            "   from nota a  join persona p on a.run = p.run " +
                                                            "   where a.id_asignatura = ? and (p1 + p2)/2 < (select valor from params where id_param = 1)");
               ps.setInt(1, idAsignatura);
               ResultSet rs=ps.executeQuery();

               
               while (rs.next())
               {
                   Nota n = new Nota();
                   n.setRun(rs.getInt(1));
                   n.setPri_nom(rs.getString(2));
                   n.setSeg_nom(rs.getString(3));
                   n.setPri_ap(rs.getString(4));
                   n.setSeg_ap(rs.getString(5));
                   n.setPf(rs.getFloat(6));
                   listaAlumnos.add(n);
               }
               
               return listaAlumnos;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
   
   
   public int generarCierreAsignatura(int idAsignatura){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_CERRARASIGNATURA(?,?); END;";

            
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
   
   public void listarNotas(JTable tbl)
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
    
   public void listarNotasAsigPorAlumno(JTable tbl1,JTable tbl2, int run, int idCurso)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select run, pri_nom, pri_ap, seg_ap, id_asignatura, id_curso, nom_curso, nom_asignatura, " +
                                                            "n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20, " +
                                                            "p1, p2, pf, estado, docentejefe, docenteasignatura from v_notas2 where run=? and id_curso = ? order by nom_asignatura"); //34 params
               
               ps.setInt(1, run);
               ps.setInt(2, idCurso);
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl1.getModel();
               DefaultTableModel modelo2 = (DefaultTableModel) tbl2.getModel();
               modelo.setRowCount(0);
               modelo2.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[13]; // columnas en la tabla
                Object[] fila2 = new Object[15];
                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 15; i++) {
                    fila[0] = rs.getObject(8);
                    fila[1] = rs.getObject(34);
                    fila[2] = rs.getObject(9);
                    fila[3] = rs.getObject(10);
                    fila[4] = rs.getObject(11);
                    fila[5] = rs.getObject(12);
                    fila[6] = rs.getObject(13);
                    fila[7] = rs.getObject(14);
                    fila[8] = rs.getObject(15);
                    fila[9] = rs.getObject(16);
                    fila[10] = rs.getObject(17);
                    fila[11] = rs.getObject(18);
                    fila[12] = rs.getObject(29);
                    
                    fila2[0] = rs.getObject(8);
                    fila2[1] = rs.getObject(34);
                    fila2[2] = rs.getObject(19);
                    fila2[3] = rs.getObject(20);
                    fila2[4] = rs.getObject(21);
                    fila2[5] = rs.getObject(22);
                    fila2[6] = rs.getObject(23);
                    fila2[7] = rs.getObject(24);
                    fila2[8] = rs.getObject(25);
                    fila2[9] = rs.getObject(26);
                    fila2[10] = rs.getObject(27);
                    fila2[11] = rs.getObject(28);
                    fila2[12] = rs.getObject(30);
                    fila2[13] = rs.getObject(31);
                    fila2[14] = rs.getObject(32);
                }

                modelo.addRow(fila);
                modelo2.addRow(fila2);
                }
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
   }
    
   public ArrayList<String> consultarPromedios(JLabel p1Curso, JLabel p2Curso, JLabel pfCurso,JLabel p1Alumno, JLabel p2Alumno, JLabel pfAlumno, int idCurso, int run ){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_RECUPERARPROMEDIOS(?, ?, ?, ?, ?, ?, ?, ?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, idCurso);
            callableStatement.setInt(2, run);

            callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(4, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(5, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(6, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(7, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(8, OracleTypes.VARCHAR);
            
            callableStatement.execute();
            ArrayList<String> respuesta = new ArrayList<>();
            respuesta.add(callableStatement.getString(3));
            respuesta.add(callableStatement.getString(4));
            respuesta.add(callableStatement.getString(5));
            respuesta.add(callableStatement.getString(6));
            respuesta.add(callableStatement.getString(7));
            respuesta.add(callableStatement.getString(8));
            System.out.println(respuesta);
            p1Curso.setText(callableStatement.getString(3));
            p2Curso.setText(callableStatement.getString(4));
            pfCurso.setText(callableStatement.getString(5));
            p1Alumno.setText(callableStatement.getString(6));
            p2Alumno.setText(callableStatement.getString(7));
            pfAlumno.setText(callableStatement.getString(8));
            return respuesta; 
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList<>();
       }

    }
   
   
      public int guardarParametro(int param, float valor){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_SETPARAMETROS(?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, param);
            callableStatement.setFloat(2, valor);
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
      
     public float getParametro(int param){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_GETPARAMETRO(?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, param);
            callableStatement.registerOutParameter(2, OracleTypes.FLOAT);
            callableStatement.execute();
            
            float Respuesta = callableStatement.getFloat(2);
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