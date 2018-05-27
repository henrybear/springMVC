package com.henrybear.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.henrybear.bean.Book;
import com.henrybear.mapper.BookMapper;
import com.henrybear.service.BookService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("bookService")
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bookMapper.findAll();
	}

	@Transactional(readOnly=true)
	@Override
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
//		return bookMapper.insertBook(book);
		return 0;
	}

}
