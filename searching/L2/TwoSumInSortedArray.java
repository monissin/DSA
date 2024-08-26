package searching.L2;

public class TwoSumInSortedArray {

    // Two pointer technique
   public static boolean twoSum(int[] arr,int n,int sum){
       int start=0,last=n-1;
       while (start<last){
           int tmp=arr[start]+arr[last];
           if(sum==tmp){
               return true;
           } else if (sum<tmp) {
               last--;
           } else {
               start++;
           }
       }
       return false;
   }

    public static void main(String[] args) {
        int[] arr={2,5,8,12,30};
        System.out.println(twoSum(arr,arr.length,50));
    }
}
