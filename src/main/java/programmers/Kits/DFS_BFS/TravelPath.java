package programmers.Kits.DFS_BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TravelPath {
    public static void main(String[] args) {
        String tic[][]={
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
        };
        System.out.println(Arrays.toString(solution(tic)));
    }
    static boolean v[];
    static List<String> answers;
    static String ticketlist[][];
    public static String[] solution(String[][] tickets) {
        String[] answer={};
        ticketlist=tickets;
        v=new boolean[tickets.length];
        answers=new ArrayList<>();
        dfs(0,"ICN","ICN");
        Collections.sort(answers);
        answer=answers.get(0).split(" ");
        return answer;
    }

    private static void dfs(int cnt, String start, String answer) {
        if(cnt==ticketlist.length)
        {
            answers.add(answer);
            return;
        }
        else
        {
            for (int i = 0; i < ticketlist.length; i++) {
                if(!v[i] && ticketlist[i][0].equals(start))
                {
                    v[i]=true;
                    dfs(cnt+1,ticketlist[i][1],answer+" "+ticketlist[i][1]);
                    v[i]=false;
                }
            }
        }
    }
}
