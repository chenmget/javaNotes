package com.leetcode.demo1;

import com.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Demo1 {



    public static void main(String[] args) {
        Demo1 d = new Demo1();

//        String s = "pwwkew";
//        System.out.println(d.lengthOfLongestSubstring(s));
//        System.out.println(d.longestPalindrome("babad"));
        System.out.println(d.convert("PAYPALISHIRING",4));
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
        int n =s.length();
        int y = s.length();
        if(numRows!=1){
            y = n/(numRows-1);
        }
        Character[][] array=new Character[numRows][y+1];
        int i=0;
        int j=0;
        boolean add = true;
        char[] chars = s.toCharArray();
        for(int k=0;k<n;k++){
            array[i][j]=chars[k];
            if(numRows==1){
                j++;
            }else{
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
            j=k/(numRows-1);

        }
        StringBuffer ans = new StringBuffer();
        for(int k=0;k<numRows;k++){
            for(int z=0;z<y;z++){
                if(array[k][z]!=null){
                    ans.append(array[k][z]);
                }
            }
        }

        return ans.toString();
    }

}
