package package2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Card /*implements Comparable<Card>*/{
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {//alt+insert->equals hashcode
        if (this == o) return true;//判断this和o是不是指向同一个对象
        if (!(o instanceof Card)) return false;//判断Card是不是o的实例
        Card card = (Card) o;
        return rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    /*@Override
    public int compareTo(Card o) {
        *//*if(this.rank > o.rank) {
            return 1;
        }*//*
        //return 0;
        return this.rank - o.rank;
    }*/
}
//CardComparator->比较器-》牌面值
class CardComparator implements Comparator<Card>{


    @Override
    public int compare(Card o1, Card o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {//o1小
            return -1;
        }
        if (o2 == null) {//o1大
            return 1;
        }
        return o1.rank-o2.rank;
    }
}
class Student {
    public String name;

    public Student(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj instanceof Student) {
            Student student = (Student) obj;
            return this.name.equals(student.name);
        }
        return false;
    }
}
public class Demo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student("l");
        Student student2 = new Student("l");
        list.add(student1);
        System.out.println(student1.equals(student2));
        System.out.println(list.contains(student2));
        //在源代码中contains调用的是equals,此时equals已经重写了，所以是true,
        //如果equals不重写，就是false
    }


    public static void main1(String[] args) {
        Card card1 = new Card(3,"♥");
        Card card2 = new Card(2,"♥");
       /* System.out.println(card1.equals(card2));

        System.out.println(card1.compareTo(card2));
*/
        Comparator<Card> cardComparator = new CardComparator();

        int ret = cardComparator.compare(card1,card2);
        System.out.println(ret);
    }
}
