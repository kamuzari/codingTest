package AL_CS_STUDY.Weekly_40to50.Weekly42;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ15961_RotateSushi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        LinkedList<Integer> q = new LinkedList<>();
        final int solution = solution(n, d, k, c, arr);
        System.out.println(solution);

    }

    private static int solution(int n, int d, int k, int c, int[] arr) {
        int answer=0;
        int v[]=new int[d+1];
        int uniqueCnt=0;
        for(int i=0; i<k; i++){
            if(v[arr[i]]==0) uniqueCnt++;
            v[arr[i]]++;
        }
        answer=uniqueCnt;
        for(int i=1; i<n; i++){
            if(answer<=uniqueCnt){
                if(v[c]==0) answer=uniqueCnt+1;
                else answer=uniqueCnt;
            }
            v[arr[i-1]]--;
            if(v[arr[i-1]]==0) uniqueCnt--;
            int next=i+k-1;
            if(v[arr[next%n]]==0) uniqueCnt++;
            v[arr[next%n]]++;

        }
        return answer;
    }
}
