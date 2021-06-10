package leetcode;

import java.math.BigInteger;

/**
 * @Description: 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。-191
 * @Author: wengweixin
 * @E-mail： wengweixin@csair.com
 * @Date: 2021/6/10 11:14
 **/
public class HammingWeight {
    public static void main(String[] args) {
        int n=11;
        System.out.println(hammingWeight(n));
    }
    public static int hammingWeight(int n) {
        //整数转成二进制字符数
        String binaryString = Integer.toBinaryString(n);
        char[] chars = binaryString.toCharArray();
        int sum=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='1'){
                sum++;
            }
        }
        return sum;
    }
}
