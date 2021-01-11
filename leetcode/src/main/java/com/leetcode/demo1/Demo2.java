package com.leetcode.demo1;

public class Demo2 {
    public static void main(String[] args) {
        Demo2 d = new Demo2();
        //System.out.println(d.isPalindrome(121));
        int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(d.maxArea(height));

    }

    public int maxArea(int[] height) {
        int l = 0;
        int r=height.length-1;
        int s=0;
        while(l!=r){
            int v1 = height[l];
            int v2 = height[r];
            s = Math.max(s,Math.min(v1,v2)*(r-l));
            if(v1<=v2){
                l++;
            }else{
                r--;
            }
        }
        return s;
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int x1=x;
        int a=0;
        while(x!=0){
            a=a*10+x%10;
            x=x/10;
        }
        return x1==a;

    }
}
