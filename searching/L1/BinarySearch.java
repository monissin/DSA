package searching.L1;

public class BinarySearch {

    static int searchInSorted(int arr[], int N, int K)
    {

        int low=0, high=N-1;
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

    static int bs(int arr[], int l,int r, int x)
    {

       if(r>=l){
           int mid=l+(r-l)/2;
           if(arr[mid]==x){
               return mid;
           }
           if(arr[mid]>x){
               return bs(arr,l,mid-1,x);
           }
           return bs(arr,mid+1,r,x);
       }
       return -1;

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,6};
        System.out.println(bs(arr,0,arr.length-1,1));
    }
}
