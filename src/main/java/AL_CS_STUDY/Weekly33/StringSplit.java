package AL_CS_STUDY.Weekly33;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringSplit {

    private static int n;
    private static int m;
    static Map<String, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String str[] = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        int s = 0;
        int e = n - 1;
        boolean flag = false;
        int mid=0;
        while (s <= e) {
            mid = (s + e) >> 1;
            boolean check = isDuplicateString(mid, str);
            if (!check)
            {
                // 중복 시작된다면
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
            flag=check;
            map.clear();
        }
        if(!flag)
        {
            System.out.println(mid-1);
        }
        else
            System.out.println(mid);
    }

    private static boolean isDuplicateString(int startIdx, String[] str) {
        for (int j = 0; j < m; j++) {
            StringBuilder sub = new StringBuilder();

            for (int i = startIdx; i < n; i++) {
                sub.append(str[i].charAt(j));
            }

            if (map.containsKey(sub.toString())) {
                return false;
            }
            map.put(sub.toString(), 1);
        }

        return true;
    }
}
