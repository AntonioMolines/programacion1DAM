package tienDAM;

import java.util.ArrayList;

import ejercicio1.punto;

public class Almacen {
    
    private ArrayList<Articulo> articulos;
    private final int maxArticulos;
    private int indice;
    

    public Almacen(int maxA) {
        maxArticulos = maxA;
        articulos = new ArrayList();
        indice = 0;
        
    }

    public int getIndice() {
        return indice;
    }

    public Articulo verArticulo(int indice) {
        return articulos.get(indice);
    }
    public boolean añadirArticulo(Articulo a) {
        boolean exito = false;
        if(articulos.size() < maxArticulos) {
            articulos.add(indice, a);
            exito = true;
            indice++;
        }
        return exito;
    }

    public boolean añadirArticulo(String n,double p, double iva, int c) {
        Articulo a = new Articulo(n, p, iva, c);
        return añadirArticulo(a);
    }
    
    public boolean quitarArticulo(int indice) {
        boolean exito = false;
        if(articulos.size() > indice) {
            exito = true;
            articulos.remove(indice);
            indice--;
        }
        return exito;
    }

    public boolean modificarPrecio(int indice, double p) {
        return articulos.get(indice).setPrecio(p);
    }

    public ArrayList<Integer> buscarArticulo(String n) {
        int[]pos = new int[maxArticulos];
        int f = 0;
        for(int i = 0; i < indice; i++) {
            if(articulos.get(i).getNombre().contains(n)) {
                pos[f] = i;
                f++;
            }
        }
        return pos;
    }

    public boolean recibir(int indice, int c) {
        return articulos.get(indice).aumentar(c);
    }

    public boolean devolver(int indice, int c) {
        return articulos.get(indice).disminuir(c);
    }
}
