package arrays.L2;

public class MaxIndexDiff {

    /***
     * Two pointer approach
     */
    public static int maxIndexDiff(int A[], int N) {

        //Constructing LMin[] such that LMin[i] stores the minimum value from (arr[0], arr[1], ... arr[i]).
        int[] lMin=new int[N];
        lMin[0]=A[0];
        for (int i=1;i<N;i++){
            lMin[i]=Math.min(A[i],lMin[i-1]);
        }

        //Constructing RMax[] such that RMax[j] stores the maximum value from (arr[j], arr[j+1], ..arr[n-1]).
        int[] rMax=new int[N];
        rMax[N-1]=A[N-1];
        for(int i=N-2;i>=0;i--){
            rMax[i]=Math.max(rMax[i+1],A[i] );
        }

        //Traversing both arrays from left to right to find optimum j-i.
        int i=0,j=0,diff=-1;
        while (i<N&&j<N){
            if(lMin[i]<=rMax[j]){
                diff=Math.max(diff,j-i);
                j++;
            } else{
                i++;
            }
        }
        return diff;

    }

    public static void main(String[] args) {
        int N = 7;
        int A[] = {82, 63, 44, 74, 82, 99, 82};
        System.out.println(maxIndexDiff(A,N));

    }
}
