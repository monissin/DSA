package arrays.L1;

public class WaveArray {
    public static void convertToWave(int n, int[] a) {
        for(int i=0;i<n;i+=2){
            if(i+1<n) {
                int tmp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,4,7,8,9,10};
        convertToWave(arr.length,arr);
    }
}
