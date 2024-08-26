package arrays.L2;

public class MaxDifference {

    static int maxDiff(int A[], int N){
       int diff=A[1]-A[0],min=A[0];
       for(int i=1;i<N;i++){
           if(A[i]-min>diff){
               diff=A[i]-min;
           }
           if(A[i]<min){
               min=A[i];
           }
       }
        return diff;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDiff(arr,arr.length));

    }
}
