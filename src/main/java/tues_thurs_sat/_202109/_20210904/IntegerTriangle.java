package tues_thurs_sat._202109._20210904;

public class IntegerTriangle {
    public static void main(String[] args) {

    }
    public int solution(int[][] triangle) {
        for (int i = triangle.length-2; i>=0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j]+=Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
}
