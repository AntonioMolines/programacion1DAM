import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        Scanner lector = new Scanner(System.in);
        System.out.println("introduzca el nombre de la persona 1");
        p1.setNombre(lector.nextLine());
        System.out.println("Introduzca el apellido de " + p1.getNombre());
        p1.setApellidos(lector.nextLine());
        System.out.println("introduzca la edad de " + p1.getNombre() + " " + p1.getApellidos());
        p1.setEdad(lector.nextInt());
        System.out.println("introduzca el dni de " + p1.getNombre() + " " + p1.getApellidos());
        p1.setDni(lector.nextLine());


        System.out.println("introduzca el nombre de la persona 2");
        p2.setNombre(lector.nextLine());
        System.out.println("Introduzca el apellido de " + p2.getNombre());
        p2.setApellidos(lector.nextLine());
        System.out.println("introduzca la edad de " + p2.getNombre() + " " + p2.getApellidos());
        p2.setEdad(lector.nextInt());
        System.out.println("introduzca el dni de " + p2.getNombre() + " " + p2.getApellidos());
        p2.setDni(lector.nextLine());

        
    }
}
