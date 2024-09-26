package com.example.demo.lab3;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @PostMapping("/book")
    public BookResponse receiveBook(@RequestBody Book book) {
        BookResponse response = new BookResponse();
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setStatus("received");
        return response;
    }
}

class Book {
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class BookResponse extends Book {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}