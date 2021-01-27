package oneDay_twoSol.Greedy;

import java.util.*;

public class Main {

    static class Product implements Comparable<Product> {
        int m;          //무게
        int v;          //가격

        public Product(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Product o) {
            return this.m - o.m;  // 무게별 오림차순.
        }
    }

    static Product[] product;
    static ArrayList<Integer> pack;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        product = new Product[N]; // 보석의 가치와 무게를 담는 배열.
        pack = new ArrayList<>(); // 각 가방의 제한적인 무게를 둘 배열.
        pq = new PriorityQueue<>(); // 일반적으로 여기에서 우선순위를 큐를 보면 돈의 가치가 가장 큰 순서대로 정렬되어 있ㄴ을 것이다라는 생각을 한다.
                                    // 하지만 가장 비싼 가치를 마이너스를 붙여 가장 앞쪽에 할 것이다.

        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            int v = sc.nextInt();
            product[i] = new Product(m, v);
        }
        // 각 가방의 제한 무게.
        for (int k = 0; k < K; k++) {
            int c = sc.nextInt();
            pack.add(c);
        }

        Collections.sort(pack);// 가장 작은 제한의 무게 가방부터.
        Arrays.sort(product);// 무게가 가장 작은 보석 부터.

        long sum = 0;
        int idx = 0;
        for (int m : pack) {
            while (idx < N) {
                if (m >= product[idx].m) {
                    //계속 pq에 추가추가추가 끝까지 가방의 무게가 제한적인 무게까지.
                    pq.add(-(product[idx].v)); // -를 붙임으로써 가장 큰 자연수가 제일 작아지기 떄문에 . 기본적 pq는 오름차순이다. 따로 넣고 뒤집으면 시간초과 ,,
                    idx++;
                } else
                    break;
            }
            if (!pq.isEmpty()) {
                // 기존에 pq를 초기화 하지 않고 가지고 있다. 다시 넣는 것을 하지 않는다.
                // 이미 가방의 제한 을 오름차순으로 정렬했기 때문에 또한 arr에 있는 정렬도 오름차순으로 정렬했기 떄문에 pq를 계속 집어넣는 과정에서 다음번의 무게제한을 가진
                // 가방의 무게는 이전에 작은 가방의 무게가 넣어왔던 물건을 넣을 수 있다는 것이 보장된다. 그래서 쓸데없이 다시 초기화하고 넣을 필요가 없다.
                sum += Math.abs(pq.poll());
            }
        }
        System.out.println(sum);
    }
}
