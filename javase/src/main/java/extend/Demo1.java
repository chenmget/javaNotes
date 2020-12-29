package extend;

public class Demo1 {
    private static final  int data= 1;
    private static final  People user = new People();

    public static void main(String[] args) {
        Demo1 d = new Demo1();
        d.methodA();
        System.out.println("finish");
    }

    private int methodA() {
        int a = 1;
        int b = 2;
        int c = (a+b)*10;
        return c;
    }
}
