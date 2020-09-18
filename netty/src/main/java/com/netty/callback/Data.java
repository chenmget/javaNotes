package com.netty.callback;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-08-27 19:31
 **/
public class Data {
    private int m;
    private int n;

    public Data(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public String toString() {
        int r = n / m;
        return n + "/" + m + "=" + r;
    }
}
