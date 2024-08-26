package searching.L2;

public class FindFloor {

    static int findFloor(long arr[], int n, long x)
    {
        int low=0, high=n-1,res=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x){
                high=mid-1;
            } else if(arr[mid]==x) {
                return mid;
            } else{
                low=mid+1;
                res=mid;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int N = 7, x = 5;
        long arr[] = {1,2,8,10,11,12,19};
        System.out.println(findFloor(arr,N,x));
    }
}
