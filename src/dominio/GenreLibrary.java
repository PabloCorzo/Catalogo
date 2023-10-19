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
}