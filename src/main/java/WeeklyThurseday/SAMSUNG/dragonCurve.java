package WeeklyThurseday.SAMSUNG;

import java.util.ArrayList;
import java.util.Scanner;

public class dragonCurve {
    static int dx[]={0,-1,0,1};
    static int dy[]={1,0,-1,0};  // 오,위,왼,아래
    static int y,x,d,g;
    static boolean map[][]=new boolean[101][101];
    static ArrayList<Integer> direc;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i <n ; i++) {
            y=sc.nextInt();
            x=sc.nextInt();
            d=sc.nextInt();
            g=sc.nextInt();
            direc= new ArrayList<>();
            direc.add(d);
            curve(g);
            draw(x,y);
        }
        int cnt=0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] && map[i+1][j]&& map[i][j+1] && map[i+1][j+1])
                    cnt++;
            }
        }
        System.out.println(cnt);

    }
    static void draw(int x,int y)
    {
        map[x][y]=true;
        int nx=x;
        int ny=y;

        for (int i = 0; i < direc.size(); i++) {
            int d=direc.get(i);
            nx+=dx[d];
            ny+=dy[d];
            map[nx][ny]=true;
        }
    }

    private static void curve(int genertaions) {
        for (int i = 0; i < genertaions; i++) { // 몇세대 까지 그려라.
            int size=direc.size();
            for (int j = size-1; j >=0 ; j--) {
                direc.add((direc.get(j)+1)%4);
            }
        }

    }
}
