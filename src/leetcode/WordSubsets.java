package leetcode;

import java.util.*;

/*
我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。

现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。

如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。

你可以按任意顺序以列表形式返回 A 中所有的通用单词。

 

示例 1：

输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
输出：["facebook","google","leetcode"]
示例 2：

输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
输出：["apple","google","leetcode"]
示例 3：
 */
public class WordSubsets {
    public static void main(String[] args){
        String[] A=new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] B=new String[]{"lo","eo"};
        List<String> list=wordSubsets(A,B);
        System.out.println(list.toString());
    }
   /*
   //时间过长
   public static List<String> wordSubsets(String[] A, String[] B) {
        List<HashMap<Character,Integer>> a=new ArrayList<>();
        List<String> list=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            HashMap<Character,Integer> hashMap=new HashMap();
            for(int j=0;j<A[i].length();j++){
                if(hashMap.get(A[i].charAt(j))==null){
                    hashMap.put(A[i].charAt(j),1);
                }
                else {
                    hashMap.put(A[i].charAt(j),hashMap.get(A[i].charAt(j))+1);
                }
            }
            a.add(hashMap);
        }
        for(int i=0;i<a.size();i++){
            boolean flag1=false;
            for(int j=0;j<B.length;j++){
                HashMap<Character,Integer> hashMap=new HashMap<>(a.get(i));
                for(int z=0;z<B[j].length();z++){
                    Character character=B[j].charAt(z);
                    if(hashMap.get(character)==null || hashMap.get(character)==0){
                        flag1=true;
                        break;

                    }else {
                        hashMap.put(character,hashMap.get(character)-1);
                    }
                }
                if(flag1){
                    break;
                }
            }
            if (!flag1){
                list.add(A[i]);
            }
        }
        return list;
    }*/
   //关键思想是将B数组按一定规律合成一个单词
   public static List<String> wordSubsets(String[] A, String[] B) {
       int[] bmax = count("");
       for (String b: B) {
           int[] bCount = count(b);
           for (int i = 0; i < 26; ++i)
               bmax[i] = Math.max(bmax[i], bCount[i]);
       }

       List<String> ans = new ArrayList();
       search: for (String a: A) {
           int[] aCount = count(a);
           for (int i = 0; i < 26; ++i)
               if (aCount[i] < bmax[i])
                   continue search;
           ans.add(a);
       }

       return ans;
   }

    public static int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}
