package AL_CS_STUDY.Weekly_20to30.Weekly22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TLE_iceMountain {
    static int n,m,map[][],area[][],melt[][];
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];

        List<Node> list=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]!=0)
                {
                    list.add(new Node(i,j,map[i][j]));
                }
            }
        }
        int t=0;
        int cnt=0;
        while (true)
        {
            t++;
            cnt=1;
            area=new int[n][m];
            // 최대 9,000,000 칸  -> list 300칸
            for (Node node : list) {
                if(area[node.y][node.x]==0) {
                    areaAssign(node.y, node.x, cnt);
                    cnt++;
                }

                if(cnt>2)
                {
                    System.out.println(t-1);
                    return;
                }
            }


            List<Node> newList=new ArrayList<>();
            List<Node> removeList=new ArrayList<>();
            for (Node ice : list)
            {
                Node cur = ice;
                int count=0;
                for (int i = 0; i < 4; i++) {
                    int ny=dy[i]+cur.y;
                    int nx=dx[i]+cur.x;
                    if(ny<0 || nx<0 && ny>=n && nx>=m)
                        continue;
                    if(map[ny][nx]==0)
                        count++;
                }
                int gap = cur.h - count;
                if(gap>0)
                {
                    newList.add(new Node(cur.y,cur.x,gap));
                    map[cur.y][cur.x]=gap;
                }
                else
                {
                    removeList.add(new Node(cur.y,cur.x));
                }
            }
            for (Node node : removeList) {
                map[node.y][node.x]=0;
            }
/*            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(map[i]));
            }*/
            list.clear();
            list.addAll(newList);
        }
    }
    static void areaAssign(int y,int x,int number)
    {
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(y,x));
        area[y][x]=number;
        while (!q.isEmpty())
        {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny<0 || nx<0 && ny>=n && nx>=m)
                    continue;
                if(area[ny][nx]!=0)
                    continue;
                if(map[ny][nx]==0)
                    continue;

                area[ny][nx]=number;
                q.offer(new Node(ny,nx));
            }
        }
    }
    static class Node{
        private int y,x,h;

        public Node(int y,int x)
        {
            this.y=y;
            this.x = x;
        }
        public Node(int y, int x,int h) {
            this.y = y;
            this.x = x;
            this.h=h;
        }
    }
}
