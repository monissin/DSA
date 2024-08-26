package searching.L1;

public class RoofTop {

    static int maxStep(int A[], int N)
    {
        int steps=0,maxSteps=0;
        for(int i=1;i<N;i++){
            if(A[i-1]<A[i]){
                steps++;
                maxSteps=Math.max(steps,maxSteps);
            } else {
                steps=0;
            }
        }
        return maxSteps;
    }

    public static void main(String[] args) {
        int A[] = {6, 9, 2, 7, 5, 4, 1, 9};
        System.out.println(maxStep(A,A.length));

    }
}
