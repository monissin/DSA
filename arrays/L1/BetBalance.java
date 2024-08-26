package arrays.L1;

public class BetBalance {

    static int betBalance(String result)
    {
        int bet=1, balance=4;
        char[] chars=result.toCharArray();
        for(int i=0;i<chars.length;i++){

            if(chars[i]=='W'){
                balance+=bet;
                bet=1;
            } else {
                balance-=bet;
                bet*=2;
                if(bet>balance&&i!=chars.length-1){
                    return -1;
                }
            }
        }
        return balance;
    }
    public static void main(String[] args) {
        String result = "WWLWLLL";
        System.out.println(betBalance(result));

    }
}
