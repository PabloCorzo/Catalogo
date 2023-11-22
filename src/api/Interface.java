package api;
import domain.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface implements Serializable{

    private ArrayList<Book>library;
    private ArrayList<Author>authors;

    public Interface(){
        this.library = new ArrayList<>();
        this.authors = new ArrayList<>();
        ObjectInputStream obj;
        File file = new File("books.txt");
        File file2 = new File("authors.txt");
        try{
            obj = new ObjectInputStream(new FileInputStream(file));
            try{
                this.library = (ArrayList<Book>)obj.readObject();
            }catch(Exception e){
                //SHOULD BE POP-UP
                System.out.println("Libros no leidos.");
            }
            obj.close();
            obj = new ObjectInputStream(new FileInputStream(file2));
            try{
                this.authors = (ArrayList<Author>)obj.readObject();
            }catch(Exception e){
                //SHOULD BE POP-UP
                System.out.println("Autores no leidos.");
            }
            obj.close();
            //SHOULD BE POP-UP
            System.out.println("Leido.");
        }catch(Exception e){
            //SHOULD BE POP-UP
            System.out.println("NO LEIDO: " + e);
        }
    }

    // MIGHT NOT BE USED, BUTTONS INSTEAD
    // public String getInput(String prompt);
}
