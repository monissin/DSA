package searching.L2;

public class FloorSqrt {

    static long floorSqrt(long x)
    {
        if(x==0||x==1){
            return x;
        }
        long ans=0,start=1,last=x/2;
        while (start<=last){
            long mid=(start+last)/2;
            long val=mid*mid;
            if(val==x){
                return mid;
            } else if (val<x) {
                ans=mid;
                start=mid+1;
            } else {
                last=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(4));

    }
}
