package searching.L2;

import java.util.Objects;

public class FindRepeating {

    static class Pair{
        long x;
        long y;

        Pair(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
    public static Pair findRepeating(Long arr[],int n)
    {
        if((n-(arr[n-1]-arr[0]))==1){
            return new Pair(-1,-1);
        }
        int start=0,last=n-1;
        while (start<=last){
            int mid=(start+last)/2;
            if(arr[mid]>=arr[0]+mid){
                start=mid+1;
            } else {
                last=mid-1;
            }
        }
        return new Pair(arr[start],n-(arr[n-1]-arr[0]));
    }

    public static void main(String[] args) {
        Long arr[] = {1L,2L,3L,3L,4L};
        Pair pair=findRepeating(arr,arr.length);
        System.out.println(pair.x);
        System.out.println(pair.y);
    }
}
