package domain;

public class Narrative extends Book{
    private String genre;
    private boolean fiction;

    public Narrative(String name, Author author, String date, String pages, String genre, boolean fiction){
        super(name, author, date, pages);
        this.genre = genre;
        this.fiction = fiction;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setFiction(boolean fiction){
        this.fiction = fiction;
    }

    public String getGenre(){
        return this.genre;
    }

    public String getFiction(){
        if(this.fiction){
            return " es ficcion";
        }

        else{
            return " no es ficcion";
        }
    }

    public String toString(){
        return this.getName() + ", escrito por " + this.getAuthorName() + " en " + this.getDate() + " de genero "+this.getGenre() + this.getFiction() +" y tiene " + this.getPages() + " paginas.";
    }

}