package dominio;
import java.util.ArrayList;

public class Genero{
    private String nombre_genero;

    public Genero(String nombre){
        this.nombre_genero = nombre;
    }
    ArrayList<Libro> libros_genero = new ArrayList<>();
    
    public void addLibro(Libro libro){
        libros_genero.add(libro);
    }

    public void delLibro(Libro libro){
        libros_genero.remove(libro);
    }

    public String toString(){
        String res = "Libros de " + this.nombre_genero + ": ";
        for(Libro libro : libros_genero){    
            res += libro.getNombre();
            if(libros_genero.indexOf(libro) == libros_genero.size() - 2){
                res += " y ";
            }
            else if(libros_genero.indexOf(libro) == libros_genero.size() - 1){
                ;
            }
            else{res += (", ");}
        }
        return res;
    }
    public static void main(String[] args) {
        Genero filosofia = new Genero("filosofia");
        Libro lib1 = new Libro("libro1", "yo", 2, "filosofia");
        Libro lib2 = new Libro("libro2", "yo", 2, "filosofia");
        filosofia.addLibro(lib1);
        filosofia.addLibro(lib2);
        System.out.println(filosofia.toString());
    }
}