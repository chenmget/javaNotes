package com.leetcode.demo1;

import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        Demo2 d = new Demo2();
        //System.out.println(d.isPalindrome(121));
        //int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        //System.out.println(d.maxArea(height));
        //int[] nums=new int[]{-1,0,1,2,-1,-4};
//        int[] nums=new int[]{3,0,-2,-1,1,2};//-2 -1 0 1 2 3
//        List<List<Integer>> rst = d.threeSum(nums);
//        System.out.println(rst.toString());

        int[] nums=new int[]{-3,-2,-5,3,-4};//-2 -1 0 1 2 3
        System.out.println( d.threeSumClosest(nums,-1));
    }

    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<>();
        if(digits==null){
            return rst;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        char[] chars = digits.toCharArray();
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            makeupDate(rst,phoneMap,c);
        }
        return rst;
    }

    private void makeupDate(List<String> rst, Map<Character, String> phoneMap, char c) {
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=100000000;
        int rst=0;
        for(int i=0;i<nums.length-2;i++){

            int first=i+1;
            int last= nums.length-1;
            while(first<last&&first<=nums.length-2){
                int sum = nums[i]+nums[first]+nums[last];
                if(sum==target){
                    return sum;
                }else if(sum>target){
                    if(Math.abs(sum-target)<Math.abs(diff)){
                        diff = sum-target;
                        rst = sum;
                    }
                    last--;
                }else{
                    if(Math.abs(target-sum)<Math.abs(diff)){
                        diff = target-sum;
                        rst = sum;
                    }
                    first++;
                }
            }
        }
        return rst;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if(nums.length<3){
            return rst;
        }
        //对数据排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0){
                if(nums[i]==nums[i-1]){
                    continue;
                }
            }
            int first=i+1;
            int last= nums.length-1;
            while(first<last&&first<=nums.length-2){
                int sum = nums[i]+nums[first]+nums[last];
                if(sum==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[first]);
                    temp.add(nums[last]);
                    rst.add(temp);
                    while(nums[first+1] == nums[first]&&first<nums.length-2){
                        first++;
                    }
                    first++;

                }else if(sum<0){
                    while(nums[first+1] == nums[first]&&first<nums.length-2){
                        first++;
                    }
                    first++;
                }else{
                    while(nums[last-1] == nums[last]&&last>first){
                        last--;
                    }
                    last--;
                }
            }

        }
        return rst;
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
