import com.kj.pojo.Books;
import com.kj.service.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl = context.getBean("bookServiceImpl", BookServiceImpl.class);
        List<Books> booksList = bookServiceImpl.queryAllBooks();
        for (Books books : booksList) {
            System.out.println(books);
        }
    }
}
