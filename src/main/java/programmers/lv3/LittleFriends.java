package programmers.lv3;

import java.util.*;

public class LittleFriends {

    class Node {
        private int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static final String impossible = "IMPOSSIBLE";
    Map<Character, Node[]> tileGrouping = new HashMap<>();
    char map[][];

    public String solution(int m, int n, String[] board) {
        int idx = 0;
        map = new char[m][n];
        for (String str : board) {
            int row = idx / n;
            map[row] = str.toCharArray();
            for (char c : map[row]) {
                if (c == '.' || c == '*') {
                    idx++;
                    continue;
                }
                if (!tileGrouping.containsKey(c)) {
                    tileGrouping.put(c, new Node[2]);
                    tileGrouping.get(c)[0] = new Node(row, idx % n);
                } else {
                    tileGrouping.get(c)[1] = new Node(row, idx % n);
                }
                idx++;
            }
        }
        LinkedList<Character> list = new LinkedList<>(tileGrouping.keySet());
        list.sort((o1, o2) -> o1.compareTo(o2));
        Collections.sort(list);
        idx = 0;
        StringBuilder answer = new StringBuilder();
        while (list.size() != 0) {
            char key = list.get(idx);
            if (isPromising(key)) {
                answer.append(key);
                list.remove(idx);
                mapNotationRemove(key);
                tileGrouping.remove(key);
                idx = 0;
            } else {
                idx++;
                if (idx == list.size()) {
                    return impossible;
                }
            }
        }

        return answer.toString();
    }

    private void mapNotationRemove(char key) {
        Node[] nodes = tileGrouping.get(key);
        Node a = nodes[0];
        Node b = nodes[1];
        map[a.y][a.x] = '.';
        map[b.y][b.x] = '.';
    }

    private boolean isPromising(char key) {
        Node[] nodes = tileGrouping.get(key);
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
            if (map[i][x] != '.' && map[i][x] != key) {
                return false;
            }
        }
        return true;
    }

    boolean colCheck(int x1, int x2, int y, char key) {
        for (int i = x1; i < x2 + 1; i++) {
            if (map[y][i] != '.' && map[y][i] != key) {
                return false;
            }
        }
        return true;
    }
}
