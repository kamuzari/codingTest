package Thur_Sunday_aWeek_Al.StringProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class travelRoute {
    public static void main(String[] args) {
        String tic[][] = {
                {
                        "ICN", "SFO"
                },
                {
                        "ICN", "ATL"
                },
                {
                        "SFO", "ATL"
                },
                {
                        "ATL", "ICN"
                },
                {
                "ATL", "SFO"
                }
        };
       String s[]= solution(tic);
        System.out.println(Arrays.toString(s));
    }
    // 주어진 티켓을 모두 사용해야 한다. 한번 왔다간 정정의 갱신이 필요.
    static boolean visited[];
    static ArrayList<String> ans;

    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        ans = new ArrayList<>();
        dfs(0,"ICN", "ICN", tickets);
        Collections.sort(ans);
        String[] answer = ans.get(0).split(" ");
        return answer;
    }

    static void dfs(int cnt, String s, String answer, String[][] ticket) {
        if (cnt == ticket.length) {
            ans.add(answer);
            return;
        }
        for (int i = 0; i < ticket.length; i++) {
            if (!visited[i] && ticket[i][0].equals(s)) {
                visited[i] = true;
                dfs(cnt + 1, ticket[i][1], answer + " " + ticket[i][1], ticket);
                visited[i] = false;
            }
        }
    }



}
