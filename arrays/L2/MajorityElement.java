package arrays.L2;

public class MajorityElement {

    static int findCandidate(int arr[],int size){
        int majIndex=0,count=1;
        for(int i=1;i<size;i++){
            if(arr[i]==arr[majIndex]){
                count++;
            } else {
                count--;
            }
            if(count==0){
                majIndex=i;
                count=1;
            }
        }
        return arr[majIndex];
    }
    static void printMajority(int a[], int size){
        int majEle=findCandidate(a,size);
        int count=0;
        for(int tmp:a){
            if(tmp==majEle){
                count++;
            }
        }
        if(count>size/2){
            System.out.println(" " + majEle + " ");
        } else {
            System.out.println("No Majority Element");
        }
    }

    public static void main(String[] args) {
        int a[] = new int[] { 1, 1, 2, 1, 3, 5, 1 };
        printMajority(a,a.length);

    }
}
