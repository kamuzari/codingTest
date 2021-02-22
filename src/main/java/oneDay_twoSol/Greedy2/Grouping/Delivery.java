package oneDay_twoSol.Greedy2.Grouping;

import java.util.*;

public class Delivery {

    static class delivery implements Comparable<delivery> {
        private int source;
        private int destination;
        private int quantity;

        public delivery(int source, int destination, int quantity) {
            this.source = source;
            this.destination = destination;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "delivery{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", quantity=" + quantity +
                    '}';
        }

        // 1 시도-> source 정렬 후 destination 정렬 반례 -> 용량 40 일떄 1에 40있는 경우  ..
        // 2 시도 도착지 오름차순 후 시작점 오름차순.
        @Override
        public int compareTo(delivery o) {
            if (destination == o.destination)
                return source - o.source;
            return destination - o.destination;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            deliveries.add(new delivery(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(deliveries);
       int [] viliege=new int[n];
        for (int i = 0; i < n; i++) {
            viliege[i]=c;
        }

        int cnt=0;
        for (int i = 1; i <=m; i++) {
            delivery cur=deliveries.get(i-1);

            int maxQuantity=(int)1e9;
            for (int j = cur.source; j <cur.destination ; j++) {
                maxQuantity=Math.min(maxQuantity,viliege[j-1]);
            }

            if(maxQuantity>=cur.quantity)
            {
                for (int j = cur.source; j <cur.destination ; j++) {
                    viliege[j-1]-=cur.quantity;
                }
                cnt+=cur.quantity;
            }
            else
            {
                for (int j = cur.source; j <cur.destination ; j++) {
                    viliege[j-1]-=maxQuantity;
                }
                cnt+=maxQuantity;
            }
        }
        System.out.println(cnt);

    }
}
