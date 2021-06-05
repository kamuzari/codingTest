package tues_thurs_sat._20210605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorPaper {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int paper[]=new int[7];
        for (int i = 1; i < 7; i++) {
            paper[i]=Integer.parseInt(br.readLine());
        }
        int cnt=paper[6];
        while (paper[1]!=0 || paper[2]!=0 || paper[3]!=0 || paper[4]!=0 || paper[5]!=0)
        {
            while (paper[5]>0)
            {
                int size=36;
                paper[5]--;
                size-=25;
                if(paper[1]<=size)
                    paper[1]=0;
                else
                    paper[1]-=size;
                cnt++;
            }
            while (paper[4]>0)
            {
                int size=36;
                paper[4]--;
                size-=16;
                if(paper[2]>5)
                {
                    paper[2]-=5;
                    size-=20;
                }
                else
                {
                    size-=4*paper[2];
                    paper[2]=0;
                }
                if(paper[1]<=size)
                    paper[1]=0;
                else
                    paper[1]-=size;
                cnt++;
            }

            while (paper[3]>0)
            {
                int size=36;
                if(paper[3]>4)
                {
                    paper[3]-=4;
                    size=0;
                }
                else
                {
                    size-=9*paper[3];
                    paper[3]=0;
                }
                if (size == 27 && paper[2]>5)
                {
                    paper[2] -= 5;
                    size -= 20;
                }
                else if (size == 27 && paper[2] <= 5)
                {
                    size -= 4 * paper[2];
                    paper[2] = 0;
                }
                if (size == 18 && paper[2]>3)
                {
                    paper[2] -= 3;
                    size -= 12;
                }
                else if (size == 18 && paper[2] <= 3)
                {
                    size -= 4 * paper[2];
                    paper[2] = 0;
                }
                if (size == 9 && paper[2] >= 1)
                {
                    size -= 4 * paper[2];
                    paper[2] = 0;
                }
                if (paper[1] <= size)
                    paper[1]  = 0;
                else
                    paper[1]  -= size;
                cnt++;
            }

            while (paper[2]>0)
            {
                int size=36;
                if (paper[2]>9)
                {
                    paper[2] -= 9;
                    size = 0;
                }
                else
                {
                    size -= 4 * paper[2];
                    paper[2] = 0;
                }
                if (paper[1] <= size)
                    paper[1] = 0;
                else
                    paper[1] -= size;
                cnt++;
            }
            while (paper[1]>0)
            {
                if(paper[1]>36)
                    paper[1]-=36;
                else
                    paper[1]=0;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
