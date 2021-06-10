package leetcode;

/**
 * @Description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：  每行的元素从左到右升序排列。 每列的元素从上到下升序排列。
 * @Author: wengweixin
 * @E-mail： wengweixin@csair.com
 * @Date: 2021/6/9 15:22
 **/
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int y=matrix.length;
        int x=matrix[0].length;
        for (int i = y-1; i >=0; i--) {
            if(matrix[i][0]<=target){
                for (int j = 0; j < x; j++) {
                    if(matrix[i][j]>target){
                        break;
                    }
                    if (matrix[i][j]==target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
