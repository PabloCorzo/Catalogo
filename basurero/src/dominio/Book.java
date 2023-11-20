package dominio;
import java.util.ArrayList;
// import java.util.HashMap;

public class Book{
    private String name;
    private Author author;
    private String date;
    private String genre;
    static ArrayList <Book> books = new ArrayList<>();
    static ArrayList <Author> authors = new ArrayList<>();
    static ArrayList <String> genres = new ArrayList<>();
    

    public static ArrayList <Book> getBooks(){
        return books;
    }

    public static  ArrayList <Author>  getAuthors(){
        return authors;
    }

    public static ArrayList <String>  getGenres(){
        return genres;
    }

    public Book(String name,String author,String date, String genre){
        this.name = name;
        Author auth = new Author(author,this);
        this.author = auth;
        this.date = date;
        this.genre = genre;
        authors.add(this.author);
        genres.add(this.genre);
    }

    public boolean exists(){
        //BUGGED
        boolean exists = false;
        for(Book b : books){
            if(b.name.equalsIgnoreCase(this.name)){
                exists = true;

                //Sets this equal to b (Atributes only)
                this.author = b.author;
                this.date = b.date;
                this.genre = b.genre;
                
                //Sustitutes b for this so it can be addressed from interface
                books.set(books.indexOf(b), this);
            }    
        }
        return exists;
    }

    public String toString(){
        String result = "El libro " + this.name + ", escrito por " + this.author + " en " + this.date + " es del genre " + this.genre ;
        return result;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = new Author(author, this);
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getName(){
        return this.name;
    }

    public Author getAuthor(){
        return this.author;
    }

    public String getDate(){
        return this.date;
    }

    public String getGenre(){
        return this.genre;
    }

}