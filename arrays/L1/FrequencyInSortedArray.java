package arrays.L1;

public class FrequencyInSortedArray {

    static void printFreq(int arr[], int N){
        int freq=1;
        for(int i=1;i<N;i++){
            if(arr[i]==arr[i-1]){
                freq++;
            } else{
                System.out.println("Frequency of "+arr[i-1]+ " "+freq);
                freq=1;
            }
        }
        System.out.println("Frequency of "+arr[N-1]+ " "+freq);
    }

    public static void main(String[] args) {
        int arr[]
                = { 1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10 };
        int N = arr.length;
        printFreq(arr,N);

    }
}
