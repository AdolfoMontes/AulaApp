
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Persona;
import modelo.Usuario;

import oracle.jdbc.OracleTypes;

public class ControladorPersona {
    
    public int almacenarPersona(int run, String dv, String pri_nom, String seg_nom, String pri_ap, String seg_ap,
                                String estado, String fec_nac, int id_rol, String id_sexo, int id_pueblo, int id_curso,
                                int id_discapacidad, int id_comuna, String descripcion, String cod_usuario, String mail, 
                                String password){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); END;";

            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, run);
            callableStatement.setString(2, dv);
            callableStatement.setString(3, pri_nom);
            callableStatement.setString(4, seg_nom);
            callableStatement.setString(5, pri_ap);
            callableStatement.setString(6, seg_ap);
            callableStatement.setString(7, estado);
            callableStatement.setString(8, fec_nac);
            callableStatement.setInt(9, id_rol);
            callableStatement.setString(10, id_sexo);
            callableStatement.setInt(11, id_pueblo);
            callableStatement.setInt(12, id_curso);
            callableStatement.setInt(13, id_discapacidad);
            callableStatement.setInt(14, id_comuna);
            callableStatement.setString(15, descripcion);
            callableStatement.setString(16, cod_usuario);
            callableStatement.setString(17, mail);
            callableStatement.setString(18, password);
            callableStatement.registerOutParameter(19, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(19);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return 1;
       }

    }
    
    
    public void listarPersonas(JTable tbl)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT RUN,NOMBRE_COMPLETO,FEC_NAC,SEXO,PUEBLO,DIRECCION,MAIL,COD_USUARIO,ROL,ESTADO FROM V_PERSONAS WHERE ESTADO = 'A' ");
               
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[10]; // columnas en la tabla

                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 10; i++) {
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
    public int desactivarPersona(int run){
         try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                PreparedStatement ps = con.prepareStatement("UPDATE USUARIO SET ESTADO='X' WHERE RUN = ?");
                PreparedStatement ps2 = con.prepareStatement("UPDATE PERSONA SET ESTADO='X' WHERE RUN = ?");
                ps.setInt(1,run);
                ps2.setInt(1,run);
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
    public int activarPersona(int run){
         try
        {
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                PreparedStatement ps = con.prepareStatement("UPDATE USUARIO SET ESTADO='A' WHERE RUN = ?");
                PreparedStatement ps2 = con.prepareStatement("UPDATE PERSONA SET ESTADO='A' WHERE RUN = ?");
                ps.setInt(1,run);
                ps2.setInt(1,run);
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
   public void listarPersonasDesactivadas(JTable tbl)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT RUN,NOMBRE_COMPLETO,FEC_NAC,SEXO,PUEBLO,DIRECCION,MAIL,COD_USUARIO,ROL,ESTADO FROM V_PERSONAS WHERE ESTADO = 'X' ");
               
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[10]; // columnas en la tabla

                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 10; i++) {
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
   
   public int almacenarAlumno(int run, String dv, String pri_nom, String seg_nom, String pri_ap, String seg_ap,
                                String estado, String fec_nac, String id_sexo, int id_pueblo, int id_curso
                                , int id_comuna, String descripcion ,String discapacidad, int anio, String usuario_creacion){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARALUMNO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); END;";
            //16 parametros 1 de salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, run);
            callableStatement.setString(2, dv);
            callableStatement.setString(3, pri_nom);
            callableStatement.setString(4, seg_nom);
            callableStatement.setString(5, pri_ap);
            callableStatement.setString(6, seg_ap);
            callableStatement.setString(7, estado);
            callableStatement.setString(8, fec_nac);
            callableStatement.setString(9, id_sexo);
            callableStatement.setInt(10, id_pueblo);
            callableStatement.setInt(11, id_curso);
            callableStatement.setInt(12, id_comuna);
            callableStatement.setString(13, descripcion);
            callableStatement.setString(14, discapacidad);
            callableStatement.setInt(15, anio);
            callableStatement.setString(16, usuario_creacion);

            callableStatement.registerOutParameter(17, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(17);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return 1;
       }
        
        
    }
   
    public int almacenarApoderado(int run, String dv, String pri_nom, String seg_nom, String pri_ap, String seg_ap,
                                int ocupacion, int estadocivil, int parentesco, String mail, String telefono
                                , String fec_nac, int nivel ,String direccion, int comuna){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARAPODERADO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?); END;";
            //15 parametros 1 de salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, run);
            callableStatement.setString(2, dv);
            callableStatement.setString(3, pri_nom);
            callableStatement.setString(4, seg_nom);
            callableStatement.setString(5, pri_ap);
            callableStatement.setString(6, seg_ap);
            callableStatement.setInt(7, ocupacion);
            callableStatement.setInt(8, estadocivil);
            callableStatement.setInt(9, parentesco);
            callableStatement.setString(10, mail);
            callableStatement.setString(11, telefono);
            callableStatement.setString(12, fec_nac);
            callableStatement.setInt(13, nivel);
            callableStatement.setString(14, direccion);
            callableStatement.setInt(15, comuna);

            callableStatement.registerOutParameter(16, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(16);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return 1;
       }
        
        
    }
    
    public int almacenarAlumnoApoderado(int runAlumno, int runApoderado){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_INSERTARRUTALUMNOAPODERADO(?,?,?); END;";
            //2 parametros 1 de salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, runAlumno);
            callableStatement.setInt(2, runApoderado);
 
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
    
    public ArrayList <Persona> listarDocentes()
   {
       try
       {
           ArrayList<Persona> listaDocentes = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT p.run, p.dv ,p.pri_nom, nvl(p.seg_nom,' ') as seg_nom, p.pri_ap, nvl(p.seg_ap, ' ') as seg_ap, p.estado, p.fec_nac, p.id_rol, p.id_sexo FROM PERSONA P "
                                                    + "JOIN ROL R ON P.ID_ROL = R.ID_ROL WHERE R.DESCRIPCION = 'Docente'");
               
               ResultSet rs=ps.executeQuery();
               
               
               while (rs.next())
               {
                   Persona s = new Persona(rs.getInt(1),rs.getString(2).charAt(0), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
                                            rs.getString(7).charAt(0), rs.getString(8), rs.getInt(9), rs.getString(10).charAt(0));
   
                   listaDocentes.add(s);
               }
               
               return listaDocentes;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
    
    
    public Usuario seleccionarUsuario(int run)
   {
       Usuario u = new Usuario();
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT " +
                                                        "    p.run," +
                                                        "    p.dv," +
                                                        "    p.pri_nom," +
                                                        "    p.seg_nom," +
                                                        "    p.pri_ap," +
                                                        "    p.seg_ap," +
                                                        "    p.fec_nac," +
                                                        "    s.id_sexo," +
                                                        "    pb.id_pueblo," +
                                                        "    d.id_direccion, " +
                                                        "    c.id_comuna, " +
                                                        "    reg.id_region," +
                                                        "    u.mail," +
                                                        "    u.cod_usuario," +
                                                        "    r.id_rol," +
                                                        "    p.estado," +
                                                        "    u.password" +
                                                        " FROM" +
                                                        "    persona p" +
                                                        "    left join rol r on p.id_rol=r.id_rol" +
                                                        "    join sexo s on s.id_sexo = p.id_sexo" +
                                                        "    left join pueblo_originario pb on p.id_pueblo = pb.id_pueblo" +
                                                        "    join direccion d on p.id_direccion = d.id_direccion" +
                                                        "    join comuna c on d.id_comuna = c.id_comuna" +
                                                        "    join region reg on c.id_region=reg.id_region" +
                                                        "    join usuario u on p.run = u.run" +
                                                        "    where p.id_curso is null and u.estado = 'A'and p.run=? ");
               ps.setInt(1, run);
               ResultSet rs=ps.executeQuery();
               while (rs.next()) {
                     u.setRun(rs.getInt(1));
                     u.setDv(rs.getString(2).charAt(0));
                     u.setPri_nom(rs.getString(3));
                     u.setSeg_nom(rs.getString(4));
                     u.setPri_ap(rs.getString(5));
                     u.setSeg_ap(rs.getString(6));
                     u.setFec_nac(rs.getString(7));
                     u.setId_sexo(rs.getString(8).charAt(0));
                     u.setId_pueblo(rs.getInt(9));
                     u.setId_direccion(rs.getInt(10));
                     u.setMail(rs.getString(13));
                     u.setCodUsuario(rs.getString(14));
                     u.setId_rol(rs.getInt(15));
                }
               return u;
           }
           
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return u;
       }
   }   
    
    
    public int modificarPersona(int run, String pri_nom, String seg_nom, String pri_ap, String seg_ap,
                                String fec_nac, int id_rol, String id_sexo, int id_pueblo
                                , int id_comuna, String descripcion, String mail){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_ACTUALIZARUSUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?); END;";
            //12 parametros 1 de salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, run);
            callableStatement.setString(2, pri_nom);
            callableStatement.setString(3, seg_nom);
            callableStatement.setString(4, pri_ap);
            callableStatement.setString(5, seg_ap);
            callableStatement.setString(6, fec_nac);
            callableStatement.setInt(7, id_rol);
            callableStatement.setString(8, id_sexo);
            callableStatement.setInt(9, id_pueblo);
            callableStatement.setInt(10, id_comuna);
            callableStatement.setString(11, descripcion);
            callableStatement.setString(12, mail);

            callableStatement.registerOutParameter(13, OracleTypes.INTEGER);
            callableStatement.execute();
            
            int Respuesta = callableStatement.getInt(13);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return 1;
       }
        
        
    }
    
    
   public ArrayList <Persona> listarAlumno(int anio, int idnivel)
   {
       try
       {
           ArrayList<Persona> listaAlumnos = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement(" select run, dv, pri_nom, seg_nom, pri_ap, seg_ap, estado, anio, descripcion, fec_matricula, id_nivel from v_alumnossincurso where anio = ? and id_nivel=?");
               ps.setInt(1, anio);
               ps.setInt(2, idnivel);
               System.out.println(anio);
               ResultSet rs=ps.executeQuery();
               System.out.println(idnivel);
               
               while (rs.next())
               {
                   Persona s = new Persona();
                   s.setRun(rs.getInt(1));
                   s.setDv(rs.getString(2).charAt(0));
                   s.setPri_nom(rs.getString(3));
                   s.setSeg_nom(rs.getString(4));
                   s.setPri_ap(rs.getString(5));
                   s.setSeg_ap(rs.getString(6));
                   s.setEstado(rs.getString(7).charAt(0));
                   s.setAnio_matricula(rs.getInt(8));
                   s.setDescripcion_curso(rs.getString(9));
                   s.setFecha_matricula(rs.getString(10));
                   s.setId_curso(rs.getInt(11));
                   System.out.println("db:"+rs.getInt(11));
                   listaAlumnos.add(s);
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
   
    public void listarAlumnosconCurso(JTable tbl)
   {
       try
       {
           
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select runalumno, nombrealumno, estado, cursoactual, anio, sexo, edad from v_alumnos where cursoactual <> ' ' order by cursoactual");
               
               ResultSet rs=ps.executeQuery();
               DefaultTableModel modelo = (DefaultTableModel) tbl.getModel();
               TableRowSorter<TableModel> ordenar = new TableRowSorter<>(modelo);
               tbl.setRowSorter(ordenar);
               modelo.setRowCount(0);
               while (rs.next()) {

                Object[] fila = new Object[7]; // columnas en la tabla

                // Se rellena cada posiciÃ³n del array con las columnas de la db
                for (int i = 0; i < 7; i++) {
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
    
    public int eliminarAlumnodeCurso(int runAlumno){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_ELIMINARALUMNODECURSO(?,?); END;";
            //2 parametros 1 de salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setInt(1, runAlumno);
 
            callableStatement.registerOutParameter(2, OracleTypes.INTEGER);
            callableStatement.execute();
           
            int Respuesta = callableStatement.getInt(2);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
        
        
    }
    
    
   public ArrayList <Persona> listarAlumnodeCurso(int idcurso)
   {
       try
       {
           ArrayList<Persona> listaAlumnos = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select run, pri_nom, seg_nom, pri_ap, seg_ap, estado, cursoactual, id_curso from v_alumnos where id_curso=? order by nombrealumno");
               ps.setInt(1, idcurso);
               ResultSet rs=ps.executeQuery();

               
               while (rs.next())
               {
                   Persona s = new Persona();
                   s.setRun(rs.getInt(1));
                   s.setPri_nom(rs.getString(2));
                   s.setSeg_nom(rs.getString(3));
                   s.setPri_ap(rs.getString(4));
                   s.setSeg_ap(rs.getString(5));
                   s.setDescripcion_curso(rs.getString(7));
                   s.setId_curso(rs.getInt(8));
                   listaAlumnos.add(s);
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
   public int contarPersonas(int tipo)
   {
       int resultado = 0;
       try
       {
           
           Conexion conexion = new Conexion();
           PreparedStatement ps = null;
           try (Connection con = conexion.getConnection()) {
               if(tipo ==1){  //busco por alumno
                   ps=con.prepareStatement("select count(runalumno) from v_alumnos where cursoactual <> ' ' ");
               }else if(tipo ==2){ //busco docentes activos
                   ps=con.prepareStatement("select count(run) from persona where id_rol = 3 and estado = 'A'");
               }else if(tipo == 3 ){ //busco alumnos sin curso
                   ps=con.prepareStatement("select count(runalumno) from v_alumnos where cursoactual = ' ' ");
               }
               
               
               ResultSet rs=ps.executeQuery();
               while (rs.next()) {

                    resultado = rs.getInt(1);
                }
           }
           return resultado;
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return resultado;
       }
   }
    
}