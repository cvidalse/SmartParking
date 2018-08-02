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

    private Estacionamiento est;
    static private PanamaHitek_Arduino ph = new PanamaHitek_Arduino();
    SerialPortEventListener events = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (ph.isMessageAvailable()) {

                    String mensaje1 = ph.printMessage();
                    System.out.println(mensaje1);
                    patron(mensaje1);

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

    public ConexionArduino(Estacionamiento estacionamiento) {
        est = estacionamiento;
        try {

            ph.arduinoRX("COM10", 9600, events);
        } catch (ArduinoException AE) {
             JOptionPane.showMessageDialog(this, "La conexión a Arduino esta ausente");
        } catch (SerialPortException ex) {
            Logger.getLogger(ConexionArduino.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void patron(String mensaje) throws IOException {
        Pattern pattern = Pattern.compile("(([\\d]?[\\d])([\\d]?[\\d])([\\d]?[\\d]))");
        Matcher buscar = pattern.matcher(mensaje);
        System.out.println("match");
        System.out.println(buscar.groupCount());

        if (buscar.matches()) {
            for (int i = 0; i <= buscar.groupCount(); i++) {
                System.out.println(buscar.group(i));
                pattern2(buscar.group(i));

            }
        }

    }

    private void pattern2(String group) throws IOException {
        System.out.println("aqui");

        Pattern pattern = Pattern.compile("([\\d])?([\\d])");
        Matcher buscar = pattern.matcher(group);
        if (buscar.matches()) {
            System.out.println("cambiando" + buscar.group(1) + "con" + buscar.group(2));
            est.actualizarEstado(Integer.parseInt(buscar.group(1)), Integer.parseInt(buscar.group(2)));
        }else{
        System.out.println("gg");
        }
    }

}
