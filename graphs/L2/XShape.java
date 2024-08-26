package graphs.L2;

public class XShape {

    static int[] xAxis= {1, -1, 0, 0};
    static int[] yAxis={0, 0, 1, -1};
    public static boolean isSafe(int x,int y,char[][] grid,boolean[][] visited){
        return (x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]=='X'&&!visited[x][y]);
    }
    public static void dfs(char[][] grid,boolean[][] visited, int i, int j){
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            if(isSafe(i+xAxis[k],j+yAxis[k],grid,visited)){
                dfs(grid,visited,i+xAxis[k],j+yAxis[k]);
            }
        }
    }
    public static int xShape(char[][] grid)
    {
        int count=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i< grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(!visited[i][j]&&grid[i][j]=='X'){
                    dfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'X','X'},{'X','X'}};
        System.out.println(xShape(grid));
    }
}
