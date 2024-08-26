package graphs.L2;

import java.util.LinkedList;
import java.util.Queue;

public class IsPathPossible {


    public static class Pair{
        int y;

        public Pair(int x, int y) {
            this.y = y;
            this.x = x;
        }

        int x;
    }

    public static boolean isSafe(int[][] grid,int x,int y,boolean[][] visited){
        return x>=0&&x< grid.length&&y>=0&&y<grid[0].length&&(grid[x][y]==3||grid[x][y]==2)&&!visited[x][y];
    }
    public static boolean is_Possible(int[][] grid)
    {
        int[] xAxis={-1,0,0,1};
        int[] yAxis={0,-1,1,0};
        Pair source=null,dest=null;
        for(int i=0;i< grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    source=new Pair(i,j);
                }
                if(grid[i][j]==2){
                    dest=new Pair(i,j);
                }
            }
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.add(source);
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        visited[source.x][source.y]=true;
        while (!queue.isEmpty()){
            Pair tmp=queue.poll();
            if(tmp.x==dest.x&&tmp.y==dest.y){
                return true;
            }
            for(int i=0;i<4;i++){
                int tmpx= tmp.x+xAxis[i],tmpy=tmp.y+yAxis[i];
                if(isSafe(grid,tmpx,tmpy,visited)){
                    visited[tmpx][tmpy]=true;
                    queue.add(new Pair(tmpx,tmpy));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,0,3,0,0},{3,0,0,0,3}
                ,{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}};
        System.out.println(is_Possible(grid));

    }
}
