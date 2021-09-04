package tues_thurs_sat._202109._0904;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HanoiTop {
    public static void main(String[] args) {
        HanoiTop hanoiTop = new HanoiTop();
        hanoiTop.solution(2);
    }

    static List<int[]> sequence=new LinkedList<>();
    public int[][] solution(int n)
    {
        hanoi(n,1,3,2);
        int [][]answer=new int[sequence.size()][2];
        int idx=0;
        for (int[] ints : sequence) {
            answer[idx++]=ints.clone();
        }
        Arrays.stream(answer).forEach(ints -> System.out.println(Arrays.toString(ints)));
        return answer;
    }
    private void hanoi(int n,int from,int to,int via)
    {
        int [] move={from,to};

        if(n==1)
        {
            sequence.add(move);
        }
        else
        {
            hanoi(n-1,from,via,to);
            sequence.add(move);
            hanoi(n-1,via,to,from);
        }


    }


}
