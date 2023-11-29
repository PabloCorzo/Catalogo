package app;
import api.*;


public class Main{
    public static Interface i = new Interface();
    public static void main(String[] args){
    String input = i.getInput("que desea hacer?");
    int returnCode = i.chooseMethod(input);
    if(returnCode == 1){
        Main.main(args);
    }
    }
}