package domain;

public class Philosophy extends Book{
    
    private static String[]types = {"Ensayo","Dialogo","Novela"};
    private String movement;
    private String type;

    public Philosophy(String name, Author author, String date, String pages, String movement, String type){
        super(name, author, date, pages);
        this.movement = movement;
        for(String t: types){
            if(t.equalsIgnoreCase(type)){
                this.type = type;
            }
        }
    }

    public void setMovement(String movement){
        this.movement = movement;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getMovement(){
        return this.movement;
    }

    public String getType(){
        return this.type;
    }

    public String toString(){
        return this.getName()+ " Del movimiento " + this.movement + " y de tipo " + this.type +  ", escrito por " + this.getAuthorName() + " en " + this.getDate() + " tiene " + this.getPages() + " paginas.";
    }
   
}