import java.util.Scanner;

public class   ahorcado {
    
    public static int elegirPos(String[] x) {
        int i = x.length;
        int pos = (int) (Math.random()*i);
        System.out.println(pos);
        return pos;
    }

    public static String elegirPalabra(String[] palabras) {
        int posPalabra = elegirPos(palabras);
        String palabra = palabras[posPalabra];
        return palabra;
    }

    public static void inicio(String palabra) {
        System.out.println("¡¡¡Empieza el juego del ahorcado!!!");
        int vidas = 5;
        char[] letrasUsadas = new char[20];

        menu(palabra, vidas, letrasUsadas);
    }

    public static void menu(String palabra, int vidas, char[] letrasUsadas) {
        System.out.print("Palabra: ");
        for(int i = 0; i < palabra.length(); i++) {
            for(int j = 0; j < letrasUsadas.length; j++) {
                if(palabra.charAt(i) != letrasUsadas[j] || letrasUsadas[j] == '\u0000') {
                    System.out.print(" - ");
                }
            }
        }
        System.out.println("");
        System.out.print("Vidas: " + vidas + "\t" + "letras usadas: ");
        for(int i = 0; i < letrasUsadas.length; i++) {
            System.out.print(" " + letrasUsadas[i]);
            
        }
        System.out.println();
    }


    public static void main(String[] args) {
        final String[] listaPalabras = {"PALABRA","CASA","COLINA","SILLA", "PUEBLO", "TEXTO", "HABITO", "RUINA", "TAXI", "LIBRETA", "ISLA", "CAMINO" ,"CUBO", "AJEDREZ", "MURCIELAGO","LADRON","RIO","TIO","LIO","MULLIDO","TULLIDO","RUIDO","LATIGO","MARTIR","OBISPO","VACA","BACA","TAPA","CANCION","MANUTENCION","PAPILLA","ZORRO","RELIGION","OLVIDO","TRISTE","HUERTO","PUERTO","LUEGO","VISCERAS","CARNICERO","VEGETAL","ALEGRIA","ALERGIA","TALLO","MALLA","TOSTADA","ZAMBULLIDO","CODIGO","MENDIGO","PRINCIPE","MONARCA","MARIPOSA","BUEY","INDOMITO","LOBO","DESIERTO","MANADA","NIEVE","PIE","RODILLA","MIEL","ARRIBA","HISTORIA","MATEMATICAS","ALCACHOFA","DUCHA","TRIBUTO","TRIBUNO","ALGA","ALGO","CALVO","INTEMPERIE","TEMPESTAD","ECO","HUECO","HUEVO","GALLINA","DINOSAURIO","METEORITO","RODILLO","LADRILLO","PERA","MERIENDA","CENA","KOALA","DRAGON","CERDO","GATO","PATO","TIENDA","TIENTA","TINTA","LONGEVO","VIEJO","AÑEJO","PROHIBIDO","CASCADA","ABIERTO","PROGRAMA","AÑIL","ALBAÑIL","CARMESI","MANIFESTACION","REVUELTA","VILLANO","CAMPESINO"};
        
        String palabra = elegirPalabra(listaPalabras);
        inicio(palabra);
        
        
    }
}
