package package2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private String clas;//班级
    private double score;

    public Student(String name, String clas, double score) {
        this.name = name;
        this.clas = clas;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clas='" + clas + '\'' +
                ", score=" + score +
                '}';
    }
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        list.add(15);
        list.add(7);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void main1(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan","1班",99.4));
        list.add(new Student("lisi","1班",98.0));
        list.add(new Student("wangmazi","1班",89.4));
        list.add(new Student("caocao","1班",99.5));
        list.add(new Student("liubei","1班",100.0));
        for ( Student student : list  ) {
            System.out.println(student);
        }
        System.out.println("====排序========");
        Collections.sort(list);//Collections：操作集合的工具类
        for ( Student student : list  ) {
            System.out.println(student);
        }
    }
}
