package bianlifeng;

import java.util.*;
/*
330 450 630 690 750 780 990 1050
 */
public class time {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        Queue<int[]> queue=new LinkedList<>();
        while (!sc.hasNext("-1")){
            list.add(sc.nextInt());
        }
        for(int i=0;i<list.size()-1;i++){
            int fri=list.get(i)-30;
            int sec=list.get(i+1);
            if (queue.isEmpty()){
                queue.add(new int[]{fri,sec});
            }else {
                int[] peek=queue.peek();
                if(fri-peek[1]<=60){
                    queue.poll();
                    queue.add(new int[]{peek[0],sec});
                }
                else {
                    queue.add(new int[]{fri,sec});
                }
            }
            i++;
        }
        while (!queue.isEmpty()){
            int[] item=queue.poll();
            System.out.print(item[0]+" ");
            System.out.print(item[1]+" ");
            System.out.println();
        }

    }
}
