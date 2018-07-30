/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arduinojavamaven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import manejodedatos.ManejoDatos;

/**
 *
 * @author Ce
 */
public class Lote {

    private String uso = "";
    private boolean estado;
    private boolean comparar;
//    private static ArrayList listeners;
    private ManejoDatos md;
    private String nombre;
    public Lote() {
        estado = false;
//        listeners = new ArrayList<>();
        md = new ManejoDatos();
    }

//    public void addEventListener(ChangeEvent listener) {
//        listeners.add(listener);
//    }
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(int entrada) throws IOException {

        if (entrada == 1) {//numero 1 en ascii
            comparar = true;
            if (this.estado != comparar) {
                java.util.Date fecha = new Date();
                this.uso += "Fecha ingreso " + fecha;
            }

            this.estado = true;

            System.out.println(estado);
//            System.out.println("ocupado");
        } else {
            comparar = false;
            if (this.estado != comparar) {
                java.util.Date fecha = new Date();
                this.uso += " Fecha salida " + fecha;
                md.aniadirArchivo(uso, "C:\\Users\\Ce\\Desktop\\taller\\ejemplo.txt");
                this.uso = "";
            }
            this.estado = false;
//            System.out.println("desocupado");

        }

    }

//    @Override
//    public void enEstado(ChangeEvent ev) {
//        java.util.Date fecha = new Date();
//        this.uso = "" + fecha;
//    }
//    @Override
//    public void enOcupado(ChangeEvent ev) {
//        java.util.Date fecha = new Date();
//        this.uso += "" + fecha;
//        md.archivo(uso);
//        this.uso = "";
//    }
//
//    private void triggerEnEstadoEvent() {
//
//        ListIterator li = listeners.listIterator();
//        while (li.hasNext()) {
//            cambioEstado listener = (cambioEstado) li.next();
//            ChangeEvent readerEvObj = new ChangeEvent(this, this);
//            (listener).enEstado(readerEvObj);
//        }
//    }
//
//    private void triggerOcupadoEvent() {
//
//        ListIterator li = listeners.listIterator();
//        while (li.hasNext()) {
//            cambioEstado listener = (cambioEstado) li.next();
//            ChangeEvent readerEvObj = new ChangeEvent(this, this);
//            (listener).enOcupado(readerEvObj);
//        }
//    }
}
