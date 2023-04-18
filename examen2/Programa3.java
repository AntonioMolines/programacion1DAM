//Antonio Vicente Molines Martin
import java.util.Scanner;
import java.util.Arrays;


public class Programa3 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        //pregunta el numero de corredores
        System.out.println("Indica el numero de corredores");
        int num = lector.nextInt();
        lector.nextLine();
        //inicializa el array
        String[] corredores = new String[num];
        for(int i = 0; i < corredores.length; i++) {
            System.out.println("Introduzca el nombre y la marca(minutos) del corredor: ");
            corredores[i] = lector.nextLine();
        }
        //crea un array de marcas
        int[] marcas = new int[num];
        for(int i = 0; i < marcas.length; i++) {
            //guarda la posicion del ultimo espacio
            int pos = corredores[i].lastIndexOf(" ");
            marcas[i] = Integer.parseInt(corredores[i].substring(pos + 1));
        }
        //ordena las marcas
        Arrays.sort(marcas);
        //inicializa el array ordenado
        String[] corredoresOrd = new String[num];
        //llena el array ordenado
        for(int i = 0; i < num; i++) {
            //recorre los corredores del array original buscando las marcas en orden
            for(int j = 0; j < num; j++){
                if(corredores[j].contains(String.valueOf(marcas[i]))){
                    int pos = corredores[j].lastIndexOf(" ");
                    corredoresOrd[i] = corredores[j].substring(0, pos);
                }
            }
            
        }
        //muestra los corredores ordenados
        for(int i = 0; i < num; i++) {
            System.out.println((i + 1) + ". " + corredoresOrd[i]);
        }
    }
}