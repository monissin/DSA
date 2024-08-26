package searching.L1;

import java.util.HashMap;
import java.util.Map;

public class CountOccurence2 {
    public static int countOccurence(int[] arr, int n, int k)
    {
       Map<Integer,Integer> mp=new HashMap<>();
       int count=0,ratio=n/k;
       for(int tmp:arr){
           mp.put(tmp,mp.getOrDefault(tmp,0)+1);
       }
       for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
           if(entry.getValue()>ratio){
               count++;
           }
       }
       return count;
    }

    public static void main(String[] args) {
        int N = 8;
        int[] arr ={3,1,2,2,1,2,3,3};
        int k = 4;
        System.out.println(countOccurence(arr,N,k));

    }
}
