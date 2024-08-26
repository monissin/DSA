package arrays.L1;

public class RotateArray {

    static void reverseArray(int arr[], int start, int end){
        int tmp;
        while (start<end){
            tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            start++;
            end--;
        }

    }
    static void rotateArr(int arr[], int d, int n)
    {
        reverseArray(arr,0,d-1);
        reverseArray(arr,d,n-1);
        reverseArray(arr,0,n-1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}, n = 5, d = 2;
        rotateArr(arr,d,n);

    }
}
