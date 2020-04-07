package bianlifeng;
/*
按位对应法。如集合A={a,b,c},对于任意一个元素，在每个子集中，要么存在，要么不存在。
映射为子集：
(a,b,c)
(1,1,1)->(a,b,c)
(1,1,0)->(a,b)
(1,0,1)->(a,c)
(1,0,0)->(a)
(0,1,1)->(b,c)
(0,1,0)->(b)
(0,0,1)->(c)
(0,0,0)->@(@表示空集)
观察以上规律，与计算机中数据存储方式相似

 */
import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class sanbei {
    public static void main(String[] args){
        List<Integer> arr=new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        while(!sc.hasNext("-1")){
            Integer item=sc.nextInt();
            arr.add(item);

        }
        int max=0;
        int length=arr.size();
            int mark=0;
            int nEnd=1<<length;
            /*
            比如:000 001 010 011 100 101 110 111
            001
            010
            100
             */
            for(mark=0;mark<nEnd;mark++){
                int sum=0;
                for(int i=0;i<length;i++){
                    if(((1<<i)&mark)!=0){//该位有元素输出
                        sum+=arr.get(i);
                    }
                }
                if(sum%3==0 && max<sum){
                    max=sum;
                }
            }
           System.out.println(max/3);
    }
}
