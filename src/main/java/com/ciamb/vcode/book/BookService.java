package com.ciamb.vcode.book;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciamb.vcode.book.model.BookItem;
import com.ciamb.vcode.generic.service.Insert;
import com.ciamb.vcode.generic.service.Read;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BookService implements Insert<BookItem>, Read<BookItem> {

    @Autowired
    BookRepository repository;

    @Override
    public BookItem insert(BookItem item) {
        log.info("trying insert book %s".formatted(item.name()));
        return repository.save(item);
    }

    @Override
    public BookItem readBy(long id) {
        log.info("searching for book with id: %s".formatted(id));
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<BookItem> readAll() {
        return repository.findAll();
    }

}
