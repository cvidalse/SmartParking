package gui;

import javax.swing.*;
import javax.swing.border.*;
import com.mycompany.arduinojavamaven.Estacionamiento;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GuiEstacionamiento extends JFrame implements ActionListener {

    private JButton volver;
    private JLabel texto;
    private JButton actualizar;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JPanel panel_5;
    private JPanel panel_6;
    private JPanel panel_7;
    private JPanel panel_8;
    private JPanel panel_9;
    private JPanel panel_10;
    private JPanel panel_11;
    private JPanel panel_12;
    private JPanel panel_13;
    private JPanel panel_14;
    private JPanel panel_15;
    private JPanel panel_16;
    private JPanel panel_17;
    private JPanel panel_18;
    private JPanel panel_19;
    private JPanel panel_20;
    private JPanel panel_21;
    private JPanel disponible;
    private JPanel ocupado;
    private Container contenido;
    private Estacionamiento est;
    private JLabel lblOcupado;
    private JLabel lblDisponible;
    private ArrayList<JPanel> espacio;

    public GuiEstacionamiento(Estacionamiento estacionamiento) {
        super();
        this.est = estacionamiento;
        espacio = new ArrayList<>();
        configuracionVentana();
        inicioComponentes();
        configPaneles();

        this.contenido = this.getContentPane();
        this.contenido.setBackground(SystemColor.inactiveCaptionBorder);
        accionBoton();
        this.setVisible(true);
    }

    private void configuracionVentana() {//configura elementos de la ventana
        this.setTitle("Smart Parking - Estacionamiento");
        this.setBounds(100, 100, 789, 625);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(GuiEstacionamiento.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void inicioComponentes() {//inicia botones e imagenens
        volver = new JButton("Volver");
        volver.setIcon(new ImageIcon(GuiEstacionamiento.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
        volver.setBounds(12, 13, 105, 29);
        texto = new JLabel("Smart Parking");
        texto.setFont(new Font("Perpetua", Font.BOLD | Font.ITALIC, 40));
        texto.setBounds(290, 0, 238, 57);
        actualizar = new JButton("Actualizar");
        actualizar.setBounds(342, 456, 97, 48);
        lblOcupado = new JLabel("Ocupado");
        lblOcupado.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblOcupado.setBounds(181, 517, 96, 40);
        lblDisponible = new JLabel("Disponible");
        lblDisponible.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDisponible.setBounds(515, 517, 96, 40);
        this.add(lblDisponible);
        this.add(lblOcupado);
        this.add(volver);
        this.add(texto);
        this.add(actualizar);
    }

    private void configPaneles() {//incia los paneles que iran asociados a los Lotes y los agrega a un array
        panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBounds(19, 70, 96, 110);
        espacio.add(panel_1);
        this.add(panel_1);

        panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_2.setBounds(127, 70, 96, 110);
        espacio.add(panel_2);
        this.add(panel_2);

        panel_3 = new JPanel();
        panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_3.setBounds(235, 70, 96, 110);
        espacio.add(panel_3);
        this.add(panel_3);
//19, 321, 96, 110
        panel_4 = new JPanel();
        panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_4.setBounds(343, 70, 96, 110);
        espacio.add(panel_4);
        this.add(panel_4);

        panel_5 = new JPanel();
        panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_5.setBounds(451, 70, 96, 110);
        espacio.add(panel_5);
        this.add(panel_5);

        panel_6 = new JPanel();
        panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_6.setBounds(559, 70, 96, 110);
        espacio.add(panel_6);
        this.add(panel_6);
        

        panel_7 = new JPanel();
        panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_7.setBounds(667, 70, 96, 110);
        espacio.add(panel_7);
        this.add(panel_7);

        panel_8 = new JPanel();
        panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_8.setBounds(19, 193, 96, 110);
        espacio.add(panel_8);
        this.add(panel_8);

        panel_9 = new JPanel();
        panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_9.setBounds(127, 193, 96, 110);
        espacio.add(panel_9);
        this.add(panel_9);

        panel_10 = new JPanel();
        panel_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_10.setBounds(235, 193, 96, 110);
        espacio.add(panel_10);
        this.add(panel_10);

        panel_11 = new JPanel();
        panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_11.setBounds(343, 193, 96, 110);
        espacio.add(panel_11);
        this.add(panel_11);

        panel_12 = new JPanel();
        panel_12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_12.setBounds(451, 193, 96, 110);
        espacio.add(panel_12);
        this.add(panel_12);

        panel_13 = new JPanel();
        panel_13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_13.setBounds(559, 193, 96, 110);
        espacio.add(panel_13);
        this.add(panel_13);

        panel_14 = new JPanel();
        panel_14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_14.setBounds(667, 193, 96, 110);
        espacio.add(panel_14);
        this.add(panel_14);

        panel_15 = new JPanel();
        panel_15.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_15.setBounds(19, 321, 96, 110);
        espacio.add(panel_15);
        this.add(panel_15);

        panel_16 = new JPanel();
        panel_16.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_16.setBounds(127, 321, 96, 110);
        espacio.add(panel_16);
        this.add(panel_16);

        panel_17 = new JPanel();
        panel_17.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_17.setBounds(235, 321, 96, 110);
        espacio.add(panel_17);
        this.add(panel_17);

        panel_18 = new JPanel();
        panel_18.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_18.setBounds(343, 321, 96, 110);
        espacio.add(panel_18);
        this.add(panel_18);

        panel_19 = new JPanel();
        panel_19.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_19.setBounds(451, 321, 96, 110);
        espacio.add(panel_19);
        this.add(panel_19);

        panel_20 = new JPanel();
        panel_20.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_20.setBounds(559, 321, 96, 110);
        espacio.add(panel_20);
        this.add(panel_20);

        panel_21 = new JPanel();
        panel_21.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_21.setBounds(667, 321, 96, 110);
        espacio.add(panel_21);
        this.add(panel_21);

        ocupado = new JPanel();
        ocupado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        ocupado.setBackground(SystemColor.activeCaptionBorder);
        ocupado.setBounds(608, 517, 47, 40);
        this.add(ocupado);

        disponible = new JPanel();
        disponible.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        disponible.setBackground(SystemColor.textHighlight);
        disponible.setBounds(127, 517, 47, 40);
        this.add(disponible);

    }

    private void accionBoton() {
        volver.addActionListener(this);
        actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                est.copiarEstado();
                est.botonActualizar(est.cambio, espacio);

//                                  boolean verdadera = true;
                for (int i = 0; i < espacio.size(); i++) {
                    if (est.cambio.get(i)) {
                        espacio.get(i).setBackground(SystemColor.textHighlight);
//                    test.setBackground(Color.RED);
                    } else {
                        espacio.get(i).setBackground(SystemColor.activeCaptionBorder);

                    }
                }
            }

//                testing.setColor(panel_1);
//                testing.setColor(panel_2);
//                testing.setColor(panel_3);
//                testing.setColor(panel_4);
//                testing.setColor(panel_5);
//                testing.setColor(panel_6);
//                testing.setColor(panel_7);
//                testing.setColor(panel_8);
//                testing.setColor(panel_9);
//                testing.setColor(panel_10);
//                testing.setColor(panel_11);
//                testing.setColor(panel_12);
//                testing.setColor(panel_13);
//                testing.setColor(panel_14);
//                testing.setColor(panel_15);
//                testing.setColor(panel_16);
//                testing.setColor(panel_17);
//                testing.setColor(panel_18);
//                testing.setColor(panel_19);
//                testing.setColor(panel_20);
//                testing.setColor(panel_21);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        @SuppressWarnings("unused")
        GuiPrincipal menu = new GuiPrincipal(est);
        this.dispose();
    }

    public static void main(String[] args){
    Estacionamiento esta= new Estacionamiento();
    GuiEstacionamiento gui = new GuiEstacionamiento(esta);
    }
    
}
