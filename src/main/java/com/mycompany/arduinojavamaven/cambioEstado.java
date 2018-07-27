/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arduinojavamaven;

import java.util.EventListener;

/**
 *
 * @author Ce
 */
public interface cambioEstado extends EventListener {

    public void enEstado(ChangeEvent ev);

    public void enOcupado(ChangeEvent ev);

}
