package api;
import domain.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
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
        try{
            obj = new ObjectInputStream(new FileInputStream(file));
            try{
                this.library = (ArrayList<Book>)obj.readObject();
            }catch(Exception e){
                //SHOULD BE POP-UP
                System.out.println("Libros no leidos.");
            }
            obj.close();
            obj = new ObjectInputStream(new FileInputStream(file2));
            try{
                this.authors = (ArrayList<Author>)obj.readObject();
            }catch(Exception e){
                //SHOULD BE POP-UP
                System.out.println("Autores no leidos.");
            }
            obj.close();
            //SHOULD BE POP-UP
            System.out.println("Leido.");
        }catch(Exception e){
            //SHOULD BE POP-UP
            System.out.println("NO LEIDO: " + e);
        }
    }


    public void closeScanner(){
        this.sc.close();
    }
    // MIGHT NOT BE USED, BUTTONS INSTEAD
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
		return 1;
	}

	else if(split[0].equalsIgnoreCase("agregar") && (split[1].equalsIgnoreCase("autor") || split[1].equalsIgnoreCase("autora"))){
		//add author
		return 1;
	}

	else if(split[0].equalsIgnoreCase("borrar") && split[1].equalsIgnoreCase("libro")){
		//delete book
		return 1;
	}

	else if(split[0].equalsIgnoreCase("borrar") && (split[1].equalsIgnoreCase("autor") || split[1].equalsIgnoreCase("autora:"))){
		String yn = this.getInput("Si borras el autor, se borraran sus libros. Estas seguro? y/n");
		if(yn.equalsIgnoreCase("y")){
			//delete all of their books
			//delete the author
			return 1;
		}
		else{
			System.out.println("No se ha borrado.");
			return 1;
		}
	}
	else if((split[0]).equalsIgnoreCase("editar") && (split[1].equalsIgnoreCase("libro"))){
		//edit book
		//choose book
		String name = this.getInput("Que libro quieres editar?");
		Book book = new Book(name,new Author("name"),"","");
		if(book.exists(library)){
			int index = book.getIndexIn(library);
			String edit = this.getInput("Que quieres editar? (nombre, autor, fecha, paginas)");
			if(edit.equalsIgnoreCase("nombre")){
				String newName = this.getInput("Nuevo nombre:");
				library.get(index).setName(newName);
			}
			else if(edit.equalsIgnoreCase("autor")){
				String newAuthor = this.getInput("Nuevo autor (si no existe,sera creado) :");
				Author newa = new Author(newAuthor);
				if(newa.exists(authors)){
					int index2 = newa.getIndexIn(authors);
					authors.get(index2).addBook(library.get(index));
				}
				else{
					newa.addBook(library.get(index));
					authors.add(newa);
				library.get(index).setAuthor(newa);
				}
			}

			else if(edit.equalsIgnoreCase("fecha")){
				String newDate = this.getInput("Nueva fecha:");
				library.get(index).setDate(newDate);
			}
			else if(edit.equalsIgnoreCase("paginas")){
				String newPages = this.getInput("Nuevas paginas:");
				library.get(index).setPages(newPages);
			}
			else{
				System.out.println("Atributo no reconocido.");
			}
		}

		return 1;
	}
	else if(split[0].equalsIgnoreCase("editar") && (split[1].equalsIgnoreCase("autor") || split[1].equalsIgnoreCase("autora"))){
		//edit author
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
}
}
