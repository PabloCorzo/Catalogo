package domain;

public class Philosophy extends Book{
    
    private static String[]types = {"Ensayo","Dialogo","Novela"};
    private String movement;
    private String type;

    /**
     * Constructor
     * @param name nombre
     * @param author autor
     * @param date fecha
     * @param pages paginas
     * @param movement movimiento filosofico
     * @param type tipo de escritura(ensayo,dialogo...)
     * construye una filosofia con los parametros dados
     */
    public Philosophy(String name, Author author, String date, String pages, String movement, String type){
        super(name, author, date, pages);
        this.movement = movement;
        for(String t: types){
            if(t.equalsIgnoreCase(type)){
                this.type = type;
            }
        }
    }

    /**
     * Setter de movimiento
     * @param movement movimiento filosofico
     * cambia el movimiento de la filosofia
     */
    public void setMovement(String movement){
        this.movement = movement;
    }
    
    /**
     * Setter de tipo
     * @param type tipo de escritura(ensayo,dialogo...)
     * cambia el tipo de la filosofia
     */
    public void setType(String type){
        this.type = type;
    }
    
    /**
     * Getter de movimiento
     * @return String movement
     * retorna el movimiento de la filosofia
     */
    public String getMovement(){
        return this.movement;
    }

    /**
     * Getter de tipo
     * @return String type
     * retorna el tipo de la filosofia
     */
    public String getType(){
        return this.type;
    }

    /**
     * toString
     * @return String
     * retorna la informacion de la filosofia
     */
    public String toString(){
        return this.getName()+ " Del movimiento " + this.movement + " y de tipo " + this.type +  ", escrito por " + this.getAuthorName() + " en " + this.getDate() + " tiene " + this.getPages() + " paginas.";
    }  
}