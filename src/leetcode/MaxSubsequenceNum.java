package leetcode;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */

public class MaxSubsequenceNum {
    public static void main(String[] args){
        int[] origin={1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(origin));
    }
    /*public static int lengthOfLIS(int[] nums) {
        List<int[]> firLink= new LinkedList();
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                firLink.add(new int[]{i-1,i});
            }
        }
        Stack<int[]> sequende=new Stack<>();

        for(int i=0;i<firLink.size();i++){
            if(sequende.isEmpty()){
                sequende.push(firLink.get(i));
            }
            else{
                int[] item=sequende.peek();
                if(item[1]==firLink.get(i)[0]){
                    sequende.pop();
                    sequende.push(new int[]{item[0],firLink.get(i)[1]});
                }
                else {
                    sequende.push(firLink.get(i));
                }
            }
        }
        int max=0;
        while (!sequende.isEmpty()){
            int[] item=sequende.pop();
            if(item[1]-item[0]>max){
                max=item[1]-item[0];
            }
        }
        if(nums.length==0){
            return max;
        }
        else {
            return max+1;
        }

    }*/
    public static int lengthOfLIS(int[] nums) {
        int[] maxlen=new int[nums.length];
        int res=1;
        for(int i=0;i<nums.length;i++){
            int len=1;
           for(int j=i;j>0;j--){
               if(nums[i]>nums[j-1]){
                   if(len<maxlen[j-1]+1){
                       len=maxlen[j-1]+1;
                   }
               }
           }
           maxlen[i]=len;
           res=Math.max(len,res);
        }
        if(nums.length==0){
            return 0;
        }
        return res;
    }
}
