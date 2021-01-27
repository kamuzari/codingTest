package oneDay_twoSol.DB_FirstSearch;

import java.util.*;

public class Competitive_Infection {
    static int n, k;
    static int map[][];
    static ArrayList<virus> virusNodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        virusNodes =new ArrayList<>();
        n = sc.nextInt();
        map=new int[n][n];
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=sc.nextInt();
                if(map[i][j]!=0)
                {
                    virusNodes.add(new virus(map[i][j],0,i,j)); // 바이러스 번호, 시간 0(초기화),좌표
                }
            }
        }

        Collections.sort(virusNodes);
   /*     System.out.println();
        for (virus v:virusNodes
        ) {
            System.out.println( v.getNumber()+" "+v.getY() + " " + v.getX());
        }*/
        Queue<virus> q=new LinkedList<>();
        for (virus virusNode : virusNodes) {
            q.offer(virusNode);
        }
        int targetTime=sc.nextInt();
        int targetY=sc.nextInt()-1;
        int targetX=sc.nextInt()-1;


        int[] dy ={-1,1,0,0};
        int[] dx ={0,0,-1,1};

        while (!q.isEmpty())
        {
            virus v=q.poll();
            // 해당 초는 칠하고 난 뒤 확인을 하므로 해당요구하는 시간에는 칠하고 그다음 확인을 받는다.
            if(v.getTime()==targetTime)
                break;
            for (int i = 0; i <4 ; i++) {
                int tempY=v.getY()+dy[i];
                int tempX=v.getX()+dx[i];
                if(tempX>=0 && tempX<n && tempY>=0 && tempY<n) // 배열안의 범위 값인지 확인.
                {
                    if(map[tempY][tempX]==0) // 0이면 전역
                    {
                        map[tempY][tempX]=v.getNumber(); // 전염병 번호를 기입하고.
                        q.offer(new virus(v.getNumber(),v.getTime()+1,tempY,tempX)); //전염시킨 자리를 큐에 넣는다.
                    }
                }
            }
        }
        System.out.println(map[targetY][targetX]);
    }

    static class virus implements Comparable<virus>
    {
        private int number;  // 바이러스번호
        private int time;  // 시간
        // 좌표.
        private int y;
        private int x;

        public virus(int number, int time, int y, int x) {
            this.number = number;
            this.time = time;
            this.y = y;
            this.x = x;
        }

        public int getNumber() {
            return number;
        }

        public int getTime() {
            return time;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        // 번호가 빠른순서대로.
        @Override
        public int compareTo(virus o) {
            if(this.number>=o.number)
            {
                return 1;
            }
            else
                return -1;
        }
    }

}
