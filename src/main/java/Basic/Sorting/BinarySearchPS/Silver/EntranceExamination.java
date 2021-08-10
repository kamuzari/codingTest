package Basic.Sorting.BinarySearchPS.Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EntranceExamination {
    static int peopleCnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        peopleCnt=m;
        int times[]=new int[n];
        for (int i = 0; i < n; i++) {
            times[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(times);
        long answer = binarySearch(times, n);
        System.out.println(answer);
    }

    private static long binarySearch(int[] times,int n) {
        long s=0;
        long e= (long) peopleCnt * times[n-1];

        long answer=0;
        while (s<=e)
        {
            long mid=(s+e)/2;
            long cnt=getCnt(mid,times);
            if(cnt>=peopleCnt)
            {
                answer=mid;
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        return answer;
    }

    private static long getCnt(long givenTheTime, int[] times) {
        long cnt=0;
        for (int takenTime : times) {
            cnt+=givenTheTime/takenTime;
        }
        return cnt;

    }
}
