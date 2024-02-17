package models;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> product = new ArrayList<>();
    public boolean addProducts(Producto producti){
        boolean status;
        status = product.add(producti);
        return status;
    }

    public ArrayList<Producto> getProducto(){
        return product;
    }

}
