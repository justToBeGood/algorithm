package tencent;

import java.util.Scanner;
import java.util.Stack;

/*
小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，
于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
输入描述:
输入第一行包含一个字符串s，代表压缩后的字符串。
S的长度<=1000;
S仅包含大写字母、[、]、|;
解压后的字符串长度不超过100000;
压缩递归层数不超过10层;
输出描述:
输出一个字符串，代表解压后的字符串。
 */
public class Compression {
    //四则运算的思想来解决问题
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        Stack<String> num=new Stack<>();
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<str.length();i++){
            /*[、|字符前的字符串都压进栈里，读到]有两种情况：
            1、都是字符串则取出相加，再从栈里取出重复次数
            2、第一个为重复次数、第二次是字符串
            */
            if(str.charAt(i)=='[' || str.charAt(i)=='|'){
                String subStr=stringBuffer.toString();
                if(!subStr.equals("")){
                    num.push(subStr);
                }
                stringBuffer=new StringBuffer();
                continue;
            }
            if(str.charAt(i)==']') {
                String subStr = stringBuffer.toString();
                if (!subStr.equals("")) {
                    num.push(subStr);
                }
                stringBuffer = new StringBuffer();
                String string=num.pop();
                String a="";
                while (true) {
                    try{
                        StringBuffer subStringBuffer=new StringBuffer();
                        a=num.pop();
                        int time=Integer.parseInt(a);
                        for(int j=0;j<time;j++){
                            subStringBuffer.append(string);
                        }
                        num.push(subStringBuffer.toString());
                        break;
                    }catch (Exception e){
                        string=a+string;
                        continue;
                    }
                }
                continue;
            }
            stringBuffer.append(str.charAt(i));
        }
        num.push(stringBuffer.toString());
        String out="";
        while (!num.isEmpty()){
            out=num.pop()+out;
        }
        System.out.println(out);
    }
}
