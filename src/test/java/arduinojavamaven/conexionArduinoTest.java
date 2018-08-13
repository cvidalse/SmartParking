/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinojavamaven;

import org.junit.Test;
//import static org.junit.Assert.*;
import com.mycompany.arduinojavamaven.*;
import com.panamahitek.ArduinoException;
import java.io.IOException;
import jssc.SerialPortException;
import manejodedatos.ManejoDatos;

/**
 *
 * @author Ce
 */
public class conexionArduinoTest {
//con la conexion faltando
    @Test (expected = ArduinoException.class)
    public void ConexionArduinoTest() throws ArduinoException, ArduinoException{
    Estacionamiento est = new Estacionamiento();
    ConexionArduino conexion = new ConexionArduino(est);
    
    } 
//con conexion a arduinos
   public void ConexionArduinoTestCorrecta() throws ArduinoException, ArduinoException{
    Estacionamiento est = new Estacionamiento();
    ConexionArduino conexion = new ConexionArduino(est);
    
    }
}
