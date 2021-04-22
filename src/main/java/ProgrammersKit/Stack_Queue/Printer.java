package ProgrammersKit.Stack_Queue;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int p1[]={2,1,3,2}; int l1=2;
        int p2[]={1,1,9,1,1,1}; int l2=0;
        System.out.println(solution(p1,l1));
        System.out.println(solution(p2,l2));
    }
    static class Node{
        int idx,importance;

        public Node(int idx, int importance) {
            this.idx = idx;
            this.importance = importance;
        }
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Node> list=new LinkedList<>();
        int len=priorities.length;
        for (int i = 0; i < len; i++) {
            int importance=priorities[i];
            list.offer(new Node(i,importance));
        }
        int cnt=0;

        while (true)
        {
            boolean flag=true;
            Node cur = list.poll();
            for (int j = 0; j < list.size();j++ ) {
                Node temp=list.get(j);
                if(temp.importance>cur.importance)
                {
                    flag=false;
                    list.add(cur);
                    break;
                }
            }
            if(flag)
                cnt++;
            if(flag && cur.idx==location)
                return cnt;
        }
    }
}
