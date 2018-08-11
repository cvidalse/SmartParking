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
import manejodedatos.CalcularEstadia;
import manejodedatos.ManejoDatos;

/**
 *
 * @author Ce
 */
public class Lote {

    private String uso = "";
    private boolean estado;
    private boolean comparar;

    private ManejoDatos md;
    private String nombre;

    public Lote() {
        estado = false;

        md = new ManejoDatos();
    }

    public Lote(String nombre) {
        this.nombre = nombre;

        estado = false;
//        listeners = new ArrayList<>();
        md = new ManejoDatos();
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(int entrada) throws IOException {//recibe los valores 0 e 1 los cuales asocia a true o false, 1==true, 0==fale
        //de igual forma se hace cargo del ingreseo de las fechas de entrada y salida
        if (entrada == 1) {//entrada o salida
            comparar = true;//utilizado para detectar el cambio de estado de un lote e ingresar la fecha de llegada
            if (this.estado != comparar) {//si comparar y el estado actual del lote son distintos significa que la fecha de ingreso debe ser guardada
                this.uso += "" + nombre + " ";
                java.util.Date fecha = new Date();
                this.uso += "Fecha ingreso " + fecha;
            }

            this.estado = true;//se cambia a true
        } else {
            comparar = false;
            if (this.estado != comparar) {//si comparar y el estado actual del lote son distintos significa que la fecha de salida debe ser guardada
                java.util.Date fecha = new Date();

                this.uso += " Fecha salida " + fecha;//luego de que ambas, la fecha de salida como la de entrada se encuentran calculadas se ejecuta el metodo calcular del manejo de datos y se agrega al String generado

                this.uso += CalcularEstadia.calcular(this.uso);
               
                md.aniadirArchivo(uso);//se envia al metodo aniadirArchivo para su guardado
                this.uso = "";
            }
            this.estado = false;//se cambia el estado del Lote


        }

    }
}
