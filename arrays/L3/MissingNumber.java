package arrays.L3;

public class MissingNumber {

    // segregate negative and zeros to one end
    // check for each element in segregated array
    // The idea is to use array elements as an index. To mark the presence of an element x, change the value at the index x to negative
    // Traverse the array again and print the first index which has a positive value.
    static int segregateNeg(int arr[], int n){
        int j=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=0){
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
                j++;
            }
        }
        return j;
    }
    static int missingNumber(int arr[], int start, int end)
    {
        for(int i=start;i<end;i++){
            if(Math.abs(arr[i])+start-1<end&&arr[Math.abs(arr[i])+start-1]>0){
                arr[Math.abs(arr[i])+start-1]*=(-1);
            }
        }
        for(int i=start;i<end;i++){
            if(arr[i]>0){
                return i-start+1;
            }
        }
        return end-start+1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, -1, 1};
        int start=segregateNeg(arr,arr.length);
        System.out.println(missingNumber(arr,start,arr.length));
    }
}
