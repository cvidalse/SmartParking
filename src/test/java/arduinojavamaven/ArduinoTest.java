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
public class ArduinoTest {
    

    
    @Test (expected = java.lang.RuntimeException.class)
    public void ManejoDatosTestFallo(){
        
        ManejoDatos.aniadirArchivo(5);
    
    }
    
    @Test ()
    public void ManejoDatosTestExcito() throws IOException{

        ManejoDatos.aniadirArchivo("hola");
    
    }
    

}
