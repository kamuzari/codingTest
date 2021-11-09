package Programmers.LV2.Printer;

import java.util.*;

public class Printer_TreeMap {
    TreeMap<Integer,Integer> map=new TreeMap<>();
    class Node{
        private int idx, prior;
        public Node(int idx,int prior){
            this.idx=idx;
            this.prior=prior;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 1;
        LinkedList<Node> q=new LinkedList<>();
        int[] p=priorities;
        for(int i=0; i<p.length; i++){
            q.offer(new Node(i,p[i]));
            map.put(p[i],map.getOrDefault(p[i],0)+1);
        }
        while(!q.isEmpty()){
            Node cur=q.poll();
            int priorKey=map.lastKey();
            if(cur.prior!=priorKey) {
                q.offer(cur);
            }else if(cur.prior==priorKey && cur.idx==location){
                break;
            }else if(cur.prior==priorKey){
                if(map.get(priorKey)==1){
                    map.remove(priorKey);
                }else{
                    map.put(priorKey,map.get(priorKey)-1);
                }
                answer++;
            }
        }
        return answer;
    }
}
