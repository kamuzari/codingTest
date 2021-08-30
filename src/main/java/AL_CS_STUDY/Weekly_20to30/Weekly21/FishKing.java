package AL_CS_STUDY.Weekly_20to30.Weekly21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class FishKing {
    static int n, m, sharkOfNumber;

    static class shark implements Comparable<shark> {
        private int y, x, s, d, z;

        public shark(int y, int x, int s, int d, int z) {
            this.y = y;
            this.x = x;
            this.s = s;
            this.d = d;
            this.z = z;
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



        @Override
        public int compareTo(shark shark) {
            if (x == shark.x) {
                if (y == shark.y) {
                    return shark.z - z;
                }
                return y - shark.y;
            }
            return x - shark.x;
        }
    }

    static int dy[] = {0, -1, 1, 0, 0};
    static int dx[] = {0, 0, 0, 1, -1};
    static ArrayList<shark> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sharkOfNumber = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < sharkOfNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.add(new shark(y - 1, x - 1, s, d, z));
        }

        int t = 0;
        int answer = 0;
        while (t < m) {
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).x == t) {
                    answer += list.get(i).z;
                    list.remove(i);
                    break;
                }
            }
            // 이동
            for (int i = 0; i < list.size(); i++) {
                shark cur = list.get(i);
                int y = cur.y;
                int x = cur.x;
                int dir=cur.d;
                int s = cur.s;
                while (s > 0) {
                    y+=dy[dir];
                    x+=dx[dir];
                    if(y<0 || x<0 || y>=n || x>=m)
                    {
                        y-=dy[dir];
                        x-=dx[dir];
                        if(dir==1)
                        {
                            dir=2;
                        }
                        else if(dir==2)
                        {
                            dir=1;
                        }
                        else if(dir==3)
                        {
                            dir=4;
                        }
                        else if(dir==4)
                        {
                            dir=3;
                        }
                        continue;
                    }
                    s--;
                }
                list.get(i).setY(y);
                list.get(i).setX(x);
                list.get(i).setD(dir);
            }
            shark map[][]=new shark[n][m];
            for (int i = 0; i < list.size(); i++) {
                int y=list.get(i).y;
                int x=list.get(i).x;
                if(map[y][x]==null)
                {
                    map[y][x]=list.get(i);
                }
                else {
                    if(map[y][x].z<list.get(i).z)
                    {
                        map[y][x]=list.get(i);
                    }
                }
            }
            list.clear();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j]!=null)
                    {
                        list.add(map[i][j]);
                    }
                }
            }

            t++;
        }
        System.out.println(answer);
    }
}
