package com.design.singleton;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-12 18:15
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 以上这种⽅方式在我们平常的业务开发中⾮非常场常⻅见，这样静态类的⽅方式可以在第⼀一次运⾏行行的时候直
 * 接初始化Map类，同时这⾥里里我们也不不需要到延迟加载在使⽤用。
 * 在不不需要维持任何状态下，仅仅⽤用于全局访问，这个使⽤用使⽤用静态类的⽅方式更更加⽅方便便。
 * 但如果需要被继承以及需要维持⼀一些特定状态的情况下，就适合使⽤用单例例模式。
 */
public class Singleton_00 {
    public static Map<String,String> cache = new HashMap<String,String>();
}
