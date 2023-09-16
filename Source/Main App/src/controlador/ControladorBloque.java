
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Bloque;



public class ControladorBloque {
   public ArrayList <Bloque> bloqueListar(int idDia)
   {
       try
       {
           ArrayList<Bloque> listaBloque = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select id_horario, hora_ini, hora_ter, dia_semana,estado from bloque where estado = 'A'");
               
               ResultSet rs=ps.executeQuery();

               while (rs.next())
               {
                   Bloque b = new Bloque();
                   b.setId_bloque(rs.getInt(1));
                   b.setHora_ini(rs.getString(2));
                   b.setHora_ter(rs.getString(3));
                   b.setDia_semana(rs.getInt(4));
                   b.setEstado(rs.getString(5).charAt(0));
                   if(idDia>0)
                       if(b.getDia_semana() == idDia)
                       {listaBloque.add(b);}
    
               }
               
               return listaBloque;
           }
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList <>();
       }
   }
   
   public ArrayList <Bloque> bloqueListarenTablas(int idAsignatura)
   {
       try
       {
           ArrayList<Bloque> listaBloque = new ArrayList<>();
           Conexion conexion = new Conexion();
           try (Connection con = conexion.getConnection()) {
               PreparedStatement ps = con.prepareStatement("select a.id_horario, a.hora_ini, a.hora_ter, a.dia_semana,a.estado,"
                       + "(select case when id_asignatura is not null then 1 else 0 end from bloque_asignatura b where b.id_bloquehorario = a.id_horario and b.id_asignatura = ?) as asignado  "
                       + "from bloque a  where a.estado = 'A' order by a.id_horario");
               ps.setInt(1, idAsignatura);
               ResultSet rs=ps.executeQuery();
               while (rs.next())
               {
                   Bloque b = new Bloque();
                   b.setId_bloque(rs.getInt(1));
                   b.setHora_ini(rs.getString(2));
                   b.setHora_ter(rs.getString(3));
                   b.setDia_semana(rs.getInt(4));
                   b.setEstado(rs.getString(5).charAt(0));
                   b.setAsignado(rs.getBoolean(6));
                   listaBloque.add(b);

               }
           }
           return listaBloque;
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           return new ArrayList<>();
       }
   }
   
    public void cargarTabla(JTable lunes, JTable martes, JTable miercoles, JTable jueves, JTable viernes, JTable sabado, JTable domingo, int idAsignatura) {

        ArrayList<Bloque> listarBloques = bloqueListarenTablas(idAsignatura);
        DefaultTableModel modelolunes = (DefaultTableModel) lunes.getModel();
        DefaultTableModel modelomartes = (DefaultTableModel) martes.getModel();
        DefaultTableModel modelomiercoles = (DefaultTableModel) miercoles.getModel();
        DefaultTableModel modelojueves = (DefaultTableModel) jueves.getModel();
        DefaultTableModel modeloviernes = (DefaultTableModel) viernes.getModel();
        DefaultTableModel modelosabado = (DefaultTableModel) sabado.getModel();
        DefaultTableModel modelodomingo = (DefaultTableModel) domingo.getModel();
        modelolunes.setRowCount(0);
        modelomartes.setRowCount(0);
        modelomiercoles.setRowCount(0);
        modelojueves.setRowCount(0);
        modeloviernes.setRowCount(0);
        modelosabado.setRowCount(0);
        modelodomingo.setRowCount(0);
        for (Bloque p : listarBloques) {

            Object[] objeto
                    = {
                        p.getId_bloque(),
                        p.toString(),
                        p.isAsignado()

                    };
            System.out.println(p.getDia_semana());
            switch (p.getDia_semana()) {
                case 1:

                        modelolunes.addRow(objeto);

                    break;
                        
                  
                case 2:
                    modelomartes.addRow(objeto);
                    break;
                case 3:
                    modelomiercoles.addRow(objeto);
                    break;
                case 4:
                    modelojueves.addRow(objeto);
                    break;
                case 5:
                    modeloviernes.addRow(objeto);
                    break;
                case 6:
                    modelosabado.addRow(objeto);
                    break;
                case 7:
                    modelodomingo.addRow(objeto);
                    break;
                default:
                    break;
            }
            

        }
    }

}

