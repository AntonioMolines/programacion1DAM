package tienDAM;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sql.rowset.serial.SerialException;

public class TienDAM {
    private static Almacen a = new Almacen(50);
    private static Pedido p = new Pedido("");
    private static Scanner lector = new Scanner(System.in);
    public static void menuPrincipal() {
        
        int op = 0;
        while(op != 3) {
            System.out.println("Menu de TienDAM: ");
            System.out.println("Seleccione una opción:");
            System.out.println("1- Almacen");
            System.out.println("2- Pedido");
            System.out.println("3- Salir");
            op = pedirIntValido("opcion elegida: ");
            switch(op) {
                case 1:
                    menuAlmacen();
                    break;
                case 2:
                    menuPedido();
                    break;
            }
        }
    }

    public static void menuAlmacen() {
        int op = 0;
        while(op != 6) {
            System.out.println("Menu del almacen de TienDAM");
            System.out.println("Seleccione una opción:");
            System.out.println("1- Ver articulos");
            System.out.println("2- buscar articulos");
            System.out.println("3- añadir articulos");
            System.out.println("4- recibir articulos");
            System.out.println("5- Devolver articulos");
            System.out.println("6- volver al menu principal");
            op = pedirIntValido("opcion elegida: ");
            switch (op) {
                case 1:
                    verArticulos();
                    break;
                case 2:
                    buscarArticulos("Introduzca el articulo a buscar");
                    break;
                case 3:
                    añadirArticuloAlmacen();
                    break;
                case 4:
                    recibirArticulo();
                    break;
                case 5:
                    devolverArticulo();
                    break;
                
            }
        }
    }

   


    public static void menuPedido() {
        int op = 0;
        while(op != 7) {
            System.out.println("Menu para nuevos pedidos");
            System.out.println("Seleccione una opción");
            System.out.println("1- Añadir articulo al carro");
            System.out.println("2- Eliminar un articulo del carro");
            System.out.println("3- Modificar la cantidad de un articulo");
            System.out.println("4- Aplicar descuentos");
            System.out.println("5- Acabar la venta(comprar)");
            System.out.println("6- Rehacer la venta(descartar el carro pero seguir en este menu)");
            System.out.println("7- Volver al menu principal");
            op = pedirIntValido("opcion elegida: ");
                switch (op) {
                    case 1:
                        añadirCarro();
                        break;
                    case 2:
                        eliminarArticulo();
                        break;
                    case 3:
                        modificarCantidad();
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        
                        break;
                }
            }

    }
    public static int pedirIntValido(String msg) {
        int res = 0;
        boolean salida = false;
        while(!salida) {
            System.out.println(msg);
            try {
                res = lector.nextInt();
                salida = true;
            } catch (InputMismatchException e) {
                System.err.println("Valor no válido.Introduce un entero");
                lector.nextLine();

            }
        }
        return res;
    }

    public static String pedirStringValido(String msg) {
        String res = "";
        boolean salida = false;
        while(!salida) {
            System.out.println(msg);
            try {
                res = lector.nextLine();
                salida = true;
            } catch (InputMismatchException e) {
                System.err.println("Valor no válido.Introduce un String");
                lector.nextLine();

            }
        }
        return res;
    }

    public static void añadirCarro() {
        if(p.getNombre() == "") {
            p.setNombre(pedirStringValido("Introduzca el nombre del comprador:"));
            lector.nextLine();
        }
        p.getArticulos().add(buscarArticulos("Introduzca el nombre del articulo"));

    }

    public static void eliminarArticulo() {
        p.eliminarArticulo(buscarArticulos("Introduzca el articulo que desa eliminar:"));
    }

    public static void modificarCantidad() {
        Articulo art = buscarArticulos("Introduzca el articulo al que quieres modificar la cantidad");
        if(art != null) {
            int pos = p.getPosArticulo(art);
            System.out.println("Actualmente hay " + p.getCantidadAComprar().get(pos));
            System.out.println("introduzca la nueva cantidad: ");
            int cantidad = lector.nextInt();
            
        }
    }
    public static void verArticulos() {
        for(int i = 0; i <= a.getArticulos().size(); i++) {
            System.out.println(a.verArticulo(i).toString());   
        }
    }

    public static Articulo buscarArticulos(String msg) {
        System.out.println(msg);
        String nombre = lector.nextLine();
        ArrayList<Articulo> artEncontrados = new ArrayList();
        artEncontrados = a.buscarArticulo(nombre);

        if(artEncontrados.size() == 0){
            System.out.println("No hay articulos que coincidan con la busqueda");
            
        }
        else if(artEncontrados.size() == 1){
            return artEncontrados.get(0);
        }
        else {
            System.out.println("Hay más de un articulo con ese nombre, se más especifico. Se han encontrado...");

            for(int i = 0; i < artEncontrados.size(); i++) {
                System.out.println(artEncontrados.get(i).toString()); 
            }
        }

        return null;
    }

    public static void añadirArticuloAlmacen() {
        System.out.println("Introduzca el nombre del articulo");
        String n = lector.nextLine();
        System.out.println("Introduzca el precio del articulo");
        double p = lector.nextDouble();
        System.out.println("Introduzca el IVA del articulo");
        double IVA = lector.nextDouble();
        System.out.println("Introduzca la cantidad");
        int c = lector.nextInt();
        if(a.añadirArticulo(n, p, IVA, c)) {
            System.out.println("El articulo se ha añadido con éxito");
        }
        else {
            System.out.println("error al añadir el articulo");
        }
    }
    
    public static void recibirArticulo() {
        System.out.println("Introduzca la posicion del articulo o '-1' si desconoce las posiciones de estos");
        int pos = lector.nextInt();
        if(pos == -1) {
            a.toString();
            recibirArticulo();
        }
        else {
            System.out.println("Introduzca la cantidad a recibir de " + a.verArticulo(pos).getNombre() + ":");
            int c = lector.nextInt();
            if(a.recibir(pos, c)) {
                System.out.println("Se han recibido los articulos exitosamente");
            }
            else {
                System.out.println("Error al recibir el articulo");
            }


        }

    }

    public static void devolverArticulo() {
        System.out.println("Introduzca la posicion del articulo o '-1' si desconoce las posiciones de estos");
        int pos = lector.nextInt();
        if(pos == -1) {
            a.toString();
            devolverArticulo();
        }
        else {
            System.out.println("Introduzca la cantidad a devolver de " + a.verArticulo(pos).getNombre() + ":");
            int c = lector.nextInt();
            if(a.devolver(pos, c)) {
                System.out.println("Se han devuelto los articulos exitosamente");
            }
            else {
                System.out.println("Error al devolver el articulo");
            }


        }

    }
    public static void main(String[] args) {
        
        menuPrincipal();
    }
}