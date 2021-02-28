package oneDay_twoSol.Implementation2.Deepening;

import java.util.*;

public class Snake {
    // 오른쪽 (왼쪽) 위 (오른쪽) 아래
    private static int dy[] = {0, -1, 0, 1};
    private static int dx[] = {1, 0, -1, 0};
    private static int board[][];
    private static TreeMap<Integer, Character> cmd = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];

        int appleNumber = sc.nextInt();
        for (int i = 0; i < appleNumber; i++) {
            board[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        }
        int cmdNumber = sc.nextInt();
        for (int i = 0; i < cmdNumber; i++) {
            cmd.put(sc.nextInt(), sc.next().charAt(0));
        }
//        for (Map.Entry<Integer, Character> set : cmd.entrySet()) {
//            System.out.println(set.getKey() + "  " + set.getValue());
//        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        int level = 1;
        int dirction = 0;
        int seconds = 0;
        // 뱀의 현재 위치.
        int ny = 0;
        int nx = 0;
        while (true) {
            if (!cmd.containsKey(seconds)) {
                seconds++;
                ny += dy[dirction];
                nx += dx[dirction];
                boolean flag=true;
                // 자기 몸이랑 부딪힘.
                for (Node node : q) {
                    if(node.x==nx && node.y==ny) {
                        flag=false;
                        break;
                    }
                }
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && flag) {
                    if (board[ny][nx] == 1) {
                        board[ny][nx] = 0;
                    } else {
                        q.poll();
                    }
                    q.add(new Node(ny, nx));
                } else {
                    break;
                }
            } else {
                char ch = cmd.get(seconds);
                cmd.remove(seconds);

                if (ch == 'L') {
                    dirction++;
                    if (dirction > 3)
                        dirction %= 4;
                } else {
                    dirction--;
                    if (dirction < 0)
                        dirction =3;
                }

            }
        }
        System.out.println(seconds);


    }

    static class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
