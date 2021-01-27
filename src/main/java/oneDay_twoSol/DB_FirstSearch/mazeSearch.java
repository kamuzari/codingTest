package oneDay_twoSol.DB_FirstSearch;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class mazeSearch {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    // 위 아래 왼쪽 위
    static boolean visited[][]; // 방문 배열.
    static int matrix[][]; //  adjecent Matrix
    static int distance[][]; //각 위치의 최단거리 저장 배열.
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new int[n][m];
        visited = new boolean[n][m];
        distance =new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[] = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        bfs(0, 0);
       /* for (int i = 0; i <distanc.length ; i++) {
            for (int j = 0; j <distanc[i].length ; j++) {
                System.out.print(distanc[i][j]+" ");
            }
            System.out.println();
        }*/
       int k= memo_bfs(0,0);
        System.out.println(k);
        for (int i = 0; i < distance.length ; i++) {
            for (int j = 0; j < distance[i].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }




    static void bfs(int y, int x) {
        visited[y][x]=true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));
        while (!q.isEmpty()) {
            Node node = q.poll();
            y = node.getY();
            x = node.getX();
            for (int i = 0; i < 4; i++) {
                int tmpY = y + dy[i];
                int tmpX = x + dx[i];
                if (tmpX >= 0 && tmpX < m && tmpY < n && tmpY >= 0) {
                    if (matrix[tmpY][tmpX] == 1&&!visited[tmpY][tmpX] && distance[tmpY][tmpX]==0) {
                        visited[tmpY][tmpX]=true;
                        distance[tmpY][tmpX] = distance[y][x] + 1;
                        q.offer(new Node(tmpY, tmpX));
                    }
                }
            }
        }
        System.out.println(distance[n - 1][m - 1]+1);
    }

    static class Node {
        private int y;
        private int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }

    public static int memo_bfs(int y, int x) {
        // 큐(Queue) 구현을 위해 queue 라이브러리 사용
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x));
        // 큐가 빌 때까지 반복하기
        while(!q.isEmpty()) {
            Node node = q.poll();
            y = node.getY();
            x = node.getX();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                // 벽인 경우 무시
                if (matrix[ny][nx] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (matrix[ny][nx] == 1) {
                    matrix[ny][nx] = matrix[y][x] + 1;
                    q.offer(new Node(ny, nx));
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return matrix[n - 1][m - 1];
    }


}
