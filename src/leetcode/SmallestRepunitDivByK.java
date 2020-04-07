package leetcode;
/*
给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
返回 N 的长度。如果不存在这样的 N，就返回 -1。
示例 1：
输入：1
输出：1
解释：最小的答案是 N = 1，其长度为 1。
示例 2：
输入：2
输出：-1
解释：不存在可被 2 整除的正整数 N 。
 */
public class SmallestRepunitDivByK {
    public static void main(String[] args){
        int K=3;
        System.out.print(smallestRepunitDivByK(K));
    }
    public static int smallestRepunitDivByK(int K) {
        if(K%2==0||K%5==0)
            return -1;
        int i=1;
        for(int num=1;num%K!=0;i++){
            num=(num*10+1)%K;
            //num%=K;
        }
        return i;
    }

}
