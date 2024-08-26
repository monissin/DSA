package searching.L1;

public class CountOccurence {

    static int first(int arr[], int x, int n){
        int low=0,high=n-1,first=-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                high=mid-1;
            } else if (arr[mid]<x) {
                low=mid+1;
            } else {
                first=mid;
                high=mid-1;
            }
        }
        return first;
    }


    static int last(int arr[], int x, int n){
        int low=0,high=n-1,last=-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                high=mid-1;
            } else if (arr[mid]<x) {
                low=mid+1;
            } else {
                last=mid;
                low=mid+1;
            }
        }
        return last;
    }
   static int countOcc(int arr[], int n, int x){
        int first=first(arr,x,n);
        if(first==-1){
            return 0;
        }
        return last(arr,x,n)-first+1;

    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 20, 20, 40, 40}, n = 6;

        int x = 40;

        System.out.println(countOcc(arr,arr.length,x));
    }
}
