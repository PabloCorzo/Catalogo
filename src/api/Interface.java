package api;
import domain.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface implements Serializable{

    private Scanner sc;
    private ArrayList<Book>library;
    private ArrayList<Author>authors;

    
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

    public void closeScanner(){
        this.sc.close();
    }


	public String getInput(String prompt){
    	System.out.println(prompt);
		String input = sc.nextLine();
		return input;
    }


    public int chooseMethod(String input){
	String[] split = input.split(" ");
	//METHODS
	//ADD -> BOOK, AUTHOR
	//REMOVE -> BOOK, AUTHOR(DELETES ALL OF THEIR BOOKS, NEEDS Y/N)
	//EDIT -> BOOK, AUTHOR -> ANY OF THEIR RESPECTIVE ATRIBUTES
	//SHOW -> BY GENRE(SUBCLASS) OR BY AUTHOR
	//HELP AND EXIT
	if(split[0].equalsIgnoreCase("agregar") && split[1].equalsIgnoreCase("libro")){
		//add book
		String name = this.getInput("Nombre del libro:");
		String author = this.getInput("Autor del libro:");
		String date = this.getInput("Fecha del libro:");
		String pages = this.getInput("Paginas del libro:");
		String genre = this.getInput("Genero del libro:\n1. Filosofia\n2. Narrativa\n3. Biografia\n4. Comic");
		Author a = new Author(author);
		if(a.exists(authors)){
		}
		else{
			authors.add(a);
			System.out.println("Autor agregado.");
		}
		if(genre.equalsIgnoreCase("1")){
			//add philosophy book
			String movement = this.getInput("Movimiento del libro:");
			String type = this.getInput("Tipo de libro:");
			Philosophy p = new Philosophy(name,a,date,pages,movement,type);
			if(p.exists(library)){
				System.out.println("Libro ya existe.");
			}
			else{
				library.add(p);
				System.out.println("Libro agregado.");
			}
		}
		else if(genre.equalsIgnoreCase("2")){
			//add narrative book
			String type = this.getInput("Genero narrativo del libro:");
			String isfiction = this.getInput("Es ficcion? y/n");
			if (isfiction.equalsIgnoreCase("y")){
				Narrative n = new Narrative(name,a,date,pages,type,true);
				if(n.exists(library)){
					System.out.println("Libro ya existe.");
				}
				else{
					library.add(n);
					authors.get(a.getIndexIn(authors)).addBook(n);
					System.out.println("Libro agregado.");
				}
			}
			else if(isfiction.equalsIgnoreCase("n")){
				Narrative n = new Narrative(name,a,date,pages,type,false);
				if(n.exists(library)){
					System.out.println("Libro ya existe.");
				}
				else{
					library.add(n);
					authors.get(a.getIndexIn(authors)).addBook(n);
					System.out.println("Libro agregado.");
				}
			}
			else{
				System.out.println("No se ha reconocido la respuesta.");
				
			}
		}
		else if(genre.equalsIgnoreCase("3")){
			//add biography book
			String subject = this.getInput("Sujeto del libro:");
			String isselfwritten = this.getInput("Es autoescrito? y/n");
			if(isselfwritten.equalsIgnoreCase("y")){
				Biography b = new Biography(name,a,date,pages,subject,true);
				library.add(b);
				authors.get(a.getIndexIn(authors)).addBook(b);
			}
			else if(isselfwritten.equalsIgnoreCase("n")){
				Biography b = new Biography(name,a,date,pages,subject,false);
				library.add(b);
				authors.get(a.getIndexIn(authors)).addBook(b);
			}
			else{
				System.out.println("No se ha reconocido la respuesta.");
			}
		}
		else if(genre.equalsIgnoreCase("4")){
			//add comic book
			String illustrator = this.getInput("Ilustrador del libro:");
			String series = this.getInput("Serie del libro:");
			Comic c = new Comic(name,a,date,pages,illustrator,series);
			if(c.exists(library)){
				System.out.println("Libro ya existe.");
			}
			else{
				library.add(c);
				authors.get(a.getIndexIn(authors)).addBook(c);
				System.out.println("Libro agregado.");
			}
		}
		else{
			System.out.println("Genero no reconocido.");
		}
		return 1;
	}

	else if(split[0].equalsIgnoreCase("agregar") && (split[1].equalsIgnoreCase("autor") || split[1].equalsIgnoreCase("autora"))){
		//add author
		String name = this.getInput("Nombre del autor:");
		Author a = new Author(name);
		if(a.exists(authors)){
			System.out.println("Autor ya existe.");
		}
		else{
			authors.add(a);
			System.out.println("Autor agregado.");
		}
		return 1;
	}

	else if(split[0].equalsIgnoreCase("borrar") && split[1].equalsIgnoreCase("libro")){
		//delete book
		String name = this.getInput("Nombre del libro:");
		Book book = new Book(name,new Author(""),"","");
		if(book.exists(library)){
			int index = book.getIndexIn(library);
			library.remove(index);
			System.out.println("Libro borrado.");
		}
		else{
			System.out.println("Libro no encontrado.");
		}
		return 1;
	}

	else if(split[0].equalsIgnoreCase("borrar") && (split[1].equalsIgnoreCase("autor") || split[1].equalsIgnoreCase("autora:"))){
		String yn = this.getInput("Si borras el autor, se borraran sus libros. Estas seguro? y/n");
		if(yn.equalsIgnoreCase("y")){
			//delete all of their books
			String name = this.getInput("Nombre del autor:");
			Author author = new Author(name);
			if(author.exists(authors)){
				int index = author.getIndexIn(authors);
				for(Book b : authors.get(index).getBooks()){
					library.remove(b);
				}
				authors.remove(index);
				System.out.println("Autor borrado.");
			}
			else{
				System.out.println("Autor no encontrado.");
			}
			return 1;
		}
		else{
			System.out.println("No se ha borrado.");
			return 1;
		}
	}
	else if((split[0]).equalsIgnoreCase("editar") && (split[1].equalsIgnoreCase("libro"))){
		//edit book
		String name = this.getInput("Que libro quieres editar?");
		Book book = new Book(name,new Author("name"),"","");
		if(book.exists(library)){
			int index = book.getIndexIn(library);
			if(library.get(index)instanceof Philosophy){
				//edit philosophy book
				String value = this.getInput("que quieres editar? 1. Nombre\n2. Autor\n3. Fecha\n4. Paginas\n5. Movimiento\n6. Tipo");
				if(value.equalsIgnoreCase("1")){
					String newName = this.getInput("Nuevo nombre:");
					library.get(index).setName(newName);
					System.out.println("Nombre cambiado.");
				}
				else if(value.equalsIgnoreCase("2")){

					
				}
			}
		}
		else{
			System.out.println("Libro no encontrado.");
		}
		return 1;
	}
	else if(split[0].equalsIgnoreCase("editar") && (split[1].equalsIgnoreCase("autor") || split[1].equalsIgnoreCase("autora"))){
		//edit author
		String name = this.getInput("Que autor quieres editar?");
		Author author = new Author(name);
		if(author.exists(authors)){
			int index = author.getIndexIn(authors);
				String newName = this.getInput("Nuevo nombre:");
				authors.get(index).setName(newName);
		}
		else{
			System.out.println("Autor no encontrado.");
		}
		return 1;
	}
	else if(split[0].equalsIgnoreCase("mostrar") && split[1].equalsIgnoreCase("libros")){
		//show all book sublasses, with the option to choose one to show its designated books
		System.out.println("Categorias: \n1. Filosofia\n2. Narrativa\n3. Biografia\n4. Comic");
		String cat = this.getInput("Que categoria quieres ver? (1-4)");
		if(cat.equalsIgnoreCase("1")){
			//show all philosophy books
			ArrayList<Book>philosophy = new ArrayList<>();
			for(Book b : library){
				if(b instanceof Philosophy){
					philosophy.add(b);
				}
			}
			for(Book b : philosophy){
				System.out.println(b.toString());
				System.out.println("");
			}
			return 1;
		}
		else if(cat.equalsIgnoreCase("2")){
			//show all narrative books
			ArrayList<Book>narrative = new ArrayList<>();
			for(Book b : library){
				if(b instanceof Narrative){
					narrative.add(b);
				}
			}
			for(Book b : narrative){
				System.out.println(b.toString());
				System.out.println("");
			}
			return 1;
		}
		else if(cat.equalsIgnoreCase("3")){
			//show all biography books
			ArrayList<Book>biography = new ArrayList<>();
			for(Book b : library){
				if(b instanceof Biography){
					biography.add(b);
				}
			}
			for(Book b : biography){
				System.out.println(b.toString());
				System.out.println("");
			}
			return 1;
		}
		else if(cat.equalsIgnoreCase("4")){
			//show all comic books
			ArrayList<Book>comic = new ArrayList<>();
			for(Book b : library){
				if(b instanceof Comic){
					comic.add(b);
				}
			}
			for(Book b : comic){
				System.out.println(b.toString());
				System.out.println("");
			}
			return 1;
		}
		else{
			System.out.println("Categoria no reconocida.");
			return 1;
		}
	}
	else if(split[0].equalsIgnoreCase("mostrar") && split[1].equalsIgnoreCase("autores")){
		//show all authors, with the option to choose one to show their designated books
		for(Author a : authors){
			System.out.println(a.toString());
			System.out.println("");
		}
		String name = this.getInput("que autor quieres ver?");
		Author author = new Author(name);
		if(author.exists(authors)){
			int index = author.getIndexIn(authors);
			for(Book b : authors.get(index).getBooks()){
				System.out.println(b.toString());
				System.out.println("");
			}
		}
		else{
			System.out.println("Autor no encontrado.");
		}
		return 1;
	}
	else if(split[0].equalsIgnoreCase("help") || split[0].equalsIgnoreCase("ayuda")){
		//help
		//show all commands
		System.out.println("Comandos: \n1. Agregar libro\n2. Agregar autor\n3. Borrar libro\n4. Borrar autor\n5. Editar libro\n6. Editar autor\n7. Mostrar libros\n8. Mostrar autores\n9. Ayuda\n10. Salir");
		return 1;
	}
	else if(split[0].equalsIgnoreCase("salir") || split[0].equalsIgnoreCase("quit")){
		//exit
		this.save();
		return 0;
	}
	else{
		System.out.println("Comando no reconocido.");
		return 1;
	}
}
	public void save(){
		//serialize library and authors
		ObjectOutputStream obj;
		File file = new File("books.txt");
		File file2 = new File("authors.txt");
		try{
			obj = new ObjectOutputStream(new FileOutputStream(file));
			obj.writeObject(this.library);
			obj.close();
			obj = new ObjectOutputStream(new FileOutputStream(file2));
			obj.writeObject(this.authors);
			obj.close();
			System.out.println("Guardado.");
	}catch(Exception e){
		System.out.println("NO GUARDADO: " + e);
	}
	this.closeScanner();
}
}
