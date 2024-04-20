package com.ciamb.vcode.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookInsert(
    String name,
    
    @JsonProperty(value = "page_number")
    Integer pageNumber
) { }
