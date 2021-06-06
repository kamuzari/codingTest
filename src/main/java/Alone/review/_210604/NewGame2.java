package Alone.review._210604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NewGame2 {
    static class Node {
        private int y, x, d;

        public Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setD(int d) {
            this.d = d;
        }
    }

    static int n, k;
    static int dy[] = {0, -1, 0, 1};
    static int dx[] = {1, 0, -1, 0};
    static ArrayList<Integer> map[][];
    static int colors[][];
    static Node horses[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new ArrayList[n][n];
        horses = new Node[n];
        colors=new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            if (d == 1)
                d = 2;
            else if (d == 2)
                d = 1;
            horses[i] = new Node(y, x, d);
            map[y][x].add(i);
        }
        for (int tiem = 1; tiem <= 1000; tiem++) {
            for (int j = 0; j < k; j++) {
                Node cur = horses[j];
                int height = 0;
                for (int h = 0; h < map[cur.y][cur.x].size(); h++) {
                    if (map[cur.y][cur.x].get(h) == j) {
                        height = h;
                        break;
                    }
                }

                int ny = dy[cur.d] + cur.y;
                int nx = dx[cur.d] + cur.x;
                if (ny < 0 || nx < 0 || ny >= n && nx >= n || colors[ny][nx] == 2) {
                    cur.setD((cur.d + 2) % 4);
                    ny = dy[cur.d] + cur.y;
                    nx = dx[cur.d] + cur.x;
                    if(ny < 0 || nx < 0 || ny >= n && nx >= n || colors[ny][nx] == 2)
                    {
                        continue;
                    }
                }
                int prevY=cur.y;
                int prevX=cur.x;
               while (map[prevY][prevX].size()>height)
               {
                   int moveHorseNumber=0;
                    if(colors[ny][nx]==0)
                    {
                        moveHorseNumber=map[prevY][prevX].remove(height);
                    }
                    else if(colors[ny][nx]==1)
                    {
                        moveHorseNumber=map[prevY][prevX].remove(map[prevY][prevX].size()-1);
                    }
                    else if(colors[ny][nx]==2)
                    {
                        // 위에서 처리
                    }

                    horses[moveHorseNumber].setY(ny);
                    horses[moveHorseNumber].setY(nx);
                    map[ny][nx].add(moveHorseNumber);
               }
               if(map[ny][nx].size()>=4)
               {
                   System.out.println(tiem);
                   return;
               }

            }
        }
        System.out.println(-1);
    }
}
