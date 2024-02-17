package models;
public class Producto {
    private String nombre;
    private Float precio;
    private int cantidad;

    public Producto(String nombre, Float precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public Float getPrecio() {

        return precio;
    }

    public void setPrecio(Float precio) {

        this.precio = precio;
    }

    public int getCantidad() {

        return cantidad;
    }

    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Son " + cantidad+" Piezas de " + nombre + " a "+ precio + " c/u";
    }


}
