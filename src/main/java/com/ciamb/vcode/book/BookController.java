package com.ciamb.vcode.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciamb.vcode.book.mapper.BookListMapper;
import com.ciamb.vcode.book.mapper.BookMapper;
import com.ciamb.vcode.book.model.BookInsert;
import com.ciamb.vcode.book.model.BookView;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/book")
@Log4j2
public class BookController {
    @Autowired BookService service;
    @Autowired BookMapper mapper;
    @Autowired BookListMapper listMapper;

    @PostMapping    
    @Operation(description = "insert the requested book at db")
    void post(@RequestBody BookInsert request) {
        var item = mapper.apply(request);
        log.info("request insert book %s".formatted(request.name()));
        service.insert(item);
    }

    @GetMapping("/all")
    @Operation(description = "read all")
    ResponseEntity<List<BookView>> readAll() {
        log.info("gathering all book infos");
        var res = listMapper.apply(service.readAll());
        return ResponseEntity.ok().body(res);
    }
    
}
