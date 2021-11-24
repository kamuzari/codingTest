package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1620_PoketmonMaster {
    static Map<String, Integer> nameTo = new HashMap<>();
    static Map<Integer, String> idxTo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            nameTo.put(name, i + 1);
            idxTo.put(i + 1, name);
        }
        StringBuffer answers = new StringBuffer();
        while (m-- > 0) {
            String input = br.readLine();
            if (isDigit(input.charAt(0))) {
                int key = Integer.parseInt(input);
                if (!idxTo.containsKey(key)) continue;
                String getName = idxTo.get(key);
                answers.append(getName).append("\n");
            } else {
                String key = input;
                if (!nameTo.containsKey(key)) continue;
                Integer getIdx = nameTo.get(key);
                answers.append(getIdx).append("\n");
            }
        }
        System.out.println(answers);
    }

    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }
}
