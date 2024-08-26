package arrays.L2;

import java.util.ArrayList;

public class StockBuySell {

   static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> stocks=new ArrayList<>();
        Integer start = -1,end = -1;
        for(int i=1;i<n;i++) {
            if (A[i] > A[i - 1]) {
                if (start == -1) {
                    start = i - 1;
                }
                end = i;
            } else {
                if (start != -1 && end != -1) {
                    {
                        ArrayList<Integer> span = new ArrayList<>();
                        span.add(start);
                        span.add(end);
                        stocks.add(span);
                        start = -1;
                        end = -1;
                    }

                }
            }
        }
            if(start!=-1&&end!=-1) {
                ArrayList<Integer> span = new ArrayList<>();
                span.add(start);
                span.add(end);
                stocks.add(span);

            }
        return stocks;
    }

    public static void main(String[] args) {
        int A[] =  {4,2,2,2,4};
        System.out.println(stockBuySell(A,A.length));

    }
}
