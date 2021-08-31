package AL_CS_STUDY.Weekly_30to40.Weekly35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2048_EASY_IMPROVE {
    static class Node {
        private int value;
        private boolean isCombine;

        public Node(int value) {
            this.value = value;
            this.isCombine = false;
        }

        public void combine(int a) {
            this.value += a;
            this.isCombine = true;
        }
    }
    static int n,map[][],max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        dfs(0,map);
        System.out.println(max);
    }
    static void dfs(int cnt,int [][] map)
    {
        if(cnt==5)
        {
            return;
        }
        for (int i = 0; i < 4; i++) {
            move(cnt,map);
            map=rotate(map);
        }
    }

    private static int[][] rotate(int[][] map) {
        int temp[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                System.out.println(j+" "+(n-1-i));
                temp[j][n-1-i]=map[i][j];
            }
        }
        return temp;
    }

    private static void move(int cnt, int[][] map) {
        int copy[][]=copiedArray(map);
        Stack<Node> s=new Stack<>();
        for (int j = 0; j <n ; j++) {
            for (int i = 0; i < n; i++) {
                if(copy[i][j]==0)
                {
                    continue;
                }
                else
                {
                    if(s.isEmpty())
                    {
                        s.push(new Node(copy[i][j]));
                    }
                    else
                    {
                        if(s.peek().value==copy[i][j] && !s.peek().isCombine)
                        {
                            s.peek().combine(copy[i][j]);
                        }
                        else
                        {
                            s.push(new Node(copy[i][j]));
                        }
                    }
                    copy[i][j]=0;
                }
            }
            while (!s.isEmpty())
            {
                int i=s.size()-1;
                max=Math.max(max,s.peek().value);
                copy[i][j]=s.pop().value;
            }
        }
        dfs(cnt+1,copy);
    }
    static int[][] copiedArray(int arr[][])
    {
        int temp[][]=new int[n][n];
        for (int i = 0; i < n; i++) {
            temp[i]=arr[i].clone();
        }
        return temp;
    }
}
