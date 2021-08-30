package AL_CS_STUDY.Weekly_20to30.Weekly20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BabyShark {
    static class Node{
        private int y,x,dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    static int n,map[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        map=new int[n][n];
        int sy=0,sx=0;
        for (int i = 0; i < n; i++) {
            String str[] =br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(str[j]);
                if (a == 9) {
                    sy = i;
                    sx = j;
                } else
                    map[i][j] = a;
            }
        }
        int cnt=0;
        int minDist=0;
        int level=2;
        int exp=0;
        Node baby=new Node(sy,sx,0);
        do {
            boolean v[][]=new boolean[n][n];
            Queue<Node> q=new LinkedList<>();
            v[baby.y][baby.x]=true;
            q.offer(new Node(baby.y, baby.x, 0));
            minDist=(int)1e9;
            while (!q.isEmpty())
            {
                Node cur = q.poll();
                if(cur.dist >minDist)
                    continue;
                if(map[cur.y][cur.x]<level && map[cur.y][cur.x]!=0)
                { // 작은레벨의 물고기를 먹을 때 가장 짧은 맨해튼 거리에 있는 물고기 먹기. 만약 거리가 같으면 위 , 왼쪽에 있는 걸로.
                    if(cur.dist<minDist)
                    {
                        minDist=cur.dist;
                        baby=cur;
                    }
                    else if(cur.dist==minDist)
                    {
                        if(cur.y< baby.y)
                        {
                            baby=cur;
                        }
                        else if(cur.y== baby.y && cur.x <baby.x)
                        {
                            baby=cur;
                        }
                    }
                    continue;
                }
                // 이동 하는 방향.
                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + cur.y;
                    int nx = dx[i] + cur.x;
                    if (nx >= 0 && ny >= 0 && ny < n && nx < n) {
                        if (!v[ny][nx] && map[ny][nx]<=level) {
                            v[ny][nx] = true;
                            q.add(new Node(ny, nx, cur.dist + 1)); // 거리를 계속 더해줌.
                        }
                    }
                }

            }
            if (minDist != (int)1e9) {
                cnt += minDist;
                exp++;
                if (exp == level) {
                    level++;
                    exp = 0;
                }
            }
            map[baby.y][baby.x] = 0;
        } while (minDist!=(int)1e9);
        System.out.println(cnt);

    }
}
