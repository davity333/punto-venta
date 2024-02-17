import models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Inventario invent = new Inventario();//instancia
    static ArrayList<String> soloproductos = new ArrayList<>();
    static ArrayList<Float> soloprecios = new ArrayList<>();
    static ArrayList<Integer> solocantidad = new ArrayList<>();
    static ArrayList<Integer> ventatotal = new ArrayList<>();
    private static Scanner guardar = new Scanner(System.in);

    public static float arqueototal;
    private static Scanner key = new Scanner(System.in);
    private static int cuantos;

    public static void main(String[] args) {
        int opcion;
        int opciondos;
        int opciontres;

        do {
            System.out.println("1. Ingresa como administrador");
            System.out.println("2. Ingresa como cajero");
            System.out.println("3. Salir");
            System.out.print("INGRESA UN NUMERO: ");
            opcion = guardar.nextInt();

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("");
                        System.out.println("ADMINISTRADOR INGRESADO");
                        System.out.println("1. Hacer apertura");
                        System.out.println("2. Hacer arqueo");
                        System.out.println("3. Salir");
                        System.out.print("INGRESA UN NUMERO: ");
                        opciondos = guardar.nextInt();

                        switch (opciondos) {
                            case 1:
                                HacerApertura();
                                break;

                            case 2:
                                HacerArqueo(soloproductos, solocantidad, ventatotal );
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("Ingresa un numero correspondiente a la lista");
                        }
                    } while (opciondos !=3);
                    break;

                case 2:
                    do {
                        System.out.println("");
                        System.out.println("CAJERO INGRESADO");
                        System.out.println("1. Añadir productos");
                        System.out.println("2. Mostrar productos");
                        System.out.println("3. Registrar ventas");
                        System.out.println("4. Salir");
                        System.out.print("INGRESA UN NUMERO: ");
                        opciontres = guardar.nextInt();

                        switch (opciontres) {
                            case 1:
                                addProducts();
                                break;
                            case 2:
                                showProduct();
                                break;
                            case 3:
                                RegistrandoVentas();
                                break;
                            case 4:
                            default:
                                System.out.println("Ingresa un numero correspondiente a la lista");
                        }
                    } while (opciontres !=4);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Ingresa un numero correspondiente a la lista");
            }
        } while (opcion !=3);
    }

    private static void addProducts() {
        String nombre;
        int cantidad;
        float precio;

        System.out.print("Nombre: ");
        nombre = guardar.next();
        soloproductos.add(nombre);

        System.out.print("Precio: ");
        precio = guardar.nextFloat();
        soloprecios.add(precio);

        System.out.print("Cantidad: ");
        cantidad = guardar.nextInt();
        solocantidad.add(cantidad);


        Producto products = new Producto(nombre, precio, cantidad);

        if (invent.addProducts(products)) {
            System.out.println("Registro exitoso");
        } else {
            System.out.println("No se metio");
        }
    }

    private static void showProduct() {
        ArrayList<Producto> obetenerproductos;
        obetenerproductos = invent.getProducto();
        for (int i = 0; i < obetenerproductos.size(); i++) {
            System.out.println(obetenerproductos.get(i));
        }
    }

    private static void HacerApertura() {
        Caja cajita = new Caja();
        System.out.println("Ingresa la apertura a la caja");
        Float apertura = guardar.nextFloat();
        cajita.setApertura(apertura);
        System.out.println("Ingresastes: $" + apertura + " a la caja registradora");
        arqueototal = apertura;
    }

    private static void RegistrandoVentas() {
        Ventas cantidadobj = new Ventas();
        ArrayList<Integer> cantidadVendida = cantidadobj.getProducto();

        for (int i = 0; i < soloproductos.size(); i++) {
            System.out.println("Ingresa cuántas piezas de " + soloproductos.get(i) + " vendiste");
            int cantidadVendidaentero = guardar.nextInt();

            while (cantidadVendidaentero > solocantidad.get(i)) {
                System.out.println("Solo tienes " + solocantidad.get(i) + " piezas en el inventario");
                System.out.println("Ingresa cuántas piezas de " + soloproductos.get(i) + " vendiste");
                cantidadVendidaentero = guardar.nextInt();
            }
            cantidadVendida.add(cantidadVendidaentero);

            int enteroventa = (int) (cantidadVendidaentero * soloprecios.get(i));
            ventatotal.add(enteroventa);
        }

        System.out.println("Venta total");
        for (int i = 0; i < solocantidad.size(); i++) {
            System.out.println("-----------------------------------");
            System.out.println(cantidadVendida.get(i)+" piezas de "+ soloproductos.get(i)+" → $ "+ventatotal.get(i));
            System.out.println("-----------------------------------");
            System.out.println("");
        }
    }



    public static void HacerArqueo(ArrayList<String> soloproductos, ArrayList<Integer> cantidadVendida, ArrayList<Integer> ventatotal ){
        System.out.println("Venta total");
        for (int i = 0; i < solocantidad.size(); i++) {
            System.out.println(cantidadVendida.get(i)+" piezas de "+soloproductos.get(i)+" = $ "+(cantidadVendida.get(i)*soloprecios.get(i) ));
            System.out.println("");
        }


        Arqueo arque = new Arqueo();
        float Arqueo = arque.getArqueoo();
        arque.setArqueoo(arque.getArqueoo());


        for (int i = 0; i < ventatotal.size(); i++) {
            Arqueo = Arqueo + ventatotal.get(i);
        }
        System.out.println("----------------------------------");
        System.out.println("Las ventas fue " + "$ "+Arqueo);
        System.out.println("----------------------------------");
        System.out.println("La ventas con el arqueo es = $ "+(Arqueo + arqueototal));
        System.out.println("----------------------------------");
    }
}









