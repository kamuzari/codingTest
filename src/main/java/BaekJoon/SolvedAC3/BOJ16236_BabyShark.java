package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ16236_BabyShark {

    private static int n,map[][];
    static class Shark{
        private int y,x,level,exp;
        private Node fish;
        public Shark(int y,int x){
            this.y=y;
            this.x=x;
            this.level=2;
            this.exp=0;
        }
        public void eat(){
            this.exp++;
            if(this.exp==this.level){
                this.level++;
                this.exp=0;
            }
            map[fish.y][fish.x]=0;
            this.fish=null;
        }
        public void setPositions(){
            this.y=fish.y;
            this.x=fish.x;
        }
        public void detectFish(Node fish){
            this.fish=fish;
        }
        public boolean isExistFish(){
            return this.fish!=null;
        }
    }
    static Shark shark;
    static class Node{
        int y,x,dist;

        public Node(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    static int dy[]={-1,1,0,0};
    static int dx[]={0,0,-1,1};
    static final int INF=(int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map=new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    map[i][j]=0;
                    shark=new Shark(i,j);
                }
            }
        }
        int minDist=0;
        int answer=0;
        do{
            boolean v[][]=new boolean[n][n];
            LinkedList<Node> q=new LinkedList<>();
            v[shark.y][shark.x]=true;
            q.offer(new Node(shark.y, shark.x,0));
            minDist=INF;
            while (!q.isEmpty()){
                Node cur = q.poll();
                if(cur.dist>minDist) continue;
                if(map[cur.y][cur.x]!=0&&map[cur.y][cur.x]<shark.level){
                    if(cur.dist<minDist){
                        minDist=cur.dist;
                        shark.detectFish(cur);
                    }else if(cur.dist==minDist){
                        if(cur.y<shark.fish.y) shark.detectFish(cur);
                        else if(cur.y== shark.fish.y && cur.x<shark.fish.x) shark.detectFish(cur);
                    }
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int ny=cur.y+dy[i];
                    int nx=cur.x+dx[i];
                    if(outOfIndex(ny,nx)) continue;
                    if(v[ny][nx] || map[ny][nx]>shark.level) continue;
                    v[ny][nx]=true;
                    q.offer(new Node(ny,nx,cur.dist+1));
                }
            }
            if(shark.isExistFish()){
                answer+=(shark.fish.dist);
                shark.setPositions();
                shark.eat();
            }
        }while (minDist!=INF);
        System.out.println(answer);
    }
    static boolean outOfIndex(int ny,int nx){
        return ny<0 || nx<0 || ny>n-1 || nx>n-1;
    }
}
