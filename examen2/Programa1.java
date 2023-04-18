//Antonio Vicente Molines Martin
import java.util.Scanner;
import java.util.Arrays;


public class Programa1 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //inicia las cadenas
        //nombre
        System.out.println("Introduzca el nombre y dos apellidos sin saltos de linea:");
        String nombreCompleto = lector.nextLine();
        //DNI
        System.out.println("Introduzca DNI con letra:");
        String DNI = lector.nextLine();
        //pregunta numero de productos
        System.out.println("Indica el numero de productos");
        int numProd = lector.nextInt();
        //crea arrays de precios y nombres
        int[] precioProd = new int[numProd];
        String[] nombreProd = new String[numProd];
        for(int i = 0; i < numProd; i++) {
            //introduce los valores de los productos(precio y nombre)
            lector.nextLine();
            System.out.println("Introduce el nombre del producto numero: " + i);
            nombreProd[i] = lector.nextLine();
            System.out.println("Introduzca el precio de: " + nombreProd[i]);
            precioProd[i] = lector.nextInt();
        }
        //crea el codigo del cliente
        //1 Busca los espacios;
        int espacio1 = nombreCompleto.indexOf((" "));
        int espacio2 = nombreCompleto.lastIndexOf((" "));
        //nombre + letra apellidos
        String codigoCliente = nombreCompleto.substring(0, espacio1);
        codigoCliente += nombreCompleto.charAt(espacio1 + 1);
        codigoCliente += nombreCompleto.charAt(espacio2 + 1);
        //agrega DNI
        codigoCliente += DNI.substring(0,7);
        //empieza a imprimir el ticket
        System.out.println("TICKET - TIENDA DEL BARRIO");
        System.out.println("Cliente: " + codigoCliente);
        System.out.println("-------------------");
        //inicializa el subtotal y los productos mas caros y baratos
        double prodCaro = 0;
        double prodBarato = 0;
        double subtotal = 0;
        //muestra la lista de productos y calcula el subtotal
        for(int i = 0; i < numProd; i++) {
            System.out.println((i+1) + ". " + nombreProd[i] + " " + precioProd[i] + " €");
            subtotal += precioProd[i];
            if(prodCaro < precioProd[i]) {
                prodCaro = precioProd[i];
            }
            if(prodBarato == 0 || precioProd[i] < prodBarato) {
                prodBarato = precioProd[i];
            }
        }
        //muestra subtotal
        System.out.println("-------------------");
        System.out.println("Subtotal: " + subtotal + " €");
        //calcula descuentos
        int descuento = 3;
        if(subtotal >= 50) {
            descuento += 5;
        }
        if(prodCaro > 99 ) {
            descuento += 9;
        }
        else if(prodCaro > 66) {
            descuento += 6;
        }
        if((prodCaro - prodBarato) > 50) {
            descuento +=10;
        }
        //muestra descuento
        System.out.println("Descuento: " + descuento + "%");
        //precio de descuento
        double aDescontar = (subtotal * descuento) / 100;
        System.out.println("Descuento: " + aDescontar);
        System.out.println("Precio a pagar: " + (subtotal - aDescontar) + " €");
    }
}