package programmers.Kits.Stack_Queue;

import java.util.*;

public class FunctionDevelopment {

    public static void main(String[] args) {
        int p[]={93,30,55};
        int p2[]={95, 90, 99, 99, 80, 99};
        int s[]={1,30,5};
        int s2[]={1,1,1,1,1,1};
        System.out.println(Arrays.toString(solution2(p,s)));
        System.out.println(Arrays.toString(solution2(p2,s2)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        int[] answer = new int[progresses.length];
        List<Integer> pro=new LinkedList<>();
        for (int val : progresses) {
            pro.add(val);
        }
        List<Integer> spe=new LinkedList<>();
        for (int val : speeds) {
            spe.add(val);
        }
        int cnt=0;
        int idx=0;
        while (!pro.isEmpty())
        {
            if(pro.get(0)<100)
            {
                for (int i = 0; i < pro.size(); i++) {
                    pro.set(i,pro.get(i)+spe.get(i));
                }
                cnt++;
            }
            else
            {
                while (!pro.isEmpty()&&pro.get(0)>=100)
                {
                    map.put(idx,map.getOrDefault(idx,0)+1);
                    pro.remove(0);
                    spe.remove(0);
                }
                idx++;
            }

        }
        answer=new int[map.size()];
        int i=0;
        for (Integer val : map.values()) {
            answer[i]=val;
            i++;
        }

        return answer;
    }
    public static int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        System.out.println(Arrays.toString(dayOfend));
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
