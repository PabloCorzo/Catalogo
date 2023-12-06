package domain;

public class Biography extends Book{

    private String subject;
    private boolean selfwritten;


    /**
     * Constructor
     * @param name nombre
     * @param author autor
     * @param date fecha
     * @param pages paginas
     * @param subject sujeto de la biografia
     * @param selfwritten es autobigrafica
     * construye una biografia con los parametros dados
     */
    public Biography(String name, Author author, String date, String pages,String subject, boolean selfwritten){
        super(name, author, date, pages);
        this.subject = subject;
        this.selfwritten = selfwritten;
    }

    /**
     * Setter de sujeto
     * @param subject sujeto de la biografia
     * cambia el sujeto de la biografia
     */
    public void setSubject(String subject){
        this.subject = subject;
    }

    /**
     * Setter de valor boolean autobiografico
     * @param selfwritten es autobiografica
     * cambia el valor boolean autobiografico de la biografia
     */
    public void setIsSelfWritten(boolean selfwritten){
        this.selfwritten = selfwritten;
    }

    /**
     * Getter de sujeto
     * @return String sujeto
     * retorna el sujeto de la biografia
     */
    public String getSubject(){
        return this.subject;
    }
    
    /**
     * Getter de valor boolean autobiografico
     * @return bool autobiografico
     * retorna si la biografia es autobiografica
     */
    public String getSelfWritten(){
        if(this.selfwritten){
            return " es autobiográfico ";
        }
        else{
            return " sobre " + this.getSubject() + " ";
        }
    }

    /**
     * toString
     * @return String
     * retorna un string con el nombre de la biografia, su autor, fecha, si es autobiografico y sus paginas
     */
    public String toString(){
        return this.getName() + ", escrito por " + this.getAuthorName() + " en " + this.getDate() + this.getSelfWritten() + "y tiene " + this.getPages() + " paginas.";
    }
}