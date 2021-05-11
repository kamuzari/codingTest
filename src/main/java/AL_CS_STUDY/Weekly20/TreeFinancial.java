package AL_CS_STUDY.Weekly20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class TreeFinancial {

    static int n,m,k;
    static int dy[]={-1,1,0,0,-1,1,-1,1};
    static int dx[]={0,0,-1,1,1,-1,-1,1};
    static int map[][], arr[][];
    static ArrayList<Integer> tree[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        map = new int[n+1][n+1];

        tree = new ArrayList[n+1][n+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                tree[i][j] = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++)
                map[i][j] = 5;
        }
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());

        }
        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            tree[a][b].add(age);
        }
        while(k-->0) {

            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(tree[i][j].size() > 0) {
                        int end = 0;
                        Collections.sort(tree[i][j]);
                        ArrayList<Integer> tmp = new ArrayList<>();
                        for(int q=0; q<tree[i][j].size(); q++) {
                            int age = tree[i][j].get(q);
                            if(map[i][j] >= age) {
                                map[i][j] -= age;
                                tmp.add(age+1);
                            }else {
                                end += age/2;
                            }
                        }
                        tree[i][j] = new ArrayList<>();
                        for(int val : tmp)
                            tree[i][j].add(val);

                        map[i][j] += end;
                    }
                }
            }

            /// 가을
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(tree[i][j].size() > 0) {

                        for(int q=0; q<tree[i][j].size(); q++) {
                            int age = tree[i][j].get(q);
                            if(age % 5 == 0) {
                                for(int d=0; d<8; d++) {
                                    int ny = i + dy[d];
                                    int nx = j + dx[d];
                                    if(0<ny && ny<=n && 0<nx && nx<=n) {
                                        tree[ny][nx].add(1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            /// 겨울
            for(int i=1; i<=n; i++)
                for(int j=1; j<=n; j++)
                    map[i][j] += arr[i][j];
        }
        int result = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                result += tree[i][j].size();
            }
        }
        StringBuilder sb=new StringBuilder();
        System.out.println(result);
    }


}
