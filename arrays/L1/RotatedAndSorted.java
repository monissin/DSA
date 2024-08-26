package arrays.L1;

public class RotatedAndSorted {
    public static boolean checkRotatedAndSorted(int arr[], int num){

        if(num==0||num==1){
            return true;
        }
        int change=1;
       if(arr[0]>arr[num-1]){
           for(int i=1;i<num;i++){
               if(arr[i]<arr[i-1]){
                 change--;
               }
           }
       } else {
           for(int i=1;i<num;i++){
               if(arr[i]>arr[i-1]){
                   change--;
               }
           }
       }
       return change == 0;

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(checkRotatedAndSorted(arr,arr.length));
    }
}
