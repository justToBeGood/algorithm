package bianlifeng;

import java.util.*;
/*
1 2 2 3 3 4 4 5 5 3
 */
public class huan {
    public static void main(String[] args){
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int front=0;
        int index=0;
        while (!sc.hasNext("-1")){
            int fri=sc.nextInt();
            int sec=sc.nextInt();
            if(map.get(fri)==null){
                map.put(fri,1);
                list.add(fri);
            }else {
                map.put(fri,map.get(fri)+1);
            }
            if(map.get(sec)==null){
                map.put(sec,1);
                list.add(sec);
            }
            else {
                if (map.get(sec)==2){
                    map.put(fri,map.get(fri)+1);
                    front=sec;
                    break;
                }else {
                    map.put(sec,map.get(sec)+1);
                    list.add(sec);
                }
            }
        }
        for (int i=0;i<list.size();i++){
            if(list.get(i)==front){
                index=i;
                break;
            }
        }
        System.out.println(list.size()-index);
    }
}
