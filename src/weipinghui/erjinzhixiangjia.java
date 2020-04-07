package weipinghui;

import java.util.Scanner;

public class erjinzhixiangjia {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        int max=0,min=0;
        String[] maxstr;
        String[] minstr;
        int aLen=a.length();
        int bLen=b.length();
        String[] A=a.split("");
        String[] B=b.split("");
        if(aLen>=bLen){
            max=aLen;
            min=bLen;
            maxstr=a.split("");
            minstr=b.split("");
        }else {
            max=bLen;
            min=aLen;
            maxstr=b.split("");
            minstr=a.split("");
        }
        int[] result=new int[max];
        int res=0;
        for(int i=1;i<=min;i++){
            int z=Integer.parseInt(maxstr[max-i])+Integer.parseInt(minstr[min-i])+res;
            if(z>=2){
                result[max-i]=z%2;
                res=1;
            }else {
                result[max-i]=z;
                res=0;
            }
        }
        for(int i=max-min-1;i>=0;i--){
            int z=Integer.parseInt(maxstr[i])+res;
            if(z>=2){
                result[i]=z%2;
                res=1;
            }else {
                result[i]=z;
                res=0;
            }
        }
        if(res==1){
            System.out.print("1");
        }
        for(int i=0;i<max;i++){
            System.out.print(result[i]);
        }
    }
}
