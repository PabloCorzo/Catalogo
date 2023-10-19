package interfaz;
import javax.swing.JOptionPane;
import dominio.*;
/* METODOS POR HACER:
ESCOGER LIBRERIA
EDITAR LIBRO
REMOVE AUTOR IF LIBROS DEL AUTOR ES 0
 */
//HASHMAPS PARA BUSQUEDA EN LA BIBLIOTECA Y ARRAYLIST PARA EL TOSTRING
// HASHMAP AUTORES
//key libro value autor
//HASHMAP GENEROS
// key libro value genero7

public class Interface{
    public static void exe() {
        String option = JOptionPane.showInputDialog("Editar, mostrar o salir?");
        if(option.equalsIgnoreCase("editar")){
            
        }
        else if(option.equalsIgnoreCase("mostrar")){

        }
        else if (option.equalsIgnoreCase("salir")){

        }
        else{JOptionPane.showMessageDialog(null, "Metodo introducido incorrecto", "error", 0, null);}
    }

    public static void addBook(){
        String libro_autor = JOptionPane.showInputDialog(null, "Introduzca el autor del libro", "Nuevo libro", 0);
        String libro_fecha = JOptionPane.showInputDialog(null, "Introduzca la fecha del libro", "Nuevo libro", 0);
        String libro_genero = JOptionPane.showInputDialog(null, "Introduzca el genero del libro", "Nuevo libro", 0);
        String libro_nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre del libro", "Nuevo libro", 0);
        Book.getBooks().add(new Book(libro_nombre,libro_autor,libro_fecha,libro_genero));
        Book.getAuthors().put(libro_nombre,libro_autor);
        Book.getGenres().put(libro_nombre, libro_genero);
        System.out.println(Book.getAuthors());
    }

    public static void delBook(){
        String book_to_del = JOptionPane.showInputDialog(null, "Introduzca el nombre del libro a borrar", "Borrar libro", 0);
        Book.getAuthors().remove(book_to_del);
        Book.getGenres().remove(book_to_del);
        for(Book libro : Book.getBooks()){
            if(libro.getName().equalsIgnoreCase(book_to_del)){
                Book.getBooks().remove(libro);
            }
            else{
                ;
            }
        }
    }

    public static void editBook(){
        String option = JOptionPane.showInputDialog("Que quiere editar?");
        if(option.equalsIgnoreCase("titulo")){
            
        }
        else if(option.equalsIgnoreCase("autor")){

        }
        else if (option.equalsIgnoreCase("genero")){

        }
        else{JOptionPane.showMessageDialog(null, "Metodo introducido incorrecto", "error", 0, null);}

    }


    public static void showAuthors(){
        //filtrar arraylist libros para oranizar los autores existentes y sus libros
        //escoger autor
    }

    public static void showGenres(){
        System.out.println(Book.getGenres()); 
        //escoger genero
    }
}