package programmers.lv2;
import java.util.*;
// 날짜 계산 : 가장 앞에 있는 날짜일수보다 많으면 중지 아니면 배포 count 증가
public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> results=new ArrayList<>();
        LinkedList<Integer> q=new LinkedList<>();
        int n=progresses.length;
        int prog[]=progresses;
        for(int i=0; i<n; i++){
            double rest=100-prog[i];
            int day=(int)Math.ceil(rest/speeds[i]);
            while(!q.isEmpty() && q.peek()<day){
                results.add(q.size());
                q.clear();
            }
            q.offer(day);
        }
        int cnt=0;
        while(!q.isEmpty()){
            q.poll();
            cnt++;
        }
        results.add(cnt);
        int answer[]=new int[results.size()];
        int idx=0;
        for(int val:results){
            answer[idx++]=val;
        }
        return answer;
    }
}
