package tencent;

import java.util.Scanner;
import java.util.Stack;

public class BuildingNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] height=new int[num];
        int[] result=new int[num];
        for(int i=0;i<num;i++){
            int n=sc.nextInt();
            height[i]=n;
        }
        for(int i=0;i<num;i++){
            Stack<Integer> front=new Stack<>();
            Stack<Integer> back=new Stack<>();
            for(int j=i;j>0;j--){
                if(front.isEmpty()){
                    front.push(height[j-1]);
                }else {
                    if(front.peek()<height[j-1]){
                        front.push(height[j-1]);
                    }
                }
            }
            for(int j=i;j<num-1;j++){
                if(back.isEmpty()){
                    back.push(height[j+1]);
                }else {
                    if(back.peek()<height[j+1]){
                        back.push(height[j+1]);
                    }
                }
            }
            result[i]=front.size()+back.size()+1;
        }
        for(int i=0;i<num;i++){
            System.out.print(result[i]+" ");
        }
    }

}
