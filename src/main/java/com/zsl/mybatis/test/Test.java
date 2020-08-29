package com.zsl.mybatis.test;

/**
 * @author : zsl
 * @date : Created in 2020/6/27 5:21 下午
 */
public class Test {

    public static void main(String[] args) {
        int i = 2;
        i =+ 9;
        System.out.println(i);
        i += 3;
        System.out.println(i);

        // \\u000d System.out.println("hello");
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        System.out.println(a == b);
        System.out.println(c == d);

        System.out.println(a.equals(b));
        System.out.println(c.equals(d));

        System.out.println(a.equals(c));
    }
}
