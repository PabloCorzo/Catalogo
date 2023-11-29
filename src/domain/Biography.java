package domain;

public class Biography extends Book{

    private String subject;
    private boolean selfwritten;

    public Biography(String name, Author author, String date, String pages,String subject, boolean selfwritten){
        super(name, author, date, pages);
        this.subject = subject;
        this.selfwritten = selfwritten;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public void setIsSelfWritten(boolean selfwritten){
        this.selfwritten = selfwritten;
    }

    public String getSubject(){
        return this.subject;
    }
    
    public String getSelfWritten(){
        if(this.selfwritten){
            return "es autobiográfico";
        }
        else{
            //Returns empty String because author will be shown by another method
            return "";
        }
    }

    public String toString(){
        return this.getName() + ", escrito por " + this.getAuthorName() + " en " + this.getDate() + this.getSelfWritten() + "y tiene " + this.getPages() + " paginas.";
    }
}