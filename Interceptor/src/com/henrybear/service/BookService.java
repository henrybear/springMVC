package com.henrybear.service;

import java.util.List;

import com.henrybear.bean.Book;

public interface BookService {

	List<Book> getAll();
	int insertBook(Book book);
}
