package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable{
    //Author contains books, and all books will be stored in library, which will also store authors with their repective operations
    //include search for: if nout found, suggest to add it to the collection

    private String name;
    private Author author;

    //Not gonna be used for operations, might be used to represent non-numbers(date with A.D/B.C.E., pages with "+- x pages"....)
    private String date;
    private String pages;
    
    /**
     * Constructor
     * @param name nombre
     * @param author autor
     * @param date fecha
     * @param pages paginas
     * construye un libro con los parametros dados
     */
    public Book(String name, Author author, String date, String pages){
        this.name = name;
        this.author = author;
        this.date = date;
        this.pages = pages;
    }

    /**
     * Setter de nombre
     * @param name nombre
     * cambia el nombre del libro
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Setter de autor
     * @param author autor
     * cambia el autor del libro
     */
    public void setAuthor(Author author){
        this.author = author;
    }

    /**
     * Setter de fecha
     * @param date fecha
     * cambia la fecha del libro
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     * Setter de paginas
     * @param pages paginas
     * cambia las paginas del libro
     */
    public void setPages(String pages){
        this.pages = pages;
    }

    /**
     * Getter de nombre
     * @return String name
     * retorna el nombre del libro
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Getter de autor
     * @return String nombre del autor
     * retorna el nombre del autor del libro
     */
    public String getAuthorName(){
        return this.author.getName();
    }

    /**
     * Getter de autor
     * @return Author autor
     * retorna el autor del libro
     */
    public Author getAuthor(){
        return this.author;
    }

    /**
     * Getter de fecha
     * @return String date
     * retorna la fecha del libro
     */
    public String getDate(){
        return this.date;
    }

    /**
     * Getter de paginas
     * @return String 
     * retorna las paginas del libro
     */
    public String getPages(){
        return this.pages;
    }

    /**
     * Equals
     * @param array array de libros
     * @return boolean exists
     * retorna true si el libro existe en el arraylist
     * retorna false si el libro no existe en el arraylist
     */
    public boolean exists(ArrayList<Book> array){
        boolean exists = false;
        for(int i = 0; i < array.size(); i++){
            if(this.name.equalsIgnoreCase(array.get(i).getName())){
                exists = true;
            }
        }
        return exists;
    }

    /**
     * getIndexIn
     * @param array arraylist de libros
     * @return int index
     * retorna el indice del libro en el arraylist
     * retorna -1 si el libro no existe en el arraylist
     */
    public int getIndexIn(ArrayList<Book> array){
        int index = -1;
        for(Book b : array){
            if(b.getName().equalsIgnoreCase(this.name)){
                index = array.indexOf(b);
            }
        }
        return index;
    }

    /**
     * toString
     * @return String tostring
     * retorna un string con la informacion del libro
     */
    public String toString(){
        return this.name + ", escrito por " + this.author.getName() + " en " + this.date + " tiene " + this.pages + " paginas.";
    }

}