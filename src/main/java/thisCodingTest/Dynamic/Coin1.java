package thisCodingTest.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int coin[]=new int[k+1];
        coin[0]=1;
        for (int i = 0; i < n; i++) {
            int COIN=arr[i];
            for (int j = COIN; j < k+1; j++) {
                coin[j]+=coin[j-COIN];

            }

            System.out.println(Arrays.toString(coin));
        }
        System.out.println(coin[k]);


    }
}
