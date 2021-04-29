package tues_thurs_sat._20210429;

import java.util.*;

public class LittleFriends {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    public static void main(String[] args) {
        String b[] = {"DBA", "C*A", "CDB"};
        System.out.println(solution(3, 3, b));
    }

    static Map<Character, Node[]> hash;
    static char map[][];

    public static String solution(int m, int n, String[] board) {
        String answer = "";
        hash = new LinkedHashMap<>();
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '.' || map[i][j] == '*')
                    continue;
                if (!hash.containsKey(map[i][j])) {
                    hash.put(map[i][j], new Node[2]);
                    hash.get(map[i][j])[0] = new Node(i, j);
                } else
                    hash.get(map[i][j])[1] = new Node(i, j);
            }
        }
        System.out.println(hash);
        ArrayList<Character> list = new ArrayList<>(hash.keySet());
        Collections.sort(list);
        int idx = 0;
        while (list.size() != 0) {
            if (isDelete(list.get(idx))) {
                char del = list.remove(idx);
                answer += del;
                Node a = hash.get(del)[0];
                Node b = hash.get(del)[1];
                hash.remove(del);
                map[a.y][a.x]='.';
                map[b.y][b.x]='.';
                idx=0;
            }
            else
            {
                idx++;
                if(idx==list.size())
                    return "IMPOSSIBLE";
            }
        }

        return answer;
    }

    public static boolean isDelete(char ch) {
        Node a = hash.get(ch)[0];
        Node b = hash.get(ch)[1];
        if (a.x < b.x) {
            if (colCheck(a.x, b.x, a.y, ch) && rowCheck(a.y, b.y, b.x, ch))
                return true;
            if (rowCheck(a.y, b.y, a.x, ch) && colCheck(a.x, b.x, b.y, ch))
                return true;
        } else {
            if (rowCheck(a.y, b.y, b.x, ch) && colCheck(b.x, a.x, a.y, ch))
                return true;
            if (colCheck(b.x, a.x, b.y, ch) && rowCheck(a.y, b.y, a.x, ch))
                return true;
        }
        return false;
    }

    static boolean rowCheck(int y1, int y2, int x, char ch) {
        for (int i = y1; i < y2 + 1; i++) {
            if (map[i][x] != '.' && map[i][x] != ch)
                return false;
        }
        return true;
    }

    static boolean colCheck(int x1, int x2, int y, char ch) {
        for (int i = x1; i < x2 + 1; i++) {
            if (map[y][i] != '.' && map[y][i] != ch)
                return false;
        }
        return true;
    }

}