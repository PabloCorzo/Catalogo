package dominio;
import java.util.ArrayList;

public class LibreriaAutores{
    ArrayList<Escritor> autores = new ArrayList<>();
        
    public void addAutor(Escritor autor){
        autores.add(autor);
    }

    public void delAutor(Escritor autor){
        autores.remove(autor);
    }
    
    public String toString(){
        String res = "La libreria contiene a los autores: ";
        for(Escritor autor  : autores){    
            res += autor.getNombre();
            if(autores.indexOf(autor) == autores.size() - 2){
                res += " y ";
            }
            else if(autores.indexOf(autor) == autores.size() - 1){
                ;
            }
            else{res += (", ");}
        }
        return res;
    }
}