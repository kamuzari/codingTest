package thisCodingTest.Graph.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Curriculum {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int passDegree[]=new int[n+1];
        int time[]=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n+1; i++) {
            String str[]=br.readLine().split(" ");
            time[i]=Integer.parseInt(str[0]);
            for (int j = 1; j < str.length-1; j++) {
                int a = Integer.parseInt(str[j]);
                list.get(a).add(i);
                passDegree[i]++;
            }
        }
        for (int i = 0; i < n+1; i++) {
//            System.out.println(list.get(i));
        }
//        System.out.println(Arrays.toString(passDegree));
//        System.out.println(Arrays.toString(time));
        Queue<Integer> q=new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if(passDegree[i]==0)
                q.offer(i);
        }

        int sum[]=new int[n+1];
        sum=time.clone();
        while (!q.isEmpty())
        {
            int cur=q.poll();
            for (Integer val : list.get(cur)) {
                passDegree[val]--;
                sum[val]=Math.max(time[val]+sum[cur],sum[val]);
                if(passDegree[val]==0)
                    q.offer(val);
            }
        }


        System.out.println(Arrays.toString(sum));


    }
}
/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1

*/
