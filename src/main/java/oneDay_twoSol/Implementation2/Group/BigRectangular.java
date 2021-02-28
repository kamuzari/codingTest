package oneDay_twoSol.Implementation2.Group;

import java.util.Scanner;

public class BigRectangular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int rect[][] = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str[]=sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                rect[i][j] = Integer.parseInt(str[j]);
            }
        }
        int area=0;
        int maxArea=0;
        for (int k = 0; k <Math.min(n,m) ; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(k+i <n && k+j<m)
                    {
                        if(rect[i][j]== rect[i+k][j] && rect[i][j] == rect[i][j+k]&& rect[i][j]==rect[i+k][j+k])
                        {
                            area=(k+1)*(k+1);
                            maxArea=Math.max(area,maxArea);
                        }
                    }
                }
            }
        }
        System.out.println(maxArea);

    }
}
