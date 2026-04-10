package com.restaurant.controller;

import com.restaurant.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private List<Book> books = Arrays.asList(
            new Book(1, "Nobita", "Xeko", 500000),
            new Book(2, "Doraemon", "Nobita", 200000),
            new Book(3, "One Piece", "Doraemon", 350000),
            new Book(4, "Conan", "Shizuka", 150000)
    );

    @GetMapping
    public String showBooks(Model model) {
        model.addAttribute("books", books);
        model.addAttribute("title", "Danh sách sách");
        return "books";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable ("id") int id, Model model) {
        for (Book b : books) {
            if (b.getId() == id) {
                model.addAttribute("book", b);
                model.addAttribute("title", "Chi tiết sách");
                return "detail";
            }
        }
        return "redirect:/books";
    }
}