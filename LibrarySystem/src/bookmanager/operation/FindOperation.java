package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("查找书籍");
        System.out.println("请输入要查找的书名: ");
        String name = scanner.next();
        int count=0;
        for(int i=0;i<booklist.getSize();i++){
            Book book=booklist.getBook(i);
            if(book.getName().equals(name)){
                System.out.println(book);
                count++;
            }
        }
        if(count==0){
            System.out.println("没找到此书");
        }else{
            System.out.println("共计找到 " + count + " 本书!");
        }
    }
}
