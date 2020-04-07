package leetcode;
/*
这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。

如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。

请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。

输入：grid = [[1,0],[1,1]]
输出：3
解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 */
public class CountServers {
    public static void main(String[] args){
        int[][] data={{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(data));
    }
    public static int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m]; // 统计某一行的服务器数量
        int[] col = new int[n]; // 统计某一列的服务器数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                row[i] += 1; // 第 i 行服务器数量+1
                col[j] += 1; // 第 j 列服务器数量+1
            }
        }
        int ans = 0;
        // 该行该列的服务器数量只有一个（即其自身）则它无法与任何其他服务器通信
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                if (row[i] == 1 && col[j] == 1) continue;
                ans++;
            }
        }
        return ans;
    }
}
