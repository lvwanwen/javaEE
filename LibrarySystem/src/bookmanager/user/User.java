package bookmanager.user;

import bookmanager.book.BookList;
import bookmanager.operation.IOperation;

import java.util.Scanner;

abstract public class User {
    protected String name;//用户的名字
    protected IOperation[] operations;//当前用户支持的操作对象

    public User(String name) {
        this.name = name;
    }
    //打印一个操作菜单，不同的用户支持的操作不同，对应的菜单也就不同
    Scanner scanner = new Scanner(System.in);
    abstract public int menu();
    //根据用户输入的选项（menu返回结果）调用对应的操作对象
    public void doOperation(int choice, BookList booklist){
        operations[choice].work(booklist);
    }
}
