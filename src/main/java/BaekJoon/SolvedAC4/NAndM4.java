package BaekJoon.SolvedAC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class NAndM4 {

    private static int n;
    private static int m;
    private static StringBuilder answers;
    private static Set<List<Integer>> sets = new HashSet<>();

    /**
     * NOTE : 같은 수를 두번 골라도 된다. 단, 오름 차순이여야 하며 중복되는 수열을 여러번 출력하면 안된다.
     * hint : data structure
     * how : stack
     * why :
     *      set은 중복을 잡을 때 해당 원소에 포함되어 있는 원소 체크하는 로직에서 1 1 2 와 1 2 2 를 같은 것으로 판단하므로 출력할 수 없었음.
     *      list 또한 containsAll() method 가 동일하게 판단하므로 출력할 수 없었음.
     *      자세히 보아하니 오름차순으로 이루어져 있는 조건을 가지고 스택에 가장 최근에 들어간것 보다 크거나 같은 조건을 이용하여 stack에 결과값들을 저장함.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answers = new StringBuilder();
        pick(0, m, new Stack<>());
        System.out.println(answers);
    }

    public static void pick(int depth, int target, Stack<Integer> s) {
        if (depth == target) {
            for (Integer result : s) {
                answers.append(result + " ");
            }
            answers.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (s.isEmpty() || s.peek() <= i) {
                s.push(i);
                pick(depth + 1, target, s);
                s.pop();
            }
        }
    }
}
