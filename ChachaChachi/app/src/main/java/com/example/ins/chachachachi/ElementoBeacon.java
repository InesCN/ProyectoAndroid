package com.example.ins.chachachachi;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by mrodriguez on 31/05/2018.
 */

public class ElementoBeacon {

    private int sala;//nombre de la sala
    private ArrayList<String> tareas;
    private boolean check;

    public ElementoBeacon() {
        super();
    }

    public ElementoBeacon(int sala, ArrayList<String> tareas, boolean check) {
        super();
        this.sala = sala;
        this.tareas = tareas;
        this.check = check;
    }
}
