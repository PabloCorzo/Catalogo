package domain;

public class Comic extends Book{
    
    private String illustrator;
    private String series;

    public Comic(String name, Author author, String date, String pages, String illustrator, String series){
        super(name, author, date, pages);
        this.illustrator = illustrator;
        this.series = series;
    }

    public void setIllustrator(String illustrator){
        this.illustrator = illustrator;
    }
    
    public void setSeries(String series){
        this.series = series;
    }

    public String getIllustrator(){
        return this.illustrator;
    }
    
    public String getSeries(){
        return this.series;
    }

    public String toString(){
        return this.getName() + ", de la serie " + this.series + " escrito por " + this.getAuthorName() + " e ilustrado por" + this.illustrator +  " en " + this.getDate() + " tiene " + this.getPages() + " paginas.";
    }
}
