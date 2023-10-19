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

public class Interface2{
    public static boolean exe(String option) {
        if(option.equalsIgnoreCase("editar")){
            String old_name = JOptionPane.showInputDialog(null, "Introduzca el nombre del libro a editar", "Nuevo libro", 0);
            String val_to_edit = JOptionPane.showInputDialog("Que quiere editar?");
            if(val_to_edit.equalsIgnoreCase("titulo")){
             String new_name = JOptionPane.showInputDialog(null, "Introduzca el nuevo titulo", "Editor", 0);
             boolean changed = false;
                for(Book book :Book.getBooks()){
                    if(book.getName().equalsIgnoreCase(old_name)){
                        book.setName(new_name);
                        changed = true;
                    }
                }
                if(changed){JOptionPane.showMessageDialog(null, "Titulo cambiado", "Editado correctamente", 0, null);}
                else{JOptionPane.showMessageDialog(null, "No se encontro el libro", "Error", 0, null);}
            }
            else if(val_to_edit.equalsIgnoreCase("autor")){
                String new_author = JOptionPane.showInputDialog(null, "Introduzca el autor", "Editor", 0);
                Book.getAuthors().put(option, new_author);
            }
            else if (val_to_edit.equalsIgnoreCase("genero")){
                String new_genre = JOptionPane.showInputDialog(null, "Introduzca el genero", "Editor", 0);
                boolean genre_exists = false;
                for(String genre : GenreLibrary.getGenres()){
                    if(genre.equalsIgnoreCase(new_genre)){
                        genre_exists = true;
                    }
                }
                if(genre_exists){
                    Book.getGenres().put(old_name, new_genre);
                }
            }
            else{JOptionPane.showMessageDialog(null, "Metodo introducido incorrecto", "error", 0, null);}
                return true;
        }
        else if(option.equalsIgnoreCase("mostrar")){
            // mostrar n shi
            return true;
        }
        else if (option.equalsIgnoreCase("salir")){
            return false;
        }
        else{
            JOptionPane.showMessageDialog(null, "Metodo introducido incorrecto", "error", 0, null);
            return false;
        }
    }

    public static void addBook(){
        String book_name = JOptionPane.showInputDialog(null, "Introduzca el nombre del libro", "Nuevo libro", 0);
        String book_author = JOptionPane.showInputDialog(null, "Introduzca el autor del libro", "Nuevo libro", 0);
        String book_date = JOptionPane.showInputDialog(null, "Introduzca la fecha del libro", "Nuevo libro", 0);
        String book_genre = JOptionPane.showInputDialog(null, "Introduzca el genero del libro", "Nuevo libro", 0);
        Book.getBooks().add(new Book(book_name,book_author,book_date,book_genre));
        Book.getAuthors().put(book_name,book_author);
        Book.getGenres().put(book_name, book_genre);
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

    // public static void editBook(){
    //     String val_to_edit = JOptionPane.showInputDialog("Que quiere editar?");
    //     if(val_to_edit.equalsIgnoreCase("titulo")){
    //         String new_name = JOptionPane.showInputDialog(null, "Introduzca el titulo", "Editor", 0); 
    //         Book.getBooks().remove(old_name);
    //     }
    //     else if(val_to_edit.equalsIgnoreCase("autor")){
    //         String new_author = JOptionPane.showInputDialog(null, "Introduzca el autor", "Editor", 0);
    //         Book.getAuthors().put(option, new_author);
    //     }
    //     else if (val_to_edit.equalsIgnoreCase("genero")){
    //         String new_genre = JOptionPane.showInputDialog(null, "Introduzca el genero", "Editor", 0);
    //         boolean genre_exists = false;
    //         for(String genre : GenreLibrary.getGenres()){
    //             if(genre.equalsIgnoreCase(new_genre)){
    //                 genre_exists = true;
    //             }
    //         }
    //         if(genre_exists){
    //             Book.getGenres().put(old_name, new_genre);
    //         }
    //     }
    //     else{JOptionPane.showMessageDialog(null, "Metodo introducido incorrecto", "error", 0, null);}

    // }


    public static void showAuthors(){
        //filtrar arraylist libros para oranizar los autores existentes y sus libros
        //escoger autor
    }

    public static void showGenres(){
        System.out.println(Book.getGenres()); 
        //escoger genero
    }
}