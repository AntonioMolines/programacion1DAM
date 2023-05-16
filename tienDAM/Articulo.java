package tienDAM;

public class Articulo {
    private final String nombre;
    private double precio;
    private final double iva;
    private int cantidad;
    private final int id;
    private static int contID = 0;

    public Articulo(String n,double p, double iva, int c){
        nombre = n;
        if(p < 0) {
            precio = -p;
        }
        else {
            precio = p;
        }
        if(iva < 0) {
            this.iva = -iva;
        }
        else {
            this.iva = iva;
        }
        if(c < 0) {
            cantidad = -c;
        }
        else {
            cantidad = c;
        }
        
        id = contID;
        contID++;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public double getIVA() {
        return iva;
    }

    public int getCantidad() {
        return cantidad;
    }
    public int getID() {
        return id;
    }
    public boolean setPrecio(double p) {
        if(p > 0) {
            precio = p;
            return true;
        }
        else {
            System.out.println("El precio debe ser mayor a cero");
            return false;
        }
    }

    public boolean aumentar(int c) {
        if(c <= 0) {
            System.out.println("Para aumentar introduzca una cantidad positiva");
            return false;
        }
        cantidad += c;
        return true;
    }

    public boolean disminuir(int c) {
        if(c <= 0) {
            System.out.println("Para disminuir introduzca una cantidad positiva");
            return false;
        }
        else if(this.cantidad < c) {
            System.out.println("Cantidad a retirar insuficente. Operacion cancelada");
            return false;
        }
        cantidad -= c;
        return true;
    }
    
    public String toString() {
        return "El articulo con nombre: " + nombre + " y valor: " + precio + " tiene un IVA del: " + iva + " y hay disponible(s) " + cantidad;
    }
}
