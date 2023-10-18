package dominio;
import java.util.ArrayList;
import java.util.HashMap;

public class Libro{
    private String nombre;
    private String autor;
    private String fecha;
    private String genero;
    static ArrayList <Libro> libros = new ArrayList<>();
    static HashMap <String, String> libros_autor = new HashMap<>(0, 0);
    static HashMap <String, String> libros_genero = new HashMap<>(0, 0);

    public static ArrayList <Libro> getLibros(){
        return libros;
    }

    public static HashMap <String,String> getAutores(){
        return libros_autor;
    }

    public static HashMap <String, String> getGeneros(){
        return libros_genero;
    }


    public Libro(String nombre,String autor,String fecha, String genero){
        this.nombre = nombre;
        this.autor = autor;
        this.fecha = fecha;
        this.genero = genero;
        libros_autor.put(this.nombre, this.autor);
        libros_genero.put(this.nombre, this.genero);
    }

    public String toString(){
        String result = "El libro " + this.nombre + ", escrito por " + this.autor + " en " + this.fecha + " es del genero " + this.genero ;
        return result;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getFecha(){
        return this.fecha;
    }

    public String getGenero(){
        return this.genero;
    }

}