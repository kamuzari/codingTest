package oneDay_twoSol.Greedy2.Grouping;

import java.util.*;

public class Chaining {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr); // 3 4 5 7 9
        int cnt=0;
        while (true)
        {
            if(arr.size()<=1) // 한번에 두개가 사라지면 ==1 이 이난 <=1 작은 값으로 루프문을 탈출해야 한다.
            {
                break;
            }
            arr.set(0,arr.get(0)-1); //
            arr.remove(arr.size()-1);
            if(arr.get(0)==0)
                arr.remove(0) ;
            cnt++;
        }
        System.out.println(cnt);


    }
}
