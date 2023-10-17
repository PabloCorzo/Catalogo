package dominio;
import java.util.ArrayList;

public class Escritor{
    private String nombre;
    ArrayList <Libro> libros_autor = new ArrayList<>();
    ArrayList <Libro> libros = new ArrayList<>();

    public Escritor(String nombre, Libro libro){
        this.nombre = nombre;
        libros_autor.add(libro);
    }

    public String getNombre(){
        return this.nombre;
    }

    public void addLibro(Libro libro){
        libros_autor.add(libro);
    }

    public void delLibro(Libro libro){
        libros_autor.remove(libro);
    }

    public String toString(){
        String res = "libros_autor del autor " + this.nombre + ": ";
        for(Libro libro : libros){
            res += libro.getNombre();
            if(libros_autor.indexOf(libro) == libros_autor.size() - 2){
                res += " y ";
            }
            else if(libros_autor.indexOf(libro) == libros_autor.size() - 1){
                ;
            }
            else{res += (", ");}
        }
        return res; 
        } 
    
    // public static void main(String[] args) {
    //     Libro lib1 = new Libro("libro1", "yo", 2, "filosof");
    //     Libro lib2 = new Libro("libro2", "yo", 2, "filosofia");
    //     Escritor autor = new Escritor("yo", lib1);
    //     autor.addLibro(lib2);
    //     System.out.println(autor.toString());
    // }
}