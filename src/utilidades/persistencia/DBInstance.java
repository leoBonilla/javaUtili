/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.persistencia;

import java.sql.Connection;

/**
 *
 * @author Leo
 */
public abstract class DBInstance {
    protected String HOST = "localhost";
    protected String PORT = "3306";
    protected String DATABASE = "mydb";
    protected String USER = "root";
    protected String PASSWORD = "";
    protected String DRIVER = "com.mysql.jdbc.Driver";
    protected Connection conn;

    public abstract boolean connect();
    public abstract boolean close();

}
