package tienDAM;

import java.util.Scanner;

public class TienDAM {

    public static void menuPrincipal() {
        Scanner lector = new Scanner(System.in);
        int op = 0;
        while(op != 3) {
            System.out.println("Menu de TienDAM: ");
            System.out.println("Seleccione una opción:");
            System.out.println("1- Almacen");
            System.out.println("2- Pedido");
            System.out.println("3- Salir");
            op = lector.nextInt();
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
        Scanner lector = new Scanner(System.in);
        while(op != 6) {
            System.out.println("Menu del almacen de TienDAM");
            System.out.println("Seleccione una opción:");
            System.out.println("1- Ver articulos");
            System.out.println("2- buscar articulos");
            System.out.println("3- añadir articulos");
            System.out.println("4- recibir articulos");
            System.out.println("5- Devolver articulos");
            System.out.println("6- volver al menu principal");
            op = lector.nextInt();
            switch (op) {
                case 1:

                    break;
                case 2:
                
                    break;
            }
        }
    }

    public static void menuPedido() {

    }
    Almacen a = new Almacen(50);
    public static void main(String[] args) {
        menuPrincipal();
    }
}