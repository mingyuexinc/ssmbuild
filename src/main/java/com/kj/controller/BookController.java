package com.kj.controller;

import com.kj.pojo.Books;
import com.kj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部书籍，并返回到书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> booksList = bookService.queryAllBooks();
        model.addAttribute("list",booksList);
        return "allBook";
    }

    // 跳转到添加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage(Model model){
        return "addBook";
    }

    // 添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBooks=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";  // 重定向到@RequestMapping("/allBook")请求
    }

    // 跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePage(int id,Model model){
        Books book = bookService.queryBookByID(id);
        model.addAttribute("QBook",book);
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id){
        bookService.deleteBookByID(id);
        return "redirect:/book/allBook";
    }

    // 查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.err.println("queryBook=>"+books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if (books == null){
            list = bookService.queryAllBooks();
            model.addAttribute("error","未查到！");
        }
        // err:以红色日志形式打印结果
        model.addAttribute("list",list);
        return "allBook";
    }
}
