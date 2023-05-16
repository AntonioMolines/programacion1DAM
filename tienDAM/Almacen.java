package tienDAM;

import java.util.ArrayList;

import ejercicio1.punto;

public class Almacen {
    
    private ArrayList<Articulo> articulos;
    private final int maxArticulos;
    

    public Almacen(int maxA) {
        maxArticulos = maxA;
        articulos = new ArrayList();
        
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public Articulo verArticulo(int indice) {
        try {
            articulos.get(indice);
            return articulos.get(indice);
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
        
    }
    public boolean añadirArticulo(Articulo a) {
        boolean exito = false;
        if(articulos.size() < maxArticulos) {
            articulos.add(a);
            exito = true;
       
        }
        return exito;
    }

    public boolean añadirArticulo(String n,double p, double iva, int c) {
        Articulo a = new Articulo(n, p, iva, c);
        return añadirArticulo(a);
    }
    
    public boolean quitarArticulo(int indice) {
        boolean exito = false;
        if(indice >= 0 && articulos.size() > indice) {
            articulos.remove(indice);
            exito = true;
        }
        return exito;
    }

    public boolean modificarPrecio(int indice, double p) {
        return articulos.get(indice).setPrecio(p);
    }

    public ArrayList<Articulo> buscarArticulo(String n) {
        ArrayList<Articulo> artEncontrados= new ArrayList();
        
        for(int i = 0; i < articulos.size(); i++) {
            if(articulos.get(i).getNombre().contains(n)) {
                artEncontrados.add(articulos.get(i));
            }
        }
        return artEncontrados;
    }

    public boolean recibir(int indice, int c) {
         try {
            return articulos.get(indice).aumentar(c);
            
        }
        catch(IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean devolver(int indice, int c) {
        try {
            return articulos.get(indice).disminuir(c);
            
        }
        catch(IndexOutOfBoundsException e) {
            return false;
        }
    }

    public String toString(){
        String res = "";
        for (int i = 0; i < articulos.size(); i++) {
            res += i + "- " + articulos.get(i).toString();
        }
        return res;
    }
}
