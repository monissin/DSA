package arrays.L1;

public class CRUD {

    //Insert element at index pos in array on length len and capacity cap
    public static int insert(int[] arr, int len, int element, int cap, int pos){
        if(len==cap){
            return len;
        }
        for(int i=len-1;i>=pos-1;i--){
            arr[i+1]=arr[i];
        }
        arr[pos-1]=element;
        return len+1;

    }

    public void insertAtIndex(int arr[],int sizeOfArray,int index,int element)
    {
        for(int i=sizeOfArray-1;i>=index-1;i--){
            arr[i+1]=arr[i];
        }
        arr[index-1]=element;
    }

    // Traverse array of length len
    public static void traverse(int[] arr,int len){
        for(int i=0;i<len;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // Search element ele in array of length len
    public static int search(int[] arr,int len, int ele){
        for(int i=0;i<len;i++){
            if (arr[i]==ele){
                return i;
            }
        }
        return -1;
    }

    // Delete element at index in array of capacity cap and length len
    public static int delete(int[] arr, int index, int cap, int len){
        if(index<0||index>=cap){
            return len;
        }
        for(int i=index;i<len-1;i++){
            arr[i]=arr[i+1];
        }
        arr[len-1]=0;
        return len-1;

    }

    public static void main(String[] args) {
        int arr[] = new int[5], cap = 5, n = 3;

        arr[0] = 5; arr[1] = 10; arr[2] = 20;

        System.out.println("Before Insertion");

        traverse(arr,n);

        int x = 7, pos = 2;

        n = insert(arr, n, x, cap, pos);

        System.out.println("After Insertion");

        traverse(arr,n);

        System.out.println("Search index of element "+7+ " in array");


        System.out.println(search(arr,n,7));

        System.out.println("Delete element at index 1");
        n=delete(arr,1,cap,n);
        traverse(arr,n);

    }
}
