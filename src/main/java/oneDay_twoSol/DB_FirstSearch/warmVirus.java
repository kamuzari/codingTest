package oneDay_twoSol.DB_FirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class warmVirus {
    static ArrayList<ArrayList<Integer>> adjecentList=new ArrayList<>();
    static boolean visited[];
    static int cnt=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int com=sc.nextInt(); // vertax
        int ssang=sc.nextInt(); // edge

        visited=new boolean[com+1];

        for (int i = 0; i <=com ; i++) {
            adjecentList.add(new ArrayList<>()); // 0번쨰 사용 x.
        }
        for (int i = 1; i <= ssang; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            adjecentList.get(a).add(b);
            adjecentList.get(b).add(a);
        }
        virusTransmission(1);

    }
    static void virusTransmission(int virusCom)  // dfs
    {
        Queue<Integer>q=new LinkedList<>();
        q.offer(virusCom);
        visited[virusCom]=true;

        while (!q.isEmpty())
        {
            int temp=q.poll();
            for (int i = 0; i <adjecentList.get(temp).size() ; i++) {
                int tempCom=adjecentList.get(temp).get(i);
                if(!visited[tempCom])
                {
                    q.offer(tempCom);
                    cnt++;
                    visited[tempCom]=true;
                }
            };

        }
        System.out.println(cnt);

    }

}
