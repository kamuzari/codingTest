package AL_CS_STUDY.Weekly21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Castle {
    static class Node{
        private int y,x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int n,m;
    static int dy[]={0,-1,0,1};
    static int dx[]={-1,0,1,0};
    static int dir[]={1,2,4,8};
    static int map[][],wall[][];
    static  Queue<Node> q;
    static ArrayList<Integer> area=new ArrayList<>();
    static int maxArea=0;
    static int room=0;
    static Map<Integer,Set<Integer>> beside=new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[m][n];
        wall=new int[m][n];
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                wall[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int num=1;
       q=new LinkedList<>();
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==0)
                {
                    bfs(i,j,num++);
                    room++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println(room);
        System.out.println(maxArea);
        int sum=0;
        for (int i = 1; i <=room; i++) {
            if(beside.get(i)!=null)
            {
                for (Integer val : beside.get(i)) {
                    sum=Math.max(area.get(i-1)+area.get(val-1),sum);
                }
            }
        }
        System.out.println(sum);
    }

    private static void bfs(int y, int x, int num) {
        int cnt=0;
        map[y][x]=num;
        q.offer(new Node(y,x));
        Set<Integer> set=new HashSet<>();
        while (!q.isEmpty())
        {
            Node cur = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(ny>=0 && nx>=0 && ny<m && nx<n)
                {
                    if( map[ny][nx]!=num && map[ny][nx]!=0)
                    {
                        set.add(map[ny][nx]);
                        continue;
                    }
                    if((wall[cur.y][cur.x] & dir[i])==0 && map[ny][nx]==0)
                    {
                        q.offer(new Node(ny,nx));
                        map[ny][nx]=num;
                    }
                }
            }
        }
        beside.put(num,set);
        area.add(cnt);
        maxArea=Math.max(cnt,maxArea);
    }
}
