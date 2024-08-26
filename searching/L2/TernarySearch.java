package searching.L2;

public class TernarySearch {

//    Time Complexity: O(Log3N)
    public static int ternarySearch(int n, int[] arr, int key){
        int left=0,right=n-1;
        while (left<=right){
            int mid1=left+(right-left)/3;
            int mid2=right-(right-left)/3;
            if(arr[mid1]==key){
                return mid1;
            } else if (arr[mid2]==key) {
                return mid2;
            } else if (arr[mid1]>key) {
                right=mid1-1;
            } else if (arr[mid2]<key) {
                left=mid2+1;
            } else {
                left=mid1+1;
                right=mid2-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,6};
        System.out.println(ternarySearch(arr.length,arr,6));

    }
}
