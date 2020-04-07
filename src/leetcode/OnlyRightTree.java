package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
中序遍历，然后构成一条只有右子树的树
 */
public class OnlyRightTree {
    public static void main(String[] args) {
        Integer[] list={5,3,6,2,4,null,8,1,null,null,null,null,null,7,9};

        TreeNode newRoot=TreeNode.createTree(list);
        List<TreeNode> NodeList=new ArrayList<>();
        leftRead(newRoot,NodeList);
        for (int i=0,len=NodeList.size()-1;i<len;i++){
            TreeNode item=NodeList.get(i);
            item.right=NodeList.get(i+1);
            item.left=null;
        }
        TreeNode.leftDispaly(NodeList.get(0));
    }
    public static void leftRead(TreeNode root,List list){
        TreeNode node=root;
        if(node!=null){
            leftRead(node.left,list);
            list.add(node);
            leftRead(node.right,list);
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> NodeList=new ArrayList<>();
        leftRead(root,NodeList);
        for (int i=0,len=NodeList.size()-1;i<len;i++){
            TreeNode item=NodeList.get(i);
            item.right=NodeList.get(i+1);
            item.left=null;
        }
        return NodeList.get(0);
    }
}
