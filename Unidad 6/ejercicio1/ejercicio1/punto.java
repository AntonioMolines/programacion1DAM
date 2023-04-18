package ejercicio1;

public class punto{
    private int coordX;
    private int coordY;

    public int getX() {
        return coordX;
    }
    public int getY() {
        return coordY;
    }
    public void setX(int x) {
        coordX = x;
    }
    public void setY(int y) {
        coordY = y;
    }

    public punto(int x, int y) {
        coordX = x;
        coordY = y;
    }

    public punto() {
        coordX = 0;
        coordY = 0;
    }

    public void moverA(int x,int y) {
        coordX = x;
        coordY = y;
    }

    public void moverA(int x) {
        coordX = x;
        coordY = x;
    }

    public void moverX(int x) {
        coordX = x;
    }

    public void moverY(int y) {
        coordY = y;
    }

    public void desplazar(int x, int y) {
        coordX += x;
        coordY += y;
    }

    public void desplazar(int x) {
        coordX += x;
        coordY += x;
    }

    public void desplazarX(int x) {
        coordX += x;
    }

    public void desplazarY(int y) {
        coordY += y;
    }

    public void imprime() {
        System.out.println("el punto esta en las coordenadas: (" + coordX + " , " + coordY + " )");
    }

    public int distancia(punto p) {
        return (int) Math.sqrt((p.getX() - this.coordX)*(p.getX() - this.coordX) + (p.getY() - this.coordY) * (p.getY() - this.coordY) );
    }
}