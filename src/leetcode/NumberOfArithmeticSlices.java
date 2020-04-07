package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
数组 A 包含 N 个数，且索引从 0 开始。该数组子序列将划分为整数序列 (P0, P1, ..., Pk)，P 与 Q 是整数且满足 0 ≤ P0 < P1 < ... < Pk < N。

如果序列 A[P0]，A[P1]，...，A[Pk-1]，A[Pk] 是等差的，那么数组 A 的子序列 (P0，P1，…，PK) 称为等差序列。值得注意的是，这意味着 k ≥ 2。
函数要返回数组 A 中所有等差子序列的个数。
输入包含 N 个整数。每个整数都在 -231 和 231-1 之间，另外 0 ≤ N ≤ 1000。保证输出小于 231-1。
 */
public class NumberOfArithmeticSlices {
    public static void main(String[] args){
        int[] data={1,2,3,4,5,6,7,8,9,10};
        System.out.println(numberOfArithmeticSlices(data));
    }
   /* public static int numberOfArithmeticSlices(int[] A) {
        double len=(double)A.length;
        double sum=0;
        int fir=0;
        for(int i=0;i<Integer.MAX_VALUE;i++){
            if(i*2+3>=len){
                fir=i;
                break;
            }
        }
        for(int i=1;i<=fir;i++){
            double num=Math.floor(len/i);//根据跨度获取等差序列个数下限
            double res=len%i;//是否有商
            if(res!=0){//有商情况下有res条num+1个数的等差数列和一条num等差数列
                for (int j=3;j<=num+1;j++){
                    sum+=(num-j+2)*res;
                }
                for(int j=3;j<=num;j++){
                    sum+=num-j+1;
                }
            }
            if(res==0){//无商情况下有i条num个数的等差数列
                for (int j=3;j<=num;j++){
                    sum=sum+(num-j+1)*i;
                }
            }
        }
        return (int)sum;
    }*/

    public static int numberOfArithmeticSlices(int[] A) {
        int n, result = 0;
        if (null == A || (n = A.length) < 3) {
            return 0;
        }
        Map<Integer, Integer>[] dp = new Map[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long gap = (long) A[i] - A[j];
                if (gap < Integer.MIN_VALUE || gap > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) gap, sum = dp[j].getOrDefault(diff, 0);
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + sum + 1);
                result += sum;  //sum统计的是dp[j][gap]的值，如果该值不为0，说明已经存在两个元素，再加上A[i]，就满足了3个元素的要求
            }
        }
        return result;
    }
}
