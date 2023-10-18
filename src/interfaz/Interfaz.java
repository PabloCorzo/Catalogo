package interfaz;
import javax.swing.JOptionPane;
import dominio.*;
/* METODOS POR HACER:
ESCOGER LIBRERIA
EDITAR LIBRO
ADD LIBRO
REMOVE LIBRO
REMOVE AUTOR IF LIBROS DEL AUTOR ES 0
hacer sub arraylists por autor y genero
iterar arraylist de libros para filtrar por autores y por genero
encontrar autores y generos repetidos al iterar / dificultad al 
 */
//HASHMAPS PARA BUSQUEDA EN LA BIBLIOTECA Y ARRAYLIST PARA EL TOSTRING
// HASHMAP AUTORES
//key libro value autor
//HASHMAP GENEROS
// key libro value genero

public class Interfaz{
    public static void ejecutar() {
        String name = JOptionPane.showInputDialog("Enter your name: ");
    }

    public static void addLibro(){
        String libro_autor = JOptionPane.showInputDialog(null, "Introduzca el autor del libro", "Nuevo libro", 0);
        String libro_fecha = JOptionPane.showInputDialog(null, "Introduzca la fecha del libro", "Nuevo libro", 0);
        String libro_genero = JOptionPane.showInputDialog(null, "Introduzca el genero del libro", "Nuevo libro", 0);
        String libro_nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre del libro", "Nuevo libro", 0);
        dominio.Libro.getLibros().add(new Libro(libro_nombre,libro_autor,libro_fecha,libro_genero));
        dominio.Libro.getAutores().put(libro_nombre,libro_autor);
    }
    public static void mostrarAutores(){
        //filtrar arraylist libros para oranizar los autores existentes y sus libros
        //escoger autor
    }

    public static void mostrarGeneros(){
        //mostrar generos 
        //escoger genero
    }
}