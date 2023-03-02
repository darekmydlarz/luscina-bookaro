package pl.sztukakodu.bookaro.catalog.infrastructure;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.sztukakodu.bookaro.catalog.domain.Book;
import pl.sztukakodu.bookaro.catalog.domain.CatalogRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Primary
class BestsellerCatalogRepository implements CatalogRepository {
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();

    public BestsellerCatalogRepository() {
        storage.put(1L, new Book(1L, "Harry Potter i Komnata Tajemnic", "JK Rowlings", 1988));
        storage.put(2L, new Book(2L, "Władca Pierścieni: Dwie wieże", "JRR Tolkien", 1954));
        storage.put(3L, new Book(3L, "Mężczyźni, którzy nienawidzą kobiet", "Stieg Larsson", 2005));
        storage.put(4L, new Book(4L, "Sezon Burz", "Andrzej Sapkowski", 2013));
    }

    @Override
    public Collection<Book> listAll() {
        return new ArrayList<>(storage.values());
    }
}
