package leetcode;

import java.util.*;
/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

 */
public class CombinationSum2 {
    public static void main(String[] args){
        int[] data={10,1,2,7,6,1,5};
        int target=8;
        combinationSum2(data,8);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        Set<String> set=new HashSet<>();
        int length=candidates.length;
        int mark=0;
        int nEnd=1<<length;
        Arrays.sort(candidates);

        for(mark=0;mark<nEnd;mark++){
            int sum=0;
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<length;i++){
                if(((1<<i)&mark)!=0){//该位有元素输出
                    list.add(candidates[i]);
                    sum+=candidates[i];
                }
            }
            String str=list.toString();
            if (sum==target && !set.contains(str)){
                set.add(str);
                lists.add(list);

            }
        }
        return lists;
    }
}
