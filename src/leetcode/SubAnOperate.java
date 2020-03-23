package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SubAnOperate {
    public static void main(String[] args){
       int[] data={1,1,2};
       System.out.println(subarrayBitwiseORs(data));
    }

    public static int subarrayBitwiseORs(int[] A) {
        int len=A.length;
        int[][] map=new int[len][len];
        Set<Integer> res=new HashSet<>();
        for(int i=0;i<len;i++){
            map[i][i]=A[i];
            res.add(A[i]);
        }
        for(int i=1;i<len;i++){
            for(int j=0;i+j<len;j++){
                map[j][i+j]=map[j][i+j-1] | A[i+j];
                res.add(map[j][i+j]);
            }
        }
        return res.size();
    }
}
