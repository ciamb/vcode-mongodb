package com.ciamb.vcode.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/book")
@Log4j2
public class BookController {
    @Autowired BookService service;
    @Autowired BookMapper mapper;

    @PostMapping    
    @Operation(description = "insert the requested book at db")
    void post(@RequestBody BookInsert request) {
        var item = mapper.apply(request);
        log.info("request insert book %s".formatted(request.name()));
        service.insert(item);
    }
    
}
