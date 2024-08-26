package arrays.L2;

public class LongestEvenOddSubarray {

    public static int maxEvenOdd(int[] arr, int n){
        int res=0,cur=1;
        for(int i=1;i<n;i++){
            if(arr[i]%2!=arr[i-1]%2){
                cur++;
            } else {
                res=Math.max(res,cur);
                cur=1;
            }
        }
        res=Math.max(res,cur);
        if(res==1){
            res=0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10,12,14,7,8};
        System.out.println(maxEvenOdd(arr,arr.length));
    }
}
