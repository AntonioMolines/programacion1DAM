package tienDAM;

public class Articulo {
    private final String nombre;
    private double precio;
    private final double iva;
    private int cantidad;

    public Articulo(String n,double p, double iva, int c){
        nombre = n;
        precio = p;
        this.iva = iva;
        cantidad = c;
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
        if(cantidad <= 0) {
            System.out.println("Para aumentar introduzca una cantidad positiva");
            return false;
        }
        cantidad += c;
        return true;
    }

    public boolean disminuir(int c) {
        if(cantidad <= 0) {
            System.out.println("Para disminuir introduzca una cantidad positiva");
            return false;
        }
        cantidad -= c;
        return true;
    }

    public String toString() {
        return "El articulo con nombre: " + nombre + " y valor: " + precio + " tiene un IVA del: " + iva + " y hay disponible(s) " + cantidad;
    }
}
