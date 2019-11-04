package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("借阅书籍");
        //输入需要借阅书籍的编号
        //根据书籍的编号查找书籍是否存在
        //拿到书籍的对象，将书籍对象的isBorrowed=true
        System.out.println("请输入要借阅的书的编号: ");
        String id = scanner.next();
        int i = 0;
        for (; i < booklist.getSize(); i++) {
            if (booklist.getBook(i).getId().equals(id)) {
                break;
            }
        }
        if (i >= booklist.getSize()) {
            System.out.println("没有找到此书");
            return;
        }
        //i为此时借阅的书籍的下标
        Book book = booklist.getBook(i);
        //执行具体的借书操作
        if (book.isBorrowed()) {//若这本书此时的状态为true,说明被借走了
            System.out.println("这本书已经被借走了!");
        } else {
            book.setBorrowed(true);
            //若这本书此时的状态为false,说明没有被借走，将其状态设为true
            System.out.println("借书成功!");
        }
    }
}
