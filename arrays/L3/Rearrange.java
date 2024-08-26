package arrays.L3;

public class Rearrange {
//    Let’s assume an element is a and another element is b, both the elements are less than n.
//    So if an element a is incremented by b*n.
//    So the element becomes a + b*n so when a + b*n is divided by n then the value is b and a + b*n % n is a.
    static void arrange(long arr[], int n)
    {
        for(int i=0;i<n;i++){
            arr[i]=arr[i]+((arr[(int) (arr[i])]%n)*n);
        }
        for(int i=0;i<n;i++){
            arr[i]/=n;
        }
        printArr(arr,n);
    }

    static void printArr(long arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        long[] arr=new long[]{4,0,2,1,3};
        arrange(arr,arr.length);

    }
}
