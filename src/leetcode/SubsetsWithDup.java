package leetcode;

import java.util.*;
/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubsetsWithDup {
    public static void main(String[] args){
        int[] data={1,2,2};
        subsetsWithDup(data);
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<String> set=new HashSet<>();
        Arrays.sort(nums);
        int length=nums.length;
        int mark=0;
        int nEnd=1<<length;
        List<List<Integer>> lists=new ArrayList<>();
        for(mark=0;mark<nEnd;mark++){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<length;i++){
                if(((1<<i)&mark)!=0){//该位有元素输出
                    list.add(nums[i]);
                }
            }
            String str=list.toString();
            if(!set.contains(str)){
                lists.add(list);
                set.add(str);
            }
        }
        return lists;
    }
}
