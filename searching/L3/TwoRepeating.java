package searching.L3;

public class TwoRepeating {

    public static int[] twoRepeated(int arr[], int N)
    {
        int[] res={-1,-1};
       for(int i=0;i<N+2;i++){
           int num=arr[i]%(N+1);
           int count=arr[(arr[i]%(N+1))-1]/(N+1);
           if(count==1){
               if(res[0]==-1){
                   res[0]=num;
               } else {
                   res[1]=num;
                   return res;
               }
           }
           arr[(arr[i]%(N+1))-1]+=(count+1)*(N+1);
       }
       return res;
    }
    public static int[] twoRepeatedEfficient(int arr[], int N)
    {
        int[] res={-1,-1};
        for(int i=0;i<N+2;i++){
           if(arr[Math.abs(arr[i])]>0){
               arr[Math.abs(arr[i])]*=-1;
           } else {
               if(res[0]==-1){
                   res[0]=Math.abs(arr[i]);
               } else {
                   res[1]=Math.abs(arr[i]);
               }
           }
        }
        return res;
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 6, 3, 4, 5, 6, 4};
        System.out.println(twoRepeated(array,6));
    }
}
