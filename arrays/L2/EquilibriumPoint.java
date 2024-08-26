package arrays.L2;

public class EquilibriumPoint {

    public static int equilibriumPoint(long arr[], int n) {

        long rightSum=0l,leftSum=0l;
        for(long tmp:arr){
            rightSum+=tmp;
        }
        for(int i=0;i<n;i++){
            rightSum-=arr[i];
            if(rightSum==leftSum){
                return i+1;
            }
            leftSum+=arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        long A[] = {1,3,5,2,2};
        System.out.println(equilibriumPoint(A,A.length));
    }
}
