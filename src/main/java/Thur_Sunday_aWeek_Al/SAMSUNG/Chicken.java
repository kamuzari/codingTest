package Thur_Sunday_aWeek_Al.SAMSUNG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Chicken {
    // 치킨집 랜덤으로 m만큼 뽑고 최단거리 갱신?
    static class Position {
        private int y, x;

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static ArrayList<Position> house = new ArrayList<>();
    static ArrayList<Position> chicken = new ArrayList<>();
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1)
                    house.add(new Position(i, j));
                else if (a == 2)
                    chicken.add(new Position(i, j));
            }
        }
        combination(0, 0);
        System.out.println(Min);
    }

    static Stack<Position> pickChicken = new Stack<>();
    static int Min =Integer.MAX_VALUE;

    public static void combination(int idx, int cnt) {
        if (cnt == m) {
            calc();
            return;
        }
        for (int i = idx; i < chicken.size(); i++) {
            pickChicken.push(chicken.get(i));
            combination(idx + 1, cnt + 1);
            pickChicken.pop();
        }
    }
    static void calc()
    {
        int sum=0;
        for (Position h : house) { // 집에서 가장 가까운 치킨 고르고.
            int min = Integer.MAX_VALUE;
            for (Position c : pickChicken) {
                int dist = Math.abs(c.x - h.x) + Math.abs(c.y - h.y);
                min = Math.min(min, dist);
            }
            sum += min;
            if (sum > Min) {
                return;
            }
        }
        Min = Math.min(sum, Min);
    }
}
