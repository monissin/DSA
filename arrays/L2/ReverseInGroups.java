package arrays.L2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseInGroups {

    static void reverseArray(ArrayList<Integer> arr, int start, int end){
        int tmp;
        while (start<end){
            tmp=arr.get(start);
            arr.set(start,arr.get(end));
            arr.set(end,tmp);
            start++;
            end--;
        }

    }
    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        for(int i=0;i<n;i+=k){
            int start=i,end=i+k-1;
            if(end>=n){
                end=n-1;
            }
            reverseArray(arr,start,end);
        }
        System.out.println(arr);
    }

    public static void main(String[] args) {
        Integer[] arr={5,6,8,9};
        ArrayList<Integer> arrayList= new ArrayList<>(Arrays.asList(arr));
        reverseInGroups(arrayList,arrayList.size(),3);
    }
}
