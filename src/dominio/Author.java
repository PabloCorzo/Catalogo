package dominio;
import java.util.ArrayList;

public class Author{
    private String name;
    ArrayList <Book> authors = new ArrayList<>();

    public Author(String name, Book book){
        this.name = name;
        authors.add(book);
    }

    public String getName(){
        return this.name;
    }

    public void addBook(Book book){
        authors.add(book);
    }

    public void delBook(Book book){
        authors.remove(book);
    }

    public String toString(){
        String res = "books_autor del autor " + this.name + ": ";
        for(Book book : Book.getBooks()){
            res += book.getName();
            if(authors.indexOf(book) == authors.size() - 2){
                res += " y ";
            }
            else if(authors.indexOf(book) == authors.size() - 1){
                ;
            }
            else{res += (", ");}
        }
        return res; 
        } 
    
}