public class Persona {
    private int edad;
    private String nombre, apellidos, dni;

    public Persona() {
        this(0,"Pepe","Gonzalez","23130876R");
    }
    public Persona(int edad, String nombre, String apellidos, String dni) {
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public boolean esMayorEdad() {
        return edad > 17;
    }

}