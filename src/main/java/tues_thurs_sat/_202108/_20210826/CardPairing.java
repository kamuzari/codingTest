package tues_thurs_sat._202108._20210826;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
// https://programmers.co.kr/learn/courses/30/lessons/17684
public class CardPairing {
    static final int BOARD_LENGTH = 4;
    static final int DIRECTION_NUMBER = 4;
    static final int ENTER = 1;

    class Node {
        private int y, x;
        private int dist;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        public void resetting(int y,int x)
        {
            this.y=y;
            this.x=x;
        }
        // 중간에 찾더라도 가는 길일 떄 최소일 수 있기 때문에 queue에 안넣으면 x.
        @Deprecated
        public boolean NotSearch()
        {
            return y==-1 && x==-1;
        }

        public boolean isEqualPosition(Node compareTarget)
        {
            return this.y ==compareTarget.y && this.x==compareTarget.x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dist=" + dist +
                    '}';
        }
    }

    int dy[] = {-1, 1, 0, 0};
    int dx[] = {0, 0, -1, 1};
    boolean permutationV[];
    int answer = 0;
    int n = 0;
    int pick[];
    ArrayList<int[]> deleteOrdersReulsts = new ArrayList<>();
    private int[] cardPairNumber;

    public static void main(String[] args) {
        CardPairing cardPairing = new CardPairing();
        int[][] b = {
                {1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}
        }; int[][] b2 = {
                {3, 0, 0, 2}, {0, 0, 1, 0}, {0, 1, 0, 0}, {2, 0, 0, 3}
        };
        cardPairing.solution(b2, 0, 1);
    }

    public int solution(int[][] board, int r, int c) {
        answer = Integer.MAX_VALUE;
        AtomicInteger count = new AtomicInteger();
        Arrays.stream(board).forEach((int[] b) -> Arrays.stream(b).filter(value -> value != 0).forEach(value -> {
            count.getAndIncrement();
        }));
        n = count.get() / 2;

        cardPairNumber = new int[n];
        pick = new int[n];
        permutationV = new boolean[n];

        for (int i = 0; i < n; i++) {
            cardPairNumber[i] = i + 1;
        }
        pick(0);

        for (int[] permResult : deleteOrdersReulsts) {
            int totalMovingCnt = 0;
            Node startDot = new Node(r, c);
            int[][] copyBoard = new int[BOARD_LENGTH][BOARD_LENGTH];
            for (int i = 0; i < BOARD_LENGTH; i++) {
                copyBoard[i] = board[i].clone();
            }
            for (int cardNumber : permResult) {
                int cnt=0;
                // 목표 카드 찾기
                cnt+=bfs(copyBoard, cardNumber, startDot)+ENTER;
                copyBoard[startDot.y][startDot.x]=0;
                // 짝 찾기
                cnt+=bfs(copyBoard,cardNumber,startDot)+ENTER;
                copyBoard[startDot.y][startDot.x]=0;

                totalMovingCnt+=cnt;
            }
            answer=Math.min(totalMovingCnt,answer);
        }
        System.out.println(answer);
        return answer;
    }

    private int bfs(int[][] board, int targetCardNumber, Node initDot) {
        LinkedList<Node> q = new LinkedList<>();
        boolean v[][] = new boolean[BOARD_LENGTH][BOARD_LENGTH];
        q.offer(new Node(initDot.y, initDot.x,0));
        v[initDot.y][initDot.x] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(board[cur.y][cur.x]==targetCardNumber)
            {
                initDot.resetting(cur.y,cur.x);
                return cur.dist;
            }
            // 1칸 씩
            for (int i = 0; i < DIRECTION_NUMBER; i++) {
                int ny=dy[i]+cur.y;
                int nx=dx[i]+cur.x;
                if(indexOutOfBound(ny,nx) || v[ny][nx])
                {
                    continue;
                }
                v[ny][nx]=true;
                q.offer(new Node(ny,nx,cur.dist+1));
            }
            // CTRL MOVING
            for (int i = 0; i < DIRECTION_NUMBER; i++) {
                Node findCard = findCard(board, cur, i);
                if(!findCard.isEqualPosition(cur))
                {
                    v[findCard.y][findCard.x]=true;
                    q.offer(new Node(findCard.y,findCard.x,cur.dist+1));
                }
            }
        }

        return 0;
    }

    private Node findCard(int[][] board, Node cur,int direction) {
        int ny= cur.y+dy[direction];
        int nx= cur.x+dx[direction];
        while (!indexOutOfBound(ny,nx))
        {
            if(board[ny][nx]!=0)
            {
                return new Node(ny,nx);
            }
            ny+=dy[direction];
            nx+=dx[direction];
        }
        return new Node(ny-dy[direction],nx-dx[direction]);
    }

    private boolean indexOutOfBound(int ny, int nx) {
        return ny<0 || nx<0 || ny>=BOARD_LENGTH || nx>=BOARD_LENGTH;
    }

    private void pick(int cnt) {
        if (cnt == n) {
            int temp[] = new int[n];
            temp = pick.clone();
            deleteOrdersReulsts.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!permutationV[i]) {
                permutationV[i] = true;
                pick[cnt] = cardPairNumber[i];
                pick(cnt + 1);
                permutationV[i] = false;
            }
        }
    }
}
