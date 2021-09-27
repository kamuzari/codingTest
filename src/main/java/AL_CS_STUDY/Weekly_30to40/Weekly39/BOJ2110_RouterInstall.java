package AL_CS_STUDY.Weekly_30to40.Weekly39;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class BOJ2110_RouterInstall {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int pos[]=new int[n];
        for (int i = 0; i < n; i++) {
            pos[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(pos);
        System.out.println(search(pos, c));

    }
    public static int search(int pos[],int target){
        int answer=0;
        int min=0;
        int max=1_000_000_000;
        while (min<=max){
            int mid=(min+max)>>1;
            int routerInstallCnt=count(mid,pos);
            if(routerInstallCnt>=target) {
                answer=mid;
                min=mid+1;
            }else{
                // 공유가 설치가 주어진 target보다 설치된게 없으면 간격을 줄여 공유기를 많이 설치
                max=mid-1;
            }
        }
        return answer;
    }

    private static int count(int interval, int[] pos) {
        int cnt=1;
        int position=pos[0];
        for (int i = 1; i <pos.length ; i++) {
            final int diff = pos[i] - position;
            if(diff>=interval){
                cnt++;
                position=pos[i];
            }
        }
        return cnt;
    }
}
