package WeeklyThuseday.SAMSUNG;

import java.util.LinkedList;
import java.util.Scanner;

public class WizardShark_Fireball {
    static int n,m,k;
    static class fireBall{
        private int m,s,d;

        public fireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static LinkedList<fireBall> map[][];
    static int dy[]={-1,-1,0,1,1,1,0,-1};
    static int dx[]={0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        map = new LinkedList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < m; i++) {
                map[sc.nextInt()-1][sc.nextInt()-1].add(new fireBall(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        while (k-- > 0) {
            move();
            inspection();
        }
        int sum[] = {0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j].stream().mapToInt(value -> value.m).forEach(value -> sum[0]+=value);
            }
        }
        System.out.println(sum[0]);
    }

    private static void inspection() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size=map[i][j].size();
                if(size<=1)
                    continue;
                int mSum=0;
                int sSum=0;
                boolean even=true; boolean odd=true;
                for (fireBall fireBall : map[i][j]) {
                    mSum+=fireBall.m;
                    sSum+=fireBall.s;
                    if(fireBall.d%2==0)
                    {
                        odd=false;
                    }
                   else
                    {
                        even=false;
                    }
                }
                map[i][j].clear();
                if(mSum/5==0) {
                    continue;
                }
                int m=mSum/5;
                int s=sSum/size;
                for (int l = 0; l < 4; l++) {
                    if(even||odd)
                    {
                        map[i][j].add(new fireBall(m,s,2*l));
                    }
                    else
                    {
                        map[i][j].add(new fireBall(m,s,1+2*l));
                    }
                }
            }
        }
    }

    private static void init(LinkedList<fireBall>[][] temp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j]=new LinkedList<>();
            }
        }
    }

    private static void move() {
        LinkedList<fireBall> temp[][]=new LinkedList[n][n];
        init(temp);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (fireBall fireBall : map[i][j]) {
                    int dist=(fireBall.s)%n;
                    int ny=(i+dy[fireBall.d]*dist+n)%n;
                    int nx=(j+dx[fireBall.d]*dist+n)%n;
                    temp[ny][nx].add(new fireBall(fireBall.m, fireBall.s, fireBall.d));
                }
            }
        }
        map=temp;

    }


}