package arrays.L1;

public class StrongestNeighbour {

    static void maximumAdjacent(int sizeOfArray, int arr[]){

      StringBuffer stringBuffer=new StringBuffer();
      for(int i=1;i<sizeOfArray;i++){
          stringBuffer.append(Math.max(arr[i-1],arr[i]));
          stringBuffer.append(" ");
      }
        System.out.println(stringBuffer.toString());

    }

    public static void main(String[] args) {
        int arr[] = {89,89,60};
        maximumAdjacent(arr.length,arr);

    }
}
