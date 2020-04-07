package leetcode;

import java.util.Stack;
/*
给定一个整数数组 asteroids，表示在同一行的行星。

对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。

找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。

 */
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
