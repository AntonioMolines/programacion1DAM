package ejercicio1;

public class programaPunto {
    public static void main(String[] args) {
        punto punto1 = new punto(5, 0);
        punto punto2 = new punto(10, 10);
        punto punto3 = new punto(-3, 7);
        System.out.println("el punto1 esta en las coordenadas: (" + punto1.getX() + " , " + punto1.getY() + " )");
        System.out.println("el punto2 esta en las coordenadas: (" + punto2.getX() + " , " + punto2.getY() + " )");
        System.out.println("el punto3 esta en las coordenadas: (" + punto3.getX() + " , " + punto3.getY() + " )");
        int dist1,dist2,dist3;
        dist1 = punto1.distancia(punto3);
        dist2 = punto2.distancia(punto3);
        dist3 = punto3.distancia(punto3);
        System.out.println(dist1 + " , distancia 2-3 " + dist2 + ", distancia 3-3 " + dist3);
    }
}
