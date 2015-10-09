/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 * 
 * Para usar esta clase es necesario cargar la libreria mysql jdbc driver
 */
public final class MysqlInstance extends DBInstance {

    
    
    MysqlInstance(){
        HOST = "localhost";
        PORT = "3306";
        DATABASE = "mydb";
        USER = "root";
        PASSWORD = "";
        DRIVER = "com.mysql.jdbc.Driver";
        conn = null;
    }
    
    
    @Override
    public boolean connect() {
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection("jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MysqlInstance.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de conexion");
        }
        return (conn == null);
    }

    @Override
    public boolean close() {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlInstance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        try {
            return (conn.isClosed());
        } catch (SQLException ex) {
            Logger.getLogger(MysqlInstance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void testConnection(){
     if(conn != null ){
         System.out.println("la conexion funciona");
     }else{
         System.out.println("la conexion es nula");
     }
    }

}
