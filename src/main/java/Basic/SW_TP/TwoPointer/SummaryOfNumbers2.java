package Basic.SW_TP.TwoPointer;

import java.io.*;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/2003
// ref https://code0xff.tistory.com/128?category=723754
public class SummaryOfNumbers2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

      twoPointer(arr,m);

    }

    private static void twoPointer(int[] arr, int m) {
        int answer=0;
        int s=0,e=0;
        int len=arr.length;
        int sum=0;

//        while (e<=len)
        while (e<=len)
        {
            if(sum>=m)
            {
                sum-=arr[s++];
            }
            else if(e>len-1)
            {
                break;
            }
            else if(sum<m)
            {
                sum+=arr[e++];
            }

            if(sum==m)
            {
                answer++;

            }
        }
        System.out.println("answer = " + answer);
    }
}

/*
6 13
2 3 5 7 11 13
2 3
1 3
정답: 1
원소의 개수가 2개 이상인 수열에서

반례 : M과 같은 원소 한개가 수열의 가장 마지막에 있을 때의 데이터
*/