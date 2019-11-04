package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;


public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("归还书籍");
        System.out.println("请输入要归还的书的编号: ");
        String id = scanner.next();
        Book book=null;
        int i=0;
        for (; i < booklist.getSize(); i++) {
            if (booklist.getBook(i).getId().equals(id)) {
                book = booklist.getBook(i);
                break;
            }
        }
        if(i>=booklist.getSize()) {
            System.out.println("没有此书籍");
            return;
        }
        if(!book.isBorrowed()) {//false
            System.out.println("这本书已经被归还了!");
            return;
        }
        book.setBorrowed(false);
        System.out.println("归还成功!");
    }
}
