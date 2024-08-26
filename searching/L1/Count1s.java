package searching.L1;

public class Count1s {

    public static int countOnes(int arr[], int N){

       int last=last(arr,N);
       if(last==-1){
           return 0;
       }
       return last+1;

    }

    public static int last(int arr[],int N){
        int last=-1,low=0,high=N-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==0){
                high=mid-1;
            } else{
                last=mid;
                low=mid+1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int N = 8;
       int arr[] =  {0,0,0,0,0,0};
        System.out.println(countOnes(arr,arr.length));
    }
}
