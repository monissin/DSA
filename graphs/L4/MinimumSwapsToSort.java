package graphs.L4;

import graphs.L2.Nearest1;

import java.util.ArrayList;
import java.util.Comparator;

public class MinimumSwapsToSort {

    public static int minSwaps(int[] arr){
        boolean[] visited=new boolean[arr.length];
        ArrayList<Nearest1.Pair> pair=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            pair.add(new Nearest1.Pair(arr[i],i));
        }
        pair.sort((o1, o2) -> {
            if (o1.getX() > o2.getX()) {
                return 1;
            } else if (o1.getX() == o2.getX()) {
                return 0;
            } else {
                return -1;
            }
        });
        int ans=0;
        for(int i=0;i< arr.length;i++){
            if(visited[i]||pair.get(i).getY()==i){
                continue;
            }
            int cycleLength=0;
            int j=i;
            while (!visited[j]){
                visited[j]=true;
                j=pair.get(j).getY();
                cycleLength++;
            }
            if(cycleLength>0){
                ans+=(cycleLength-1);
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] a = { 2,8,5,4 };
        System.out.println(minSwaps(a));
    }
}
