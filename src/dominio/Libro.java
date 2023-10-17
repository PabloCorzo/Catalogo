package dominio;
import java.util.ArrayList;

public class Libro{
    private String nombre;
    private String autor;
    private int fecha;
    private String genero;


    public Libro(String nombre,String autor,int fecha, String genero){
        this.nombre = nombre;
        this.autor = autor;
        this.fecha = fecha;
        this.genero = genero;
        libros.add(this);
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

    public void setFecha(int fecha){
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

    public int getFecha(){
        return this.fecha;
    }

    public String getGenero(){
        return this.genero;
    }

}