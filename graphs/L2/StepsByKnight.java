package graphs.L2;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

    public static class Cell{
        int x;
        int y;

        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        int dist;
    }

    public static boolean isSafe(boolean[][] visited,int x,int y,int N){
        return x>=0&&x<=N&&y>=0&&y<=N&&!visited[x][y];
    }

    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int N){
        Queue<Cell> queue=new LinkedList<>();
        queue.add(new Cell(KnightPos[0],KnightPos[1], 0));
        boolean[][] visited=new boolean[N+1][N+1];
        visited[KnightPos[0]][KnightPos[1]]=true;
        int[] xAxis={-2,-2,-1,-1,1,1,2,2};
        int[] yAxis={-1,1,-2,2,-2,2,-1,1};
        while (!queue.isEmpty()){
            Cell cell=queue.poll();
            if(cell.x==TargetPos[0]&&cell.y==TargetPos[1]){
                return cell.dist;
            }
            for(int i=0;i<8;i++){
                if(isSafe(visited,cell.x+xAxis[i],cell.y+yAxis[i],N)){
                    queue.add(new Cell(cell.x+xAxis[i],cell.y+yAxis[i],cell.dist+1));
                    visited[cell.x+xAxis[i]][cell.y+yAxis[i]]=true;
                }
            }
        }
        return Integer.MAX_VALUE;

    }


    public static void main(String[] args) {
        int N=6;
        int knightPos[] = {4, 5};
        int targetPos[] = {1, 1};
        System.out.println(minStepToReachTarget(knightPos,targetPos,N));

    }
}
