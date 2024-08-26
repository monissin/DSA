package searching.L4;

public class MinNoOfPages {

    public static boolean isFeasible(int[] arr, int sum, int N, int M){
        int curSum=0,requiredStudent=1;
        for (int i=0;i<N;i++){
            curSum+=arr[i];
            if(curSum>sum){
                requiredStudent++;
                curSum=arr[i];
            }
        }
        return requiredStudent<=M;
    }

    public static int findPages(int[]A,int N,int M)
    {
        if (N < M)
            return -1;
        int sum=0,max=0,res=-1;
        for(int tmp:A){
            sum+=tmp;
            max=Math.max(max,tmp);
        }
        // sum is the max value that can be read by student
        // max is the min value that can be read by student
        while (max<=sum){
            int mid=(sum+max)/2;
            if(isFeasible(A,mid,N,M)){
                res=mid;
                sum=mid-1;
            } else {
                max=mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 4;
        int A[] = {12,34,67,90};
        int M = 2;
        System.out.println(findPages(A,N,M));
    }
}
