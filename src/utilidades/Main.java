/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import utilidades.date.DateManager;
import utilidades.numeric.Numeric;
import utilidades.persistencia.DBInstance;
import utilidades.persistencia.DBManager;
import utilidades.persistencia.MysqlInstance;
import utilidades.rut.Rut;

/**
 *
 * @author Leo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("La edad de una persona: "+DateManager.calcularEdad("19-12-1984"));
        System.out.println("Un numero aleatorio entre 4 y 7"+Numeric.generarNumeroAleatorio(4, 7));
        System.out.println("La hora es: "+DateManager.obtenerHoraSistema());
        System.out.println("La fecha es: " +DateManager.obtenerFechadelSistema());
        System.out.println("Sumar 5 dias a hoy : "+DateManager.sumarDiasAHoy(5));
        System.out.println("Hace 3 dias era fecha: "+DateManager.restarDiasAHoy(3));
        System.out.println("Dias entre fechas:(03/10/2015, 03/11/2015) :" +DateManager.diasEntreFechas("03/10/2015", "04/11/2015"));
        System.out.println(""+Rut.validarRut("15.929.134-1"));
        MysqlInstance conexion = (MysqlInstance) DBManager.getConnection();
        conexion.connect();
        conexion.testConnection();
    }
    
}
