package com.kj.service;

import com.kj.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    // 增加一本书
    int addBook(Books book);

    // 删除一本书
    int deleteBookByID(int ID);

    // 更新一本书
    int updateBook(Books book);

    // 查询一本书
    Books queryBookByID(int id);

    // 查询全部的书
    List<Books> queryAllBooks();

    // 根据名字查询书籍
    Books queryBookByName(String bookName);
}
