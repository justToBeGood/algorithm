package leetcode;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。  每一回合，从中选出任意两块石头，然后将它们一起粉碎。
 * 假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：  如果 x == y，那么两块石头都会被完全粉碎； 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0  。
 * @Author: wengweixin
 * @E-mail： wengweixin@csair.com
 * @Date: 2021/6/8 11:25
 **/

/**
 * 解决思路：
 * 石头重量总和sum,将石头分成两堆n1,sum-n1,设计将n1更加接近sum/2,那两堆石头的相减就会更加接近
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] stones=new int[split.length];
        for(int i=0;i<split.length;i++){
           stones[i]=Integer.parseInt(split[i]);
        }
        System.out.println(lastStoneWeightII(stones));

    }
//f[i][j]表示在石头0-i并且容量0-j的最优解；当容量不允许放进去就不考虑，允许放进去就考虑放进去将去容量添加价值的最大值
    public static int lastStoneWeightII(int[] stones) {
      return 0;

    }
}
