package com.ciamb.vcode.book.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookInsert(
    String name,
    
    @JsonProperty(value = "page_number")
    Integer pageNumber
) { }
