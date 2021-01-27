package oneDay_twoSol.DB_FirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class degrees_Relationship {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count[]=new int[n+1];
        ArrayList<ArrayList<Integer>> degreeRelationship=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            degreeRelationship.add(new ArrayList<>());
            count[i]=-1;
        }
        int solvingCount=sc.nextInt();
        int solvingCount2=sc.nextInt();

        int m=sc.nextInt();

        // adjList
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            // 무방향 그래프 특징.
            degreeRelationship.get(a).add(b);
            degreeRelationship.get(b).add(a);
        }

        count[solvingCount]=0;
        Queue<Integer> q =new LinkedList<>();
        q.offer(solvingCount);

        while (!q.isEmpty())
        {
            int current=q.poll();

            for (int i = 0; i < degreeRelationship.get(current).size(); i++) {
                int next=degreeRelationship.get(current).get(i);
                if(count[next]==-1)
                {
                    count[next]=count[current]+1;
                    q.offer(next);
                }
            }
        }
        System.out.println(count[solvingCount2]);
    }
}
