package Alone.review._210604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GaryMandering2 {
    static int n,map[][];
    static boolean area[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         n=Integer.parseInt(br.readLine());
         map=new int[n+1][n+1];
         int totalSum=0;
        for (int i = 0; i < n; i++) {
            String str[]=br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                totalSum+=map[i+1][j+1]=Integer.parseInt(str[j]);
            }
        }
        System.out.println(totalSum);

        for (int i = 1; i < n+1; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        int min=Integer.MAX_VALUE;
        for (int x =1; x < n+1; x++) {
            for (int y = 2; y < n+1; y++) {
                for (int d1 = 1; d1 < n+1; d1++) {
                    for (int d2 = 1; d2 <n+1 ; d2++) {
                        if(x+d1+d2>n) continue;
                        if(y-d1<0 || y+d2>n) continue;


                        area=new boolean[n+1][n+1];
                        area[x][y]=true;
                    // 경계선 표시(5구역).
                        for (int i = 1; i <=d1; i++) {
                            area[x+i][y-i]=true;
                            area[x+d2+i][y+d2-i]=true;
                        }

                        for (int i = 1; i <=d2; i++) {
                            area[x+i][y+i]=true;
                            area[x+d1+i][y-d1+i]=true;
                        }


                    // 구역 표시
                        int sum[]=new int[6];

                    // 1구역
                        for (int i = 1; i <x+d1 ; i++) {
                            for (int j = 1; j <=y; j++) {
                                if(area[i][j])
                                    break;
                                sum[1]+=map[i][j];
                            }
                        }
                    // 2구역
                        for (int i = 1; i <=x+d2 ; i++) {
                            for (int j = n; j >y ; j--) {
                                if(area[i][j])
                                    break;
                                sum[2]+=map[i][j];
                            }
                        }

                        // 3구역
                        for (int i = x+d1; i < n+1; i++) {
                            for (int j = 1; j <y-d1+d2 ; j++) {
                                if(area[i][j])
                                    break;
                                sum[3]+=map[i][j];
                            }
                        }

                        for (int i = x+d2+1; i <n+1 ; i++) {
                            for (int j = n; j >= y-d1+d2; j--) {
                                if(area[i][j])
                                    break;
                                sum[4]+=map[i][j];
                            }
                        }

                        sum[5]=totalSum;
                        for (int i = 1; i <=4 ; i++) {
                            sum[5]-=sum[i];
                        }

                        Arrays.sort(sum,1,6);
                        min=Math.min(min,sum[5]-sum[1]);
                    }
                }
            }
        }

        System.out.println(min);

    }

}
