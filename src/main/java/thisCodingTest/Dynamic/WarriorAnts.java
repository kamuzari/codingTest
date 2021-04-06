package thisCodingTest.Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WarriorAnts {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());

        int arr[]=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        arr[1]=Math.max(arr[0],arr[1]);
        for (int i = 2; i < n; i++) {
            arr[i]=Math.max(arr[i-1],arr[i]+arr[i-2]);
        }

        System.out.println(arr[n-1]);
    }
}
