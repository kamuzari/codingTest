package Basic.SolvedAC3;
import java.io.*;
public class BOJ1992_QuardTree {

    private static int[][] map;
    private static int n;
    private static StringBuffer answers=new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str[]=br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(str[j]);
            }
        }
        partition(0,0,n);
        System.out.println(answers);

    }
    public static void partition(int y,int x,int size){
        if(check(y,x,size)){
            answers.append(map[y][x]);
            return;
        }
        answers.append("(");
        partition(y,x,size/2);
        partition(y,x+size/2,size/2);
        partition(y+size/2,x,size/2);
        partition(y+size/2,x+size/2,size/2);
        answers.append(")");
    }

    private static boolean check(int y, int x, int size) {
        int pivot=map[y][x];
        for (int i = y; i <y+size; i++) {
            for (int j = x; j <x+size ; j++) {
                if(pivot!=map[i][j]) return false;
            }
        }
        return true;
    }
}
