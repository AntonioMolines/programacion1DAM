package tienDAM;
import java.util.ArrayList;
public class Pedido {
    private String nombre;
    private double porcentDescuento;
    private double subTotal;
    private double precioFinal;
    private ArrayList<Articulo> IDarticulos = new ArrayList();
    private ArrayList<Articulo> articulos = new ArrayList();
    
    public Pedido() {

    }
}
