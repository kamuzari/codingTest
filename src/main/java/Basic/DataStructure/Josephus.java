package Basic.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {
    public static void main(String[] args) throws IOException {
        Queue<Integer> q=new LinkedList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            q.add(i+1);
        }
        String answer="";
        while (!q.isEmpty())
        {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            answer+=q.poll()+", ";

        }
        System.out.print("<");
        System.out.print(answer.substring(0,answer.length()-2));
        System.out.print(">");
    }
}
