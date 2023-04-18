//Antonio Vicente Molines Martin 1DAM
import java.util.Scanner;
public class Estudiante {

    //Atributos
    private String nombre;
    private String apellidos;
    private int anyo;
    private String DNI;
    private double notaMedia;

    //constructores

    public Estudiante(String nombre, String apellidos, int anyo, String DNI, double notaMedia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        //comprobacion año
        if(anyo <= 2009 && anyo >= 1900) {
            this.anyo = anyo;
        }
        //si el año no es válido se crea con un valor por defecto para no tener que crear otro de 0 reintroduciendo todos los datos
        else {
            this.anyo = 2009;
            System.out.println("El valor de año introducido no es válido. Se creará un estudiante nacido en 2009. Si desea puede cambiar más tarde este valor");
        }
        this.DNI = DNI;
        //comprobación nota media
        if(notaMedia <= 10 && notaMedia >= 0) {
            this.notaMedia = notaMedia;
        }
        //igual que con año, se dará un valor por defecto si no se introduce una nota válida
        else {
            this.notaMedia = 5.0;
            System.out.println("El valor de la nota media introducido no es válido. Se pondrá un 5.0 de nota por defecto que podrá modificar más tarde.");
        }
    }

    //getters y setters

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        //comprobación de año
        if(anyo <= 2009 && anyo >= 1900) {
            this.anyo = anyo;
        }
        //como ya tiene valor, en vez de asignar uno por defecto, conservará el actual
        else {
            System.out.println("Valor no válido. El año debe de estar entre 1900 y 2009.");
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        //comprobación de nota media
        if(notaMedia <= 10 && notaMedia >= 0) {
            this.notaMedia = notaMedia;
        }
        //como ya tiene valor, en vez de asignar uno por defecto, conservará el actual
        else {
            System.out.println("Valor no válido. La nota debe de estar entre 0.0 y 10.0.");
        }
    }

    //otros métodos

    public void imprimeInfo() {
        System.out.println("Alumno/a: " + nombre + " " + apellidos);
        System.out.println("DNI: " + DNI);
        int edad = 2023 - anyo;
        System.out.println("Edad: " + edad);
        System.out.println("Nota media: " + notaMedia);
    }
    

    //métodos gestión arrays

    public  static void anyadir() {
        Scanner lector =  new Scanner(System.in);
        System.out.println("Introduzca el curso (1 o 2)");
        int curso = lector.nextInt();
        anyadir(curso,0);
    }

    private static boolean anyadir(int curso,int num) {
        boolean colocado = false;
        Scanner lector =  new Scanner(System.in);
        System.out.println("Introduzca el nombre del alumno");
        String nombre = lector.nextLine();
        System.out.println("Introduzca los apellidos");
        String apellidos = lector.nextLine();
        System.out.println("Introduzca el año de nacimiento. El año debe de estar entre 1900 y 2009");
        int anyo = lector.nextInt();
        lector.nextLine();
        System.out.println("Introduzca el DNI");
        String DNI = lector.nextLine();
        System.out.println("Introduzca la nota media del alumno. Recuerde que las notas están comprendidas entre 0 y 10");
        double notaMedia = lector.nextDouble();
        for(int i = num; i < InstiAPP.maxEstudiantes && !colocado; i++) {
            //miramos en que curso hay que insertar el nuevo alumno
            switch(curso) {
                case 1:
                    //mira si hay un hueco en 1DAM
                    if(InstiAPP._1DAM[i] == null || InstiAPP._1DAM[i].nombre == "noName" ) {
                        InstiAPP._1DAM[i] = new Estudiante(nombre, apellidos, anyo, DNI, notaMedia);
                        colocado = true;
                    }
                    break;
                case 2:
                    //mira si hay un hueco en 2DAM
                    if(InstiAPP._2DAM[i] == null || InstiAPP._2DAM[i].nombre == "noName") {
                        InstiAPP._2DAM[i] = new Estudiante(nombre, apellidos, anyo, DNI, notaMedia);
                        colocado = true;
                    }
                    break;
            }
        }
        if(!colocado) {
            System.out.println("No se ha podido colocar el alumno");
        }
        return colocado;
    }

    public static void editar() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduzca el curso (1 o 2)");
        Estudiante auxEstudiante;
        int curso = lector.nextInt();
        lector.nextLine();
        boolean hayAlumnos = false;
        switch(curso) {
            case 1:
            for(int i = 0; i < InstiAPP.maxEstudiantes; i++) {
                if(InstiAPP._1DAM[i] != null && InstiAPP._1DAM[i].nombre != "noName" ) {
                    System.out.println("Alumno numero: " + i);
                    InstiAPP._1DAM[i].imprimeInfo();
                    hayAlumnos = true;
                }
            }
                break;
            case 2:
            for(int i = 0; i < InstiAPP.maxEstudiantes; i++) {
                if(InstiAPP._2DAM[i] != null && InstiAPP._2DAM[i].nombre != "noName" ) {
                    System.out.println("Alumno numero: " + i);
                    InstiAPP._2DAM[i].imprimeInfo();
                    hayAlumnos = true;
                }
            }
                break;
        }
        if(hayAlumnos) {
            System.out.println("Introduzca el numero del alumno que desea modificar");
            int numero = lector.nextInt();
            //para editar eliminamos un alumno y creamos uno nuevo, por si hay un error al añadir guardamos en un auxiliar el alumno eliminado
            switch(curso) {
                case 1:
                        auxEstudiante = (Estudiante) InstiAPP._1DAM[numero].clone();
                    break;
                case 2:
                        auxEstudiante = (Estudiante) InstiAPP._2DAM[numero].clone();
                    break;
            }
            eliminar(curso, numero);

            //comprueba si se ha podido añadir y en caso contrario devuelve el valor anterior
            if(!anyadir(curso, numero)) {
                System.out.println("No se ha podido modificar el alumno");
                switch(curso) {
                    case 1:
                            InstiAPP._1DAM[numero] = auxEstudiante;
                        break;
                    case 2:
                            InstiAPP._2DAM[numero] = auxEstudiante;
                        break;
                }
            }
        }
        else {
            System.out.println("sin alumnos para modificar, agregue uno primero");
        }
    }

    public static void eliminar() {
        Scanner lector =  new Scanner(System.in);
        System.out.println("Introduzca el curso (1 o 2)");
        int curso = lector.nextInt();
        boolean hayAlumnos = false;
        switch(curso) {
            case 1:
            for(int i = 0; i < InstiAPP.maxEstudiantes; i++) {
                if(InstiAPP._1DAM[i] != null && InstiAPP._1DAM[i].nombre != "noName" ) {
                    System.out.println("Alumno numero: " + i);
                    InstiAPP._1DAM[i].imprimeInfo();
                    hayAlumnos = true;
                }
            }
                break;
            case 2:
            for(int i = 0; i < InstiAPP.maxEstudiantes; i++) {
                if(InstiAPP._2DAM[i] != null && InstiAPP._2DAM[i].nombre != "noName" ) {
                    System.out.println("Alumno numero: " + i);
                    InstiAPP._2DAM[i].imprimeInfo();
                    hayAlumnos = true;
                }
            }
                break;
        }
        if(hayAlumnos) {
            System.out.println("Introduzca el numero del alumno que desea eliminar");
            int numero = lector.nextInt();
            eliminar(curso,numero);
        }
        else {
            System.out.println("No hay alumnos, no puede eliminar ninguno");
        }
    }

    private static void eliminar(int curso, int num) {
        //para eliminar el nombre del alumno será "noName"
        switch(curso) {
            case 1:
                    InstiAPP._1DAM[num].nombre = "noName";
                break;
            case 2:
                    InstiAPP._2DAM[num].nombre = "noName";
                break;
        }
        
    }

    public static void MostrarInfoClase() {
        Scanner lector = new Scanner(System.in);
        System.out.println("introduzca el curso a mostrar");
        int curso = lector.nextInt();
        int a = 0;
        switch(curso) {
            case 1:
                    System.out.println("la clase tiene " + "alumnos/as:");
                    for(int i = 0; i < InstiAPP.maxEstudiantes; i++) {
                        if(InstiAPP._1DAM[i] != null && InstiAPP._1DAM[i].nombre != "noName" ) {
                            System.out.println("*** Alumno/a " + a);
                            InstiAPP._1DAM[i].imprimeInfo();
                            a++;

                        }
                    }
                break;
            case 2:
                System.out.println("la clase tiene " + "alumnos/as:");
                for(int i = 0; i < InstiAPP.maxEstudiantes; i++) {
                    System.out.println("*** Alumno/a " + a);
                    if(InstiAPP._2DAM[i] != null && InstiAPP._2DAM[i].nombre != "noName" ) {
                        InstiAPP._2DAM[i].imprimeInfo();
                    }
                    a++;
                }
                break;
        }
    }
}
