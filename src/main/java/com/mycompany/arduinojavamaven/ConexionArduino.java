/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arduinojavamaven;

import com.panamahitek.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import jssc.*;

/**
 *
 * @author Ce
 */
public class ConexionArduino extends javax.swing.JFrame {

    String[] valores = new String[3];
    private Estacionamiento est;
    static private PanamaHitek_Arduino ph = new PanamaHitek_Arduino();//biblioteca panamaHitek para crear la coneccion
    SerialPortEventListener events = new SerialPortEventListener() {//depecta los eventos en el puerto serial osea los mensajes de arduinos
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ph.isMessageAvailable()) {

                    String mensaje1 = ph.printMessage();
                    System.out.println(mensaje1);

                    recorrerNumeros(split(mensaje1));

//                    est.actualizarEstado(0, Integer.parseInt(mensaje1));
                }
            } catch (SerialPortException ex) {
                Logger.getLogger(ConexionArduino.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArduinoException ex) {
                Logger.getLogger(ConexionArduino.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ConexionArduino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public ConexionArduino(Estacionamiento estacionamiento) {//crea la conexion a arduinos de lo contrario lanza un error por pantalla
        est = estacionamiento;
        try {

            ph.arduinoRX("COM6", 9600, events);//primero el puerto en el que se ejecuta, segundo el rate de actualizacion y luego el lector de eventos creado mas arriba
        } catch (ArduinoException AE) {//arduino exception cuando la coneccion falla
            JOptionPane.showMessageDialog(this, "La conexión a Arduino esta ausente");
        } catch (SerialPortException ex) {
            Logger.getLogger(ConexionArduino.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String[] split(String lectura) {//separa los valores de la lectura de cada pin, como solo lee 3 datos esta en este estado
        valores = lectura.split(" ", 3);
        return valores;
    }

    private void recorrerNumeros(String[] valores) throws IOException {//como las lecturas pueden venir de pin mayores que 10 o menores que 10 este metodo los separa de modo que aquellos menores que 10 vayan a pattern2 y los mayores a pattern3

        for (int i = 0; i < valores.length; i++) {

            String medicion = valores[i];

            if (medicion.length() == 2) {
                pattern2(medicion);
            } else {
                pattern3(medicion);
            }
        }
    }

//    private String
//    private void patron(String mensaje) throws IOException {
//        Pattern pattern = Pattern.compile("(([\\d]?[\\d])([\\d]?[\\d])([\\d]?[\\d]))");
//        Matcher buscar = pattern.matcher(mensaje);
//        System.out.println("match");
//        System.out.println(buscar.groupCount());
//
//        if (buscar.matches()) {
//            for (int i = 0; i <= buscar.groupCount(); i++) {
//                System.out.println(buscar.group(i));
//                pattern2(buscar.group(i));
//
//            }
//        }
//
//    }
    private void pattern2(String group) throws IOException {
//separa las lecuras en pin del que proceden y valor de lectura para ser entregados al metodo actualizar estado para su posterior tratamiento
        Pattern pattern = Pattern.compile("([\\d])?([\\d])");
        Matcher buscar = pattern.matcher(group);
        if (buscar.matches()) {

            est.actualizarEstado(Integer.parseInt(buscar.group(1)), Integer.parseInt(buscar.group(2)));
        }
    }

    private void pattern3(String group) throws IOException {
        //separa las lecuras en pin del que proceden y valor de lectura para ser entregados al metodo actualizar estado para su posterior tratamiento

        Pattern pattern = Pattern.compile("([\\d]?[\\d])+([\\d])");
        Matcher buscar = pattern.matcher(group);
        if (buscar.matches()) {
//            System.out.println("cambiando" + buscar.group(1) + "con" + buscar.group(2));
            est.actualizarEstado(Integer.parseInt(buscar.group(1)), Integer.parseInt(buscar.group(2)));
        }
    }

}
