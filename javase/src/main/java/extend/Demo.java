package extend;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-16 16:07
 **/
public class Demo {
    public static void main(String[] args) {
        //A a = new B();
        int i=12;
        i=i++;
        System.out.println(i);
    }
}

class A {
    int a = 3;

    public A() {
        if (a == 5) {
            printA();
        }
    }

    public void printA() {
        System.out.println(a);
    }
}

class B extends A {
    static int  a = 5;

    public B() {
        printA();
    }

    public void printA() {
        System.out.println(a);
    }
}
