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

    public boolean eliminarArticulo(Articulo art) {
        boolean res = false;
        for(int i = 0; i < articulos.size(); i++) {
            if(art.getNombre() == articulos.get(i).getNombre()) {
                articulos.remove(i);
                cantidadAComprar.remove(i);
                res = true;
            }
        }
        return res;
    }
}
