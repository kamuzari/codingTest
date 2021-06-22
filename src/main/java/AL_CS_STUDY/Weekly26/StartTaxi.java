package AL_CS_STUDY.Weekly26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartTaxi {
    static int map[][];
    static int n, m, fuel;
    static class Passenger
    {
        private int idx;
        private int start[];
        private int target[];


        public Passenger(int idx,int[] start, int[] target) {
            this.idx =idx;
            this.start=new int[2];
            this.target=new int[2];
            this.start = start;
            this.target = target;

        }
    }
    static class Taxi {
        private int y, x, cnt;

        public Taxi(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        public void renewal(int y,int x)
        {
            this.y=y;
            this.x=x;
            this.cnt=0;
        }

    }

    static Taxi taxi;
    static Passenger taken = null;
    public static int dx[] = { 0, 0, -1, 1 };
    public static int dy[] = { -1, 1, 0, 0 };
    static final int INF=(int)1e9;
   static Map<Integer,Passenger> waitingGuest=new HashMap<>();
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        waitingGuest=new HashMap<>();
        for (int i = 1; i < n+1; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                    map[i][j]=-1;
            }
        }
        st = new StringTokenizer(br.readLine());
        taxi = new Taxi(Integer.parseInt(st.nextToken())
                , Integer.parseInt(st.nextToken()), 0);
        for (int i = 1; i <=m; i++) {
            st=new StringTokenizer(br.readLine());

            int start[]=new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            int target[]=new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            waitingGuest.put(i,new Passenger(i,start,target));
            map[start[0]][start[1]]=i;
        }

        solution();
    }

    private static void solution() {
        while (!waitingGuest.isEmpty())
        {
            // 손님을 태우러 가는 연료량
            fuel-= fuelConsumptionQuantity();
            if(fuel<0)
                break;
            // 손님을 태우고 목저지 까지 가는 연료량
            int chargeQuantity = fuelConsumptionQuantity();
            fuel-=chargeQuantity;
            if(fuel<0)
                break;

            fuel+=chargeQuantity*2;
        }
        System.out.println(fuel<0 ?-1:fuel);
    }
    static int fuelConsumptionQuantity()
    {
        Queue<Taxi> q=new LinkedList<>();
        Queue<Passenger> candidates=new LinkedList<>();
        boolean v[][]=new boolean[n+1][n+1];

        int previousCnt=taxi.cnt;
        v[taxi.y][taxi.x]=true;
        q.offer(taxi);

        while (!q.isEmpty())
        {
            Taxi cur = q.poll();

            if(fuel-cur.cnt<0)
                return INF;

            if(previousCnt!=cur.cnt && !candidates.isEmpty())
                break;

            previousCnt=cur.cnt;
            if(taken==null)
            {
                int id=map[cur.y][cur.x];
                if(id>0)
                {
                    Passenger passenger = waitingGuest.get(id);
                    candidates.offer(passenger);
                }
            }
            else
            {
                if(cur.y==taken.target[0] && cur.x ==taken.target[1])
                {
                    waitingGuest.remove(taken.idx);
                    taken=null;
                    taxi.renewal(cur.y,cur.x);
                    return previousCnt;
                }
            }

            for (int i = 0; i < 4; i++) {
                int ny=cur.y+dy[i];
                int nx=cur.x+dx[i];

                if(nx>0 && ny>0 && ny<n+1 && nx<n+1)
                {
                    if(map[ny][nx]!=-1 && !v[ny][nx])
                    {
                        q.offer(new Taxi(ny,nx,cur.cnt+1));
                        v[ny][nx]=true;
                    }
                }
            }
        }

        if(candidates.isEmpty())
        {
            return INF;
        }

        taken = DetailChecking(candidates);
        taxi.renewal(taken.start[0], taken.start[1]);
        map[taken.start[0]][taken.start[1]]=0;
        return previousCnt;
    }

    private static Passenger DetailChecking(Queue<Passenger> candidates) {
        Passenger pick = candidates.poll();

        while (!candidates.isEmpty())
        {
            Passenger cur = candidates.poll();
            if(cur.start[0]<pick.start[0])
            {
                pick=cur;
            }else if(cur.start[0]==pick.start[0] && cur.start[1]<pick.start[1])
            {
                pick=cur;
            }
        }

        return pick;
    }


}
