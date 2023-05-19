package ej1;

public class Circulo extends Figura{

    public Circulo(double radio) {
        super.distancia = radio;
    }
    public double area() {
        return Math.PI * Math.pow(distancia, 2);
    }
}
