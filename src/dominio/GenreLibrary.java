package dominio;
import java.util.ArrayList;

public class GenreLibrary{
    ArrayList <Book> genres = new ArrayList<>();
    String[] all_genres = {"filosofia","narrativa","historico","terror","biografia","ficcion"};
    
    public void addLibro(Book book){
        genres.add(book);
    }

    public void delLibro(Book book){
        genres.remove(book);
    }
}