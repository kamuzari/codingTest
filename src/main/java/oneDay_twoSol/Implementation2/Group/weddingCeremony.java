package oneDay_twoSol.Implementation2.Group;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class weddingCeremony {
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    static int visisted[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        int m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            int source=sc.nextInt();
            int dest=sc.nextInt();
            list.get(source).add(dest);
            list.get(dest).add(source);
        }
       visisted=new int[n+1];

//        for (int i = 0; i < list.get(1).size(); i++) {
//            visisted[list.get(1).get(i)]=true;
//            sum++;
//        }
        visisted[1]=1;
//        for (int i = 0; i < list.get(1).size(); i++) {
//            int cur=list.get(1).get(i);
//            System.out.println(cur);
//            for (int j = 0; j < list.get(cur).size(); j++) {
//                if(!visisted[list.get(cur).get(j)])
//                    sum++;
//            }
//        }
        bfs(1);
        for (int i : visisted) {
            if(i==2 || i==3)
                sum++;
        }

        System.out.println(sum);

    }
    static int sum=0;
    static void bfs(int start)
    {
        Queue<Integer> q=new LinkedList<>();
        visisted[start]=1;
        q.offer(start);
        while (!q.isEmpty())
        {
            int cur=q.poll();
            for (Integer integer : list.get(cur)) {
                if(0==visisted[integer])
                {
                    visisted[integer]=visisted[cur]+1;
                    q.offer(integer);
                }
            }
        }
    }
}
