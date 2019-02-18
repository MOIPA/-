import java.awt.*;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        Long i = 10l;
//        int a = 1;
//        long b =1l;
//        Long c = 10l;
//        System.out.println(i==c);
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        Float x = 3.0f;
        System.out.println(c==d); //true
        System.out.println(e==f); //false
        System.out.println(c==(a+b)); //? true
        System.out.println(c.equals(a+b)); //true
        System.out.println(g==(a+b)); //? true ????????
        System.out.println(g.equals(a+b)); //? false
        System.out.println(g.equals(a+h)); //? true
        System.out.println(g.getClass().getName());
        System.out.println(x==(a+b)); //? true ????????

        Student xm = new Student();
        xm.setName("xm");
        changeName("tr",xm);
        System.out.println(xm.getName());

        List<Object> list = new Vector<>();
    }
    public static void changeName(String name,Student stu){
        stu.setName(name);
    }
}
class Student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
