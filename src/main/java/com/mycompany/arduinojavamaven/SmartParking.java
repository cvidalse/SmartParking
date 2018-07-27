/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arduinojavamaven;

import com.panamahitek.ArduinoException;
import gui.Principal;
import jssc.SerialPortException;

/**
 *
 * @author Ce
 */
public class SmartParking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArduinoException, SerialPortException {
        // TODO code application logic here
        Estacionamiento est = new Estacionamiento();
        
        Principal pr = new Principal(est);
        
        ConexionArduino conect = new ConexionArduino(est);
        
        pr.setVisible(true);
//        conect.openPorts();
//        Timer timer = new Timer();
//        TimerTask act = new TimerTask() {
//        @Override
//        public void run() {
//       
//            try {
//                conect.crearConeccion();
//            } catch (ArduinoException ex) {
//                Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SerialPortException ex) {
//                Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
//            }
//       
//        }
//    };
//    timer.schedule(act, 0, 100);

    }
}
