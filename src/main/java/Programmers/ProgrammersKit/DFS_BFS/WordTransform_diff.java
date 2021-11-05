package Programmers.ProgrammersKit.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class WordTransform_diff {
    public static void main(String[] args) {
        String s[] = {
                "hot", "dot", "dog", "lot", "log", "cog"
        };
        String start = "hit";
        String end = "cog";
        System.out.println(solution(start, end, s));
    }

    static class Node {
        String next;
        int cnt;

        public Node(String next, int cnt) {
            this.next = next;
            this.cnt = cnt;
        }
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len=words.length;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        boolean v[]=new boolean[len];
        while (!q.isEmpty())
        {
            Node cur = q.poll();
            if(cur.next.equals(target))
            {
                answer=cur.cnt;
                break;
            }
            for (int i = 0; i <len ; i++) {
                if(!v[i] && check(cur.next,words[i]))
                {
                    v[i]=true;
                    q.add(new Node(words[i], cur.cnt+1));
                }
            }
        }
        return answer;
    }
    private static boolean check(String cur, String s) {
        int cnt=0;
        for (int i = 0; i < s.length(); i++) {
            if(cur.charAt(i)!=s.charAt(i))
            {
                cnt++;
            }
            if(cnt>1)
            {
                return false;
            }
        }
        return true;
    }
}
