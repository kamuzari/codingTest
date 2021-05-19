package WeeklyThuseday.SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SharkFireball {
    static int n,m,k;
    static LinkedList<fireBall> map[][];
    static int dy[]={-1,-1,0,1,1,1,0,-1};
    static int dx[]={0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        map=new LinkedList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=new LinkedList<>();
            }
        }
        Queue<fireBall> q=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int y=sc.nextInt()-1;
            int x=sc.nextInt()-1;
            map[y][x].add(new fireBall(sc.nextInt(),sc.nextInt(), sc.nextInt()));
        }

        while (k-->0)
        {
            LinkedList<fireBall> copy[][]=new LinkedList[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    copy[i][j]=new LinkedList<>();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j].size()>0)
                    {
                        for (fireBall ball : map[i][j]) {
                            int dist=ball.s%n;
                            int y=(i+dy[ball.d]*dist +n)%n;
                            int x=(j+dx[ball.d]*dist +n)%n;
//                            System.out.println(y+" "+x+"  object -> "+ ball.toString() );
                            copy[y][x].add(new fireBall(ball.m,ball.s,ball.d));
                        }
                    }
                }
            }
            map=copy;
            inspection();
        }

        int sum[]={0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j].stream().forEach(fireBall -> sum[0]+=fireBall.m);
            }
        }

        System.out.println(sum[0]);




    }

    public static void inspection()
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j].size()==0 || map[i][j].size()==1)
                    continue;
                else
                {
                    int mSum=0;
                    int sSum=0;
                    boolean even=true;
                    boolean odd=true;
                    for (fireBall ball : map[i][j]) {
                        mSum+= ball.m;
                        sSum+= ball.s;
                        if(ball.d %2!=0)
                            even=false;
                        else
                            odd=false;
                    }
                    int m=mSum/5;
                    int s=sSum/map[i][j].size();
                    map[i][j].clear();
                    if(m==0)
                    {
                        continue;
                    }
                    for (int l = 0; l < 4; l++) {
                        if(odd || even)
                        {
                            map[i][j].add(new fireBall(m,s,2*l));
                        }
                        else
                        {
                            map[i][j].add(new fireBall(m,s,2*l+1));
                        }
                    }
                }
            }
        }
    }
    static class fireBall{
        private int m,d,s;

        public fireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "fireBall{" +
                    "m=" + m +
                    ", d=" + d +
                    ", s=" + s +
                    '}';
        }
    }
}

/*
0 2  object -> fireBall{m=5, d=2, s=2}
0 2  object -> fireBall{m=7, d=6, s=1}
3 2  object -> fireBall{m=2, d=0, s=1}
0 3  object -> fireBall{m=2, d=2, s=1}
1 2  object -> fireBall{m=2, d=4, s=1}
0 1  object -> fireBall{m=2, d=6, s=1}
0 0  object -> fireBall{m=2, d=6, s=1}
0 0  object -> fireBall{m=2, d=2, s=1}
2 2  object -> fireBall{m=2, d=4, s=1}
2 2  object -> fireBall{m=2, d=0, s=1}
8

Process finished with exit code 0

*/