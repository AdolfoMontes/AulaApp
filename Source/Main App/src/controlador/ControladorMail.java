

package controlador;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Persona;
import modelo.Usuario;
import oracle.jdbc.OracleTypes;



public class ControladorMail {

    public Usuario mailValidar(String mail)
    {   
        Usuario u = new Usuario();
        try
        {
            Conexion conexion = new Conexion();
            
            try (Connection con = conexion.getConnection()) 
            {

                PreparedStatement ps2 = con.prepareStatement("SELECT u.run,u.cod_usuario,u.mail,u.estado, r.descripcion, p.pri_nom, nvl(p.seg_nom, ' ') as seg_nom, p.pri_ap, NVL(p.seg_ap,' ' ) as seg_ap FROM USUARIO u left join PERSONA P ON u.run = p.run  "
                        + "                                     left join ROL r on p.id_rol = r.id_rol "
                        + "                                     WHERE mail = ? and u.estado in ('A', 'I')");
                ps2.setString(1, mail.toLowerCase());
                ps2.executeQuery();
                ResultSet rs=ps2.executeQuery();
                
                if(rs.next())
                {
                    u.setRun(rs.getInt("run"));
                    u.setCodUsuario(rs.getString("cod_usuario"));
                    u.setMail(rs.getString("mail")); 
                    u.setEstado(rs.getString("estado").charAt(0));
                    u.setPri_nom(rs.getString("pri_nom"));
                    u.setSeg_nom(rs.getString("seg_nom"));
                    u.setPri_ap(rs.getString("pri_ap"));
                    u.setSeg_ap(rs.getString("seg_ap"));
                    u.setDescripcion(rs.getString("descripcion"));
                   
                };
                
            }
            return u;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return u;
        }
                
    };
    
    
    public String crearCodigoOtp(Usuario usuario){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_CREARCODIGOOTP(?,?,?); END;";
            //2 parametros 1 de salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setString(1, usuario.getMail());
            callableStatement.setInt(2, usuario.getRun());
 
            callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
            callableStatement.executeUpdate();
           
            String Respuesta = callableStatement.getString(3);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return "-1";
       }
        
        
    }
    
    public int validarCodigoOtp(Usuario usuario, String codigoOtp){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            String sql="BEGIN SP_VALIDARCODIGOTP(?,?,?,?); END;";
            //3 parametros 1 de salida
            
            CallableStatement callableStatement=con.prepareCall(sql);
            callableStatement.setString(1, usuario.getMail());
            callableStatement.setInt(2, usuario.getRun());
            callableStatement.setString(3, codigoOtp);
 
            callableStatement.registerOutParameter(4, OracleTypes.INTEGER);
            callableStatement.executeUpdate();
           
            int Respuesta = callableStatement.getInt(4);
            System.out.println(Respuesta);

            return Respuesta; 
       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
           return -1;
       }
        
    }
    
        public void cobrarCodigoOtp(Usuario usuario){
        Conexion conexion = new Conexion();
        try (Connection con = conexion.getConnection()) {
            PreparedStatement ps2 = con.prepareStatement("UPDATE GESTION_OTP SET USADO=1, HORA_USO= SYSDATE, ESTADO='X' WHERE RUN= ? and estado = 'A'");
            //3 parametros 1 de salida
            ps2.setInt(1, usuario.getRun());
            ps2.executeUpdate();

       }
       
       catch(Exception ex)
       {
           ex.printStackTrace();
  
       }
        
    }
}