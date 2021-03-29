package thisCodingTest.similarPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class numberFind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            hashMap.put(a, 0);
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if(!hashMap.containsKey(Integer.parseInt(st.nextToken())))
            {
               sb.append(0+"\n");
            }
            else
            {
                sb.append(1+"\n");
            }
        }
        System.out.println(sb);
    }
}
