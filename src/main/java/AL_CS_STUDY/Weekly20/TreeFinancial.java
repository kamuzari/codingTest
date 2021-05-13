package AL_CS_STUDY.Weekly20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TreeFinancial {

    private static int[][] initVal;
    private static int n, k;
    private static PriorityQueue<pair> trees;
    private static int[][] map;
    private static int[] dy = {-1,-1,-1,0,0,1,1,1};
    private static int[] dx = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        initVal = new int[n + 1][n + 1];
        map = new int[n + 1][n + 1];

        trees = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                initVal[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(map[i], 5); // 양분 초기값
            }
        }

        for (int i = 0; i < M; i++) {// 나무정보
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees.add(new pair(y, x, z));
        }

        treeInvestment();

        System.out.println(trees.size());
    }

    public static void treeInvestment() {
        ArrayList<pair> die = new ArrayList<>();
        ArrayList<pair> breed = new ArrayList<>();
        for (int year = 0; year < k; year++) {
            // 봄
            int tsize = trees.size();
            PriorityQueue<pair> newpq = new PriorityQueue<>();
            for (int i = 0; i < tsize; i++) {

                pair p = trees.poll();
                int py = p.y;
                int px = p.x;

                if (map[py][px] < p.age) {// 양분이 내 나이보다 적으면 죽는다.
                    die.add(new pair(py,px,p.age));
                    continue;
                }

                map[py][px] -= p.age; // 나이만큼 양분 먹기
                newpq.add(new pair(py, px, p.age+1));

                if((p.age+1)%5==0) {//나이가 5의 배수면
                    breed.add(new pair(py,px,p.age+1));
                }
            }
            trees = new PriorityQueue<>(newpq);

            // 여름
            for(pair p : die) {
                int py = p.y;
                int px = p.x;

                map[py][px] += p.age/2;
            }
            die.clear();

            //가을
            for(pair p : breed) {
                int py = p.y;
                int px=p.x;
                for(int i=0;i<8;i++) {
                    int ny = py+dy[i];
                    int nx = px+dx[i];

                    if(ny<1 || ny> n || nx<1 || nx> n) continue;

                    trees.add(new pair(ny,nx,1));
                }
            }
            breed.clear();

            //겨울
            for(int i = 1; i<= n; i++) {
                for(int j = 1; j<= n; j++) {
                    map[i][j] += initVal[i][j];
                }
            }

        }//year term

        return;

    }

    static class pair implements Comparable<pair> {
        int y;
        int x;
        int age;
        public pair(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }
        @Override
        public int compareTo(pair o) {
            return this.age - o.age;
        }
    }


}
