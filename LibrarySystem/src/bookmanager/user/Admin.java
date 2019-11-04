package bookmanager.user;

import bookmanager.operation.*;

public class Admin extends User {
    public Admin(String name) {
        super(name);
        operations=new IOperation[]{
           new ExitOperation(),
           new FindOperation(),
           new AddOperation(),
           new DelOperation(),
           new PrintAllOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("============");
        System.out.println("hello " + name);
        System.out.println("1. 查找图书");
        System.out.println("2. 增加图书");
        System.out.println("3. 删除图书");
        System.out.println("4. 打印所有图书信息");
        System.out.println("0. 退出");
        System.out.println("============");
        System.out.println("请输入您的选择: ");
        int choice=scanner.nextInt();
        return choice;
    }
}
