package com.ciamb.vcode.book.mapper;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.ciamb.vcode.book.model.BookItem;
import com.ciamb.vcode.book.model.BookView;

@Component
public class BookListMapper implements Function<List<BookItem> , List<BookView>> {

    @Override
    public List<BookView> apply(List<BookItem> t) {
        return t.stream()
            .map(b -> new BookView(
                b.id(), b.name(), b.pageNumber(), b.createdDate()
            ))
            .toList();
    }


}
