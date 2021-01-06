package dongfangcaifu;

        import java.util.Scanner;

public class gupian {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] nums=new int[num];
        for(int i=0;i<num;i++){
            nums[i]=sc.nextInt();
        }
        int max=0;
        for(int i=1;i<num;i++){
            int fmax=0;
            int fmin=0;
            int bmin=0;
            int bmax=0;
            for(int p=0;p<i;p++){
                if(nums[p]>fmax){
                    fmax=nums[p];
                }
                if(nums[p]<fmin){
                    fmin=nums[p];
                }
            }
            for(int q=i+1;q<num;q++){
                if(nums[q]>bmax){
                    bmax=nums[q];
                }
                if(nums[q]<bmin){
                    bmin=nums[q];
                }
            }
            int res=fmax-fmin+bmax-bmin;
            if(max<fmax){
                max=fmax;
            }
        }
        int secmax=0;
        int min=Integer.MAX_VALUE;
        int inmax=0;
        for(int i=0;i<num;i++){
            if(nums[i]>secmax){
                secmax=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        System.out.println( Math.max(max,secmax-min));
    }
}
