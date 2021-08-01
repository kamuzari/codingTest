package codingExam.kakaoInternship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ConferenceAssign {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int t[][]=new int[n][2];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            t[i][0]=Integer.parseInt(st.nextToken());
            t[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(t, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if(t1[1]==t2[1])
                    return t1[0]-t2[0];
                return t1[1]-t2[1];
            }
        });
        int end=t[0][1];
        int cnt=1;
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
        for (int i = 1; i < n; i++) {

            if(end<=t[i][0])
            {
                cnt++;
                end=t[i][1];
            }
        }
        System.out.println(cnt);

    }

}
/*
6
1 3
3 100
4 5
6 6
5 6
7 7

ans =5
* */