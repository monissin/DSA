package searching.L2;

public class SearchInfiniteArray {

    static int findPos(int[] arr, int target){
        int start=0,last=1;
        while (arr[last]<target){
            int tmp=last+1;
            last=last+(last-start+1)*2;
            start=tmp;
        }
        return searchInSorted(arr,start,last,target);
    }

    static int searchInSorted(int arr[], int low,int high, int K)
    {
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==K){
                return mid;
            } else if(arr[mid]>K){
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        int[] arr = { 3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170 };
        int target = 10;
        // Function call
        int ans = findPos(arr, target);
        if (ans == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index "
                    + ans);
    }
}
