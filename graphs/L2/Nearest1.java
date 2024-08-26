package graphs.L2;

import java.util.LinkedList;
import java.util.Queue;

public class Nearest1 {



    public static class Pair{
        int y;

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        int x;

        public Pair(int x, int y) {
            this.y = y;
            this.x = x;
        }


    }
    public static boolean isValid(int x, int y,int[][] grid){
       return x >= 0 && x < grid.length&& y >= 0 && y < grid[0].length;
    }



    public static int[][] nearest(int[][] grid){
        int[][] nearest=new int[grid.length][grid[0].length];
        int[] xPos= {1, -1, 0, 0};
        int[] yPos={0, 0, 1, -1};
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                   queue.add(new Pair(i,j));
                   nearest[i][j]=0;
                } else {
                    nearest[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()){
            Pair tmp=queue.poll();
            for(int z=0;z<4;z++){
                int newX= tmp.x+xPos[z];
                int newY= tmp.y+yPos[z];
                if(isValid(newX,newY,grid)&&(nearest[newX][newY]>nearest[tmp.x][tmp.y]+1)){
                    nearest[newX][newY]=nearest[tmp.x][tmp.y]+1;
                        queue.add(new Pair(newX,newY));
                }
            }
        }
        return nearest;
    }

    public static void print(int[][] out){
        for (int[] ints : out) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr= {{1,0,1},{1,1,0},{1,0,0}};
        int[][] out= nearest(arr);
        print(out);
    }
}
