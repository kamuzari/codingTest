package BaekJoon.SolvedAC3;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ17219_PasswordSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = (st.nextToken());
            String val = st.nextToken();
            map.put(key, val);
        }
        StringBuilder answers=new StringBuilder();
        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            answers.append(map.get(site)+"\n");
        }
        System.out.println(answers);
    }
}
