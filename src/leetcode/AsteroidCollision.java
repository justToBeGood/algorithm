package leetcode;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args){
        int[] data={-2,-1,1,2};
        int[] res=asteroidCollision(data);
       for(int i=0;i<res.length;i++){
           System.out.print(res[i]+" ");
       }
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            Boolean flag=true;
            if (stack.isEmpty()){
                stack.push(asteroids[i]);
                continue;
            }
            while (!stack.isEmpty() && symbol(stack.peek())>0 && symbol(asteroids[i])<0){
                if(Math.abs(stack.peek())<Math.abs(asteroids[i])) {
                    stack.pop();
                }
                else if (Math.abs(stack.peek())==Math.abs(asteroids[i])){
                    stack.pop();
                    flag=false;
                    break;
                }else {
                    flag=false;
                    break;
                }
            }
            if(flag){
                stack.push(asteroids[i]);
            }
        }

        int[] res=new int[stack.size()];
        int z=stack.size()-1;
        while (!stack.isEmpty()){
            res[z]=stack.pop();
            z--;
        }
        return res;
    }
    public static int symbol(int num){
        if(num>0){
            return 1;
        }
        else if(num<0){
            return -1;
        }
        else {
            return 0;
        }
    }
}
