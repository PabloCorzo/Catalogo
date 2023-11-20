package dominio;
import java.util.ArrayList;

public class AuthorLibrary{
    ArrayList<Author> authors = new ArrayList<>();
        
    public void addAutor(Author author){
        authors.add(author);
    }

    public void delAutor(Author author){
        authors.remove(author);
    }
    
    public String toString(){
        String res = "La libreria contiene a los authores: ";
        for(Author author  : authors){    
            res += author.getName();
            if(authors.indexOf(author) == authors.size() - 2){
                res += " y ";
            }
            else if(authors.indexOf(author) == authors.size() - 1){
                ;
            }
            else{res += (", ");}
        }
        return res;
    }
}