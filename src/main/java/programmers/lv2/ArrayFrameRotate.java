package programmers.lv2;

public class ArrayFrameRotate {
    static int n,m;
    private static int[] minValues;
    private static int idx;

    public  int[] solution(int rows, int columns, int[][] queries) {
        int n=queries.length;
        int map[][]=new int[rows][columns];
        int val=1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j]=val++;
            }
        }
        minValues = new int[n];
        idx = 0;
        for (int i = 0; i <n ; i++) {
            int x1=queries[i][0];
            int y1=queries[i][1];
            int x2=queries[i][2];
            int y2=queries[i][3];
            map=rotate(map,x1-1,y1-1,x2-1,y2-1);
        }

        return minValues;
    }

    private  int[][] rotate(int[][] map, int y1, int x1, int y2, int x2) {
        int val=map[y1][x1];
        int minValue=val;

        for (int i = y1; i <y2; i++) {
            map[i][x1]=map[i+1][x1];
            minValue=Math.min(map[i][x1],minValue);
        }
        for (int i = x1; i <x2; i++) {
            map[y2][i]=map[y2][i+1];
            minValue=Math.min(map[y2][i],minValue);
        }
        for (int i = y2; i >y1 ; i--) {
            map[i][x2]=map[i-1][x2];
            minValue=Math.min(map[i][x2],minValue);
        }
        for (int i = x2; i >x1+1 ; i--) {
            map[y1][i]=map[y1][i-1];
            minValue=Math.min(map[y1][i],minValue);
        }
        map[y1][x1+1]=val;
        minValues[idx++]=minValue;
        return map;
    }
}
