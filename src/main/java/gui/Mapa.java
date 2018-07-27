/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Ce
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.mycompany.arduinojavamaven.Estacionamiento;

public class Mapa extends JFrame implements ActionListener {

    private JButton botonVolver;
    private JLabel titulo;
    private JButton botonActualizar;
    private JPanel test;
    private java.awt.Container contenido;
    Estacionamiento est;

    public Mapa(Estacionamiento estacionamiento) {
        super();
        this.est=estacionamiento;
        this.botonVolver = new JButton();
        this.botonActualizar = new JButton();
        this.test = new JPanel();
        this.titulo = new JLabel();
        this.contenido = this.getContentPane();
        this.contenido.setBackground(Color.LIGHT_GRAY);
        configuracionVentana();
        inicioComponentes();
        configPaneles();
        accionesBotones();
    }

    private void configuracionVentana() {
        this.setTitle("SP Estacionamiento");
        this.setSize(510, 410);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(0);
    }

    private void configPaneles() {
        test.setBounds(5, 50, 50, 50);
        test.setLayout(null);
        test.setBorder(BorderFactory.createLineBorder(Color.black));
        test.setBackground(Color.GREEN);
        this.add(test);
    }

    private void inicioComponentes() {
        botonVolver.setText("Volver");
        botonVolver.setBounds(5, 10, 97, 25);
        botonActualizar.setText("Actualizar");
        botonActualizar.setBounds(205, 300, 97, 25);
        titulo.setText("SMART PARKING");
        titulo.setBounds(150, 5, 300, 30);
        titulo.setFont(new Font("Serif", Font.PLAIN, 25));
        this.add(botonVolver);
        this.add(botonActualizar);
        this.add(titulo);
    }

    private void accionesBotones() {
        botonVolver.addActionListener(this);
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              
                est.copiarEstado();
                               
                                 
//                                  boolean verdadera = true;
                if (est.cambio.get(0)) {

                    test.setBackground(Color.RED);
                } else {
                    test.setBackground(Color.GREEN);

                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Principal ventana = new Principal(est);
        ventana.setVisible(true);
        this.dispose();
    }
}
