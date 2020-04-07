package leetcode;
/*
给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
示例 1:
输入: [0,1,2,4,5,7]
输出: ["0->2","4->5","7"]
解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
示例 2:
输入: [0,2,3,4,6,8,9]
输出: ["0","2->4","6","8->9"]
解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SummaryRanges {
    public static void main(String[] args){
        int[] data=new int[]{0,2,3,4,6,8,9};
        System.out.print(summaryRanges(data).toString());
    }
    public static List<String> summaryRanges(int[] nums) {
       Stack<Integer> stack=new Stack<>();
       List<String> list=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
           if(stack.isEmpty()){
               stack.add(nums[i]);
           }else {
               int peek=stack.peek();
               if(peek+1==nums[i]){
                   if(stack.size()==1){
                       stack.push(nums[i]);

                   }else {
                       stack.pop();
                       stack.push(nums[i]);

                   }
               }else {
                   if(stack.size()==1){
                       list.add(Integer.toString(stack.pop()));
                       stack.add(nums[i]);
                   }else {
                       String str="";
                       str+="->"+Integer.toString(stack.pop());
                       str=Integer.toString(stack.pop())+str;
                       list.add(str);
                       stack.add(nums[i]);
                   }
               }
           }
       }
       if(stack.size()==1){
           list.add(Integer.toString(stack.pop()));
       }
       if(stack.size()==2){
           String str="";
           str+="->"+Integer.toString(stack.pop());
           str=Integer.toString(stack.pop())+str;
           list.add(str);
       }
       return list;
    }
}
