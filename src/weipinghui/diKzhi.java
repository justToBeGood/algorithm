package weipinghui;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class diKzhi {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int n=sc.nextInt();
        List<Integer> list=new LinkedList<>();
        for(int i=0;i<Math.pow(n,2);i++){
            int z=sc.nextInt();
            if(list.size()==0){
                list.add(z);
            }else {
                int j=list.size()-1;
                int p=list.size()-1;
                for(;j>=0;j--){
                    if(z>=list.get(j)){
                        list.add(j,z);
                        break;
                    }
                }
                if(j==-1){
                    list.add(0,z);
                }
                if(j==p){
                    list.add(z);
                }
            }

        }
        System.out.print(list.get(k-1));
    }
}
