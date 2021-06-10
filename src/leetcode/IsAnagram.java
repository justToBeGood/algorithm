package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。-242
 * @Author: wengweixin
 * @E-mail： wengweixin@csair.com
 * @Date: 2021/6/10 10:56
 **/
public class IsAnagram {
    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        List<Character> list=new LinkedList<>();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            list.add(sChars[i]);
        }
        char[] tChars = t.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            list.remove((Character)tChars[i]);
        }
        return list.isEmpty();
    }
   //官方解答
  /* public boolean isAnagram(String s, String t) {
       if (s.length() != t.length()) {
           return false;
       }
       char[] str1 = s.toCharArray();
       char[] str2 = t.toCharArray();
       Arrays.sort(str1);
       Arrays.sort(str2);
       return Arrays.equals(str1, str2);
   }*/
}
