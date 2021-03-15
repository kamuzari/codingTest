package oneDay_twoSol.DFS_BFS2.Theory.Deep;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Avoiding_surveillance {
    static char map[][];
    static int n;
    static ArrayList<Position> empty=new ArrayList<>();
    static ArrayList<Position> teacher=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        map=new char[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=sc.next().charAt(0);
                if(map[i][j]=='T')
                    teacher.add(new Position(i,j));
                else if(map[i][j]=='X')
                    empty.add(new Position(i,j));
            }
        }
        obstaclePick(0,0);
        if(find)// 몿찾는 경우가 하나라도 있으면!
        {
            System.out.println("YES");
        }
        else
            System.out.println("NO");


    }
    static Stack<Position> s=new Stack<>();
    static boolean find=false;
    static void obstaclePick(int cnt, int idx)
    {

        if(cnt==3)
        {
            int notFoundTeacher=0;
            char temp[][]=new char[n][n];
            for (int i = 0; i < n; i++) {
                temp[i]=map[i].clone();
            }
            for (Position position : s) {
                temp[position.y][position.x]='O';
//                System.out.println(position.y+"  "+position.x);
            }
            for (int i = 0; i < teacher.size(); i++) {
                Position t=teacher.get(i);
                boolean isFind=findStu(t.y,t.x,temp);
                if(!isFind)
                {
                    // 어떤 선생님에게도 한번이라도 발각이 되면.
                   notFoundTeacher++;
                }
            }
            if(notFoundTeacher==teacher.size())
            {
                find=true;
            }
            return;
        }
        for (int i = idx; i < empty.size(); i++) {
           s.push(empty.get(i));
           obstaclePick(cnt+1,idx+1);
           s.pop();
        }
    }
    // 0,1,2,3 -> 상,하, 좌,우
    static boolean findStu(int y, int x,char tempMap[][])
    {
        int upY=y;
        int downY=y;
        int rightX=x;
        int leftX=x;
        while(true)
        {
             upY+=1;
            if(isValid(upY,x))
            {
                if(tempMap[upY][x]=='S')
                    return true;
                else if(tempMap[upY][x]=='O' || tempMap[upY][x]=='T')
                    break;
            }
            else break;
        }

        while(true)
        {
            downY-=1;
            if(isValid(downY,x))
            {
                if(tempMap[downY][x]=='S')
                    return true;
                else if(tempMap[downY][x]=='O' || tempMap[downY][x]=='T')
                    break;
            }
            else break;
        }

        while(true)
        {
            rightX+=1;
            if(isValid(y,rightX))
            {
                if(tempMap[y][rightX]=='S')
                    return true;
                else if(tempMap[y][rightX]=='O' || tempMap[y][rightX]=='T')
                    break;
            }
            else break;
        }

        while(true)
        {
            leftX-=1;
            if(isValid(y,leftX))
            {
                if(tempMap[y][leftX]=='S')
                    return true;
                else if(tempMap[y][leftX]=='O' || tempMap[y][leftX]=='T')
                    break;
            }
            else break;
        }
        return false;

    }
    static boolean isValid(int y,int x)
    {
        return y>=0 && x>=0 && y<n && x<n;
    }
    static class Position{
        private int y,x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
