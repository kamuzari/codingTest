package codingExam.TestSE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int distance[]=new int[100001];
    static int pan[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pan=new int[n+1];
        for (int i = 0; i < n; i++) {
            pan[i+1]=sc.nextInt();
        }
        for (int i = 1; i <= n; i++) { ;
            bfs(i);
        }
        System.out.println(max);

    }
    static int max=0;
   static  ArrayList<Integer> infLen=new ArrayList<>();
    public static void bfs(int start)
    {

        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty())
        {
            int cur=q.poll(); // 1

            int nx=cur+pan[cur]; //

            if(nx>0 && nx <100001)
            {
                if(distance[nx]==0)
                {
                    distance[nx]=1;
                    q.offer(nx);
                }
                else if(distance[nx]==1)
                {
                    distance[nx]=2;
                    infLen.add(nx);
                    q.offer(nx);
                }
            }
        }
        max=Math.max(infLen.size(),max);
        infLen.clear();
    }

}
