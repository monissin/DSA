package graphs.L2;

public class MinCostPath {

    public static boolean isSafe(int i, int j, int m, int n){
        return i>=0&&i<m&&j>=0&&j<n;
    }

    public static int dfs(int i, int j, int[][] grid, int sum){
        if(!isSafe(i,j, grid.length, grid[0].length)){
            return 0;
        }
        return sum+Math.min(Math.min(dfs(i-1,j,grid,sum),dfs(i+1,j,grid,sum)),Math.min(dfs(i,j-1,grid,sum),dfs(i,j+1,grid,sum)));
    }

    public static int minimumCostPath(int[][] grid)
    {
        return dfs(0,0,grid,grid[0][0]);
    }

    public static void main(String[] args) {
 int[][] grid = {{9,4,9,9},{6,7,6,4},
         {8,3,3,7},{7,4,9,10}};
        System.out.println(minimumCostPath(grid));
    }
}
