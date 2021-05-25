package WeeklyThuseday._0525;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LittleFriends_SichuanProvince {
    public static void main(String[] args) {
        String b[] = {"DBA", "C*A", "CDB"};
        String b2[] = {"NRYN", "ARYA"};
        System.out.println(solution(2, 4, b2));
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Map<Character, Node[]> map = new LinkedHashMap<>();
    static char arr[][];

    public static String solution(int m, int n, String[] board) {
        String answer = "";
        arr = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                arr[i][j] = board[i].charAt(j);
                if (arr[i][j] == '.' || arr[i][j] == '*')
                    continue;
                if (!map.containsKey(arr[i][j])) {
                    map.put(arr[i][j], new Node[2]);
                    map.get(arr[i][j])[0] = new Node(i, j);
                } else if (map.containsKey(arr[i][j])) {
                    map.get(arr[i][j])[1] = new Node(i, j);
                }
            }
        }
        ArrayList<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int idx = 0;
        while (!list.isEmpty()) {
            if (isDelete(list.get(idx))) {
                char del = list.remove(idx);
                answer += del;
                Node a = map.get(del)[0];
                Node b = map.get(del)[1];
                map.remove(del);
                arr[a.y][a.x] = '.';
                arr[b.y][b.x] = '.';
                idx = 0;
            } else {
                idx++;
                if (idx == list.size())
                    return "IMPOSSIBLE";
            }
        }

        return answer;
    }

    public static boolean isDelete(char ch) {
        Node a = map.get(ch)[0];
        Node b = map.get(ch)[1];
        if (a.x < b.x) {
            if (xCheck(a.x, b.x, a.y, ch) && yCheck(a.y, b.y, b.x, ch))
                return true;
            if (yCheck(a.y, b.y, a.x, ch) && xCheck(a.x, b.x, b.y, ch))
                return true;
        } else {
            if (yCheck(a.y, b.y, b.x, ch) && xCheck(b.x, a.x, a.y, ch))
                return true;
            if (xCheck(b.x, a.x, b.y, ch) && yCheck(a.y, b.y, a.x, ch))
                return true;
        }
        return false;
    }

    static boolean yCheck(int y1, int y2, int x, int ch) {
        for (int i = y1; i < y2 + 1; i++) {
            if (arr[i][x] != '.' && arr[i][x] != ch)
                return false;
        }
        return true;
    }

    static boolean xCheck(int x1, int x2, int y, int ch) {
        for (int i = x1; i < x2 + 1; i++) {
            if (arr[y][i] != '.' && arr[y][i] != ch) {
                return false;
            }
        }
        return true;
    }

}
