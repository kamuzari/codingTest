package tues_thurs_sat._20210715;
import java.util.*;

public class _HowToLineUp {
    public static void main(String[] args) {
        solution(4,9);
    }
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> res = new ArrayList<>();
        List<Integer> list = fillList(n);
        long dp[] = totalCount(n);

        while(true){
            long num = dp[n-1];

            if(k % num == 0){
                // 구간중 가장 마지막.
                res.add(list.remove((int) ((k/num)-1)));
                break;
            }else{
                res.add(list.remove((int) ((k/num))));
                k %= num;
            }
            n--;
        }
        if(!list.isEmpty()){
            for(int i=list.size()-1; i>=0; i--)
                res.add(list.get(i));
        }

        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }

        return answer;
    }

    private static  List<Integer> fillList(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        return list;
    }

    private static long[] totalCount(int n) {
        long dp[] = new long[n+1];

        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] * i;
        }

        return dp;
    }

}
