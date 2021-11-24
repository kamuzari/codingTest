package BaekJoon.SolvedAC3;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ9019_DSLR {
    static class register{
        private int number;
        private String cmd;

        public register(int number, String cmd) {
            this.number = number;
            this.cmd=cmd;
        }
        int D(){
            return (number*2)%10000;
        }
        int S(){
            return number==0 ? 9999 : number-1;
        }
        int L(){
            return number%1000*10+number/1000;
        }
        int R(){
            return number%10*1000+number/10;
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder answer=new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean v[]=new boolean[10000];
            v[a]=true;
            LinkedList<register> q=new LinkedList<>();
            q.offer(new register(a,""));
            while (!q.isEmpty()){
                register cur = q.poll();
                if(cur.number==b){
                    answer.append(cur.cmd+"\n");
                    break;
                }

                if(!v[cur.D()]){
                    q.offer(new register(cur.D(), cur.cmd+"D"));
                    v[cur.D()]=true;
                }
                if(!v[cur.S()]){
                    q.offer(new register(cur.S(), cur.cmd+"S"));
                    v[cur.S()]=true;
                }
                if(!v[cur.L()]){
                    q.offer(new register(cur.L(), cur.cmd+"L"));
                    v[cur.L()]=true;
                }
                if(!v[cur.R()]){
                    q.offer(new register(cur.R(), cur.cmd+"R"));
                    v[cur.R()]=true;
                }
            }

        }
        System.out.println(answer);
    }
}
