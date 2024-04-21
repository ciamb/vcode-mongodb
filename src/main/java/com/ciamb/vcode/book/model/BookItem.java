package com.ciamb.vcode.book.model;

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

    public static final Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Integer pageNumber;
        private LocalDateTime createdDate;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String s) {
            this.name = s;
            return this;
        }

        public Builder withPageNumber(Integer i) {
            this.pageNumber = i;
            return this;
        }

        public Builder withCreatedDate(LocalDateTime dt) {
            this.createdDate = dt;
            return this;
        }

        public BookItem build() {
            return new BookItem(id, name, pageNumber, createdDate);
        }
    } 
}
