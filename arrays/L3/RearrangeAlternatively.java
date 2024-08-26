package arrays.L3;

public class RearrangeAlternatively {

    public static void rearrange(long arr[], int n){

        int maxIndex=n-1, minIndex=0;
        long maxEle=arr[n-1]+1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                arr[i]=arr[i]+((arr[maxIndex]%maxEle)*maxEle);
                maxIndex--;
            } else{
                arr[i]=arr[i]+((arr[minIndex]%maxEle)*maxEle);
                minIndex++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i]/=maxEle;
        }
        printArr(arr,n);
    }

    static void printArr(long arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        long[] arr=new long[]{10,20,30,40,50,60,70,80,90,100,110};
        rearrange(arr,arr.length);

    }
}
