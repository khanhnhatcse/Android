package com.swift.nhat.myexercise.Model;

/**
 * Created by nhat on 3/14/17.
 */

public class TiGia {
    private int id;
    private String name;
    private float value;


    public TiGia(int id, String name, float value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
