package tues_thurs_sat.jaj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
array1.equals(array2)는 array1 == array2와 같습니다. 무슨말이냐면 두 배열이 같은 객체인지를 비교하는 것입니다.
Arrays.equals(array1,array2)는 두 배열의 내용물들이 같은지를 비교
https://www.acmicpc.net/problem/1091
*/
public class shuffleCard {
    static int n, p[], s[], org[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        s = new int[n];
        org = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            org[i] = i % 3;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int first[]=org.clone();
        while (!Arrays.equals(org, p)) {
            int temp[] = org.clone();
            for (int i = 0; i < n; i++) {
                org[i] = temp[s[i]];
            }
//            if (cnt > 200_000)
            if(Arrays.equals(org,first))
            {

                bw.write(-1 + "");
                bw.close();
                return;
            }
            cnt++;
        }
        bw.write(cnt + "");
        bw.close();
    }


}
