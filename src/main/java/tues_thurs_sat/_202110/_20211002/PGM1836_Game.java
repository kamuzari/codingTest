package tues_thurs_sat._202110._20211002;

import java.util.*;

public class PGM1836_Game {
    public static void main(String[] args) {
        PGM1836_Game p = new PGM1836_Game();
        String b[] = {"DBA", "C*A", "CDB"};
//        System.out.println(p.solution(3, 3, b));
        String b2[] = {"NRYN", "ARYA"};
        System.out.println(p.solution(2, 4, b2));
    }

    class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    Map<Character, Node[]> map = new HashMap<>();
    char arr[][];

    public String solution(int m, int n, String[] board) {
        int idx = 0;
        arr = new char[m][n];
        for (String str : board) {
            int row = idx / n;
            arr[row] = str.toCharArray();
            for (char c : arr[row]) {
                if (c == '.' || c == '*') {
                    idx++;
                    continue;
                }
                if (!map.containsKey(c)) {
                    map.put(c, new Node[2]);
                    map.get(c)[0] = new Node(row, idx % n);
                } else {
                    map.get(c)[1] = new Node(row, idx % n);
                }
                idx++;
            }
        }
        LinkedList<Character> list = new LinkedList<>(map.keySet());
        Collections.sort(list);
        idx = 0;
        StringBuffer answer = new StringBuffer();
        while (list.size() != 0) {
            char key = list.get(idx);
            if (isDelete(key)) {
                answer.append(key);
                list.remove(idx);
                mapNotationRemove(key);
                map.remove(key);
                idx = 0;
            } else {
                idx++;
                if (idx == list.size()) {
                    return "IMPOSSIBLE";
                }
            }
        }
        return answer.toString();
    }

    private void mapNotationRemove(char key) {
        Node[] nodes = map.get(key);
        Node a = nodes[0];
        Node b = nodes[1];
        arr[a.y][a.x] = '.';
        arr[b.y][b.x] = '.';
    }

    private boolean isDelete(char key) {
        Node[] nodes = map.get(key);
        Node a = nodes[0];
        Node b = nodes[1];
        if (a.x < b.x) {
            if (rowCheck(a.y, b.y, a.x, key) && colCheck(a.x, b.x, b.y, key)) {
                return true;
            }
            if (rowCheck(a.y, b.y, b.x, key) && colCheck(a.x, b.x, a.y, key)) {
                return true;
            }
        } else {
            if (rowCheck(a.y, b.y, a.x, key) && colCheck(b.x, a.x, b.y, key)) {
                return true;
            }
            if (rowCheck(a.y, b.y, b.x, key) && colCheck(b.x, a.x, a.y, key)) {
                return true;
            }
        }
        return false;
    }

    boolean rowCheck(int y1, int y2, int x, char key) {
        for (int i = y1; i < y2 + 1; i++) {
            if (arr[i][x] != '.' && arr[i][x] != key) {
                return false;
            }
        }
        return true;
    }

    boolean colCheck(int x1, int x2, int y, char key) {
        for (int i = x1; i < x2 + 1; i++) {
            if (arr[y][i] != '.' && arr[y][i] != key) {
                return false;
            }
        }
        return true;
    }
}
