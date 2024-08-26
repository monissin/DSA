package searching.L3;

public class MaxRainWater {

    static int maxWater(int height[], int n)
    {
       int max=Integer.MIN_VALUE,i=0,j=n-1;
       while (i<j){
           if(height[i]<height[j]){
               max=Math.max(max,(height[i]*(j-i-1)));
               i++;
           } else {
               max=Math.max(max,(height[j]*(j-i-1)));
               j--;
           }
       }
       return max;
    }

    public static void main(String[] args) {
        int height[] = {2,1};
        System.out.println(maxWater(height,height.length));
    }
}
