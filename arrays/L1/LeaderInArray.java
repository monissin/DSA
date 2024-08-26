package arrays.L1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LeaderInArray {
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> leaders=new ArrayList<>();
        if(n==0){
            return leaders;
        }
        int largest=arr[n-1];
        leaders.add(largest);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=largest){
                largest=arr[i];
                leaders.add(largest);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        int A[] = {16,17,4,3,5,2};
        leaders(A,A.length);
    }
}
