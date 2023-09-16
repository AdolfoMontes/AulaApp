package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Conexion 
{
    
    
    public Connection getConnection() 
    {
        Connection conn = null;
        Properties connectionProps = new Properties();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión. \n"+ex, "Error", 2);
        }
        try {
            connectionProps.load(new FileInputStream(new File("configuracion.properties")));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se ha encontrado el archivo configuracion.properties \n"+ ex,"Error",2 );
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + connectionProps.get("SERVER_NAME") + ":1521:XE", connectionProps.get("SCHEMA").toString(),connectionProps.get("PASSWORD").toString() );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido conectar con la base de datos. \n"+ex, "Error", 2);
        }
        System.out.println("Conexión Exitosa!");
        return conn;
    }
}
