package thisCodingTest.BinarySearch.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// log(n)의 복잡도를 갖도록... count정렬 o(1)
public class findNumber_orderedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        int max=-1;
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a=Integer.parseInt(st.nextToken());
            max = Math.max(a, max);
            arr[i]=a;
        }
        int cnt[]=new int[max+1];
        for (int i = 0; i < n; i++) {
            cnt[arr[i]]++;
        }
        System.out.println(Arrays.toString(cnt));
        if(max+1>=m)
        {
            System.out.println(-1);
        }
        else if(cnt[m]!=0)
        {
            System.out.println(arr[m]);
        }
        else
        {
            System.out.println(-1);
        }

    }

}
/*
7 2
1 1 2 2 2 2 3
* */