package WeeklyThurseday.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class printerQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int sequence = sc.nextInt();
            sc.nextLine();
            String str[] = sc.nextLine().split(" ");
            LinkedList<Integer> pq = new LinkedList<>();
            for (int i = 0; i < str.length; i++) {
                int b = Integer.parseInt(str[i]); // inportance -- 1,2,3 ....
                pq.add(b);
            }
            int cnt = 0;
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) q.offer(i );

            int i=0;
            boolean flag;
            while (!q.isEmpty())
            {
                flag=true;
                for (int j = i; j <q.size() ; j++) {
                    if(pq.get(i)<pq.get(j))
                    {
                        // 맨 앞에 있는 것보다 우서순위가 높은 게 있으면 뽑고 뒤로 보낸다.
                        pq.offer(pq.poll());
                        q.offer(q.poll());
                        flag=false; // 아직은 우선순위가 나보다 높은게 있다는 것.
                        break;
                    }
                }
                if(flag)
                {
                    cnt++;
                    pq.poll();
                    int x=q.poll();
                    // 내가 뽑고싶은 번호랑 같은지 비교! 아니면 pass
                    if(x==sequence) {
                        System.out.println(cnt);
                        break; // while문 탈출
                    }
                }
            }

        }
    }
}


