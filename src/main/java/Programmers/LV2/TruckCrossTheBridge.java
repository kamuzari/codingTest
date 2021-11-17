package Programmers.LV2;
import java.util.LinkedList;

public class TruckCrossTheBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList<Integer> q=new LinkedList<>();
        int limitLen=bridge_length;
        int limitW=weight;
        int curW=0;

        for(int i=0; i<truck_weights.length;){
            int cur=truck_weights[i];
            if(q.size()==limitLen){
                int w=q.poll();
                curW-=w;
            }
            if(curW+cur<=limitW && q.size()<limitLen){
                q.offer(cur);
                curW+=cur;
                answer++;
                i++;
            }else{
                q.offer(0);
                answer++;
            }
        }
        return answer+limitLen;
    }
}
