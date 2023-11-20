package dominio;
import java.util.ArrayList;

public class GenreLibrary{
    static ArrayList <Book> genres = new ArrayList<>();
    static String[] all_genres = {"filosofia","narrativa","historico","terror","biografia","ficcion"};
    
    public static String[] getGenres(){
        return all_genres;
    }

    public static void addLibro(Book book){
        genres.add(book);
    }

    public static void delLibro(Book book){
        genres.remove(book);
    }


    //Como conseguir genre 
    public String toString(String genre){
        String res = "";
        for(Book book: Book.getBooks() ){
            if(book.getGenre().equalsIgnoreCase(genre)){
                res += book.getName() + ", ";
            }
            else{;}
        }
        if(res.equalsIgnoreCase("")){
            return "No se han encontrado libros del genero indicado";
        }
        return res;
    }
}