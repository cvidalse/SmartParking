/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.mycompany.arduinojavamaven.Estacionamiento;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class GuiPrincipal extends JFrame implements ActionListener {

    private JButton mostrar;
    private JLabel imagen;
    private JLabel version;
    private JButton contacto;
    private Container contenido;
    Estacionamiento est;

    public GuiPrincipal(Estacionamiento estacionamiento) {
        super();
        est = estacionamiento;
        configuracionVentana();
        inicioComponentes();
        accionBoton();
        this.contenido = this.getContentPane();
        this.contenido.setBackground(SystemColor.inactiveCaptionBorder);
        this.setVisible(true);
    }

    private void configuracionVentana() {
        this.setTitle("Smart Parking");
        this.setBounds(100, 100, 788, 479);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(GuiPrincipal.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicioComponentes() {
        mostrar = new JButton();
        mostrar.setText("Mostrar Estacionamiento");
        mostrar.setBounds(305, 313, 184, 63);
        contacto = new JButton();
        contacto.setIcon(new ImageIcon(GuiPrincipal.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details.png")));
        contacto.setBounds(12, 13, 36, 29);
        imagen = new JLabel();
        imagen.setBounds(273, 48, 252, 252);
        imagen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
//        imagen.setIcon(new ImageIcon(getClass().getResource("/imagen/testing.jpg")));
        try {
            imageUrl(imagen);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        version = new JLabel("v0.7");
        version = new JLabel("v0.5");
        version.setFont(new Font("Consolas", Font.ITALIC, 13));
        version.setBounds(748, 3, 29, 16);
        this.add(mostrar);
        this.add(contacto);
        this.add(imagen);
        this.add(version);
    }
    
        private void imageUrl(JLabel miLabel) throws IOException {
    	 URL url = new URL("https://raw.githubusercontent.com/cvidalse/proyectoprogramacion/master/prototipoGUI/gui/icon/testing.jpg");
    	 BufferedImage image = ImageIO.read(url);
    	 miLabel.setIcon(new ImageIcon(image));	
    }
    

    private void accionBoton() {
        mostrar.addActionListener(this);
        contacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(contenido,
                        "c.vidal09@ufromail.cl\nm.bustos06@ufromail.cl\ns.robles01@ufromail.cl",
                        "Contacto",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        @SuppressWarnings("unused")
        GuiEstacionamiento estacionamiento = new GuiEstacionamiento(est);
        this.dispose();
    }

//    public static void main(String[] args) {
//        @SuppressWarnings("unused")
//        GuiPrincipal gui = new GuiPrincipal(est);
//    }
}
