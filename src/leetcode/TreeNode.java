package leetcode;

import javax.xml.soap.Node;
import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

      public static TreeNode createTree(Integer[] list){
          TreeNode root;
          Queue<TreeNode> queue=new ArrayDeque<>();
          if (list.length>0){
               root=new TreeNode(list[0]);
              queue.add(root);
          }
          else {
              return null;
          }
          for (int i=0,len=list.length;i<len;i++){
              if(list[i]!=null){
                  TreeNode item=queue.poll();
                  if(2*i+1<len){
                      if (list[2*i+1]!=null){
                          TreeNode left=new TreeNode(list[2*i+1]);
                          item.left=left;
                          queue.add(left);
                      }
                  }
                  if(2*i+2<len){
                      if (list[2*i+2]!=null){
                          TreeNode right=new TreeNode(list[2*i+2]);
                          item.right=right;
                          queue.add(right);
                      }
                  }
              }

          }
          return root;
      }

      public static void leftDispaly(TreeNode root){
          if (root!=null){
              leftDispaly(root.left);
              System.out.print(root.val+" ");
              leftDispaly(root.right);
          }
         /* System.out.print("null ");*/
      }
}
