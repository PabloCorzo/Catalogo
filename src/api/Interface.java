package api;
import domain.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Interface implements Serializable{

    private Scanner sc;
    private ArrayList<Book> library;
    private ArrayList<Author> authors;


    /**
     * Constructor
     *construye una interfaz con una lista de libros y una lista de autores
     *lee los libros y autores de un fichero
     */
    public Interface(){
        this.library = new ArrayList<>();
        this.authors = new ArrayList<>();
        ObjectInputStream obj;
        this.sc = new Scanner(System.in);
        File file = new File("books.txt");
        File file2 = new File("authors.txt");
		if(file.exists()){
			System.out.println("Libros encontrados.");
		}
        try{
            obj = new ObjectInputStream(new FileInputStream(file));
            try{
                this.library = (ArrayList<Book>)obj.readObject();
				System.out.println("Libros leidos.");
            }catch(Exception e){
                System.out.println("Libros no leidos.");
            }
            obj.close();
            obj = new ObjectInputStream(new FileInputStream(file2));
            try{
                this.authors = (ArrayList<Author>)obj.readObject();
				System.out.println("Autores leidos.");
            }catch(Exception e){
                //SHOULD BE POP-UP
                System.out.println("Autores no leidos.");
            }
            obj.close();
        }catch(Exception e){
            System.out.println("NO LEIDO: " + e);
        }
    }
    /**
	 * Cierra el scanner para borrarlo de la memoria
	 */
    public void closeScanner(){
        this.sc.close();
    }
	/**
	 * 
	 * @param prompt pregunta que mostrar
	 * @return String input
	 * Muestra la pregunta y retorna la respuesta
	 */
	public String getInput(String prompt){
    	System.out.println(prompt);
		String input = sc.nextLine();
		return input;
    }
    

    /**
     * Agrega un libro a la lista de libros
     * Pregunta por el nombre, autor, fecha, paginas y genero del libro
     *
     */
    public void addBook(){
        String name = this.getInput("Nombre del libro:");
		String author = this.getInput("Autor del libro:");
		String date = this.getInput("Fecha del libro:");
		String pages = this.getInput("Paginas del libro:");
		Author a = new Author(author);
        if(authors.contains(a)){
            this.authors.add(a);
            System.out.println("Autor agregado.");
        }
        else{
            authors.add(a);
        }
        String genre = this.getInput("Genero del libro:\n1. Filosofia\n2. Narrativa\n3. Biografia\n4. Comic");
        if(genre.equals("1")){
            String movement = this.getInput("Movimiento del libro:");
            String type = this.getInput("Tipo del libro:");
            Philosophy p = new Philosophy(name,a,date,pages,movement,type);
            this.library.add(p);
            authors.get(authors.indexOf(a)).addBook(p);
        }
        else if(genre.equals("2")){
            String narration = this.getInput("Genero narrativo del libro:");
            String fiction = this.getInput("ES ficcion? (si/no)");
            if(fiction.equalsIgnoreCase("si")){
                Narrative n = new Narrative(name,a,date,pages,narration,true);
                this.library.add(n);
                authors.get(authors.indexOf(a)).addBook(n);
            }
            else{
                Narrative n = new Narrative(name,a,date,pages,narration,false);
                this.library.add(n);
                authors.get(authors.indexOf(a)).addBook(n);                
            }
        }
        else if(genre.equals("3")){
            String subject = this.getInput("Persona del libro:");
            if(subject.equalsIgnoreCase(a.getName())){
                Biography b = new Biography(name,a,date,pages,subject,true);
                this.library.add(b);
                authors.get(authors.indexOf(a)).addBook(b);
            }
            else{
                Biography b = new Biography(name,a,date,pages,subject,false);
                this.library.add(b);
                authors.get(authors.indexOf(a)).addBook(b);
            }
        }
        else if(genre.equals("4")){
            String illustrator = this.getInput("Ilustrador del libro:");
            String series = this.getInput("Serie del libro:");
            Comic c = new Comic(name,a,date,pages,illustrator,series);
            this.library.add(c);
            authors.get(authors.indexOf(a)).addBook(c);
        }
        else{
            System.out.println("Genero no valido.");
        }
    }

    /**
     * Agrega un autor a la lista de autores
     * Pregunta por el nombre del autor
     */
    public void addAuthor(){
        String name = this.getInput("Nombre del autor:");
        Author a = new Author(name);
        if(authors.contains(a)){
            this.authors.add(a);
            System.out.println("Autor agregado.");
        }
        else{
            System.out.println("Autor ya existente.");
        }
    }

    /**
     * Elimina un libro de la lista de libros
     * Pregunta por el nombre del libro
     * Si el libro existe, lo elimina
     * Si el libro no existe, muestra un mensaje de error
     */
    public void delBook(){
        String name = this.getInput("Nombre del libro:");
        Book b = new Book(name);
        if(library.contains(b)){
            library.remove(library.indexOf(b));
            library.get(library.indexOf(b)).getAuthor().rmBook(b);
            System.out.println("Libro eliminado.");
        }
        else{
            System.out.println("Libro no existente.");
        }
    }

    /**
     * Elimina un autor de la lista de autores
     * Pregunta por el nombre del autor
     * Si el autor existe, lo elimina junto con todos sus libros
     * Si el autor no existe, muestra un mensaje de error
     */
    public void delAuthor(){
        String choice = this.getInput("Si eliminas un autor, se eliminaran todos sus libros.\nSeguro que quieres eliminar un autor? (si/no)");
        if(choice.equalsIgnoreCase("si")){
            String name = this.getInput("Nombre del autor:");
            Author a = new Author(name);
            if(authors.contains(a)){
                for(int i = 0; i < library.size(); i++){
                    Book b = library.get(i);
                    if(b.getAuthor().getName().equalsIgnoreCase(a.getName())){
                        library.remove(b);
                    }
                }
                authors.remove(authors.indexOf(a));
                System.out.println("Autor eliminado.");
            }
            else{
                System.out.println("Autor no existente.");
            }
        }
    }

    /**
     * Edita un libro de filosofia
     * @param b libro
     */
    public void editPhilosophy(Book b){
                String value = this.getInput("Que quieres editar?\n1. Nombre\n2. Autor\n3. Fecha\n4. Paginas\n5. Movimiento\n6. Tipo");
                Philosophy p = (Philosophy)library.get(library.indexOf(b));
                if(value.equals("1")){
                    String newName = this.getInput("Nuevo nombre:");
                    p.setName(newName);
                    System.out.println("Nombre cambiado.");
                }
                else if(value.equals("2")){
                    String newAuthor = this.getInput("Nuevo autor:");
                    Author a = new Author(newAuthor);
                    if(authors.contains(a)){
                        p.getAuthor().rmBook(b);
                        p.setAuthor(authors.get(authors.indexOf(a)));
                        authors.get(authors.indexOf(a)).addBook(b);
                        System.out.println("Autor cambiado.");
                    }
                    else{
                        Author newA = new Author(newAuthor);
                        authors.add(newA);
                        p.getAuthor().rmBook(b);
                        p.setAuthor(newA);
                        authors.get(authors.indexOf(newA)).addBook(b);
                        System.out.println("Autor agregado.");
                    }
                }
                else if(value.equals("3")){
                    String newDate = this.getInput("Nueva fecha:");
                    p.setDate(newDate);
                    System.out.println("Fecha cambiada.");
                }
                else if(value.equals("4")){
                    String newPages = this.getInput("Nuevas paginas:");
                    p.setPages(newPages);
                    System.out.println("Paginas cambiadas.");
                }
                else if(value.equals("5")){
                    String newMovement = this.getInput("Nuevo movimiento:");
                    ((Philosophy)p).setMovement(newMovement);
                    System.out.println("Movimiento cambiado.");
                }
                else if(value.equals("6")){
                    String newType = this.getInput("Nuevo tipo:");
                    ((Philosophy)p).setType(newType);
                    System.out.println("Tipo cambiado.");
                }
                else{
                    System.out.println("Valor no valido.");
                }
            }

    /**
     * Edita un libro de narrativa
     * @param b libro
     */
    public void editNarrative(Book b){
        String value = this.getInput("Que quieres editar?\n1. Nombre\n2. Autor\n3. Fecha\n4. Paginas\n5. Genero narrativo\n6. Ficcion");
        Narrative n = (Narrative)library.get(library.indexOf(b));
        if(value.equals("1")){
            String newName = this.getInput("Nuevo nombre:");
            n.setName(newName);
            System.out.println("Nombre cambiado.");
        }
        else if(value.equals("2")){
            String newAuthor = this.getInput("Nuevo autor:");
            Author a = new Author(newAuthor);
            if(authors.contains(a)){
                n.getAuthor().rmBook(b);
                n.setAuthor(authors.get(authors.indexOf(a)));
                authors.get(authors.indexOf(a)).addBook(b);
                System.out.println("Autor cambiado.");
            }
            else{
                Author newA = new Author(newAuthor);
                authors.add(newA);
                n.getAuthor().rmBook(b);
                n.setAuthor(newA);
                newA.addBook(b);
                System.out.println("Autor agregado.");
            }
        }
        else if(value.equals("3")){
            String newDate = this.getInput("Nueva fecha:");
            n.setDate(newDate);
            System.out.println("Fecha cambiada.");
        }
        else if(value.equals("4")){
            String newPages = this.getInput("Nuevas paginas:");
            n.setPages(newPages);
            System.out.println("Paginas cambiadas.");
        }
        else if(value.equals("5")){
            String newNarration = this.getInput("Nuevo genero narrativo:");
            ((Narrative)n).setGenre(newNarration);
            System.out.println("Genero narrativo cambiado.");
        }
        else if(value.equals("6")){
            String newFiction = this.getInput("Es ficcion? (si/no)");
            if(newFiction.equalsIgnoreCase("si")){
                ((Narrative)n).setIsFiction(true);
                System.out.println("Ficcion cambiada.");
            }
            else if(newFiction.equalsIgnoreCase("no")){
                ((Narrative)n).setIsFiction(false);
                System.out.println("Ficcion cambiada.");
            }
            else{
                System.out.println("Valor no valido.");
            }
        }
        else{
            System.out.println("Valor no valido.");
        }
    }

    /**
     * Edita un libro de biografia
     * @param b libro
     */
    public void editBiography(Book b){
        String value = this.getInput("Que quieres editar?\n1. Nombre\n2. Autor\n3. Fecha\n4. Paginas\n5. Persona");
        Biography bio = (Biography)library.get(library.indexOf(b));
        if(value.equals("1")){
            String newName = this.getInput("Nuevo nombre:");
            bio.setName(newName);
            System.out.println("Nombre cambiado.");
        }
        else if(value.equals("2")){
            String newAuthor = this.getInput("Nuevo autor:");
            Author a = new Author(newAuthor);
            if(authors.contains(a)){
                if(bio.getSubject().equalsIgnoreCase(newAuthor)){
                    bio.setIsSelfWritten(true);
                }
                else{
                    bio.setIsSelfWritten(false);
                }
                bio.getAuthor().rmBook(b);
                bio.setAuthor(authors.get(authors.indexOf(a)));
                authors.get(authors.indexOf(a)).addBook(b);
                System.out.println("Autor cambiado.");
            }
            else{
                Author newA = new Author(newAuthor);
                authors.add(newA);
                if(bio.getSubject().equalsIgnoreCase(newAuthor)){
                    bio.setIsSelfWritten(true);
                }
                else{
                    bio.setIsSelfWritten(false);
                }
                bio.getAuthor().rmBook(b);
                bio.setAuthor(newA);
                newA.addBook(b);
                System.out.println("Autor agregado.");
            }

        }
        else if(value.equals("3")){
            String newDate = this.getInput("Nueva fecha:");
            bio.setDate(newDate);
            System.out.println("Fecha cambiada.");
        }
        else if(value.equals("4")){
            String newPages = this.getInput("Nuevas paginas:");
            bio.setPages(newPages);
            System.out.println("Paginas cambiadas.");
        }
        else if(value.equals("5")){
            String newSubject = this.getInput("Nuevo sujeto:");
            bio.setSubject(newSubject);
            if(bio.getAuthor().getName().equalsIgnoreCase(newSubject)){
                bio.setIsSelfWritten(true);
            }
            else{
                bio.setIsSelfWritten(false);
            }
            System.out.println("Sujeto cambiado.");
        }
        else{
            System.out.println("Valor no valido.");
        }
    }

    /**
     * Edita un libro de comic
     * @param b libro
     */
    public void editComic(Book b){
        String value = this.getInput("Que quieres editar?\n1. Nombre\n2. Autor\n3. Fecha\n4. Paginas\n5. Ilustrador\n6. Serie");
        Comic c = (Comic)library.get(library.indexOf(b));
        if(value.equals("1")){
            String newName = this.getInput("Nuevo nombre:");
            c.setName(newName);
            System.out.println("Nombre cambiado.");
        }
        else if(value.equals("2")){
            String newAuthor = this.getInput("Nuevo autor:");
            Author a = new Author(newAuthor);
            if(authors.contains(a)){
                c.getAuthor().rmBook(b);
                c.setAuthor(authors.get(authors.indexOf(a)));
                authors.get(authors.indexOf(a)).addBook(b);
                System.out.println("Autor cambiado.");
            }
            else{
                Author newA = new Author(newAuthor);
                authors.add(newA);
                c.getAuthor().rmBook(b);
                c.setAuthor(newA);
                newA.addBook(b);
                System.out.println("Autor agregado.");
            }
        }
        else if(value.equals("3")){
            String newDate = this.getInput("Nueva fecha:");
            c.setDate(newDate);
            System.out.println("Fecha cambiada.");
        }
        else if(value.equals("4")){
            String newPages = this.getInput("Nuevas paginas:");
            c.setPages(newPages);
            System.out.println("Paginas cambiadas.");
        }
        else if(value.equals("5")){
            String newIllustrator = this.getInput("Nuevo ilustrador:");
            c.setIllustrator(newIllustrator);
            System.out.println("Ilustrador cambiado.");
        }
        else if(value.equals("6")){
            String newSeries = this.getInput("Nueva serie:");
            c.setSeries(newSeries);
            System.out.println("Serie cambiada.");
        }
        else{
            System.out.println("Valor no valido.");
        }
    }

    /**
     * Edita un autor de la lista de autores
     * Pregunta por el nombre del autor
     * Si el autor existe, lo edita
     * Si el autor no existe, muestra un mensaje de error
     */
    public void editAuthor(){
        String name = this.getInput("Nombre del autor:");
        Author a = new Author(name);
        if(authors.contains(a)){
            authors.get(authors.indexOf(a)).setName(name);
        }
        else{
            System.out.println("Autor no existente.");
        }
    }

    /**
     * Muestra todos los libros 
     */
    public void showBooks(){
        for(Book b : library){
            System.out.println(b.toString());
        }
    }

    /**
     * Muestra todos los autores con sus libros correspondientes
     */
    public void showAuthors(){
        for(Author a : authors){
            System.out.println(a.toString());
        }
    }

    /**
     * Muestra todos los libros de un tipo a escoger
     */
    public void showBookType(){
        String type = this.getInput("Que tipo de libro quieres mostrar?\n1. Filosofia\n2. Narrativa\n3. Biografia\n4. Comic");
        if(type.equalsIgnoreCase("1")){
            for(Book b: library){
                if(b instanceof Philosophy){
                    System.out.println(b.toString());
                }
            }
        }
        else if(type.equalsIgnoreCase("2")){
            for(Book b : library){
            if(b instanceof Narrative){
                System.out.println(b.toString());
                }
            }
        }
        else if(type.equalsIgnoreCase("4")){
            for(Book b : library){
            if(b instanceof Biography){
                System.out.println(b.toString());
                }
            }
        }
        else if(type.equalsIgnoreCase("4")){
            for(Book b : library){
            if(b instanceof Comic){
                System.out.println(b.toString());
                }
            }
        }
            
    }

    /**
     * Muestra un libro especifico
     * si no existe, muestra un mensaje de error
     */
    public void showBook(){
        String name = this.getInput("Nombre del libro: ");
        Book b = new Book(name);
        if(library.contains(b)){
            System.out.println(library.get(library.indexOf(b)));
        }
        else{
            System.out.println("Libro no encontrado.");
        }
    }

    /**
     * Muestra un menu de comandos
     */
    public void help(){
        System.out.println("Que desea hacer?\n1. Agregar libro\n2. Agregar autor\n3. Eliminar libro\n4. Eliminar autor\n5. Editar libro\n6. Editar autor\n7. Mostrar libros\n8. Mostrar autores\n9. Mostrar libros por tipo\n10. Mostrar libro especifico\n11. Guardar y salir");
    }
    public void save(){
		//serialize library and authors
		ObjectOutputStream obj;
		ObjectOutputStream obj2;
		File file = new File("books.txt");
		File file2 = new File("authors.txt");
		try{
			obj = new ObjectOutputStream(new FileOutputStream(file));
			obj.writeObject(this.library);
			obj.close();
			obj2 = new ObjectOutputStream(new FileOutputStream(file2));
			obj2.writeObject(this.authors);
			obj2.close();
			System.out.println("Guardado.");
	}catch(Exception e){
		System.out.println("NO GUARDADO: " + e);
	}
	this.closeScanner();
}
    /**
     * Elige que hacer segun el input
     * @param input input
     * @return int returnCode
     * retorna 1 si el input no es salir
     * retorna 0 si el input es salir
     */
    public int choiceMaker(String input){
        if(input.equals("1")){
            this.addBook();
        }
        else if(input.equals("2")){
            this.addAuthor();
        }
        else if(input.equals("3")){
            this.delBook();
        }
        else if(input.equals("4")){
            this.delAuthor();
        }
        else if(input.equals("5")){
            String name = this.getInput("Nombre del libro:");
            Book b = new Book(name);
            if(library.contains(b)){
                System.out.println("Libro encontrado.");
                if(library.get(library.indexOf(b)) instanceof Philosophy){
                    this.editPhilosophy(b);
                }
                else if(library.get(library.indexOf(b)) instanceof Narrative){
                    this.editNarrative(b);
                }
                else if(library.get(library.indexOf(b)) instanceof Biography){
                    this.editBiography(b);
                }
                else if(library.get(library.indexOf(b)) instanceof Comic){
                    this.editComic(b);
                }
            }
            else{
                System.out.println("Libro no encontrado.");
            }
        }
        else if(input.equals("6")){
            this.editAuthor();
        }
        else if(input.equals("7")){
            this.showBooks();
        }
        else if(input.equals("8")){
            this.showAuthors();
        }
        else if(input.equals("9")){
            this.showBookType();
        }
        else if(input.equals("10")){
            this.showBook();
        }
        else if(input.equals("11")){
            this.save();
            this.closeScanner();
            return 0;
        }
        else{
            System.out.println("Valor no valido.");
        }
        return 1;
    }
}
