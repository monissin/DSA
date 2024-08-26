package searching.L1;

public class FirstAndLastOccurence {

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
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        System.out.println(first(arr,8,arr.length));
        System.out.println(last(arr,8,arr.length));

    }
}
