package ProgrammersKit.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {
    public static void main(String[] args) {
        int len=2;
        int len2=100;
        int len3=100;
        int w=10;
        int w2=100;
        int w3=100;
        int t[]={7,4,5,6};
        int t2[]={10};
        int t3[]={10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(len,w,t));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int len=truck_weights.length;
        int total=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<len; i++)
        {
            int cur=truck_weights[i];
            while(true)
            {
                if(q.size()==bridge_length)
                {
                    int val=q.poll();
                    total-=val;
                }
                if(total+cur<=weight && q.size()<bridge_length)
                {
                    q.offer(cur);
                    answer++;
                    total+=cur;
                    break;
                }
                else
                {
                    q.offer(0);
                    answer++;
                }
            }
        }
        return answer+bridge_length-1;
    }
}




