package programmers.lv2.Printer;

import java.util.*;

public class Printer_Sort {
    class Node{
        int idx;
        int val;
        public Node(int idx,int val){
            this.idx=idx;
            this.val=val;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Node> q=new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            q.offer(new Node(i,priorities[i]));
        }
        Arrays.sort(priorities);
        int idx=priorities.length-1;
        int count=1;
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur.val==priorities[idx]&&cur.idx==location){
                break;
            }
            if(cur.val!=priorities[idx]){
                q.offer(cur);
            }else{
                idx--;
                count++;
            }

        }
        return count;
    }
}
