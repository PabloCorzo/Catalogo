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
    String input = i.getInput("Que desea hacer?\n1. Agregar libro\n2. Agregar autor\n3. Eliminar libro\n4. Eliminar autor\n5. Editar libro\n6. Editar autor\n7. Mostrar libros\n8. Mostrar autores\n9. Mostrar libros por tipo\n10. Mostrar libro especifico\n11. Guardar y salir\n12. Ayuda");
    int returnCode = i.choiceMaker(input);
    if(returnCode == 1){
        Main.main(args);
    }
    }
}