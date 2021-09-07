package tues_thurs_sat._20210715;

import java.util.ArrayList;
import java.util.Collections;

public class _HowToLineUp2 {
    public static void main(String[] args) {

        System.out.println(solution(3,5));
    }
    public static int[] solution(int n, long k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; ++i) list.add(i);

        return recur(0, 0, n, k, new int[n], list);
    }

    private  static int[] recur(long cnt, int idx, int n, long k, int[] answer, ArrayList<Integer> list){
        if(idx == n){
            return answer;
        }

        int num = 0;
        long add = fectorial(n - (idx + 1));
        Collections.sort(list);

        while(true){
            num = list.remove(0);
            if(cnt + add >= k) break;
            cnt += add;
            list.add(num);
        }

        answer[idx] = num;
        return recur(cnt, idx + 1, n, k, answer, list);
    }

    private  static long fectorial(int n){
        long result = 1;
        while(n >= 1) result *= n--;

        return result;
    }
}
