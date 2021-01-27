package oneDay_twoSol.Implementaion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Truck {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        int N=parser(str[0]); // 트럭의 개수
        int W=parser(str[1]); // 다리의 길이
        int L=parser(str[2]); // 다리의 최대 하중.
        int truck[]=new int[N];
        String str2[]=sc.nextLine().split(" ");
        for (int i = 0; i <str2.length ; i++) {
            truck[i]=parser(str2[i]);
        }
        int current_Weight=0;
        int cnt=0;
        Queue <Integer> bridge=new LinkedList<>();
        for (int i = 0; i <N ; i++) {
            while (true)
            {
                if(bridge.size()==W)
                {
                    current_Weight-= bridge.poll();
                }
                if(current_Weight+truck[i]<=L) // 그 다음 틀럭을 태우기에 무게가 아직 적절하다면 break하여 해당 다리에 트럭을 넣어준후 현재 적정하중에 트럭의 무게를 더해줌과 동시에 cnt를 증가한다.
                    break;
                bridge.add(0);
                cnt++;
//                System.out.println(cnt +"   "+ bridge );
            }
            bridge.add(truck[i]);
            current_Weight+=truck[i];
            cnt++;
//            System.out.println(cnt +"   "+ bridge );
        }
        System.out.println(cnt+W); // 마지막 인자에 담긴 트럭의 무게는 연산을 수행하지 않고 마지막올라탓을때 다리의 길이만큼 이동하기 떄문에 다리의 길이를 더해준다.
    }
    static int parser(String str)
    {
        return Integer.parseInt(str);
    }
}
