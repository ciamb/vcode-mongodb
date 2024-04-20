package com.ciamb.vcode.book;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "book")
public record BookItem(
    @Id
    Long id,
    
    @Field(name = "name") 
    String name,

    @Field(name = "page_number") 
    Integer pageNumber,

    @Field(name = "craeted_date")
    LocalDateTime createdDate
) { 

    public static final Entrance enter() {
        return new Entrance();
    }

    public static final class Entrance {
        private Long id;
        private String name;
        private Integer pageNumber;
        private LocalDateTime createdDate;

        Entrance withId(Long id) {
            this.id = id;
            return this;
        }

        Entrance withName(String s) {
            this.name = s;
            return this;
        }

        Entrance withPageNumber(Integer i) {
            this.pageNumber = i;
            return this;
        }

        Entrance withCreatedDate(LocalDateTime dt) {
            this.createdDate = dt;
            return this;
        }

        public BookItem exit() {
            return new BookItem(id, name, pageNumber, createdDate);
        }
    } 
}
