package Basic.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11723_Set {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int arr[] = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = i + 1;
        }
        int n = Integer.parseInt(br.readLine());
        StringBuilder answers = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            if (cmd.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("remove")) {
                int val = Integer.parseInt(st.nextToken());
                if(set.contains(val)){
                    set.remove(val);
                }
            } else if (cmd.equals("check")) {
                int val = Integer.parseInt(st.nextToken());
                if (set.contains(val)) {
                    answers.append(1 + "\n");
                } else {
                    answers.append(0 + "\n");
                }
            } else if (cmd.equals("toggle")) {
                int val = Integer.parseInt(st.nextToken());
                if (!set.add(val)) {
                    set.remove(val);
                }
            } else if (cmd.equals("all")) {
                set.clear();
                Arrays.stream(arr).forEach(set::add);
            } else if (cmd.equals("empty")) {
                set.clear();
            }
        }
        System.out.println(answers);
    }
}
