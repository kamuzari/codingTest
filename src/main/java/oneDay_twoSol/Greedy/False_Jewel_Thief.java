package oneDay_twoSol.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/1202
//  ArrayList 삽입 삭제시 시간초과 , Priority Queue 사용 하고 ArrayList에 임시로 담아두고 pq에 재삽입. 메모리 초과.
public class False_Jewel_Thief {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); // 보석의 개수
        int K = Integer.parseInt(str[1]); // 가방의 개수
        ArrayList<product> arr=new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str2[] = br.readLine().split(" ");
            int m = Integer.parseInt(str2[0]); //M 무게
            int v = Integer.parseInt(str2[1]); //V 가격
            arr.add(new product(m,v));
        }

        int[] limitPack = new int[K];
        for (int i = 0; i < K; i++) {
            limitPack[i] = br.read();
        }
        Collections.sort(arr);
        // logic
        //1. pq 이용.
        int sum=0;
        ArrayList<product> temp=new ArrayList<>();
        for (int i = 0; i <K ; i++) {
            for (int j = 0; j<arr.size() ; j++) {
                if(limitPack[i]>=arr.get(j).M)
                {
                    sum+=arr.get(j).V;
                    arr.remove(j); // 삽입 삭제시 시간초과
                    break;
                }
            }
        }
        System.out.println(sum);

    }
    static class product implements Comparable<product>{
        private int M;

        @Override
        public String toString() {
            return "product{" +
                    "M=" + M +
                    ", V=" + V +
                    '}';
        }

        private int V;

        public product(int m, int v) {
            M = m;
            V = v;
        }


        @Override
        public int compareTo(product o) {
            if(this.V==o.V)
            {
                return o.M-this.M;
            }
            else
                return o.V-this.V;

        }
    }
}
