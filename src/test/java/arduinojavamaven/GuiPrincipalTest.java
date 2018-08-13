/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinojavamaven;

import com.mycompany.arduinojavamaven.Estacionamiento;
import org.junit.Test;
import static org.junit.Assert.*;
import gui.*;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Ce
 */
public class GuiPrincipalTest {
//sin conexion a internet

    @Test(expected = IOException.class)
    public void agregarImagenTest() throws IOException {
        Estacionamiento est = new Estacionamiento();
        GuiPrincipal gp = new GuiPrincipal(est);

    }
    
    @Test 
    public void agregarImagenTestCorrecta() throws IOException{
            Estacionamiento est = new Estacionamiento();
        GuiPrincipal gp = new GuiPrincipal(est);
    } 
}
