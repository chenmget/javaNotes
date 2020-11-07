package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-10-15 19:52
 **/
public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10000000);

        Long start = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            list.add(0,"1");
        }
        System.out.println("list添加耗时："+(System.currentTimeMillis()-start));

        List<String> link = new LinkedList<>();
        Long start1 = System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            link.add("1");
        }
        System.out.println("link添加耗时："+(System.currentTimeMillis()-start1));
    }
}
