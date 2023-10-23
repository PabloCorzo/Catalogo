package interfaz;

import java.util.Scanner;
import java.io.File;
import javax.swing.JOptionPane;
import dominio.*;

public class Interface {
    public static boolean exe(String option){
        if(option.equalsIgnoreCase("editar")){
            String old_name = JOptionPane.showInputDialog(null, "Introduzca el nombre del libro a editar", "Nuevo libro", 0);
            boolean book_exists = false;
            for(Book book : Book.getBooks()){
                if(book.getName().equalsIgnoreCase(old_name)){
                    book_exists = true;
                }
            }
            if(book_exists){
                String val_to_edit = JOptionPane.showInputDialog("Que quiere editar?");
                if(val_to_edit.equalsIgnoreCase("titulo")){
                    String new_name = JOptionPane.showInputDialog(null, "Introduzca el nuevo titulo", "Editor", 0);
                    for(Book book : Book.getBooks()){
                        if(book.getName().equalsIgnoreCase(old_name)){
                            book.setName(new_name);
                            JOptionPane.showMessageDialog(null, "Titulo cambiado", "Editado correctamente", 0, null);
                        }
                    }

                }
                else if(val_to_edit.equalsIgnoreCase("autor")){
                    String new_author = JOptionPane.showInputDialog(null, "Introduzca el autor", "Editor", 0);
                    Book.getAuthors().put(option, new_author);
                }
                else if(val_to_edit.equalsIgnoreCase("genero")){
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

            }
            return true;
        }
        else if(option.equalsIgnoreCase("mostrar")){
            //mostrar n shi
            return true;
        }
        else if(option.equalsIgnoreCase("salir")){
            return false;
        }
        else if(option.equalsIgnoreCase("agregar")){
            String book_name = JOptionPane.showInputDialog(null, "Introduzca el nombre del libro", "Nuevo libro", 0);
            String book_author = JOptionPane.showInputDialog(null, "Introduzca el autor del libro", "Nuevo libro", 0);
            String book_date = JOptionPane.showInputDialog(null, "Introduzca la fecha del libro", "Nuevo libro", 0);
            String book_genre = JOptionPane.showInputDialog(null, "Introduzca el genero del libro", "Nuevo libro", 0);
            Book.getBooks().add(new Book(book_name,book_author,book_date,book_genre));
            Book.getAuthors().put(book_name,book_author);
            Book.getGenres().put(book_name, book_genre);
            System.out.println(Book.getAuthors());
            return true;
        }
        else if(option.equalsIgnoreCase("borrar")){
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
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Metodo introducido incorrecto", "error", 0, null);
            return false;
        }
    }
}
