package com.ciamb.vcode.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciamb.vcode.generic.service.Insert;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BookService implements Insert<BookItem> {

    @Autowired
    BookRepository repository;

    @Override
    public BookItem insert(BookItem item) {
        log.info("trying insert book %s".formatted(item.name()));
        return repository.save(item);
    }

}
