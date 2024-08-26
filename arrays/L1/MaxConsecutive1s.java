package arrays.L1;

public class MaxConsecutive1s {

    static int maxConsecutive1s(int[] arr, int size){
        int res=0,cur=0;
        for(int tmp:arr){
            if(tmp==1){
                cur++;
                res=Math.max(res,cur);
            } else {
                cur=0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{0,1,1,0,1,1,1};
        System.out.println(maxConsecutive1s(arr,arr.length));
    }
}
