package programmers.Kits.Stack_Queue;

import java.util.Stack;

public class StockPrice {
    public  int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < prices.length; i++) {
            if (i != prices.length - 1) {
                for (int j = i + 1; j < prices.length; j++) {
                    if(prices[i] > prices[j])
                    {
                        answer[i] = j - i;
                        break;
                    }
                    else if(j==prices.length-1) // 발견 안되면
                    {
                        answer[i] = j - i;
                        break;
                    }
                    else if (prices[i] < prices[j]) {
                        continue;
                    }
                }
            }

        }


        return answer;
    }
}
