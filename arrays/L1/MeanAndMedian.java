package arrays.L1;

import java.util.Arrays;

public class MeanAndMedian {
    public static int median(int A[],int N)
    {

        Arrays.sort(A);
        if(N%2==0){
            return (A[N/2]+A[N/2-1])/2;
        } else {
            return A[N/2];
        }
    }
    public static int mean(int A[],int N)
    {
        int sum=0;
        for(int tmp:A){
            sum+=tmp;
        }
        return sum/N;
    }

    public static void main(String[] args) {
        int[] A={2, 8, 3, 4};
        System.out.println(mean(A,A.length));
        System.out.println(median(A,A.length));
        int[] B={1, 2, 19, 28, 5};
        System.out.println(mean(B,B.length));
        System.out.println(median(B,B.length));
    }
}
