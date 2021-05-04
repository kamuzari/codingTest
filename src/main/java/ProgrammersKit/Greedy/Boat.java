package ProgrammersKit.Greedy;

import java.util.*;

public class Boat {
    public static void main(String[] args) {
        int a[]={70, 50, 80, 50};
        System.out.println(solution(a,100));
    }
    public static int Flase_solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        List<Integer> list=new LinkedList<>();
        for (int p : people) {
            list.add(p);
        }
        while (!list.isEmpty())
        {
            int sum=list.remove(0);
            answer++;
            for(int i=list.size()-1; i>=0 ; i--)
            {
                if(sum+list.get(i)<=limit)
                {
                    list.remove(list.get(i));
                    break;
                }
            }

        }
        return answer;
    }
    public static int solution(int[] people, int limit)
    {
        int answer=0;
        Arrays.sort(people);
        Deque<Integer> dq=new LinkedList<>();
        for (int p : people) {
            dq.addFirst(p);
        }
        System.out.println(dq);
        while (!dq.isEmpty())
        {
            answer++;
            Integer val = dq.pollFirst();
            if(!dq.isEmpty())
            {
                if(val+dq.peekLast()<=limit)
                    dq.pollLast();
            }
        }
        return answer;
    }
}
