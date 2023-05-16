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
            System.out.println("2- Buscar articulos");
            System.out.println("3- Añadir articulos");
            System.out.println("4- Recibir articulos");
            System.out.println("5- Devolver articulos");
            System.out.println("6- Volver al menu principal");
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
                        aplicarDescuentos();
                        break;
                    case 5:
                        comprar();
                        break;
                    case 6:
                        descartar();
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
        lector.nextLine();
        return res;
    }

    public static double pedirDoubleValido(String msg) {
        double res = 0.0;
        boolean salida = false;
        while(!salida) {
            System.out.println(msg);
            try {
                res = lector.nextDouble();
                salida = true;
            } catch (InputMismatchException e) {
                System.err.println("Valor no válido.Introduce un Double");
                lector.nextLine();

            }
        }
        lector.nextLine();
        return res;
    }
    public static void aplicarDescuentos() {
        int desc = pedirIntValido("Introduzca el porcentaje de descuento");
        if(desc < 0) {
            System.out.println("Introduce un valor de descuento positivo");
        }
        else if(desc >= 100) {
            System.out.println("Descuento demasiado alto");
        }
        else {
            p.setPorcentDescuento(desc);
        }
    }
    public static void añadirCarro() {
        if(p.getNombre() == "") {
            System.out.println("Introduzca el nombre del comprador:");
            String str = lector.nextLine();
            p.setNombre(str);
        }
        p.getArticulos().add(buscarArticulos("Introduzca el nombre del articulo"));

    }
    public static void comprar() {
        p.calcularSubtotal();
        p.calcularPrecioFinal();
        p.toString();
        descartar();
        

    }

    public static void descartar() {
        //sobreescribe pedido con un nuevo pedido vacio y sin nombre
        p = new Pedido("");
    }

    public static void eliminarArticulo() {
        try {
            p.eliminarArticulo(buscarArticulos("Introduzca el articulo que desa eliminar:"));
        }
        catch(NullPointerException e) {
            System.out.println("");
        }
    }

    public static void modificarCantidad() {
        Articulo art = buscarArticulos("Introduzca el articulo al que quieres modificar la cantidad");
        if(art != null) {
            int pos = p.getPosArticulo(art);
            System.out.println("Actualmente hay " + p.getCantidadAComprar(pos));
            int cantidad = pedirIntValido("introduzca la nueva cantidad: ");
            p.setCantidadAComprar(pos, cantidad);
            
        }
    }
    public static void verArticulos() {
        if(a.getArticulos().size() == 0) {
            System.out.println("No hay articulos en el almacen");
        }
        for(int i = 0; i < a.getArticulos().size(); i++) {
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
            System.out.println(artEncontrados.get(0).toString());
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
        double p = pedirDoubleValido("Introduzca el precio del articulo");
        double IVA = pedirDoubleValido("Introduzca el IVA del articulo");
        int c = pedirIntValido("Introduzca la cantidad");
        if(a.añadirArticulo(n, p, IVA, c)) {
            System.out.println("El articulo se ha añadido con éxito");
        }
        else {
            System.out.println("error al añadir el articulo");
        }
    }
    
    public static void recibirArticulo() {
        int pos = pedirIntValido("Introduzca la posicion del articulo o '-1' si desconoce las posiciones de estos");
        if(pos == -1) {
            System.out.println(a.toString());
            recibirArticulo();
        }
        else {
            if(a.verArticulo(pos) != null) {
                int c = pedirIntValido("Introduzca la cantidad a recibir de " + a.verArticulo(pos).getNombre() + ":");
                
                if(a.recibir(pos, c)) {
                    System.out.println("Se han recibido los articulos exitosamente");
                }
                else {
                    System.out.println("Error al recibir el articulo");
                }
            }


        }

    }

    public static void devolverArticulo() {
        
        int pos = pedirIntValido("Introduzca la posicion del articulo o '-1' si desconoce las posiciones de estos");
        if(pos == -1) {
            System.out.println( a.toString());   
            devolverArticulo();
        }
        else {
            if(a.verArticulo(pos) != null) {
                int c = pedirIntValido("Introduzca la cantidad a devolver de " + a.verArticulo(pos).getNombre() + ":");
                if(a.devolver(pos, c)) {
                    System.out.println("Se han devuelto los articulos exitosamente");
                }
                else {
                    System.out.println("Error al devolver el articulo");
                }
            }

        }

    }
    public static void main(String[] args) {
        
        menuPrincipal();
    }
}