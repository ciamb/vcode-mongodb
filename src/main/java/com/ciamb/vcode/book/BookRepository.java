package com.ciamb.vcode.book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ciamb.vcode.book.model.BookItem;

@Repository
public interface BookRepository extends MongoRepository<BookItem, Long> {

}

