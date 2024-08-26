package searching.L2;

public class ThreeSumInSortedArray {

    // Two pointer technique

    // In case of unsorted, sort the array and use below technique, time complexity will remain same as 0(n2)

    public static boolean threeSum(int[] arr, int n,int sum){
        for(int i=0;i<n-2;i++){
            if(twoSum(arr,n,sum-arr[i],i+1)){
                return true;
            }
        }
        return false;
    }
   public static boolean twoSum(int[] arr,int n,int sum, int start){
       int last=n-1;
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
        int[] arr={2,5,10,15,18};
        System.out.println(threeSum(arr,arr.length,100));
    }
}
