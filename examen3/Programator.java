import java.util.Arrays;
import java.util.Scanner;
// Antonio Vicente Molines Martin
public class Programator{
    
    //MENU que se muestra por pantalla
    public static void menu(){
        System.out.println("PROGRAMATOR:");
        System.out.println("-----------------");
        System.out.println("1- Media valores altos");
        System.out.println("2- Cerimetro");
        System.out.println("3- Vocalimetro");
        System.out.println("4- SALIR");
    }

    //llama a la funcion correspondiente a op
    public static void operacion(int op){
        switch(op) {
            case 1:
                mediaValoresAltos();
               break;
            case 2:
                cerimetro();
                break;
            case 3:
                vocalimetro();
                break;
        }
    }

    //funcion de media valores altos
    public static void mediaValoresAltos(){
        //lama al metodo que le pide el array al usuario
        int[] arrayNums = arrayNumsUsuario();
        //variables  con los numeros mas bajos(que se iran substituyendo por los mas altos)
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int num3 = Integer.MIN_VALUE;
        //recorre el array, recalculando los mayores
        for(int i = 0; i < arrayNums.length; i++) {
            if(num1 <= arrayNums[i]) {
                num3 = num2;
                num2 = num1;
                num1 = arrayNums[i];
            }
        }
        //calcula la media
        Double media = (num1 + num2 + num3) / 3.0;
        //muestra por pantalla el resultado
        System.out.println("La media aritmética de los tres valores más altos es: " + media);
    }

    //cerimetro
    public static void cerimetro(){
        //lama al metodo que le pide el array al usuario
        int[] arrayNums = arrayNumsUsuario();
        String[] arrayNumsLetra = new String[arrayNums.length + 1];
        String[] arrayNumsLetraAux = new String[arrayNums.length + 1];
        int[][] num0 = new int[3][arrayNums.length + 1];
        for(int i = 0; i < arrayNums.length; i++) {
            //pasa los numeros a string
            arrayNumsLetra[i] = String.valueOf(arrayNums[i]);
            //elimina los 0s y los guarda en una auxiliar
           
            //guarda array nums
            num0[1][i] = arrayNums[i];
            //guarda el numero de 0s de cada posicion
            num0[0][i] = arrayNumsLetra[i].length() - arrayNumsLetraAux[i].length();
            num0[2][i] = arrayNumsLetra[i].length() - arrayNumsLetraAux[i].length();
            
        }
        //ordena el numero de 0s
        Arrays.sort(num0[0]);
        for(int i = arrayNums.length; i >= 0; i--) {
            
        }
    }

    //vocalimetro
    public static void vocalimetro(){
        Scanner lector = new Scanner(System.in);
        System.out.println("BIENVENIDOS AL VOCALÍMETRO:");
        //pide la frase al usuario
        System.out.println("Introduce una frase para comprobar la palabra con mayor número de vocales:");
        String frase = lector.nextLine();
        String aux,aux2;
        int pos0 = 0;
        int pos1 = frase.indexOf( " ");
        int masVoc = 0;
        String palabraMasVoc = frase;
        
        //mientras haya más palabras...
        while(pos0 != -1){
            int cont = 0;
            //seleciona una palabra
            if(pos1 == -1) {
                aux = frase.substring(pos0 + 1).toLowerCase();
            }
            else{
                aux = frase.substring(pos0, pos1).toLowerCase();
            }
            aux2 = frase.substring(pos1);
            //cuenta numero vocales
            cont += contar(aux, "a");
            cont += contar(aux, "e");
            cont += contar(aux, "i");
            cont += contar(aux, "o");
            cont += contar(aux, "u");
            //comprueba si tiene más vocales que la ultima con mas vocales
            if(cont > masVoc) {
                palabraMasVoc = aux;
            }
            pos0 = pos1;
            pos1 = aux2.indexOf(" ");
            
        }
        
        System.out.println("La palabra con más vocales es: " + palabraMasVoc);


    }
    
    //cuenta el numero de apariciones de supr en el string x
    public static int contar(String x, String supr) {
        int pos = 0;
        int cont = 0;
        while(pos != -1) {
            pos = x.indexOf(supr);
            if(pos != -1) {
                cont++;
                x = x.substring(pos + 1);
            }
        }
        return cont;
        
    }
    //metodo para que el usuario introduzca un array de enteros de tamaño introducido por el usuario
    public static int[] arrayNumsUsuario(){
        Scanner lector = new Scanner(System.in);
        //pide numero de datos
        System.out.println("Indica cuantos numeros quieres introducir");
        int num = lector.nextInt();
        //limpia buffer
        lector.nextLine();
        //crea el array con num espacios
        int[] arrayNums = new int[num];
        //pide los numeros
        System.out.println("introduce los numeros");
        for(int i = 0; i < arrayNums.length; i++) {
            System.out.println("Introduce el numero " + (i+1) + " : ");
            arrayNums[i] = lector.nextInt();
            //limpia buffer
            lector.nextLine();
        }
        return arrayNums;
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int a;
        //bucle en el que se puestra la informacion y se selecciona la opcion
        do{
            //muestra menu
            menu();
            //seleciona opcion
            a = lector.nextInt();
            //limpia buffer
            lector.nextLine();
            //llama a la funcion que llamara a la funcion correspondiente a la opcion
            operacion(a);
        }
        while(a != 4);
    }
}