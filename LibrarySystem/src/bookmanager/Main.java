package bookmanager;

import bookmanager.book.BookList;
import bookmanager.user.Admin;
import bookmanager.user.NormalUser;
import bookmanager.user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //程序的入口
        //1.准备好书籍信息数据
        BookList booklist=new BookList();
        //2.创建用户（这里的多态）
        User user=login();
        //3.进入主循环,没有这个的话只执行一次
        while(true){
            int choice=user.menu();
            user.doOperation(choice,booklist);
        }
    }
    public static User login(){//用户登录
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您的姓名：");
        String name=scanner.next();
        System.out.println("请输入您的角色:(1 普通用户 2 管理员)");
        int role=scanner.nextInt();
        if(role==1){
            return new NormalUser(name);
        }
        return new Admin(name);
    }
}
