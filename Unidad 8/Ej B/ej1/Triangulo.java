package ej1;
public class Triangulo extends Figura {

    double altura;

    public Triangulo(double base, double altura) {
        this.altura = altura;
        super.distancia = base;
    }

    public double area() {
        return (altura * super.distancia) / 2;
    }
}
