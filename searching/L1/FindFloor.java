package searching.L1;

public class FindFloor {

    static int findFloor(long arr[], int n, long x)
    {
        int low=0, high=n-1;
        if (x >= arr[high])
            return high;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x) {
                return (int) arr[mid];
            } else if(arr[mid]>x){
                if(mid>0&&arr[mid-1]<=x){
                    return (int) arr[mid-1];
                }
                high=mid-1;
            } else if(arr[mid]==x) {
                return (int) arr[mid];
            } else{
                    return (int) arr[mid];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long arr[] = {1,2,6,8,10,11,12,19};
        System.out.println(findFloor(arr,arr.length,5));
    }
}
