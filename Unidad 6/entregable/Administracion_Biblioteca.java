import java.util.Scanner;
public class Administracion_Biblioteca {
    //Muestra el menú y selección de opción
    public static void menu(){
        System.out.println();
        System.out.println(
        "Bienvenido a la App: Administración Biblioteca.\n"
        + "\n"
        + "-----MENÚ ADMINISTRACIÓN DE LIBROS-----\n"
        + "1. Mostrar Libros\n"
        + "2. Eliminar Libros\n"
        + "3. Agregar Libros\n"
        + "4. Buscar Libros\n"
        + "\n"
        + "-----MENÚ ADMINISTRACIÓN DE USUARIOS-----\n"
        + "5. Mostrar Usuarios\n"
        + "6. Eliminar Usuarios\n"
        + "7. Agregar Usuarios\n"
        + "8. Alquilar libro a Usuario\n"
        + "9. Retirar libro a Usuario\n"
        + "\n"
        + "10. Salir.\n"
        );
    }
    //Elección de opciones
    public static int opciones(){
        Scanner lector=new Scanner(System.in);
        System.out.println("A continuación escriba el número de la operación que desee realizar:(1-10):");
        int opc = lector.nextInt();
        switch(opc){
            case 1: libros.mostrarLibros();
            break;
            
            case 2: ;
            break;

            case 3: ;
            break;

            case 4: ;
            break;

            case 5: ;
            break;

            case 6: ;
            break;
            
            case 7: ;
            break;

            case 8: ;
            break;

            case 9: ;
            break;

            case 10: return 1;
        }
        return 0;
    }

    //Main con el bucle para que se repita hasta que devuelva 1 y le paso los arrays de objetos que vamos a usar como base de datos.
    public static void main(String[] args) {
        do{
            menu();
        }while(opciones()!=1);
    }
}