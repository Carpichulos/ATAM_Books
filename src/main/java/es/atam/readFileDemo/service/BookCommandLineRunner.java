package es.atam.readFileDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.atam.readFileDemo.json.Book;

@Component
public class BookCommandLineRunner implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        // Leer y ordenar los libros por fecha
        List<Book> sortedBooks = bookService.readAndSortByDate();

        // Imprimir por pantalla los libros sin fecha
        sortedBooks.stream()
                .filter(book -> book.getPublicationTimestamp() == null)
                .forEach(book -> System.out.println("Libro sin fecha: " + book.getTitle()));
    }

}