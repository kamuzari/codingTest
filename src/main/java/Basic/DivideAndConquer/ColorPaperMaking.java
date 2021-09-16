package Basic.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class ColorPaperMaking {

    private static int[][] papers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        papers = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                papers[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[] solution = solution(n, papers);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }
    static int white=0,blue=0;
    private static int[] solution(int n,int[][] papers) {
        int answer[]=new int[2];
        sol(n,0,0);
        answer[0]=white;
        answer[1]=blue;
        return answer;
    }
    public static void sol(int n,int sy,int sx) {
        if(check(n,sy,sx))
        {
            if(papers[sy][sx]==0) {
                white++;
            }else if(papers[sy][sx]==1){
                blue++;
            }
            return;
        }
        sol(n/2,sy,sx);
        sol(n/2,sy,sx+n/2);
        sol(n/2,sy+n/2,sx);
        sol(n/2,sy+n/2,sx+n/2);
    }

    public static boolean check(int n,int y,int x)
    {
        int pivot=papers[y][x];
        for (int i = y; i < y+n; i++) {
            for (int j = x; j < x+n; j++) {
                if(pivot!=papers[i][j])
                    return false;
            }
        }
        return true;
    }
}
