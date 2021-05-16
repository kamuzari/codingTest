package WeeklyThurseday.SAMSUNG;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Chicken {
    // 치킨집 랜덤으로 m만큼 뽑고 최단거리 갱신?
    static class Position{
        private int y,x;

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int city[][];
    static List<Position> house=new LinkedList<>();
    static List<Position> chicken=new LinkedList<>();
    static int m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        m=sc.nextInt();
        city=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a=sc.nextInt();
                if(a==1)
                    house.add(new Position(i,j));
                else if(a==2)
                    chicken.add(new Position(i,j));
            }
        }
        combination(0,0);
        System.out.println(Min);


    }
    static List<Position> pickChicken =new LinkedList<>();
    static int Min=(int)1e9;
    public static void combination(int idx,int cnt)
    {
        if(cnt==m)
        {
            int sum=0;
            for (Position h : house) { // 집에서 가장 가까운 치킨 고르고.
                int min=(int)1e9;
                for (Position c : pickChicken) {
                    int dist=Math.abs(c.getX()-h.getX())+Math.abs(c.getY()-h.getY());
                    min=Math.min(min,dist);
                }
                sum+=min;
            }
            Min=Math.min(sum,Min);

            return;
        }
        for (int i = idx; i <chicken.size() ; i++) {
            pickChicken.add(chicken.get(i));
            combination(i+1,cnt+1);
            pickChicken.remove(pickChicken.size()-1);
        }
    }
}

