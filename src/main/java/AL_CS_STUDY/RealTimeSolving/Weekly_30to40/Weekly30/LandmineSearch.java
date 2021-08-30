package AL_CS_STUDY.RealTimeSolving.Weekly_30to40.Weekly30;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LandmineSearch {
    static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int dx[] = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int n;
    private static char[][] map;
    private static boolean[][] v;
    private static int[][] mine;

    static class Node{
        private int y,x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            n = Integer.parseInt(br.readLine());

            int answer=0;
            map = new char[n][n];
            v = new boolean[n][n];
            mine = new int[n][n];

            for (int i = 0; i < n; i++) {
                map[i]=br.readLine().toCharArray();
            }

            mineSearch();

            answer = zeroSearch(answer);

            // map[i][j] 에서 지뢰는 아니지만 해당 지점의 8방향중에 지뢰가 하나라도 있어서 누르지 못한 경우의 수
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j]!='*' &&!v[i][j])
                    {
                        v[i][j]=true;
                        answer++;
                    }
                }
            }
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int zeroSearch(int answer) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mine[i][j]==0 && !v[i][j])
                {
                    // 0인 구간 찾기
                    answer++;
                    v[i][j]=true;
                    Queue<Node> q=new LinkedList<>();
                    q.offer(new Node(i,j));
                    while (!q.isEmpty())
                    {
                        Node cur = q.poll();
                        for (int k = 0; k < 8; k++) {
                            int ny=cur.y+dy[k];
                            int nx=cur.x+dx[k];
                            if(ny<0 || nx<0 || ny>= n ||nx>= n)
                                continue;
                            if(map[ny][nx]!='*' &&!v[ny][nx] )
                            {
                                v[ny][nx]=true;
                                if( mine[ny][nx]==0)
                                    q.offer(new Node(ny,nx));
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    private static void mineSearch() {
        // 지뢰 주변 개수 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='*')
                {
                    for (int k = 0; k < 8; k++) {
                        int ny=i+dy[k];
                        int nx=j+dx[k];
                        if(ny<0 || nx<0 || ny>= n ||nx>= n)
                            continue;
                        mine[ny][nx]++;
                    }
                    v[i][j]=true;
                }

            }
        }
    }
}
