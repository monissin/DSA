package arrays.L1;

public class MajorityWins {

    public static int majorityWins(int arr[], int n, int x, int y) {
        int xCount=0,yCount=0;
        for(int tmp:arr){
            if(tmp==x){
                xCount++;
            } else if (tmp==y) {
                yCount++;
            }
        }
        if(xCount==yCount){
            return Math.min(x, y);
        } else {
            return xCount>yCount?x:y;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        System.out.println(majorityWins(arr,arr.length,1,5));

    }
}
