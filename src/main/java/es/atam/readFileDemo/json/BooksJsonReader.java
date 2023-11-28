package es.atam.readFileDemo.json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BooksJsonReader {
	  
	public static void main(String[] args) throws IOException{

	        // Ruta del fichero JSON
	        String rutaArchivoJson = "src/main/resources/books.json";

	            // Crear un ObjectMapper (Jackson)
	            ObjectMapper objectMapper = new ObjectMapper();
	            File booksJsonFile = new File(rutaArchivoJson);
	            
	            List<Book> listBooks = objectMapper.readValue(booksJsonFile, new TypeReference<List<Book>>() {});
	            System.out.println("Libros total: "+listBooks.size());
	            System.out.println("_____");
	            
	            //Imprimir Todo
	            printAllBooks(listBooks);
	            System.out.println("_____");
	            
	            //Ejercicio 1
	            printWithoutDate(listBooks);
	            System.out.println("_____");


	            //Ejercicio 2
	            // Devolver libros que contengan la cadena de caracteres en nombre, resumen o biografía
	            System.out.println("Ejercicio 2 ********************");
	            Book book2 = new Book();
	            String filter = "Potter";
	            book2 = findWord(listBooks, filter);
	            System.out.println("DESPUES DE FILTER: ...." +book2.getTitle() +"  ..... Fecha: "+ formatDate(book2.getPublicationTimestamp()));
	            
	            
	            // Ordenar el array de books por timestamp usando un Comparator
		        System.out.println("Listar por fecha ****");
	            ordenarFechas(listBooks);
	            System.out.println("_____");
	  
	            
	            //Ejercicio 3
		        sortPrint(listBooks);  //list<Book>
	           
	    }



	private static void sortPrint(List<Book> bookList) {

            Optional<BookDate> result;
		try {
			result = filter("", bookList);

            result.ifPresent(bookDate -> {
                System.out.println("Libro encontrado: " + bookDate.getBook().getTitle() +
                        ", Fecha de publicación: " + bookDate.getBook().getFormattedDate());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	 private static Optional<BookDate> filter(String filter, List<Book> books) {
	        

		 Comparator<Book> comparator = Comparator.comparing(Book::getId, Comparator.nullsLast(Comparator.reverseOrder()))
                .thenComparing(Book::getPublicationTimestamp);

		  List<Book> filterBooks = books.stream()
	                .filter(book -> book.getAuthor().getName().contains(filter)
	                        || book.getSummary().contains(filter)
	                        || book.getAuthor().getBio().contains(filter))
	                .collect(Collectors.toList());

		 	Book latestBook = filterBooks.stream()
	                .max(Comparator.comparing(Book::getPublicationTimestamp, Comparator.nullsLast(Comparator.naturalOrder())))
	                .orElse(null);

	        if (latestBook != null) {
	            latestBook.setFormattedDate(formatDate(latestBook.getPublicationTimestamp()));
	        }

	        filterBooks.sort(Comparator
	                .comparing(Book::getPublicationTimestamp, Comparator.nullsLast(Comparator.naturalOrder()))
	                .thenComparing(Comparator.comparingInt(book -> book.getAuthor().getBio().length())));
	        System.out.println("Ordenadción por fecha y biografiaAutor. *******");
	        for (Book book: filterBooks) {
	        	System.out.println(book.toString());
	        }
			 System.out.println("----");

	        return Optional.of(new BookDate(latestBook, ""));
	    }

	

	@SuppressWarnings("null")
	private static Book findWord(List<Book> books, String filter) {
		
		Book resultado = new Book();
		for (Book book: books){
		    if (book.getTitle().contains(filter) || book.getSummary().contains(filter)
		            || book.getAuthor().getName().contains(filter)) {
				if (resultado != null ||  0 <  book.getPublicationTimestamp().compareTo(resultado.getPublicationTimestamp())) {
		            // Limpiar la lista si encontramos un libro más recientemente publicado
		            resultado = new Book();
		            resultado = book;
		        }
		    }
		}
		System.out.println("Encontrado: " +resultado);
		return resultado;
	}

	
	
	private static void ordenarFechas(List<Book> booksList) {
		
		 List<Book> bookConFecha = imprimirConFechaPublicacion(booksList);
		
		 Book[] books = bookConFecha.toArray(new Book[bookConFecha.size()]);

		Arrays.sort(books, Comparator.comparing(Book::getPublicationTimestamp));
		
		// Imprimir los libros ordenados
		for (Book book : books) {
		    System.out.println("Imprimir LibroFecha: "+ book.getTitle() + ": " +formatDate(book.getPublicationTimestamp()));
		}
	}

	/*
	 * Escriba por pantalla los libros que no tengan fecha de publicación
	 */
	private static void printWithoutDate(List<Book> listBooks) {
		listBooks.stream()
		        .filter(book -> book.getPublicationTimestamp() == null)
		        .forEach(book -> System.out.println("Libro sin fecha: " + book.getTitle()));

	}
	/*
	 * Escriba por pantalla los libros que no tengan fecha de publicación
	 */
	private static void printAllBooks(List<Book> listBooks) {
		listBooks.stream()
		        .forEach(book -> System.out.println("Libro: " + book));

	}


	private static List<Book> imprimirConFechaPublicacion(List<Book> listBooks) {
		List<Book> listBookswithtDate = new ArrayList<Book>();
		for(Book book : listBooks) {
				if(book.getPublicationTimestamp()!= null)				
					listBookswithtDate.add(book);

		}
		return listBookswithtDate;
	}

	
    private static String formatDate(Long publicationTimestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(publicationTimestamp != null)
        	return sdf.format(new Date(publicationTimestamp));

        return "";
    }

    
    
    

}
