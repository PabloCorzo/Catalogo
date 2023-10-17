package dominio;
import java.util.ArrayList;

public class LibreriaGeneros{
    ArrayList <Libro> libros_genero = new ArrayList<>();
    String[] generos = {"filosofia","narrativa","historico","terror","biografia","ficcion"};
    
    public void addLibro(Libro libro){
        libros_genero.add(libro);
    }

    public void delLibro(Libro libro){
        libros_genero.remove(libro);
    }
}