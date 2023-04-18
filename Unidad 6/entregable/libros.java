public class libros {
    // Atributos de la clase libro.
    // Atributos estaticos
    private static int maxlibros = 100;
    public static libros[] array_libros = new libros[maxlibros];
    private static int contlibros = 0;
    private static boolean isFull = false;
    private static boolean isEmpty = true;

    // Atributos dinamicos
    private int Stock, ISBN;
    private String Titulo, Autor, Editorial;
    // private enum Genero;**************
    private enum Genero {
        Aventura , Biografía , CienciaFiccion , Divulgación , Educación , Fantasía , Gastronomía , Historico , Ilustrado , Poesía , Romance , Terror
    }
    // Constructor
    public libros(String Titulo, String Autor, String Editorial, int ISBN, int Stock) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.ISBN = ISBN;
        this.Stock = Stock;
    }

    // Setters y Getters
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getAutor() {
        return Autor;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getStock() {
        return Stock;
    }

    // Métodos
    // Mostrar libros.
    public static void mostrarLibros() {
        if (isEmpty == true) {
            System.out.println("Ningún libro registrado.");
        } else {
            for (int cont = 0; cont < contlibros; cont++) {
                System.out.println("Título:" + array_libros[cont].Titulo);
                System.out.println("Autor:" + array_libros[cont].Autor);
                System.out.println("Editorial:" + array_libros[cont].Editorial);
                System.out.println("ISBN:" + array_libros[cont].ISBN);
                System.out.println("En Stock:" + array_libros[cont].Stock);
                System.out.println("--------------------------------");
            }
        }
    }

    public static void AgregarLibros() {
        if (isFull == false) {
            // TODO falta implementacion
            contlibros++;
        }

        if (contlibros == maxlibros) {
            isFull = true;
        }
    }
}
