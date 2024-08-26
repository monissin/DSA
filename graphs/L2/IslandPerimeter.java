package graphs.L2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        int x=-1,y=-1;
        AtomicInteger per=new AtomicInteger(0);
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        outerloop:
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    x=i;
                    y=j;
                    break outerloop;
                }
            }
        }
        if(x!=-1&&y!=-1){
            dfs(x,y,visited,per,grid);
        }
        return per.get();

    }

    static int[] h={-1,0,0,1};
    static int[] v={0,-1,1,0};

    public static boolean isValid(int i, int j, int x, int y){
        return i<x&&i>=0&&j<y&&j>=0;
    }

    public static void dfs(int i, int j, boolean[][] visited, AtomicInteger perimeter,int[][] grid){
        visited[i][j]=true;
        for(int x=0;x<4;x++){
            if(isValid(i+h[x],j+v[x],visited.length,visited[0].length)){
                if(grid[i+h[x]][j+v[x]]==1&&!visited[i+h[x]][j+v[x]]){
                    dfs(i+h[x],j+v[x],visited,perimeter,grid);
                } else if(grid[i+h[x]][j+v[x]]==0){
                    perimeter.getAndIncrement();
                }
            } else {
                perimeter.getAndIncrement();
            }

        }

    }



    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node,Node> mp=new HashMap<>();
    public Node cloneGraph(Node node) {
        dfs(null,node);
        return mp.get(node);
    }

    public void dfs(Node parent,Node curNode){
        if(!mp.containsKey(curNode)){
            mp.put(curNode,new Node(curNode.val));
        }
        if(parent==null){
            for(Node tmp:curNode.neighbors){
                dfs(curNode,tmp);
            }
        } else if(!mp.get(parent).neighbors.contains(mp.get(curNode))){
            mp.get(parent).neighbors.add(mp.get(curNode));
            for(Node tmp:curNode.neighbors){
                dfs(curNode,tmp);
            }
        }
    }


    static int[] xAxis={-1,0,0,1};
    static int[] yAxis={0,1,-1,0};

    static boolean exist=true;
    public static boolean isSafe(int x,int y,int[][] grid2,boolean[][] visited){
        return (x>=0&&x<grid2.length&&y>=0&&y<grid2[0].length&&grid2[x][y]==1&&!visited[x][y]);
    }
    public static void dfs(int[][] grid1,int[][] grid2,boolean[][] visited, int i, int j){
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            if(isSafe(i+xAxis[k],j+yAxis[k],grid2,visited)){
                if(grid1[i+xAxis[k]][j+yAxis[k]]!=1){
                    exist=false;
                }
                dfs(grid1,grid2,visited,i+xAxis[k],j+yAxis[k]);
            }
        }
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {

        int count=0;
        boolean[][] visited=new boolean[grid2.length][grid2[0].length];
        for(int i=0;i< grid2.length;i++){
            for (int j=0;j<grid2[i].length;j++){
                if(!visited[i][j]&&grid2[i][j]==1&&grid1[i][j]==1){
                    dfs(grid1,grid2,visited,i,j);
                    if(exist){
                        count++;
                    }
                    exist=true;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}};
        int[][] grid2 = {{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}};
        System.out.println(countSubIslands(grid1,grid2));

    }

    boolean po=true, ao=true;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                dfsPO(i,j,heights);
                dfsAO(i,j,heights);
                if(po&&ao){
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    list.add(tmp);
                }
                po=true;
                ao=true;
            }
        }
        return list;

    }

    int[] dx={-1,0,0,1};
    int[] dy={0,-1,1,0};

    public boolean isSafe(int i, int j,int[][] heights){
        return i>=0&&j>=0&&i<heights.length&&j<heights[0].length;
    }
    public void dfsPO(int i, int j,int[][] heights){
        if(i==0||j==0){
            return;
        }
        boolean isOneSafe=false;
        for(int x=0;x<4;x++){
            int newi=i+dx[x];
            int newj=j+dy[x];
            if(isSafe(newi,newj,heights)&&heights[i][j]>=heights[newi][newj]){
                dfsPO(newi,newj,heights);
                isOneSafe=true;
            }
        }
        if(!isOneSafe){
            po=false;
        }

    }

    public void dfsAO(int i, int j,int[][] heights){
        if(j==heights[0].length-1||i==heights.length-1){
            return;
        }
        boolean isOneSafe=false;
        for(int x=0;x<4;x++){
            int newi=i+dx[x];
            int newj=j+dy[x];
            if(isSafe(newi,newj,heights)&&heights[i][j]>=heights[newi][newj]){
                dfsAO(newi,newj,heights);
                isOneSafe=true;
            }
        }
        if(!isOneSafe){
            ao=false;
        }

    }

}
