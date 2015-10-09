/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.persistencia;

/**
 *
 * @author Leo
 */
public class DBManager {
    static DBInstance instancia;
    public static DBInstance getConnection(){
        if(instancia == null){
            instancia = new MysqlInstance();
        }
        return instancia;
    }
    

}
