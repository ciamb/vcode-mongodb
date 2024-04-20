package com.ciamb.vcode.book;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciamb.vcode.book.sequence.BookSequenceGenerator;

@Component
public class BookMapper implements Function<BookInsert, BookItem>{

    @Autowired
    BookSequenceGenerator generator;

    @Override
    public BookItem apply(BookInsert t) {
        return BookItem.enter()
        .withId(generator.generateSequence("_id"))
        .withName(t.name())
        .withPageNumber(t.pageNumber())
        .withCreatedDate(LocalDateTime.now(ZoneOffset.systemDefault()))
        .exit();
    }
}
