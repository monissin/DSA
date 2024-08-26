package arrays.L2;

public class MaxSubArraySum {

    static long maxSubarraySum(int arr[], int n){

       Long max=Long.MIN_VALUE,till=0l;
       for(int tmp:arr){
           till=Math.max(till+tmp,tmp);
           max=Math.max(max,till);
       }
       return max;

    }

    public static void main(String[] args) {
        int Arr[] = {-1,-2,-3,-4};
        System.out.println(maxSubarraySum(Arr,Arr.length));
    }
}
