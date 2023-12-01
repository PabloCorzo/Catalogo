package domain;

public class Narrative extends Book{
    private String genre;
    private boolean fiction;

    /**
     * Constructor
     * @param name nombre
     * @param author autor
     * @param date fecha
     * @param pages paginas
     * @param genre genero
     * @param fiction es ficcion
     * construye una narrativa con los parametros dados
     */
    public Narrative(String name, Author author, String date, String pages, String genre, boolean fiction){
        super(name, author, date, pages);
        this.genre = genre;
        this.fiction = fiction;
    }

    /**
     * Setter de genre
     * @param genre genero
     * cambia el genero de la narrativa
     */
    public void setGenre(String genre){
        this.genre = genre;
    }

    /**
     * Setter de fiction
     * @param fiction es ficcion
     * cambia el valor ficcion/no ficcion de la narrativa
     */
    public void setIsFiction(boolean fiction){
        this.fiction = fiction;
    }

    /**
     * Getter de genre
     * @return String genre
     * retorna el genero de la narrativa
     */
    public String getGenre(){
        return this.genre;
    }

    /**
     * Getter de fiction
     * @return bool fiction
     * retorna si la narrativa es ficcion o no
     */
    public String getFiction(){
        if(this.fiction){
            return " es ficcion";
        }

        else{
            return " no es ficcion";
        }
    }

    /**
     * toString
     * @return string
     * devuelve un string con el nombre de la narrativa, su autor, fecha, genero, si es ficcion o no y sus paginas
     */
    public String toString(){
        return this.getName() + ", escrito por " + this.getAuthorName() + " en " + this.getDate() + " de genero "+this.getGenre() + this.getFiction() +" y tiene " + this.getPages() + " paginas.";
    }

}