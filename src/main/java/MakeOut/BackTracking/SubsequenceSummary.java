package MakeOut.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class SubsequenceSummary {
    static int pickNumber=0;
    private static int n;
    private static int target;
    private static int[] val;
    private static int answer=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        val = new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            val[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            pickNumber=i;
            comb(0,0,0);
        }
        System.out.println(answer);
    }
    public static void comb(int cnt,int idx,int sum)
    {
        if(cnt==pickNumber)
        {
            if(sum==target){
                answer++;
            }
            return;
        }
        for (int i = idx; i <n; i++) {
            comb(cnt+1,i+1,sum+val[i]);
        }
    }

    private static void recursion(int total, int depth) {
        if (depth == n - 1 && total == target) {
            answer++;
        }

        if (depth < n) {
            recursion(total + val[depth+1], depth+1);
            recursion(total, depth+1);
        }
    }
}
