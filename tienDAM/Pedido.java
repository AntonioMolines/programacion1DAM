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

    public int getCantidadAComprar(int index) {
        try {
            return cantidadAComprar.get(index);
        }
        catch(IndexOutOfBoundsException e) {
            return 0;
        }
        
    }
    public void setPorcentDescuento(double pD) {
        porcentDescuento = pD;
    }
    

    public int getPosArticulo(Articulo art) {
        int res = -1;
        for(int i = 0; i < articulos.size(); i++) {
            if(art.getNombre() == articulos.get(i).getNombre()) {
                res = i;
            }
        }
        return res;
    }

    public void setCantidadAComprar(int index,int c) {
        cantidadAComprar.set(index, c);
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

    public String toString() {
        String res = "Cliente: " + nombre + ": \n";
        res += "- - - - - - - - - - - - - - - - - - - -";
        for(int i = 0; i < articulos.size();i++) {
            res += ( i + 1 ) + " - " + articulos.get(i).getNombre() + " Cantidad:" + cantidadAComprar.get(i) + " IVA del: " + articulos.get(i).getIVA() + "\n";
        }
        res += "- - - - - - - - - - - - - - - - - - - -";
        res += "Subtotal: " + subTotal + "\n" + "Descuento: " + porcentDescuento + "% \n";
        res += "- - - - - - - - - - - - - - - - - - - -";
        res += "Total: " + precioFinal;
        res += "- - - - - - - - - - - - - - - - - - - -";
        res += "Gracias por su compra, vuelva pronto";
        return res;
    }

    public void calcularSubtotal() {
        double sum = 0;
        for(int i = 0; i < articulos.size(); i++) {
            sum += articulos.get(i).getIVA() * articulos.get(i).getPrecio() * cantidadAComprar.get(i) / 100;
        }
        subTotal = sum;
    }

    public void calcularPrecioFinal() {
        precioFinal = subTotal * (1 - porcentDescuento / 100);
        
    }
}
