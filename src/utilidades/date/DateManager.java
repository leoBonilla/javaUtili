/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Leo
 */
public class DateManager {
    
    /**
     *
     * @param fecha  String que representa la fecha de nacimiento de la persona
     * @return  la edad representada en un valor entero
     */
    public static int calcularEdad(String fecha) {
        String datetext = fecha;
        try {
            Calendar birth = new GregorianCalendar();
            Calendar today = new GregorianCalendar();
            int age = 0;
            int factor = 0;
            Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(datetext);
            Date currentDate = new Date(); //current date
            birth.setTime(birthDate);
            today.setTime(currentDate);
            if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                    if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                        factor = -1; //Aun no celebra su cumpleaÃ±os
                    }
                } else {
                    factor = -1; //Aun no celebra su cumpleaÃ±os
                }
            }
            age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
            return age;
        } catch (ParseException e) {
            return -1;
        }

    }
    
    /**
     *
     * @return un String representando la hora actual del sistema
     */
    public static String obtenerHoraSistema() {
        int hora, minutos, segundos;
        Calendar calendario = new GregorianCalendar();
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        return "" + hora + ":" + minutos + ":" + segundos;
    }

    /**
     *
     * @return un String representando la fecha del sistema 
     */
    public static String obtenerFechadelSistema() {
        int dia, mes, anio;
        Calendar calendario = new GregorianCalendar();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        anio = calendario.get(Calendar.YEAR);
        return "" + dia + "/" + mes + "/" + anio;
    }

    /**
     *
     * @param dias Entero, numero de dias a sumar a una fecha
     * @return  String , fecha luego de sumar los dias
     */
    public static String sumarDiasAHoy(int dias) {
        Calendar hoy = new GregorianCalendar();
        hoy.add(Calendar.DATE, dias);
        return hoy.get(Calendar.DATE) + "/" + hoy.get(Calendar.MONTH) + "/" + hoy.get(Calendar.YEAR);
    }

    /**
     *
     * @param dias Entero, numero de dias a restar
     * @return  String, fecha luego de restar los dias 
     */
    public static String restarDiasAHoy(int dias) {
        Calendar hoy = new GregorianCalendar();
        hoy.add(Calendar.DATE, -dias);
        return hoy.get(Calendar.DATE) + "/" + hoy.get(Calendar.MONTH) + "/" + hoy.get(Calendar.YEAR);
    }

    /**
     *
     * @param fecha1 String, fecha de inicio 
     * @param fecha2 String, fecha final
     * @return  long, numero de dias entre fechas
     */
    public static long diasEntreFechas(String fecha1, String fecha2) {
        try {
            Calendar finicio = new GregorianCalendar();
            Calendar ffinal = new GregorianCalendar();
            java.util.Date cal_inicio = new SimpleDateFormat("dd/MM/yyyy").parse(fecha1);
            java.util.Date cal_final = new SimpleDateFormat("dd/MM/yyyy").parse(fecha2);
            finicio.set(cal_inicio.getYear(), cal_inicio.getMonth(), cal_inicio.getDate());
            ffinal.set(cal_final.getYear(), cal_final.getMonth(), cal_final.getDate());
            long milis1 = finicio.getTimeInMillis();
            long milis2 = ffinal.getTimeInMillis();
            // calcular la diferencia en milisengundos
            long diff = milis2 - milis1;
            // calcular la diferencia en segundos
            long diffSeconds = diff / 1000;
            // calcular la diferencia en minutos
            long diffMinutes = diff / (60 * 1000);
            // calcular la diferencia en horas
            long diffHours = diff / (60 * 60 * 1000);
            // calcular la diferencia en dias
            long diffDays = diff / (24 * 60 * 60 * 1000);
            return diffDays;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
