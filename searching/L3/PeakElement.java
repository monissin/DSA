package searching.L3;

public class PeakElement {

    // if arr[mid-1]>arr[mid]  -> peak is on left side
    // if arr[mid+1]>arr[mid]  -> peak is on right side
    public static int peakElement(int[] arr,int n)
    {
       int start=0,last=n-1;
       while (start<=last){
           int mid=(start+last)/2;
           if((mid==0||arr[mid-1]<=arr[mid])&&(mid==n-1||arr[mid]>=arr[mid+1])){
               return mid;
           } else if (mid>0&&arr[mid-1]>arr[mid]) {
               last=mid-1;
           } else {
               start=mid+1;
           }
       }
       return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,13};
        System.out.println(peakElement(arr,arr.length));
    }
}
