package Al_Study.기초수학2;

import java.util.ArrayList;
import java.util.Scanner;

public class 실패_대통령선거 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();
        while (T-->0)
        {
            String str[]=sc.nextLine().split(" ");
            int C=Parse(str[0]); // 후보자
            int V=Parse(str[1]); // 유권자
            int vote[][]=new int[V][C];
            for (int i = 0; i <V ; i++) {
                String str2[]=sc.nextLine().split(" ");
                for (int j = 0; j < C; j++) {
                    vote[i][j]=Parse(str2[j]);
                };
            }
            //logic
            // 1차 2차 투표만 있는 것으로 확인
            double avg=Math.ceil((double)V/2);
//            System.out.println("과반수 인원은 "+avg);
            boolean flag=false;

            int one=0; int two=0;
            for (int i = 0; i <2 ; i++) {
                // 1차 투표.
                if(i==0)
                {
                    int cadidate[]=new int[C+1];
                    for (int j = 0; j <V; j++) {
                        cadidate[vote[j][0]]++;
                    }
                    for (int j = 1; j <cadidate.length ; j++) {
                        if(avg<=cadidate[j])
                        {
                            flag=true;
                            System.out.println(j+" 1");
                            break;
                        }
                        //candidate가 0 5 4 6 일떄 후보자가 실패 4 6 이 들어감.
                        // 오류예상.
                      /*  if(two<cadidate[j])
                        {
                            two=populationMove;
                            populationMove=j;
                        }*/
                    }
                    int cnt=2;
                    ArrayList<Integer> temp=new ArrayList<>();
                    while (cnt-->0)
                    {
                        int max=0;
                        for (int j = 1; j < cadidate.length; j++) {
                            if (max < cadidate[j]) {
                                max = j;
                            }
                        }
                        temp.add(max);
                        cadidate[max] = 0;
                    }
                   one= temp.get(0);
                   two=temp.get(1);
                }
                else if(i==1&&!flag)
                {
                    int cadidate[]=new int[C+1];
                    for (int j = 0; j <V; j++) {
                        if((vote[j][0]!=one && vote[j][0]!=two)) // 1,2 후보자를 투표한 사람들을 제외
                            if(vote[j][1]==one || vote[j][1]==two)
                                cadidate[vote[j][1]]++;
                    }
                    int pick= cadidate[one]>cadidate[two] ? one :two;
                    System.out.println(pick+" 2");
                }
            }

        }
    }



    static int Parse(String str) {
        return Integer.parseInt(str);
    }
}
