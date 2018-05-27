package com.henrybear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.henrybear.bean.Book;
import com.henrybear.service.BookService;


@Controller
public class BookController {

	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	@RequestMapping("/main")
	public String main(Model model) {
		List<Book> book_list = bookService.getAll();
		model.addAttribute("book_list", book_list);
		return "main";
	}
}
