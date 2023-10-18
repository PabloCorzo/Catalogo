package aplicacion;
import javax.swing.JOptionPane;

import interfaz.Interfaz;

public class Principal{
//     public static void main(String[] args) {
//         String opcion_libreria = JOptionPane.showInputDialog("Como quieres ordenar la libreria?");
//         if(opcion_libreria.equalsIgnoreCase("genero")){
            
//         }
//         else if(opcion_libreria.equalsIgnoreCase("autor")){

//         }
//         JOptionPane.showMessageDialog(null, "kevin leonard balls", opcion_libreria, 0);
//     }
    public static void main(String[] args) {
        Interfaz.addLibro();    
        // Interfaz.mostrarGeneros();
    }
 }