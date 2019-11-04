package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;


public class AddOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("新增一本书籍");
        System.out.println("请输入书名:");
        String name = scanner.next();
        System.out.println("请输入序号:");
        String id = scanner.next();
        System.out.println("请输入作者: ");
        String author = scanner.next();
        System.out.println("请输入价格:");
        int price = scanner.nextInt();
        System.out.println("请输入类别: ");
        String type = scanner.next();
        Book book=new Book(name,id,author,price,type,false);
        booklist.setBook(booklist.getSize(),book);//放到所有书的最后一个位置上
        booklist.setSize(booklist.getSize()+1);
    }
}
