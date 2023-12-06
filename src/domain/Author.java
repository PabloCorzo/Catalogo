package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Author implements Serializable{

    private String name;
    private ArrayList<Book>books;

    /**
     * Constructor
     * @param name nombre
     * construye un autor con el nombre dado
     */
    public Author(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }

    /**
     * Getter de nombre
     * @return String name
     * devuelve el nombre del autor
     */
    public String getName(){
        return this.name;
    }

    /**
     * toString
     * @return String tostring
     * devuelve un string con el nombre del autor y sus libros
     */
    public String toString(){
        String s = this.name;
        if(this.books.size() == 0){
            s+= "  no tiene libros.";
        }
        else{
            s+=" tiene "+ this.books.size() + " libros: ";
            for(Book b: books){
                s+= b.getName() + ", ";
            }
        }
        return s;
    }
    
    /**
     * Getter de cantidad de libros
     * @return int books size
     * devuelve la cantidad de libros del autor
     */
    public int getBookAmount(){
        return this.books.size();
    }
    
    /**
     * Getter de libros
     * @return ArrayList
     * devuelve los libros del autor
     */
    public ArrayList<Book> getBooks(){
        return this.books;
    }

    /**
     * addBook
     * @param b libro
     * agrega un libro al autor
     */
    public void addBook(Book b){
        this.books.add(b);
    }

    /**
     * equals
     * @param array array de autores
     * @return boolean exists
     * retorna true si el autor existe en el arraylist
     * retorna false si el autor no existe en el arraylist
     */
    public boolean exists(ArrayList<Author> array){
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
     * @param array array de autores
     * @return int index
     * retorna el indice del autor en el arraylist
     */
    public int getIndexIn(ArrayList<Author> array){
        int index = -1;
        for(Author a : array){
            if(a.getName().equalsIgnoreCase(this.name)){
                index = array.indexOf(a);
            }
        }
        return index;
    }

    /**
     * setName
     * @param name nombre del autor
     * cambia el nombre del autor
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * rmBook
     * @param b libro
     * borra un libro del autor
     */
    public void rmBook(Book b){
       if(b.exists(this.books)){
        this.books.remove(b.getIndexIn(this.books));
        System.out.println("Libro borrado.");
       }
       else{
        System.out.println("No se ha encontrado el libro.");
       }
    }

    /**
     * equals
     * @param a autor
     * @param a2 autor
     * @return boolean equals
     * retorna true si los autores son iguales
     * retorna false si los autores no son iguales
     */
    public boolean equals(Author a, Author a2){
        return this.name.equalsIgnoreCase(a.getName());
    }

    /**
     * equals
     * @param a autor
     * @return boolean equals
     * retorna true si los autores son iguales
     * retorna false si los autores no son iguales
     */
    public boolean equals(Object a){
        if(a instanceof Author){
            Author a2 = (Author) a;
            return this.name.equalsIgnoreCase(a2.getName());
        }
        else{
            return false;
        }
    }
}
