package ej1;

public class Cuadrado extends Figura {

    public Cuadrado(double lado) {
        super.distancia = lado;
    }
    
    public double area() {
        return distancia * distancia;
    }
}
