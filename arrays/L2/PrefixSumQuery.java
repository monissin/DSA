package arrays.L2;

public class PrefixSumQuery {

    private static void fillPrefix( int arr[], int preArray[], int n ) {
        preArray[0]=arr[0];
        for(int i=1;i<n;i++){
            preArray[i]=preArray[i-1]+arr[i];
        }
    }

    public static void main (String[] args) {
        int arr[] = { 3, 6, 2, 8, 9, 2 };
        int n = arr.length;

        int[] preArray = new int[n];

        fillPrefix( arr, preArray, n );


        int queries[][]  = { { 2, 3 }, { 4, 6 }, { 1, 5 }, { 3, 6 } };
        int q = queries.length;

        for( int i = 0; i < q; i++ ) {
            int l = queries[i][0] - 1;
            int r = queries[i][1] - 1;
            if(l-1>0) {
                System.out.println(preArray[r] - preArray[l - 1]);
            } else {
                System.out.println(preArray[r]);
            }

        }
    }
}
