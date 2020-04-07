package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
/*
今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
示例：
输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
输出：16
解释：
书店老板在最后 3 分钟保持冷静。
感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class MaxSatisfied {
    public static void main(String[] args){
        int[] customers=new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy=new int[]{0,1,0,1,0,1,0,1};
        int X=3;
        System.out.print(maxSatisfied(customers,grumpy,X));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //解1：耗时3ms
        int out = 0;
        int max = 0;
        int sum = 0;
        for(int i =0;i<grumpy.length;i++) {
            if(grumpy[i]==0) {
                out += customers[i];
                customers[i] = 0;
            }
        }
        int i=0;
        while(i<customers.length) {
            sum += customers[i];
            if(i>=X-1) {
                if(sum >= max) {
                    max = sum;
                }
                sum -= customers[i-X+1];//窗口长度为X,窗口在向前滑动一位之前,需要将窗口中的最左边的一位数减掉
            }
            i++;
        }
        return out+max;
    }


    /*
    //超出内存限制
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        List<Integer> angryIndex=new ArrayList<>();
        int max=0;
        int start=0;
        int end=0;
        int res=0;
        for(int i=0;i<grumpy.length;i++){
            if(grumpy[i]==1){
                angryIndex.add(i);
            }
        }
        int len=angryIndex.size();
        if(len>0){
            int[][] tempData=new int[len][len];
            for(int i=0;i<len;i++){
                tempData[i][i]=customers[angryIndex.get(i)];
                if(tempData[i][i]>max){
                    max=tempData[i][i];
                    start=i;
                    end=i;
                }
            }
            for(int i=1;i<len;i++){
                for(int j=0;j+i<len;j++){
                    int distance=angryIndex.get(i+j)-angryIndex.get(j)+1;
                    if(distance<=X){
                        tempData[j][i+j]=tempData[j][i+j-1]+customers[angryIndex.get(i+j)];
                        if(tempData[j][i+j]>max){
                            max=tempData[j][i+j];
                            start=j;
                            end=i+j;
                        }
                    }
                }
            }

            for(int i=0;i<customers.length;i++){
                if(i<angryIndex.get(start) || i>angryIndex.get(end)){
                    if(grumpy[i]==0){
                        res+=customers[i];
                    }
                }else {
                    res+=customers[i];
                }
            }
        }else {
            for(int i=0;i<customers.length;i++){
                res+=customers[i];
            }
        }

        return res;
    }*/
}
