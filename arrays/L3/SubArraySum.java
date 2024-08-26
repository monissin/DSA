package arrays.L3;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArraySum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s){
        int cur=0,start=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            cur+=arr[i];
            while (cur > s && start < i)
            {
                cur = cur - arr[start];
                start++;
            }
            if (cur==s) {

                list.add(start+1);
                list.add(i+1);
                return list;
            }

        }

        if(list.size()==0){
            list.add(-1);
        }
        return list;
    }

    public static String getShapeName(String shape) {
         final String filterShape = "VM.Standard3.Flex";
         final String standardE4Shape = "VM.Standard.E4.Flex";
        return shape.contains(filterShape) ? shape.replace(filterShape,standardE4Shape) : shape;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,7,5};
        System.out.println(getShapeName("PostgreSQL.VM.Standard3.Flex.4.64GB"));
        System.out.println(subarraySum(arr,arr.length,12));

    }
}
