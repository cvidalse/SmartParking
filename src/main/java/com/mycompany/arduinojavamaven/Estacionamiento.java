/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arduinojavamaven;

import java.awt.SystemColor;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Ce
 */
public class Estacionamiento {

    public ArrayList<Lote> lotes;
    public ArrayList<Boolean> cambio;

    public Estacionamiento() {
        lotes = new ArrayList<>();
        cambio = new ArrayList<>();
        llenadoTotalNombre();
        copiarEstado();
    }

    private void llenadoTotalNombre() {//crea los lotes y sus respectivos nombres
        for (int i = 0; i < 21; i++) {
            addLoteNombre("A" + i);
        }
    }

    public void copiarEstado() {//obtiene el estado de los lotes, para trabajar en tiempos distintos el estado real y el que aparece en pantalla
        for (int i = 0; i < lotes.size(); i++) {
            cambio.add(i, lotes.get(i).getEstado());//los que obtienen es un Boolean false si esta disponible y true si esta ocupado
        }

    }

    public void actualizarEstado(int pos, int valorConexion) throws IOException {//recibe los datos desde coneccion arduino, el pin asociado al numero del lote, y el valor de lectura
        lotes.get(pos).setEstado(valorConexion);
    }
    
    private void addLoteNombre(String nombre) {
        lotes.add(new Lote(nombre));
    }

    public void botonActualizar(ArrayList<Boolean> camb, ArrayList<JPanel> labels) {//generado para utilizar cuando se pulse el boton actualiza en la ventana Estacionamiento
        for (int i = 0; i < labels.size(); i++) {
            if (cambio.get(i)) {
                labels.get(i).setBackground(SystemColor.textHighlight);
//                    test.setBackground(Color.RED);
            } else {
                labels.get(i).setBackground(SystemColor.activeCaptionBorder);

            }
        }

    }
}
