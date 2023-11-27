package domain;

import java.util.ArrayList;

public class Author{

    private String name;
    private ArrayList<Book>books;

    public Author(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }

    public String toString(){
        String s = this.name;
        if(this.books.size() == 0){
            s+= "  no tiene libros.";
        }
        else{
            s+=" tiene "+ this.books.size() + " libros: ";
            for(Book b: books){
                if(books.indexOf(b) < (books.size()-2)){
                    s += b.getName() + ", ";
                }
                else if(books.indexOf(b) == (books.size()-2)){
                    s += b.getName() + " y " + books.get(books.size()-1).getName();
                }
            }
        }
        return s;
    }
    
    public int getBookAmount(){
	return this.books.size();
    }

    public ArrayList<Book> getBooks(){
        return this.books;
    }

    public void addBook(Book b){
        this.books.add(b);
    }

    public boolean exists(ArrayList<Author> array){
        boolean exists = false;
        for(int i = 0; i < array.size(); i++){
            if(this.name.equalsIgnoreCase(array.get(i).getName())){
                exists = true;
            }
        }
        return exists;
    }

    public int getIndexIn(ArrayList<Author> array){
        int index = -1;
        for(Author a : array){
            if(a.getName().equalsIgnoreCase(this.name)){
                index = array.indexOf(a);
            }
        }
        return index;
    }

    public void rmBook(Book b){
       if(b.exists(this.books)){
        this.books.remove(b.getIndexIn(this.books));
        System.out.println("Libro borrado.");
       }
       else{
        System.out.println("No se ha encontrado el libro.");
       }
    }
}
