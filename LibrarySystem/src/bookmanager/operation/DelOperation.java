package bookmanager.operation;

import bookmanager.book.Book;
import bookmanager.book.BookList;


public class DelOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("删除书籍");
        System.out.println("请输入要删除的序号: ");
        String id = scanner.next();
        //先查找
        int i;
        for(i=0;i<booklist.getSize();i++){
            Book book=booklist.getBook(i);
            if(book.getId().equals(id)){
                //找到了
                break;
            }
        }
        if(i>=booklist.getSize()){
            //没找到
            System.out.println("未找到要删除的书籍!");
            return;
        }
        //处理找到了的情况
        Book lastBook=booklist.getBook(booklist.getSize()-1);//找到最后一个元素
        booklist.setBook(i,lastBook);//将最后一个元素放到当前要删除元素的位置
        booklist.setSize(booklist.getSize()-1);//尾删
        System.out.println("删除成功!");
    }
}
