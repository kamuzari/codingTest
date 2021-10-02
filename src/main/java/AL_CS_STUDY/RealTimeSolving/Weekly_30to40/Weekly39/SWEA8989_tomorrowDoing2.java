package AL_CS_STUDY.RealTimeSolving.Weekly_30to40.Weekly39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA8989_tomorrowDoing2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalTestCase = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= totalTestCase; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int t[] = new int[n];
            int d[] = new int[n];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                pq.offer(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
            }
            int startDay=0;
            int[] tmp =null;
            if(!pq.isEmpty()) {
                 tmp= pq.poll();
                startDay = tmp[1] - tmp[0];
            }
            while (!pq.isEmpty()){
                tmp= pq.poll();
                if(startDay<tmp[1]){
                    startDay-=tmp[0];
                }else{
                    startDay=tmp[1]-tmp[0];
                }
            }
            System.out.println("#"+testCase+" "+startDay);
        }
    }

}
