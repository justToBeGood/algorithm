package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class ReverseVowels {
    public static void main(String[] args){
        String s="leetcode";
        System.out.println(reverseVowels(s));
    }
    public static String reverseVowels(String s){
        String vowels="aeiouAEIOU";
        String[] chars=s.split("");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            if(vowels.indexOf(chars[i])>-1){
                list.add(i);
            }
        }
        int back=list.size()-1;
        int front=0;
        while (front<back){
            String tmp=chars[list.get(front)];
            chars[list.get(front)]=chars[list.get(back)];
            chars[list.get(back)]=tmp;
            front++;
            back--;
        }
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<chars.length;i++){
            stringBuffer.append(chars[i]);
        }
        return stringBuffer.toString();
    }
}
