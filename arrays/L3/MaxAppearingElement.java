package arrays.L3;

import java.util.HashMap;
import java.util.Map;

public class MaxAppearingElement {

    /***
     * The idea is to use the Difference array technique.
     * Create a vector initialized with value zero.
     * Iterate through every range and
     * mark the presence of the beginning of every range by incrementing the start of the range with one i.e. arr[L[i]]++ and
     * mark the end of the range by decrementing at index one greater than the end of range by one i.e. arr[R[i]+1]–.
     * Now when computing the prefix sum,
     * Since the beginning is marked with one, all the values after beginning will be incremented by one.
     * Now as increment is only targeted only till the end of the range, the decrement on index R[i]+1 prevents that for every range i.
     */

    public int[] getConcatenation(int[] nums) {
        int[] concat=new int[nums.length*2];
        for(int i=0;i<nums.length*2;i++){
            concat[i]=nums[i%nums.length];
        }
        return concat;

    }
    public static int maxOccured(int L[], int R[], int n, int maxx){
        int[] occur=new int[maxx];
        int max=0;
        for(int i=0;i<n;i++){
            occur[L[i]]++;
            occur[R[i]+1]--;
            if(R[i]>max){
                max=R[i];
            }
        }

        int maxSum=occur[0],ele=0;
        for(int i=1;i<=max;i++){
            occur[i]+=occur[i-1];
            if(occur[i]>maxSum){
                maxSum=occur[i];
                ele=i;
            }
        }
        return ele;


    }

    public static void main(String[] args) {
       int L[] = {1,4,3,1};
       int R[] = {15,8,5,4};
        System.out.println(maxOccured(L,R,L.length,1000));
    }
}
