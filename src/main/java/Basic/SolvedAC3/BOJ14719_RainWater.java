package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719_RainWater {
    static class Node{
        int x,y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int arr[]=new int[w];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0;
        int l=0,m=0,r=0;
        for (int i = 1; i < w-1; i++) {
            l=r=0;

            for (int j = 0; j < i; j++) {
                l=Math.max(l,arr[j]);
            }
            for (int j = i+1; j < w; j++) {
                r=Math.max(r,arr[j]);
            }

            if(arr[i]<l && arr[i]<r){
                m+=Math.min(l,r)-arr[i];
            }
        }
        answer=m;
        System.out.println(answer);
    }
}
