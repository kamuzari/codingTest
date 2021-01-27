package Thur_Sunday_aWeek_Al.DFS_BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class findCityBFS {
    static int n;
    static int m;
    static int x;
    static int k;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //vertax;
        m = sc.nextInt(); // edge

        k = sc.nextInt();//givenDistance
        x = sc.nextInt();//start_city
        // 0사용 x.
        int distance[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>()); // 인접리스트.
            distance[i] = -1;
        }


        for (int i = 0; i < m; i++) {
            arr.get(sc.nextInt()).add(sc.nextInt());
        }
        for (int i = 0; i <=n ; i++) {
            System.out.println(i+"---->"+arr.get(i));
        }

        distance[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i = 0; i < arr.get(current).size(); i++) {
                int next = arr.get(current).get(i);

                if (distance[next] == -1) { // 현제 시작점에서 순횐을 걸러내는 필터링 , 자기 자신의 순환 또한 필터링,
                    distance[next] = distance[current] + 1;
                    q.offer(next);
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i <= n; i++) {
            if (distance[i] == k) {
                flag = true;
                System.out.print(i + " ");
            }
        }
        if (!flag) {
            System.out.println("-1");
        }
    }
}
