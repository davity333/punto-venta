package models;

import java.util.ArrayList;

public class Ventas {
private ArrayList<Integer> ventatotal = new ArrayList<>();
private float Arqueo;


    public ArrayList<Integer> getProducto(){
        for (int i = 0; i < ventatotal.size(); i++) {
            Arqueo = Arqueo + ventatotal.get(i);
        }
        return ventatotal;
    }

}

