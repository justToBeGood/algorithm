package leetcode;

import java.util.*;
/*
数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
我们最多能将数组分成多少块？
示例 1:
输入: arr = [4,3,2,1,0]
输出: 1
解释:将数组分成2块或者更多块，都无法得到所需的结果。
例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
示例 2:
输入: arr = [1,0,2,3,4]
输出: 4
解释:我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。

 */
public class MaxChunksToSorted {
    public static void main(String[] args){
        int[] data={2,0,1,3};
        maxChunksToSorted(data);
    }
    public static int maxChunksToSorted(int[] arr) {
        int start=-1;
        int index=0;
        int block=0;
        List<List<Integer>> lists=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            boolean flag=false;
            if(arr[i]==start+1){
                List<Integer> list=new LinkedList<>();
                for(int j=index;j<=i;j++){
                    list.add(arr[j]);
                }
                Collections.sort(list);
                for(int j=0;j<list.size()-1;j++){
                    if(list.get(j)+1!=list.get(j+1)){
                        flag=true;
                        start=list.get(j);
                        break;
                    }
                }
                if(flag){
                    continue;
                }
                start=list.get(list.size()-1);
                block++;
                List<Integer> clone=new ArrayList<>(list);
                lists.add(clone);
                index=i+1;
            }
        }
        if(block==0){
            return 1;
        }
        return block;
    }
}
