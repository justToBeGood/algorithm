package weipinghui;



import java.util.Scanner;
import java.util.Stack;

public class pipei {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        sc.close();
       System.out.print(zhixing(str));
    }
    public static boolean zhixing(String str){
        String[] string=str.split("");
        Stack<String> kou=new Stack<>();
        Stack<String> hua=new Stack<>();
        Stack<String> kuang=new Stack<>();
        String koustr="()";
        String huastr="{}";
        String kuangstr="[]";
        for(int i=0;i<string.length;i++){
            if(koustr.indexOf(string[i])>-1){
                if(kou.isEmpty()){
                    kou.add(string[i]);
                }else {
                    String hao=kou.peek();
                    if(!hao.equals(string[i])){
                        if(hao.equals("(")){
                            kou.pop();
                        }else {
                            kou.add(string[i]);
                        }
                    }else {
                        kou.add(string[i]);
                    }
                }

            }
            if(huastr.indexOf(string[i])>-1){
                if(hua.isEmpty()){
                    hua.add(string[i]);
                }else {
                    String hao=hua.peek();
                    if(!hao.equals(string[i])){
                        if(hao.equals("{")){
                            hua.pop();
                        }else {
                            hua.add(string[i]);
                        }
                    }else {
                        hua.add(string[i]);
                    }
                }

            }
            if(kuangstr.indexOf(string[i])>-1){
                if(kuang.isEmpty()){
                    kuang.add(string[i]);
                }else {
                    String hao=kuang.peek();
                    if(!hao.equals(string[i])){
                        if(hao.equals("[")){
                            kuang.pop();
                        }else {
                            kuang.add(string[i]);
                        }
                    }else {
                        kuang.add(string[i]);
                    }
                }

            }
        }
        if(kou.isEmpty()&&hua.isEmpty()&&kuang.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
