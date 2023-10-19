package dominio;
import java.util.ArrayList;
import java.util.HashMap;

public class Book{
    private String name;
    private String author;
    private String date;
    private String genre;
    static ArrayList <Book> books = new ArrayList<>();
    static HashMap <String, String> authors = new HashMap<>();
    static HashMap <String, String> genres = new HashMap<>();
    

    public static ArrayList <Book> getBooks(){
        return books;
    }

    public static HashMap <String,String> getAuthors(){
        return authors;
    }

    public static HashMap <String, String> getGenres(){
        return genres;
    }


    public Book(String name,String author,String date, String genre){
        this.name = name;
        this.author = author;
        this.date = date;
        this.genre = genre;
        authors.put(this.name, this.author);
        genres.put(this.name, this.genre);
    }

    public String toString(){
        String result = "El libro " + this.name + ", escrito por " + this.author + " en " + this.date + " es del genre " + this.genre ;
        return result;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = author;
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

    public String getAuthor(){
        return this.author;
    }

    public String getDate(){
        return this.date;
    }

    public String getGenre(){
        return this.genre;
    }

}