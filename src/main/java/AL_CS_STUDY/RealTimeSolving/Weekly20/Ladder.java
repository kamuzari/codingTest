package AL_CS_STUDY.RealTimeSolving.Weekly20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ladder {
    private static int[] dy = {0, 0, -1};
    private static int[] dx = {-1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int n=Integer.parseInt(br.readLine().trim());
            int [][]map=new int[100][100];
            boolean visited[][]=new boolean[100][100];
            int y=0,x=0,answer=0;
            for (int i = 0; i < 100; i++) {
                String str[]=br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    map[i][j]=Integer.parseInt(str[j]);
                    if(map[i][j]==2)
                    {
                        y=i;
                        x=j;
                    }
                }
            }

            while (true)
            {
                boolean flag=true;
                visited[y][x]=true;
                for (int i = 0; i < 3; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny == 0) {
                        answer = x;
                        flag = false;
                        break;
                    }
                    if (ny >= 0 && nx >= 0 && ny < 100 && nx < 100 && map[ny][nx] == 1 && !visited[ny][nx]) {
                        y = ny;
                        x = nx;
                        break;
                    }
                }
                    if (!flag) {
                        break;
                    }
            }
            System.out.println("#"+t+" "+answer);
        }
    }
}
