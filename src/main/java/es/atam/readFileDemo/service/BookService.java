package es.atam.readFileDemo.service;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.atam.readFileDemo.json.Book;

@Service
public class BookService {

    public List<Book> readAndSortByDate() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("books.json"); // Asegúrate de que el archivo esté en la raíz de tu classpath.

        Book[] books = objectMapper.readValue(resource.getFile(), Book[].class);
        
        // Ordenar el array de books por timestamp usando un Comparator
        //Arrays.sort(books, Comparator.comparing(Book::getPublicationTimestamp));


        // Imprimir los libros ordenados
        for (Book book : books) {
            System.out.println(book.getTitle() + ": " + book.getPublicationTimestamp());
        }
        return Arrays.asList(books);
    }
}