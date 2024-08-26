package arrays.L2;

public class MaxKSum {

    static int maxSum(int arr[], int n, int k){
        int max=Integer.MIN_VALUE,cur=0;
        for(int i=0;i<k;i++){
            cur+=arr[i];
        }
        for(int i=k;i<n;i++){
            cur+=(arr[i]-arr[i-k]);
            max=Math.max(max,cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 8, 30, -5, 20, 7 }, n = arr.length, k = 3;
        System.out.println(maxSum(arr,n,k));

    }
}
