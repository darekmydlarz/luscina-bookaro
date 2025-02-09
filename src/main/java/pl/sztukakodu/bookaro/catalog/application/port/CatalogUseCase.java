package pl.sztukakodu.bookaro.catalog.application.port;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import pl.sztukakodu.bookaro.catalog.domain.Book;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

public interface CatalogUseCase {
    List<Book> findByTitle(String title);
    Optional<Book> findOneByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findAll();

    List<Book> findByTitleAndAuthor(String author, String title);

    Book addBook(CreateBookCommand command);

    void removeById(Long id);

    UpdateBookResponse updateBook(UpdateBookCommand command);

    Optional<Book> findById(Long id);

    @Value
    class CreateBookCommand {
        String title;
        String author;
        Integer year;
        BigDecimal price;

        public Book toBook(){
            return new Book(title, author, year, price);
        }
    }
    @Value
    @Builder
    @RequiredArgsConstructor
    class UpdateBookCommand {
        Long id;
        String title;
        String author;
        Integer year;


        public Book updateFields(Book book){
            if(title != null){
                book.setTitle(title);
            }
            if(author != null){
                book.setAuthor(author);
            }
            if(year != null){
                book.setYear(year);
            }
            return book;
        }
    }
    @Value
    class UpdateBookResponse{
        public static UpdateBookResponse SUCCESS = new UpdateBookResponse(true, emptyList());
        boolean success;
        List<String> error;
    }
}
