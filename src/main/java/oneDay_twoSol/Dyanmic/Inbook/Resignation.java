package oneDay_twoSol.Dyanmic.Inbook;

import java.util.Scanner;

public class Resignation {
    static int maxVal;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        node calendar[]=new node[n+1];
        for (int i = 1; i < n+1; i++) {
            calendar[i]=new node(sc.nextInt(),sc.nextInt());
        }
        int dp[]=new int[n+2];
        for (int i = n; i >0 ; i--) {

            int time=calendar[i].getTime()+i;
//            System.out.println(time);
            if(time<=n+1)
            {
                dp[i]=Math.max(calendar[i].getProfit()+dp[time],maxVal);
                maxVal=dp[i];
            }
            else
                dp[i]=maxVal;
        }
        System.out.println(dp[1]);
    }

    static class node{
        private  int time;
        private  int profit;

        @Override
        public String toString() {
            return "node{" +
                    "time=" + time +
                    ", profit=" + profit +
                    '}';
        }

        public node(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }

        public int getTime() {
            return time;
        }

        public int getProfit() {
            return profit;
        }
    }
}
