//Antonio Vicente Molines Martin
import java.util.Scanner;
import java.util.Arrays;


public class Programa2 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //pide los valores F y C
        System.out.println("Introduce el tamaño de filas: ");
        int f = lector.nextInt();
        lector.nextLine();
        System.out.println("Introduce el tamaño de columnas: ");
        int c = lector.nextInt();
        //crea la matriz
        int[][] matriz = new int[f][c];
        //rellena la matriz y la muestra
        for(int fil = 0; fil < matriz.length; fil++) {
            for(int col = 0; col < matriz[fil].length; col++) {
                int num = (int)(Math.random() * 11 - 5);
                matriz[fil][col] = num;
                //agrega un espacio extra a numeros no negativos, para que la matriz se muestre cuadrada
                if(num >= 0) {
                    System.out.print(" ");
                }
                System.out.print(matriz[fil][col] + " ");
            }
            System.out.println();
        }
        //inicializa los arrays con las sumas
        int[] sumFil = new int[f];
        int[] sumCol = new int[c];
        int sumTot = 0;

        //calcula las sumas
        for(int fil = 0; fil < matriz.length;fil++) {
            for(int col = 0; col < matriz[fil].length; col++) {
                sumCol[col] += matriz[fil][col];
                sumFil[fil] += matriz[fil][col];
                sumTot += matriz[fil][col];
            }
        }
        //muestra el resultado
        for(int i = 0; i < sumFil.length;i++) {
            System.out.println("Fila " + (i + 1) +": " + sumFil[i]);
        }
        for(int i = 0; i < sumCol.length;i++) {
            System.out.println("Columna " + (i + 1) +": " + sumCol[i]);
        }
        System.out.println("Suma total: " + sumTot);
    }
}