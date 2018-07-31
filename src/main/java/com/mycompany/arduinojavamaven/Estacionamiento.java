/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arduinojavamaven;

import java.io.IOException;
import java.util.ArrayList;

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
        llenadoTotal();
        copiarEstado();
    }
    
    private void llenadoTotal(){
    for(int i = 0; i<21;i++){
    addLote();
    }
    }
    
    public void copiarEstado() {
        for (int i = 0; i < lotes.size(); i++) {
            cambio.add(i, lotes.get(i).getEstado());
            System.out.println("copiado " + lotes.get(i).getEstado());
            System.out.println("copiando");
        }
//      cambio.add(true);

    }


    public void actualizarEstado(int pos, int valorConexion) throws IOException {
//        System.out.println("actualizando estado");
        lotes.get(pos).setEstado(valorConexion);
    }

    private void addLote() {
        lotes.add(new Lote());

    }

}
