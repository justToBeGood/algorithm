package leetcode;

import java.util.*;

public class OrderlyQueue {
    public static void main(String[] args){
        String value="enbczfjtvxerzbrvigpl";
        System.out.println(orderlyQueue(value,1));
    }
    /*
    当 K = 1 时，每次操作只能将第一个字符移动到末尾，因此字符串 S 可以看成一个头尾相连的环。如果 S 的长度为 NN，我们只需要找出这 NN 个位置中字典序最小的字符串即可。

当 K = 2 时，可以发现，我们能够交换字符串中任意两个相邻的字母。具体地，设字符串 S 为 S[1], S[2], ..., S[i], S[i + 1], ..., S[N]，我们需要交换 S[i] 和 S[j]。首先我们依次将 S[i] 之前的所有字符依次移到末尾，得到

S[i], S[i + 1], ..., S[N], S[1], S[2], ..., S[i - 1]

随后我们先将 S[i + 1] 移到末尾，再将 S[i] 移到末尾，得到

S[i + 2], ..., S[N], S[1], S[2], ..., S[i - 1], S[i + 1], S[i]

最后将 S[i + 1] 之后的所有字符依次移到末尾，得到

S[1], S[2], ..., S[i - 1], S[i + 1], S[i], S[i + 2], ..., S[N]

这样就交换了 S[i] 和 S[i + 1]，而没有改变其余字符的位置。

当我们可以交换任意两个相邻的字母后，就可以使用冒泡排序的方法，仅通过交换相邻两个字母，使得字符串变得有序。因此当 K = 2 时，我们可以将字符串移动得到最小的字典序。

当 K > 2 时，我们可以完成 K = 2 时的所有操作。

     */
    public static String orderlyQueue(String S, int K) {
        if (K == 1) {
            String ans = S;
            for (int i = 0; i < S.length(); ++i) {//循环每个字符找出最小的排列方式
                String T = S.substring(i) + S.substring(0, i);
                if (T.compareTo(ans) < 0) ans = T;
            }
            return ans;
        } else {
            char[] ca = S.toCharArray();
            Arrays.sort(ca);//还有这种排序的方式的
            return new String(ca);
        }
    }
    /*public static String orderlyQueue(String S, int K) {
        List<Item> list=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            list.add(new Item(S.charAt(i),S.charAt(i)));
        }
        Collections.sort(list);
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<list.size();i++){
            stringBuffer.append(list.get(i).getWord());
        }
        return stringBuffer.toString();
    }
    static class Item implements Comparable<Item>{
        private char word;
        private int ascii;

        public Item(char word,int ascii){
            this.word=word;
            this.ascii=ascii;
        }

        public char getWord() {
            return word;
        }

        public void setWord(char word) {
            this.word = word;
        }

        public int getAscii() {
            return ascii;
        }

        public void setAscii(int ascii) {
            this.ascii = ascii;
        }

        public int compareTo(Item arg0) {
            if (this.getAscii()>arg0.getAscii()){
                return 1;
            }
            else if (this.getAscii()<arg0.getAscii()){
                return -1;
            }else {
                return 0;
            }
        }
    }*/
}

