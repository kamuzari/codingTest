package AL_CS_STUDY.Weekly_30to40.Weekly35;

import java.io.*;
import java.util.Stack;

public class BOJ2048_EASY {
    static class Node {
        private int value;
        private boolean isCombine;

        public Node(int value) {
            this.value = value;
            this.isCombine = false;
        }

        public void combine(int a) {
            this.value += a;
            this.isCombine = true;
        }
    }

    static final int TURN = 5;

    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;

    static final int DIRECTION_NUMBER = 4;

    static int map[][];
    static int[] moveDirections = new int[TURN];
    static int MAX = Integer.MIN_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        dfs(0);
        System.out.println(MAX);
    }

    static void dfs(int cnt) {
        if (cnt == 5) {
            Move();
            return;
        }
        for (int i = 0; i < DIRECTION_NUMBER; i++) {
                moveDirections[cnt] = i;
                dfs(cnt + 1);
            }
    }

    private static void Move() {
        int copy[][] = copiedArray();
        Stack<Node> s = new Stack<>();
        for (int turn = 0; turn < TURN; turn++) {
            int dir = moveDirections[turn];
            if (dir == UP) {
                for (int j = 0; j < n; j++) {
                    for (int i = 0; i < n; i++) {
                        if (copy[i][j] == 0) {
                            continue;
                        } else {

                            if (s.isEmpty()) {
                                s.push(new Node(copy[i][j]));
                            } else {
                                if (s.peek().value == copy[i][j] && !s.peek().isCombine) {
                                    s.peek().combine(copy[i][j]);
                                } else
                                    s.push(new Node(copy[i][j]));
                            }
                            copy[i][j] = 0;
                        }
                    }
                    while (!s.isEmpty()) {
                        int i = s.size() - 1;
                        MAX = Math.max(MAX, s.peek().value);
                        copy[i][j] = s.pop().value;
                    }
                }
            } else if (dir == DOWN) {
                for (int j = 0; j < n; j++) {
                    for (int i = n - 1; i >= 0; i--) {
                        if (copy[i][j] == 0) {
                            continue;
                        } else {
                            if (s.isEmpty()) {
                                s.push(new Node(copy[i][j]));
                            } else {
                                if (s.peek().value == copy[i][j] && !s.peek().isCombine) {
                                    s.peek().combine(copy[i][j]);
                                } else {
                                    s.push(new Node(copy[i][j]));
                                }
                            }
                            copy[i][j] = 0;
                        }
                    }
                    while (!s.isEmpty()) {
                        int i = n - s.size();
                        MAX = Math.max(MAX, s.peek().value);
                        copy[i][j] = s.pop().value;
                    }
                }
            } else if (dir == LEFT) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (copy[i][j] == 0) {
                            continue;
                        } else {
                            if (s.isEmpty()) {
                                s.push(new Node(copy[i][j]));
                            } else {
                                if (s.peek().value == copy[i][j] && !s.peek().isCombine) {
                                    s.peek().combine(copy[i][j]);
                                } else {
                                    s.push(new Node(copy[i][j]));
                                }
                            }
                            copy[i][j] = 0;
                        }
                    }

                    while (!s.isEmpty()) {
                        int j = s.size() - 1;
                        MAX = Math.max(MAX, s.peek().value);
                        copy[i][j] = s.pop().value;
                    }

                }
            } else if (dir == RIGHT) {
                for (int i = 0; i < n; i++) {
                    for (int j = n-1; j >=0 ; j--) {
                        if(copy[i][j]==0)
                        {
                            continue;
                        }
                        else
                        {
                            if(s.isEmpty())
                            {
                                s.push(new Node(copy[i][j]));
                            }
                            else
                            {
                                if(s.peek().value==copy[i][j] && !s.peek().isCombine)
                                {
                                    s.peek().combine(copy[i][j]);
                                }
                                else
                                {
                                    s.push(new Node(copy[i][j]));
                                }
                            }
                            copy[i][j]=0;
                        }
                    }
                    while (!s.isEmpty())
                    {
                        int j=n-s.size();
                        MAX=Math.max(MAX,s.peek().value);
                        copy[i][j]=s.pop().value;
                    }
                }
            }
            s.clear();
        }
    }

    private static int[][] copiedArray() {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }
}
