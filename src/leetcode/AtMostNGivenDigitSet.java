package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AtMostNGivenDigitSet {
    public static void main(String[] args){
        String[] str={"3","4","5","6"};
        System.out.println(atMostNGivenDigitSet(str,64));
    }
    public static int atMostNGivenDigitSet(String[] D, int N) {
        String num=String.valueOf(N);
        String[] arr=num.split("");
        int fri=0;
        for(int i=1;i<arr.length;i++){
            fri=fri+(int)Math.pow(D.length,i);
        }
        String S = String.valueOf(N);
        int K = S.length();
        int[] dp = new int[K+1];
        dp[K] = 1;

        /*
        考虑完位数小于 K 的数，我们接下来考虑位数等于 K 的数，我们用 N = 2345 作为例子来考虑所有合法的 K = 4 位数。
如果第 1 个数位比 N 中对应的第 1 个数位（即 2）小，那么剩下的 3 个数位我们可以使用 D 中的任何一个数字，因此有 |D|^{k-1}∣D∣ k−1个合法的数。
如果第 1 个数位和 N 中对应的第 1 个数位（即 2）相等，那么从第 2 个数位开始，它既可以比 N 中对应的第 2 个数位（即 3）小，也可以相等。此时相当于我们在考虑一个 K - 1 位数的问题。
         */
        for (int i = K-1; i >= 0; --i) {
            // compute dp[i]
            int Si = S.charAt(i) - '0';
            //下面是重点，假如d值小于Si，则Math.pow(D.length, K-i-1),总的就是n*Math.pow(D.length, K-i-1)，n是小于Si的个数
            //等到d值等于Si时，把前面的值加进来小于的值S.char(i+1)的值个数加进来加进来
            for (String d: D) {
                if (Integer.valueOf(d) < Si)
                    dp[i] += Math.pow(D.length, K-i-1);
                else if (Integer.valueOf(d) == Si)
                    dp[i] += dp[i+1];
            }
        }
        return fri+dp[0];
    }
}
