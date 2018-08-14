/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinojavamaven;

import com.mycompany.arduinojavamaven.Estacionamiento;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ce
 */
public class testEstacionamiento {
    
@Test(expected = IndexOutOfBoundsException.class )    
public  void estacionamientoTest()throws IndexOutOfBoundsException, IOException{
Estacionamiento est = new Estacionamiento();

est.actualizarEstado(23, 0);
    
}
    
}
