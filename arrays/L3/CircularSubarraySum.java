package arrays.L3;

public class CircularSubarraySum {

    static int circularSubarraySum(int a[], int n) {

        if(n==1){
            return a[0];
        }
        int sum=0;
        for(int tmp:a){
            sum+=tmp;
        }
        int max_sum=a[0],cur_max=a[0],min_sum=a[0],cur_min=a[0];
        for(int i=1;i<n;i++){
            cur_max=Math.max(cur_max+a[i],a[i]);
            max_sum=Math.max(cur_max,max_sum);
            cur_min=Math.min(cur_min+a[i],a[i]);
            min_sum=Math.min(min_sum,cur_min);
        }
        if(min_sum==sum){
            return max_sum;
        }
        return Math.max(max_sum,sum-min_sum);
    }

    public static void main(String[] args) {
        int arr[] = {-12,-14};
        System.out.println(circularSubarraySum(arr,arr.length));

    }
}
