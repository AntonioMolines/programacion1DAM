import java.util.Scanner;

public class calculadora {

    public static double suma(double a, double b) {
        return a + b;
    }

    public static double resta(double a, double b) {
        return a - b;
    }

    public static double mult(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        return a / b;
    }

    public static double areaCirc(double a, double b) {
        return Math.PI * Math.pow(a, 2);
    }

    public static double coseno(double a) {
        return Math.cos(a);
    }

    public static double seno(double a) {
        return Math.sin(a);
    }

    public static double tangente(double a) {
        return Math.tan(a);
    }

    public static int menu() {
        System.out.println("¿Que operación deseas realizar?");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Area rectangulo");
        System.out.println("6. Area triangulo equilatero");
        System.out.println("7. Area del circulo");
        System.out.println("8. Seno, coseno y tangente");
        System.out.println("9. Salir");
        Scanner lector = new Scanner(System.in);
        return lector.nextInt();

    }

    public static void operacion(int ope) {
        double a, b, resultado, resultado2, resultado3;
        Scanner lector = new Scanner(System.in);
        resultado = 0;
        resultado2 = 10000;
        resultado3 = 0;
        if(ope != 9){ 
            System.out.println("Introduzca el valor de A");
            a = lector.nextDouble();
            System.out.println("Introduzca el valor de B");
            b = lector.nextDouble();
            switch (ope) {
                case 1: 
                    resultado = suma(a, b);
                    break;
                case 2:
                    resultado = resta(a, b);
                    break;
                case 3:case 5:
                    resultado = mult(a, b);
                    break;
                case 4:
                    resultado = div(a, b);
                    break;
                case 6:
                    resultado = div(mult(a, b),2);
                    break;
                case 7:
                    resultado = areaCirc(a, b);
                    break;
                case 8:
                    resultado = seno(a);
                    resultado2 = coseno(a);
                    resultado3 = tangente(a);
                    break;
                default: 
                break;
            }
            if(resultado2 != 10000) {
                System.out.println("el resultado es: " + resultado + " " + resultado2 + " " + resultado3);
            }
            else{
                System.out.println("El resultado es: " + resultado);
            }
        }
        
        
    }

    public static void main(String[] args) {
        int op;
        do {
            op = menu();
            operacion(op);

        } while (op != 9);
    }
}
