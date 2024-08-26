package arrays.L2;

public class TrappingRainWater {

    static long trappingWater(int arr[], int n) {
        int left[]=new int[n];
        left[0]=arr[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }
        int right[]=new int[n];
        right[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
           right[i]=Math.max(right[i+1],arr[i]);
        }
        long max=0;
        for(int i=0;i<n;i++){
            int min=Math.min(left[i],right[i]);
            if(arr[i]<min){
                max+=min-arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {3,0,0,2,0,4};
        System.out.println(trappingWater(arr,arr.length));
    }
}
