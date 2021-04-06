package thisCodingTest.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/2294
public class efficientCoin {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int coin[]=new int[k+1];
        Arrays.fill(coin,100001);
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        coin[0]=0;
        for (int i = 0; i < n; i++) {
            int COIN=arr[i];
            for (int j = COIN; j <k+1 ; j++) {
                    coin[j]=Math.min(coin[j],coin[j-COIN]+1);
            }
        }
//        System.out.println(Arrays.toString(coin));
        if(coin[k]!=100001)
            System.out.println(coin[k]);
        else
            System.out.println(-1);
    }
}
