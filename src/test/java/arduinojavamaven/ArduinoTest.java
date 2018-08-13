/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinojavamaven;

import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.arduinojavamaven.*;
import com.panamahitek.ArduinoException;
import jssc.SerialPortException;

/**
 *
 * @author Ce
 */
public class ArduinoTest {
    
    @Test (expected = ArduinoException.class)
    public void ConexionArduinoTest() throws ArduinoException{
    Estacionamiento est = new Estacionamiento();
    ConexionArduino conexion = new ConexionArduino(est);
    
    } 

    
}
