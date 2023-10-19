package aplicacion;
import javax.swing.JOptionPane;

import interfaz.Interface;

public class Principal{
    public static void main(String[] args) {
        boolean looping;
        do{
            String option = JOptionPane.showInputDialog("Editar, mostrar, agregar, borrar o salir?");
            looping = Interface.exe(option);
        } while(looping);
    }
 }