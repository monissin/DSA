package arrays.L1;

public class MinAdjDiff {

    public static int minAdjDiff(int arr[], int n) {

        int min=Math.min(Math.abs(arr[0]-arr[1]),Math.abs(arr[n-1]-arr[0]));
        for(int i=2;i<n;i++){
            min=Math.min(min,Math.abs(arr[i-1]-arr[i]));
        }
        return min;

    }

    public static void main(String[] args) {
        int Arr[] = {10,-3,-4,7,6,5,-4,-1};
        System.out.println(minAdjDiff(Arr,Arr.length));
    }
}
