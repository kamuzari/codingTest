package oneDay_twoSol.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Scale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr2 = new ArrayList<>();
        int n = sc.nextInt();
        int sum = 1;
        for (int i = 0; i < n; i++) {
            arr2.add(sc.nextInt());
        }
        Collections.sort(arr2);
        System.out.println(arr2);
        // sum 전까지 만드는 것을 보장한다.,
        for (int i = 0; i <arr2.size() ; i++) {
            System.out.print(arr2.get(i)+" ");
            //  각 원소가 지금까지 더한값보다 작아야 그보다 작은 것을 계속적으로 그 수를 만든다는 보장이 있다.
            // 계속적으로 첫번째 인덱스를 가지고 1을 만들수 있으며 그다음 1이라는 원소로 첫번째 1,두번째 1을가지고 2까지 만들수 있고 그 전에 1,1,은 2를 만들 수 있으므로 이제 2원소를 보면 1+1 보다 작기
            // 때문에 2를 포함시켜 1~4까지의 수를 만들수 있다. 또한 그다음 3을 더하므로 1부터 7까지 만들 수 있다. 쭈욱 이어가다가 30이라는 원소에 다달을 때까지의 합이 작으므로 만들 수 없는 수가 발생한다.
            if(sum< arr2.get(i))
                break;
            sum+=arr2.get(i);
            System.out.println(sum);
        }
        System.out.println();
        System.out.println(sum);
    }
}
