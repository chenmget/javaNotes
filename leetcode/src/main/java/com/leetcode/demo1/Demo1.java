package com.leetcode.demo1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo1 {



    public static void main(String[] args) {
        Demo1 d = new Demo1();

//        String s = "pwwkew";
//        System.out.println(d.lengthOfLongestSubstring(s));
//        System.out.println(d.longestPalindrome("babad"));
//        System.out.println(d.convert("PAYPALISHIRING",4));
//        System.out.println(d.reverse(321));
//        System.out.println(d.intToRoman(20));
        System.out.println(d.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int rst = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            int val =getValue(c);
            int nextval=-1;
            if(i!=chars.length-1){
                nextval = getValue(chars[i+1]);
            }
            if(nextval==-1||val>=nextval){
                rst+=val;
            }else{
                rst-=val;
            }


        }
        return rst;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    public String intToRoman(int num) {
        int[] nums = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] roman = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuffer rst = new StringBuffer();
        while(num!=0){
            for(int i=nums.length-1;i>=0;i--) {
                while(num-nums[i]>=0){
                    num=num-nums[i];
                    rst.append(roman[i]);
                }
            }
        }
        return rst.toString();
    }

    public int reverse(int x) {
        long rst=0;
        while(x!=0){
            rst=rst*10+x%10;
            x=x/10;
        }
        if(rst!=(int)rst){
            return 0;
        }
        return (int)rst;
    }


//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return dfs(l1,l2,0);
//    }
//
//    public ListNode dfs(ListNode l1, ListNode l2,int i){
//        if(l1==null&&l2==null&&i==0){
//            return null;
//        }
//        int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+i;
//        ListNode node = new ListNode(sum%10);
//        node.next=dfs(l1==null?null:l1.next,l2==null?null:l2.next,sum/10);
//        return node;
//    }


    public int lengthOfLongestSubstring(String s) {
       char[] array = s.toCharArray();
       Set<Character> set = new HashSet<>();
       int n =array.length;
       int rst = 0;
       int key=-1;
       for(int i=0;i<n;i++){
           if(i!=1){
               set.remove(array[i]);
           }
           while(key+1<n&&!set.contains(array[key+1])){
               set.add(array[key+1]);
               key++;
           }
           rst = Math.max(rst,key-i+1);
       }
       return rst;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if(l==0){
                    dp[i][j]=true;
                }else if(l==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                }
                if(dp[i][j]&&j-i>=ans.length()){
                    ans=s.substring(i,j+1);
                }
            }
        }
        return ans;
    }

    public String convert(String s, int numRows) {
        List<StringBuffer> list = new ArrayList<>();
        if(numRows==1){
            return s;
        }
        for(int i =0;i<numRows;i++){
            list.add(new StringBuffer());
        }
        char[] chars = s.toCharArray();
        int n =s.length();
        boolean add = true;
        int i=0;
        for(int k=0;k<n;k++){
            StringBuffer sb = list.get(0);
            sb.append(chars[k]);
            if(add){
                if(i+1>=numRows){
                    add=false;
                    i--;
                }else{
                    i++;
                }
            }else{
                if(i-1<0){
                    add=true;
                    i++;
                }else{
                    i--;
                }
            }
        }
        StringBuffer ans = new StringBuffer();
        for(int k=0;k<list.size();k++) {
            ans.append(list.get(k));
        }
        return ans.toString();
    }

}
