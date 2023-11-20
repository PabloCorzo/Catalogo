package interfaz;

//import java.util.Scanner;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;
import dominio.*;

public class Interface2 implements Serializable{

    ArrayList<Book> books = new ArrayList<>();

    public Interface2(){
        ObjectInputStream obj;
        File file = new File("books.txt");
        try{
            obj = new ObjectInputStream(new FileInputStream(file));
            books = (ArrayList<Book>)obj.readObject();
            obj.close();
            JOptionPane.showMessageDialog(null, "Leido");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No leido");
            books = new ArrayList<>();
        }
    }
    public boolean run(String option){
        //Mostrar generos
        //Mostrar autores
        //Editar nombre
        //Editar genero 
        //Editar autor
        //Editar fecha
        String[] split = option.split(" ");
        if(split[0].equalsIgnoreCase("salir")){
            ObjectOutputStream obj;
            File file = new File("books.txt");
            try{
                obj = new ObjectOutputStream(new FileOutputStream(file));
                obj.writeObject(books);
                obj.close();
                JOptionPane.showMessageDialog(null, "Guardado");
                } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al guardar");
                System.out.println(e);
                };
            return false;
        }
        if(split[0].equalsIgnoreCase("Agregar")){
            //Gets values and creates object to add
            String name = split[1];
            String author = split[2];
            String date = split[3];
            String genre = split[4];
            Book b = new Book(name, author, date, genre);
            Book.getBooks().add(b);

            JOptionPane.showMessageDialog(null, "Libro agregado", "Added", 0);
        }
        if (split[0].equalsIgnoreCase("Borrar")){
            //Gets value and creates object to search for
            String name = split[1];
            Book b = new Book(name, null, null, null);
            
            boolean exists = b.exists();
            //Book is found
            if(exists){
                Book.getBooks().remove(b);
                JOptionPane.showMessageDialog(null, "Libro borrado", "Borrado", 0);
            }

            //Book is not found
            
            //
            //BUGGED - DOESNT DETECT OBJECT AFTER IT HAS BEEN SAVED
            //
            else if(exists == false){
                JOptionPane.showMessageDialog(null, "Libro no encontrado", "ERROR", 0);
            }

            //This should never execute
            else{JOptionPane.showMessageDialog(null, "Este mensaje no debe ser accesible.");}
        }

        //Edit
        if(split[0].equalsIgnoreCase("Editar")){
            //Edits name
            if(split[1].equalsIgnoreCase("Nombre")){

            }
            //Edits author
            else if(split[1].equalsIgnoreCase("Autor")){

            }
            //Edits date
            else if(split[1].equalsIgnoreCase("Fecha")){

            }
            //Edits genre
            else if(split[1].equalsIgnoreCase("Genero")){

            }
        }

        //Show either genres or authors
        //Type a genre or an author to show books related to it
        if(split[0].equalsIgnoreCase("Mostrar")){
            //If sorted by author
            if(split[1].equalsIgnoreCase("Autores")|| split[1].equalsIgnoreCase("Autor")){

            }

            //If sorted by genre
            else if(split[1].equalsIgnoreCase("Generos")|| split[1].equalsIgnoreCase("Genero")){
                
            }
        }

        return true;
    }
}