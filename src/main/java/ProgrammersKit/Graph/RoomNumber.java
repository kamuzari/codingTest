package ProgrammersKit.Graph;

import java.util.HashSet;

public class RoomNumber {
    class Edge{
        int r1,r2,c1,c2,d;//시작정점, 도착정점, 방향
        Edge(int r1, int c1, int r2, int c2, int d){
            this.r1 = r1;
            this.r2 = r2;
            this.c1 = c1;
            this.c2 = c2;
            this.d = d;
        }

        @Override
        public boolean equals(Object obj){
            Edge e = (Edge) obj;

            //edge에 방향을 없애고 edge가 그려진 위치로만 같은 객체임을 비교
            //ex) `3방향으로 (0,0), (1,1)` == `7방향으로 (1,1), (0,0)` 서로 같은 객체
            if((e.r1 + e.r2 == this.r1 + this.r2) && (e.c1 + e.c2 == this.c1 + this.c2)
                    && (Math.abs(e.d - this.d) == 4 || e.d == this.d)) return true;
            return false;
        }

        @Override
        public int hashCode(){
            int prime = 31;
            int hashcode = 1;
            int dir = this.d;
            if(this.d < 4) dir += 4;

            hashcode = prime * hashcode + (this.r1+this.r2);
            hashcode = prime * hashcode + (this.c1+this.c2);
            hashcode = prime * hashcode + dir;

            return hashcode;
        }
    }
    class Point{
        int r,c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj){
            Point p = (Point) obj;

            if(this.r == p.r && this.c == p.c) return true;
            return false;
        }

        @Override
        public int hashCode(){
            int prime = 31;
            int hashcode = 1;

            hashcode = prime * hashcode + this.r;
            hashcode = prime * hashcode + this.c;

            return hashcode;
        }
    }

    class Solution {
        public int solution(int[] arrows) {
            int answer = 0;

            int[][] move = new int[][]{
                    {-1,0}
                    , {-1,1}//대각선
                    , {0,1}
                    , {1,1}//대각선
                    , {1,0}
                    , {1,-1}//대각선
                    , {0,-1}
                    , {-1,-1}//대각선
            };

            HashSet<Point> point = new HashSet<>();
            HashSet<Edge> edge = new HashSet<>();


            int r = 0, c = 0;//(0,0)에서 시작
            point.add(new Point(r,c));

            for(int i = 0, size = arrows.length; i < size; i++){
                int d = arrows[i];
                r += move[d][0];
                c += move[d][1];

                Point cur = new Point(r,c);

                //이미 존재하는 edge로 다시 이동한거라면 continue;
                if(edge.contains(new Edge(r - move[d][0], c - move[d][1], r, c, d))) continue;

                if(point.contains(cur)){//이미 찍혀있던 정점이라면
                    answer++;
                }else{//처음 도착한 정점이라면
                    point.add(cur);//정점 추가
                }

                //대각선이라면 중간에 edge 겹치는지 확인
                if(d % 2 == 1 && edge.contains(new Edge(r - move[d][0], c, r, c - move[d][1], ((d+2) % 8)))) answer++;

                edge.add(new Edge(r - move[d][0], c - move[d][1], r, c, d));//edge 추가

            }

            return answer;
        }
    }
}
