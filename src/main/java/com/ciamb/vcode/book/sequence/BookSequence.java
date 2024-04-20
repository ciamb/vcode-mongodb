package com.ciamb.vcode.book.sequence;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "book-sequences")
public record BookSequence(
    @Id
    String id,

    long sequences,
    @Field(name = "last_entrance")
    LocalDateTime lastEntrance
) { }
