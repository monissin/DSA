package arrays.L2;

import java.util.ArrayList;
import java.util.List;

public class PrintPattern {

    // w/o recursion
    static List<Integer> list=new ArrayList<>();

    static void f(int curr,int n,int type){
        if(curr<=0){
            type=1;
        }
        list.add(curr);
        if(type==1&&curr==n){
            return;
        }
        if(type==0){
            f(curr-5,n,type);
        } else {
            f(curr+5,n,type);
        }
    }
    public static List<Integer> pattern(int N){
        f(N,N,0);
        return list;
    }

    public static void main(String[] args) {
        pattern(16);
        System.out.println(list);
    }
}
