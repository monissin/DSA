package arrays.L1;

public class PrefixSum {

    private static void fillPrefix( int arr[], int preArray[], int n ) {
        preArray[0]=arr[0];
        for(int i=1;i<n;i++){
            preArray[i]=preArray[i-1]+arr[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 4, 16, 20 };
        int n = arr.length;

        int[] preArray = new int[n];

        fillPrefix( arr, preArray, n );

        for( int i = 0; i < n; i++ ) {
            System.out.print( preArray[i] + " " );
        }

    }
}
