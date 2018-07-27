/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arduinojavamaven;

import java.util.EventObject;

/**
 *
 * @author Ce
 */
public class ChangeEvent extends EventObject {

    Lote lote;

    public ChangeEvent(Object source, Lote _lote) {
        super(source);
        lote = _lote;
    }

}
