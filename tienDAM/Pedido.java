package tienDAM;
import java.util.ArrayList;
public class Pedido {
    private String nombre;
    private double porcentDescuento;
    private double subTotal;
    private double precioFinal;
    private ArrayList<Integer> cantidadAComprar = new ArrayList();
    private ArrayList<Articulo> articulos = new ArrayList();
    
    public Pedido(String n) {
        nombre = n;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public ArrayList<Integer> getCantidadAComprar() {
        return cantidadAComprar;
    }

    public int getPosArticulo(Articulo art) {
        int res = -1;
        for(int i = 0; i < articulos.size(); i++) {
            if(art.getNombre() == articulos.get(i).getNombre()) {
                articulos.remove(i);
                cantidadAComprar.remove(i);
                res = i;
            }
        }
        return res;
    }

    public void setCantidadAComprar(int c) {
        
    }
    public boolean eliminarArticulo(Articulo art) {
        boolean res = false;
        int pos = getPosArticulo(art);
            if(pos != -1) {
                articulos.remove(pos);
                cantidadAComprar.remove(pos);
                res = true;
            }
        return res;
    }
}
