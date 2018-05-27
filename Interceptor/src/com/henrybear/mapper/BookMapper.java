package com.henrybear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.henrybear.bean.Book;

public interface BookMapper {

	@Select("select * from tb_book ")
	List<Book> findAll();

/*	@InsertProvider(type=com.henrybear.bean.Book.class, method="insertBook")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insertBook(Book book);*/
}
