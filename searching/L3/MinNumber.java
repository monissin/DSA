package searching.L3;

public class MinNumber {

    static int minNumber(int arr[], int low, int high)
    {
        if(arr[low]<=arr[high]){
            return arr[low];
        }
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<arr[mid-1]){
                return arr[mid];
            }
            if(arr[mid]>arr[high]){
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,7,8,9,10,1};
        System.out.println(minNumber(arr,0, arr.length-1));
    }
}
