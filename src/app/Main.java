package app;
import api.*;


public class Main{
    public static Interface i = new Interface();

    /**
     * Metodo main
     * Empieza un bucle de preguntas para ejecutar el input
     * Solo termina si el input es salir. si no, se llama a si mismo
     * @param args sin uso
     */
    public static void main(String[] args){
    String input = i.getInput("que desea hacer?");
    int returnCode = i.chooseMethod(input);
    if(returnCode == 1){
        Main.main(args);
    }
    }
}