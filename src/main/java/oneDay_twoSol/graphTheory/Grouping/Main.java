package oneDay_twoSol.graphTheory.Grouping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int N, ans;
    static int[] want;
    static boolean[] chk;
    static boolean[] done;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            N=Integer.parseInt(br.readLine());
            ans=N;
            want=new int[N+1];//1부터 시작
            chk=new boolean[N+1];
            done=new boolean[N+1];
            st=new StringTokenizer(br.readLine()," ");
            for(int i=1; i<=N; i++) {
                want[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<=N; i++) {
                if(!chk[i]) {
                    chk[i]=true;
                    dfs(i);
                }

            }

            System.out.println(ans);
        }
    }

    private static void dfs(int num) {
        int next=want[num];
        if(chk[next]==false) {
            chk[next]=true;
            dfs(next);
        }
        if(done[next]==false) {
            ans--;
            for(int i=next; i!=num; i=want[i])
                ans--;
        }

        done[num]=true;
    }

}