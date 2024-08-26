package searching.L3;

public class FindRepeating {

    // Determine cycle
    // find intersection point
    // similar to linked list
    static int findRepeating1based(int[] arr, int n){
        int slow=arr[0],fast=arr[0];
        do{
            slow=arr[slow];
            fast=arr[arr[fast]];
        } while (slow!=fast);
        slow=arr[0];
        while (slow!=fast){
            slow=arr[slow];
            fast=arr[fast];
        }
        return slow;
    }

    static int findRepeating0based(int[] arr, int n){
        int slow=arr[0]+1,fast=arr[0]+1;
        do{
            slow=arr[slow]+1;
            fast=arr[arr[fast]+1]+1;
        } while (slow!=fast);
        slow=arr[0]+1;
        while (slow!=fast){
            slow=arr[slow]+1;
            fast=arr[fast]+1;
        }
        return slow-1;
    }

    public static void main(String[] args) {
        int arr[]={0,2,1,3,5,4,6,2};
        System.out.println(findRepeating0based(arr,arr.length));
    }
}
