package com.leetcode.demo1;

import com.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo2 {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Demo2 d = new Demo2();
        //53. 最大子序和
        int[] nums=new int[]{1,2};
        System.out.println(d.maxSubArray(nums));

        //38. 外观数列
//        System.out.println(d.countAndSay(6));
        //22. 括号生成
//        System.out.println( d.generateParenthesis(3));
        //21. 合并两个有序链表

        //19. 删除链表的倒数第 N 个结点

        //System.out.println(d.isPalindrome(121));
        //int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        //System.out.println(d.maxArea(height));
        //int[] nums=new int[]{-1,0,1,2,-1,-4};
//        int[] nums=new int[]{3,0,-2,-1,1,2};//-2 -1 0 1 2 3
//        List<List<Integer>> rst = d.threeSum(nums);
//        System.out.println(rst.toString());

//        int[] nums=new int[]{-3,-2,-5,3,-4};//-2 -1 0 1 2 3
//        System.out.println( d.threeSumClosest(nums,-1));

        //17电话号码的字母组合
//        String digits = "23";
//        System.out.println( d.letterCombinations(digits));

        //18四数之和
//        int[] nums=new int[]{0,0,0,0};
//        System.out.println( d.fourSum(nums,0));
    }

    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int sum=0;int start=-1;int end=-1;int maxval=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                end=i;
                if(start==-1){
                    start=i;
                }
            }
            maxval=maxval>nums[i]?maxval:nums[i];
        }
        if(start==end&&start==-1){
            return maxval;
        }
        for(int i=start;i<=end;i++){
            sum+=nums[i];
        }
        int max=sum;
        while (start<end){
            sum-=nums[start];
            max=max>sum?max:sum;
            start++;
            while(nums[start]<0&&start<end){
                sum-=nums[start];
                start++;
            }
            max=max>sum?max:sum;

            sum-=nums[end];
            max=max>sum?max:sum;
            end--;
            while(nums[end]<0&&start<end){
                sum-=nums[end];
                end--;
            }

            max=max>sum?max:sum;
        }
        return max;
    }

    /**
     * 外观数列
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int j = i + 1;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            sb.append(j - i);
            sb.append(chars[i]);
            i = j - 1;
        }
        return sb.toString();
    }


    public List<String> generateParenthesis(int n) {
        getParenthesis("", n, n);
        return res;
    }

    private void getParenthesis(String str, int l, int r) {
        if (l == r && l == 0) {
            res.add(str);
            return;
        }
        if (l == r) {
            str += "(";
            getParenthesis(str, l - 1, r);
        } else if (l < r) {
            if (l > 0) {
                getParenthesis(str + "(", l - 1, r);
            }
            str += ")";
            getParenthesis(str, l, r - 1);
        }
    }


    /**
     * 21. 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1==null){
//            return l2;
//        }else if(l2==null){
//            return l1;
//        }else if(l1.val<l2.val){
//            l1.next=mergeTwoLists(l1.next,l2);
//            return l1;
//        }else{
//            l2.next=mergeTwoLists(l1,l2.next);
//            return l2;
//        }
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode first = newHead;
        ListNode second = newHead;
        int i = 0;
        while (i < n) {
            first = first.next;
            i++;
        }
        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return newHead.next;

//        List<ListNode> list = new ArrayList<>();
//        ListNode node = head;
//
//        while(node!=null){
//            list.add(node);
//            node=node.next;
//        }
//        if(n==list.size()){
//            return head.next;
//        }
//        ListNode next =null;
//        if(n>1){
//            next = list.get(list.size()-n+1);
//        }
//        ListNode last = list.get(list.size()-n-1);
//        last.next=next;
//        return list.get(0);
    }

    /**
     * 18四数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return rst;
        }
        //对数组排序
        Arrays.sort(nums);
        int length = nums.length;
        //遍历数组
        for (int i = 0; i < nums.length - 3; i++) {
            //如果与前一位数字相同，不做处理
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //如果前四位加起来数值大于target，结束
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                return rst;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            //双指针
            int next = i + 1;
            while (next < length - 2) {
                if (next - 1 != i && nums[next] == nums[next - 1]) {
                    next++;
                    continue;
                }
                int first = next + 1;
                int last = length - 1;
                while (first < last) {
                    int sum = nums[i] + nums[next] + nums[first] + nums[last];
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[next]);
                        tmp.add(nums[first]);
                        tmp.add(nums[last]);
                        rst.add(tmp);
                        while (first < last && nums[first + 1] == nums[first]) {
                            first++;
                        }
                        first++;
                    } else if (sum > target) {
                        while (first < last && nums[last - 1] == nums[last]) {
                            last--;
                        }
                        last--;
                    } else {
                        while (first < last && nums[first + 1] == nums[first]) {
                            first++;
                        }
                        first++;
                    }
                }
                next++;
            }
        }
        return rst;
    }

    /**
     * 17电话号码的字母组合
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<>();
        if (digits == null) {
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
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            rst = makeupDate(rst, phoneMap, c);
        }
        return rst;
    }

    private List<String> makeupDate(List<String> rst, Map<Character, String> phoneMap, char c) {
        String v = phoneMap.get(c);
        List<String> nRst = new ArrayList<>();
        if (v == null) {
            return rst;
        }
        if (rst.size() == 0) {
            for (int i = 0; i < v.length(); i++) {
                nRst.add(String.valueOf(v.charAt(i)));
            }
        } else {
            for (int i = 0; i < v.length(); i++) {
                for (String s : rst) {
                    s += String.valueOf(v.charAt(i));
                    nRst.add(s);
                }
            }
        }
        return nRst;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = 100000000;
        int rst = 0;
        for (int i = 0; i < nums.length - 2; i++) {

            int first = i + 1;
            int last = nums.length - 1;
            while (first < last && first <= nums.length - 2) {
                int sum = nums[i] + nums[first] + nums[last];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    if (Math.abs(sum - target) < Math.abs(diff)) {
                        diff = sum - target;
                        rst = sum;
                    }
                    last--;
                } else {
                    if (Math.abs(target - sum) < Math.abs(diff)) {
                        diff = target - sum;
                        rst = sum;
                    }
                    first++;
                }
            }
        }
        return rst;
    }

    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums.length < 3) {
            return rst;
        }
        //对数据排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }
            int first = i + 1;
            int last = nums.length - 1;
            while (first < last && first <= nums.length - 2) {
                int sum = nums[i] + nums[first] + nums[last];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[first]);
                    temp.add(nums[last]);
                    rst.add(temp);
                    while (nums[first + 1] == nums[first] && first < nums.length - 2) {
                        first++;
                    }
                    first++;

                } else if (sum < 0) {
                    while (nums[first + 1] == nums[first] && first < nums.length - 2) {
                        first++;
                    }
                    first++;
                } else {
                    while (nums[last - 1] == nums[last] && last > first) {
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
        int r = height.length - 1;
        int s = 0;
        while (l != r) {
            int v1 = height[l];
            int v2 = height[r];
            s = Math.max(s, Math.min(v1, v2) * (r - l));
            if (v1 <= v2) {
                l++;
            } else {
                r--;
            }
        }
        return s;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int x1 = x;
        int a = 0;
        while (x != 0) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        return x1 == a;

    }
}
