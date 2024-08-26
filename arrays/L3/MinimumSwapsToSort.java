package arrays.L3;

import graphs.L2.Nearest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapsToSort {

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int minSwaps(int[] arr){
        int ans=0;
        int[] tmp= Arrays.copyOfRange(arr,0,arr.length);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        Arrays.sort(tmp);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=tmp[i]){
                ans++;
                int first=arr[i];
                swap(arr,i,map.get(tmp[i]));
                map.put(first,map.get(tmp[i]));
                map.put(tmp[i],i);
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
