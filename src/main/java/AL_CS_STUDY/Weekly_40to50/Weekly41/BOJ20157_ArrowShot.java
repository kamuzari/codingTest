package AL_CS_STUDY.Weekly_40to50.Weekly41;

import java.io.BufferedReader;

import java.io.*;
import java.util.*;

public class BOJ20157_ArrowShot {
    static class Node{
        private int y, x;
        public Node(int y,int x){
            this.y=y;
            this.x=x;
        }
        @Override
        public boolean equals(Object o){
            Node comp=(Node)o;
            return this.y==comp.y && this.x==comp.x;
        }

        @Override
        public int hashCode(){
            return Objects.hash(y,x);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Map<Node,Integer> map=new HashMap<>();
        List<Node> list=new LinkedList<>();
        for(int i=0; i<n; i++){
            String str[]=br.readLine().split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            int incli=GCD(a,b);
            incli=Math.max(incli,(-1)*incli);
            Node key=new Node(b/incli,a/incli);
            map.put(key,map.getOrDefault(key,0)+1);
            list.add(key);
        }
        int answer=0;
        for (Node key : list) {
            answer=Math.max(answer,map.get(key));
        }
        System.out.println(answer);
    }
    static int GCD(int a,int b){
        while(b!=0){
            int tmp=a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
}
