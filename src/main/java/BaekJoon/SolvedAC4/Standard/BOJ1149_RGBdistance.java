package BaekJoon.SolvedAC4.Standard;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149_RGBdistance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int houses[][]=new int[n+1][4];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int red=Integer.parseInt(st.nextToken());
            int green=Integer.parseInt(st.nextToken());
            int blue=Integer.parseInt(st.nextToken());
            houses[i][1]=red;
            houses[i][2]=green;
            houses[i][3]=blue;
        }
        for (int i = 2; i <=n ; i++) {
            houses[i][1]+=Math.min(houses[i-1][2],houses[i-1][3]);
            houses[i][2]+=Math.min(houses[i-1][1],houses[i-1][3]);
            houses[i][3]+=Math.min(houses[i-1][1],houses[i-1][2]);
        }
        int answer=Math.min(houses[n][1],houses[n][2]);
        answer=Math.min(answer,houses[n][3]);
        System.out.println(answer);
    }
}
