package domain;

import java.util.ArrayList;

public class Book {
    //Author contains books, and all books will be stored in library, which will also store authors with their repective operations
    //include search for: if nout found, suggest to add it to the collection

    private String name;
    private Author author;

    //Not gonna be used for operations, might be used to represent non-numbers(date with A.D/B.C.E., pages with "+- x pages"....)
    private String date;
    private String pages;
    
    public Book(String name, Author author, String date, String pages){
        this.name = name;
        this.author = author;
        this.date = date;
        this.pages = pages;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setPages(String pages){
        this.pages = pages;
    }

    public String getName(){
        return this.name;
    }
    
    public String getAuthorName(){
        return this.author.getName();
    }

    public String getAuthor(){
        return this.author.toString();
    }

    public String getDate(){
        return this.date;
    }

    public String getPages(){
        return this.pages;
    }

    public boolean exists(ArrayList<Book> array){
        boolean exists = false;
        for(int i = 0; i < array.size(); i++){
            if(this.name.equalsIgnoreCase(array.get(i).getName())){
                exists = true;
            }
        }
        return exists;
    }

    //Returns -1 if not found
    public int getIndexIn(ArrayList<Book> array){
        int index = -1;
        for(Book b : array){
            if(b.getName().equalsIgnoreCase(this.name)){
                index = array.indexOf(b);
            }
        }
        return index;
    }


    public String toString(){
        return this.name + ", escrito por " + this.author.getName() + " en " + this.date + " tiene " + this.pages + " paginas.";
    }

}