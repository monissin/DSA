package arrays.L3;

public class FrequencyCount {

    public static void frequencyCount(int arr[], int N, int P)
    {
        for(int i=0;i<N;i++){
            int ele=arr[i]%(P+1);
            if(ele<=N) {
                int val = arr[(ele) - 1] / (P + 1);
                arr[ele - 1] = (arr[ele - 1] % (P + 1)) + (val + 1) * (P + 1);
            }
        }
        for (int i=0;i<N;i++){
            arr[i]=arr[i]/(P+1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,3,2,3,5};
        frequencyCount(arr,5,5);
    }
}
