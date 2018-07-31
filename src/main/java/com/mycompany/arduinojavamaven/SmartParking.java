/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arduinojavamaven;

import com.panamahitek.ArduinoException;
import gui.GuiPrincipal;
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
        
        GuiPrincipal pr = new GuiPrincipal(est);
        
        ConexionArduino conect = new ConexionArduino(est);
        
        pr.setVisible(true);


    }
}
