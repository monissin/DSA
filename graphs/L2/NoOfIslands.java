package graphs.L2;

public class NoOfIslands {

    static int[] xAxis={-1,-1,-1,0,0,1,1,1};
    static int[] yAxis={-1,0,1,-1,1,-1,0,1};

    public static boolean isSafe(int x,int y,char[][] grid,boolean[][] visited){
        return (x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1&&!visited[x][y]);
    }
    public static void dfs(char[][] grid,boolean[][] visited, int i, int j){
        visited[i][j]=true;
        for(int k=0;k<8;k++){
            if(isSafe(i+xAxis[k],j+yAxis[k],grid,visited)){
                dfs(grid,visited,i+xAxis[k],j+yAxis[k]);
            }
        }
    }
    public static int numIslands(char[][] grid) {
        int count=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    dfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        char[][] grid =  {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        System.out.println(numIslands(grid));

    }
}
