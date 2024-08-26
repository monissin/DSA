package arrays.L1;

public class ReverseArray {

    static void reverseArray(int arr[]){
        int start=0, end=arr.length-1,tmp;
        while (start<end){
            tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            start++;
            end--;
        }

    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        reverseArray(arr);
    }
}
