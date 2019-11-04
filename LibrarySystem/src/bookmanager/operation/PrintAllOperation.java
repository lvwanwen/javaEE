package bookmanager.operation;

import bookmanager.book.BookList;

public class PrintAllOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("打印所有书籍信息");
        for(int i=0;i<booklist.getSize();i++){
            System.out.println(booklist.getBook(i));
        }
        System.out.println("共计 " + booklist.getSize() + " 本书!");
    }
}
