package com.ciamb.vcode.book.model;

import java.time.LocalDateTime;

public record BookView(
    Long id,
    String name, 
    Integer pageNumber,
    LocalDateTime createdDate
) {

}
