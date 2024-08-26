package arrays.L1;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxAndSecondMax {

    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[])
    {
       Integer first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
       for(int tmp:arr){
           if(tmp>first){
               second=first;
               first=tmp;
           } else if (tmp>second&&tmp<first) {
               second=tmp;
           }
       }
       return new ArrayList<>(Arrays.asList(first,second));
    }

    public static void main(String[] args) {
        int A[]=new int[]{2,1,2};
        System.out.println(largestAndSecondLargest(A.length,A));

    }
}
