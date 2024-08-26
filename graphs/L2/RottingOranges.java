package graphs.L2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static boolean isSafe(int newX,int newY,int[][] grid){
        return newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length &&grid[newX][newY]==1;
    }

    public static boolean isDelim(ArrayList<Integer> delimit){
        return delimit.get(0)==-1&&delimit.get(1)==-1;
    }
    public static int orangesRotting(int[][] grid)
    {
        int[] tmpX={-1,0,0,1};
        int[] tmpY={0,-1,1,0};
        Queue<ArrayList<Integer>> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    queue.add(arr);
                }
            }
        }
        ArrayList<Integer> tmpArr = new ArrayList<>();
        tmpArr.add(-1);
        tmpArr.add(-1);
        queue.add(tmpArr);
        int count=0;
        while (!queue.isEmpty()){
            boolean change=false;
            while (!isDelim(queue.peek())) {
                ArrayList<Integer> tmp=queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = tmp.get(0) + tmpX[i];
                    int newY = tmp.get(1) + tmpY[i];
                    if (isSafe(newX, newY, grid)) {
                        grid[newX][newY] = 2;
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(newX);
                        arr.add(newY);
                        queue.add(arr);
                        change=true;
                    }
                }
            }
            queue.poll();
            if(change) count++;
            if(!queue.isEmpty()){
                queue.add(tmpArr);
            }
        }
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return -1;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] grid =  {{0,1,2},{0,1,2},{2,1,1}};
        System.out.println(orangesRotting(grid));

    }
}
