package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * @Author: wengweixin
 * @E-mail： wengweixin@csair.com
 * @Date: 2021/6/9 17:12
 **/

/**
 *使用分治法，将最底层子表达式计算，将每个子表达式的可能结果向上进行计算，最后进行总表达式的可能结果计算
 */
public class DiffWaysToCompute {
    public static void main(String[] args) {
        String expression="2*3-4*5";
        List<Integer> list = diffWaysToCompute(expression);
        System.out.println(list.toString());
    }
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res=new ArrayList<>();
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='-'|| chars[i]=='+' || chars[i]=='*'){
                List<Integer> leftRes = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightRes = diffWaysToCompute(expression.substring(i + 1));
                for (int j = 0; j < leftRes.size(); j++) {
                    for (int k = 0; k < rightRes.size(); k++) {
                        if (chars[i]=='+'){
                            res.add(leftRes.get(j)+rightRes.get(k));
                        }else if (chars[i]=='-'){
                            res.add(leftRes.get(j)-rightRes.get(k));
                        }else {
                            res.add(leftRes.get(j)*rightRes.get(k));
                        }
                    }
                }

            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
