package dominio;
import java.util.ArrayList;

public class Author{
    private String name;
    ArrayList <Book> authors_books = new ArrayList<>();

    public Author(String name, Book book){
        this.name = name;
        authors_books.add(book);
    }

    public String getName(){
        return this.name;
    }

    public void addBook(Book book){
        authors_books.add(book);
    }

    public void delBook(Book book){
        authors_books.remove(book);
    }

    public String toString(){
        String res = "books_autor del autor " + this.name + ": ";
        for(Book book : Book.getBooks()){
            res += book.getName();
            if(authors_books.indexOf(book) == authors_books.size() - 2){
                res += " y ";
            }
            else if(authors_books.indexOf(book) == authors_books.size() - 1){
                ;
            }
            else{res += (", ");}
        }
        return res; 
        } 
    
}