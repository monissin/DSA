package searching.L4;

public class MedianOf2SortedArray {

    // https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Searching/article/NzIyMg%3D%3D
    // https://www.geeksforgeeks.org/batch/dsa-4/track/DSASP-Searching/video/MTQyMA%3D%3D

    public static int findMedian(int arr[], int n, int brr[], int m)
    {
        if(n>m){
            return findMedian(brr,m,arr,n);
        }
        int mergedMid=(n+m+1)/2;
        int left=0,right=n;
        while (left<=right){
            int midA=(left+right)/2;
            int midB=mergedMid-midA;
            int leftA=(midA>0)?arr[midA-1]:Integer.MIN_VALUE;
            int rightA=(midA<n)?arr[midA]:Integer.MAX_VALUE;
            int leftB=(midB>0)?brr[midB-1]:Integer.MIN_VALUE;
            int rightB=(midB<m)?brr[midB]:Integer.MAX_VALUE;
            if(leftA<=rightB&&leftB<=rightA){
                if((n+m)%2==0){
                    return (Math.max(leftA,leftB)+Math.min(rightA,rightB))/2;
                } else {
                    return Math.max(leftA,leftB);
                }
            } else if (leftA>rightB) {
                right=midA-1;
            } else {
                left=midA+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
       int arr[] = {1,2,3,4,5};
       int brr[] = {3,4,5,6,7,8};

        System.out.println(findMedian(arr,arr.length,brr, brr.length));

    }

}
