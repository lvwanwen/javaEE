package bookmanager.operation;

import bookmanager.book.BookList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BookList booklist) {
        System.out.println("goodbye!");
        System.exit(0);//相当于C中的return 0
    }
}
