package AL_CS_STUDY.RealTimeSolving.Weekly20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SudokuTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int num[][] = new int[9][9];
            int[] is;
            boolean flag = false;
            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    num[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 9; j++) {
                is=new int[9];
                for (int k = 0; k < 9; k++) {
                    is[num[j][k]-1]=1;
                }
                for (int k = 0; k < 9; k++) {
                    if(is[k]==0)
                    {
                        flag=true;
                        break;
                    }
                }
            }

            for (int j = 0; j < 9; j++) {
                is=new int[9];
                for (int k = 0; k < 9; k++) {
                    is[num[k][j]-1]=1;
                }
                for (int k = 0; k < 9; k++) {
                    if(is[k]==0)
                    {
                        flag=true;
                        break;
                    }
                }
            }
            is=new int[9];
            for (int j = 0; j <=6; j+=3) {
                for (int k = 0; k <=6 ; k+=3) {
                    is=new int[9];
                    for (int l = i; l < j+3; l++) {
                        for (int m = k; m <k+3 ; m++) {
                            is[num[l][m]-1]=1;
                        }
                    }
                }
                for (int k = 0; k < 9; k++) {
                    if(is[k]==0)
                    {
                        flag=true;
                        break;
                    }
                }
            }
            if(flag)
                System.out.println("#"+t+" "+0);
            else
                System.out.println("#"+t+" "+1);

        }
    }

}
