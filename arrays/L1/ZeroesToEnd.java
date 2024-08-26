package arrays.L1;

public class ZeroesToEnd {

//      Similar to remove duplicates problem
    static void moveZerosToEnd(int arr[], int n) {
        int res=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[res]=arr[i];
                res++;
            }
        }
        for(int i=res;i<n;i++){
            arr[i]=0;
        }
        printArray(arr,n);
    }

    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 9, 8, 4, 0, 0, 2,
                7, 0, 6, 0, 9};
        moveZerosToEnd(arr, arr.length);
    }
}
