package oneDay_twoSol.Implementation2.Deepening;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class chickenTransit {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static ArrayList<Node> House = new ArrayList<>();
    static ArrayList<Node> Chicken = new ArrayList<>();
    static Stack<Node> selectChicken=new Stack<>();
    static int map[][];
    static int n, m;

    public static void main(String[] args) {
        // 집 마다 치킨 최단거리 구하고.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    House.add(new Node(i, j));
                } else if (a == 2) {
                    Chicken.add(new Node(i, j));
                }
                map[i][j] = a;
            }
        }
        Pick(0,0);
        System.out.println(minDist);

    }

    static int minDist = (int) 1e9;

    static void Pick(int start, int count) {
        if (count == m) {
            calc();
            return;
        }
        for (int i = start; i < Chicken.size(); i++) {
            selectChicken.push(Chicken.get(i));
            Pick(i + 1, count + 1);
            selectChicken.pop();
        }
    }
    static void calc() {
        int sum = 0;
        for (Node house : House) {
            int min = Integer.MAX_VALUE;
            for (Node chicken : selectChicken) {
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                min = Math.min(min, dist);
            }
            sum += min;

            if (sum > minDist) {
                return;
            }
        }
        minDist = Math.min(sum, minDist);

    }


}
