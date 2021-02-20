package oneDay_twoSol.Greedy2.Grouping;

import java.util.Scanner;

public class sickKnight {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        if(n==1)
            System.out.println(1);
        else if(n==2)
        {
            System.out.println(Math.min(4,(m+1)/2));
        }
        else if(m<7)
         {
             System.out.println(Math.min(4,m));
        }
        else
            System.out.println(m-7+5);
    }
}
/*
- 조건에서, 이 부분이 추가가 되어야 합니다.



- 1번 조건 : 2칸 위로, 1칸 오른쪽

- 2번 조건 : 1칸 위로, 2칸 오른쪽

- 3번 조건 : 1칸 아래로, 2칸 오른쪽

- 4번 조건 : 2칸 아래로, 1칸 오른쪽



- "병든 나이트가 4회 이동 후, 다섯번 째 움직임 부터는 1번 조건부터 4번 조건까지 모두 무.조.건 한 번씩 이동해야 합니다"

- 위의 말은 즉, 4회 이동 후, 위의 네 조건 중 하나라도 만족시킬 수 없다면 이동이 불가능하다는 점입니다.

- 즉 4회 이동 후, 조건 중 하나라도 만족시키지 못할 것 같다 싶으면 아예 이동을 시도조차 할 수 없다는 의미가 됩니다.

- 위의 조건만 추가 된다면, 굉장히 쉬운 문제가 되어 버립니다.
*/