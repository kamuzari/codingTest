package AL_CS_STUDY.Weekly27;

import java.util.*;
import java.io.*;

public class WizardSharkFireBall {

    private static int k;
    private static int m;
    private static int n;

    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};

    static LinkedList<Node> map[][];
    static class Node{
        private int m,s,d;

        public Node(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map=new LinkedList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=new LinkedList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine()    );
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            map[r-1][c-1].add(new Node(m,s,d));
        }

        while (k-->0)
        {
            move();
            verification();
        }

        int sum=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (Node ball : map[i][j]) {

                  sum+=ball.m;
                }
            }
        }
        System.out.println(sum);


    }

    private static void verification() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size=map[i][j].size();
                if(size<=1)
                    continue;
                int totalM=0;
                int totalS=0;
                boolean even=true;
                boolean odd=true;
                for (Node ball : map[i][j]) {
                    totalM+=ball.m ;
                    totalS+=ball.s ;
                    if(ball.d%2==0)
                    {
                        odd=false;
                    }
                    else {
                        even=false;
                    }
                }
                map[i][j].clear();
                if(totalM/5==0)
                    continue;

                int m=totalM/5;
                int s=totalS/size;
                for (int k = 0; k < 4; k++) {
                    if(even||odd)
                    {
                        map[i][j].add(new Node(m,s,2*k));
                    }
                    else
                    {
                        map[i][j].add(new Node(m,s,2*k+1));
                    }
                }
            }
        }
    }

    private static void move() {
        LinkedList<Node> [][] temp = new LinkedList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j]=new LinkedList();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (Node fireball : map[i][j]) {
                    int dist=(fireball.s)%n;
                    int ny=(i+dy[fireball.d]*dist+n)%n;
                    int nx=(j+dx[fireball.d]*dist+n)%n;
                    temp[ny][nx].add(new Node(fireball.m, fireball.s, fireball.d));
                }
            }
        }
        map=temp;
    }
}
