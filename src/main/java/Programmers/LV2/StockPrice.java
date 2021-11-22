package Programmers.LV2;

import java.util.Stack;

public class StockPrice {
    // 오큰수랑 유사.
    class Node{
        private int period,val;
        public Node(int period,int val){
            this.period=period;
            this.val=val;
        }
    }
    public int[] solution(int[] prices) {
        int n=prices.length;
        int[] answer = new int[n];
        // int n=100_000;(n^2 : = TLE)
        // System.out.println(n*((n/2)*(n+1))>=100_000_000==true ? "TLE":"PASS");
        Stack<Node> s=new Stack<>();
        for(int i=n-2; i>=0; i--){
            int period=1; // default
            while(!s.isEmpty() && s.peek().val>=prices[i] ){
                period+=s.pop().period;
            }
            s.push(new Node(period,prices[i]));
            answer[i]=s.peek().period;
        }
        s.clear();
        return answer;
    }
}
