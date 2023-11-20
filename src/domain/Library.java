package domain;

import java.util.ArrayList;

public class Library {

    private static ArrayList<Book>library = new ArrayList<>();
    private static ArrayList<Author>authors = new ArrayList<>();

    public int addBook(Book b){
        
        if(b.exists(library)){
            //If book already exists, it wont be added
            return -1;
        }
        else{
            library.add(b);
            return 0;
        }
    }

    public int delBook(Book b){
        if(b.exists(library)){
            library.remove(b.getIndexIn(library));
            return 0;
        }
        else{
            //Book not found
            return -1;
        }
    }

    public int addAuthor(Author a){
        if(a.exists(authors)){
            //If author already exists, it wont be added
            return -1;
        }
        else{
            authors.add(a);
            return 0;
        }
    }

    public int delAuthor(Author a){
        if(a.exists(authors)){
            authors.remove(a.getIndexIn(authors));
            return 0;
        }
        else{
            //Author not found
            return -1;
        }
    }

}