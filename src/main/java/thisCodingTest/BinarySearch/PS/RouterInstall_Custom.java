package thisCodingTest.BinarySearch.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterInstall_Custom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
//        int min=arr[0]; // 1     최소로 차이나는 거리
        int min=1;
        int max=arr[n-1];  // 최대로 많이 차이나는 거리.
        int ans=0;
        while (min<=max)
        {
            int mid=(min+max)/2;
            int val=arr[0];
            int cnt=1;
            for (int i = 1; i < n; i++) {
                if(arr[i]>=mid+val)
                {
                    val=arr[i];
                    cnt++;
                }
            }
            if(cnt>=c)
            {
                // 더 간격을 넓게 설치할 수 있다.
                min=mid+1;
                ans=mid;
            }
            else
            {
                // 더 간격을 좁혀야 한다.
                max=mid-1;
            }
        }

        System.out.println(ans);
    }
}
/*
3 2
8
9
10
8,9,10 위치에 있을 때.. 를 생각해서 최소 min=arr[0] 두면 안됨.
*/