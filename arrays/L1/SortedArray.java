package arrays.L1;

import java.util.Arrays;

public class SortedArray {
    static boolean arraySortedOrNot(int arr[], int n){
        if(n==0||n==1){
            return true;
        }
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 20, 23, 23, 21, 78, 88 };
        System.out.println(arraySortedOrNot(arr,arr.length));

    }
}
