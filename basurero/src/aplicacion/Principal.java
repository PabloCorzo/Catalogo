package aplicacion;
import javax.swing.JOptionPane;
import interfaz.Interface2;

public class Principal{
    public static void main(String[] args) {
        boolean looping;
        Interface2 i = new Interface2();
        do{
            // String option = JOptionPane.showInputDialog("Editar, mostrar, agregar, borrar o salir?");
            String option = JOptionPane.showInputDialog("Editar, mostrar, agregar, borrar o salir?ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");

            looping = i.run(option);
        } while(looping);
    }
 }