package domain;

public class Comic extends Book{
    
    private String illustrator;
    private String series;

    /**
     * Constructor
     * @param name nombre
     * @param author autor
     * @param date fecha
     * @param pages paginas
     * @param illustrator ilustrador
     * @param series serie
     * construye un comic con los parametros dados
     */
    public Comic(String name, Author author, String date, String pages, String illustrator, String series){
        super(name, author, date, pages);
        this.illustrator = illustrator;
        this.series = series;
    }

    /**
     * Setter de illustrador
     * @param illustrator ilustrador
     * cambia el ilustrador del comic
     */
    public void setIllustrator(String illustrator){
        this.illustrator = illustrator;
    }
    
    /**
     * Setter de serie
     * @param series serie
     * cambia la serie del comic
     */
    public void setSeries(String series){
        this.series = series;
    }

    /**
     * Getter de ilustrador
     * @return String illustrator
     * retorna el ilustrador del comic
     */
    public String getIllustrator(){
        return this.illustrator;
    }
    
    /**
     * Getter de serie
     * @return String series
     * retorna la serie del comic
     */
    public String getSeries(){
        return this.series;
    }

    /**
     * toString
     * @return string
     * devuelve un string con el nombre del comic, su serie, su autor, su ilustrador, su fecha y sus paginas
     */
    public String toString(){
        return this.getName() + ", de la serie " + this.series + " escrito por " + this.getAuthorName() + " e ilustrado por" + this.illustrator +  " en " + this.getDate() + " tiene " + this.getPages() + " paginas.";
    }
}
