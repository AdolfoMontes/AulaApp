
package controlador;

import db.Conexion;
import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Observacion;
import oracle.jdbc.OracleTypes;
import vista.TextAreaRenderer;


public class ControladorObservacion {
    public int guardarObservacion(String tipo, String descripcion, String usuario, int run, int idCurso ){
            Conexion conexion = new Conexion();
            try (Connection con = conexion.getConnection()) {
                String sql="BEGIN SP_GUARDAROBSERVACION(?,?,?,?,?,?); END;";


                CallableStatement callableStatement=con.prepareCall(sql);
                callableStatement.setString(1, tipo);
                callableStatement.setString(2, descripcion);
                callableStatement.setString(3, usuario);
                callableStatement.setInt(4, run);
                callableStatement.setInt(5, idCurso);
                callableStatement.registerOutParameter(6, OracleTypes.INTEGER);
                callableStatement.execute();

                int Respuesta = callableStatement.getInt(6);
                System.out.println(Respuesta);

                return Respuesta; 
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
               return -1;
           }

        }
    
    
    public ArrayList <Observacion> observacionListar(int run, int idCurso, JTable tbl1, JTable tbl2)
   {
       try
       {
           System.out.println("ID CURSO-->" + idCurso);
           ArrayList<Observacion> listaObservacion = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("SELECT ID_OBS ,TIPO, DESC_OBS, FECHA_INS, USR_CREACION, RUN, ID_CURSO FROM OBSERVACION WHERE ID_CURSO = ? AND RUN = ?");
               ps.setInt(1, idCurso);
               ps.setInt(2, run);
               ResultSet rs=ps.executeQuery();
               DefaultTableModel model1 = (DefaultTableModel) tbl1.getModel();
               DefaultTableModel model2 = (DefaultTableModel) tbl2.getModel();
               model1.setRowCount(0);
               model2.setRowCount(0);
               tbl1.getColumnModel().getColumn(0).setCellRenderer(new TextAreaRenderer());
               tbl2.getColumnModel().getColumn(0).setCellRenderer(new TextAreaRenderer());

               while (rs.next())
               {
                   Observacion e = new Observacion();
                   e.setIdObservacion(rs.getInt(1));
                   e.setTipo(rs.getString(2));
                   e.setDescripcion(rs.getString(3));
                   e.setFechaIns(rs.getString(4));
                   e.setUsrCreacion(rs.getString(5));
                   e.setRun(rs.getInt(6));
                   e.setIdCurso(rs.getInt(7));
                   listaObservacion.add(e);
                   System.out.println("Observacion: "+e.getTipo() + " | RUN: "+e.getRun()+" | Desc:"+ e.getDescripcion());
                   if(e.getTipo().equals("+")){
                        Object[] objeto
                        = {
                           "<html> <br>Fecha: "+e.getFechaIns()+ "<br>Usuario creación: " + e.getUsrCreacion() + "<br> <div style=\"width: 50%\"> <b>Detalle: " + e.getDescripcion() + "</b> </div></html>"
                        };
                        model1.addRow(objeto);

                    }else if(e.getTipo().equals("-")){
                        Object[] objeto
                        = {
                            "<html> <br>Fecha: "+e.getFechaIns()+ "<br>Usuario creación: " + e.getUsrCreacion() + "<br> <div style=\"width: 50%\"> <b>Detalle: " + e.getDescripcion() + "</b> </div></html>"
                        };
                    model2.addRow(objeto);

                    }
           }
               
               return listaObservacion;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
}