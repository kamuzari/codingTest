package WeeklyThurseday.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 회의실배정 {
    // 회의실 최대 사용개수 찾아보자
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=n;
        sc.nextLine();
        ArrayList<Room> arr=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        while (n-->0)
        {
            String str[]=sc.nextLine().split(" ");
            int x=parse(str[0]);
            int y=parse(str[1]);
            arr.add(new Room(x,y));
        }
        n=t;
        Collections.sort(arr);
        // 끝나는 시간으로 정렬하면 해당 끈나는 것이 가장 작은 것끼리 해야 최소가 된다.
       /* for (Room r:arr
             ) {
            System.out.println(r.s+" "+r.e);
        }*/

        int cnt=0;
        int end=0;
        for (int i = 0; i <n ; i++) {
            if(arr.get(i).s>=end) // 끝나는 시점에 바로 시작할수 있다 했다.
            {
                cnt++;
                end=arr.get(i).e;
            }
        }
        sb.append(cnt);
        System.out.println(sb);

    }

    static class Room implements Comparable<Room>{
        private int s;
        private int e;

        public Room(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Room o) {
            if(this.e>o.e)
                return 1;
            else if(o.e>this.e)
                return -1;
            else
            {
                if(this.s>o.s)
                    return 1;
                else if(this.s<o.s)
                    return -1;
                else
                    return 0;
            }
        }
    }
    public static int parse(String str)
    {
        return Integer.parseInt(str);
    }
}
