package Basic.Sorting.BinarySearchPS;

import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/2110
public class RouterInstallation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        int n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        int answer=solution(n,arr,c);
        System.out.println(answer);
    }

    public static int solution(int n, int arr[],int c) {
        int answer=0;
        int start=1;
        Arrays.sort(arr);
        int end=arr[n-1]-arr[0];
        while (start<=end)
        {
            int mid=(start+end)/2;
            int interval=arr[0];
            int cnt=1;
            for (int i = 1; i <n ; i++) {
                if(arr[i]>=interval+mid)
                {
                    interval=arr[i];
                    cnt++;
                }
            }

            if(cnt>=c)
            {
                answer=mid;
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return answer;
    }
}