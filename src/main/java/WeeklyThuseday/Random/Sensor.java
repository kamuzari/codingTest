package WeeklyThuseday.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 문제 이해 x.
public class Sensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> arr = new ArrayList<>();
        List<Long> diff = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (n > k) { //
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextLong());
            }
            Collections.sort(arr);
            for (int i = 0; i < n - 1; i++) {
                diff.add(arr.get(i + 1) - arr.get(i));
            }
            Collections.sort(diff);
            k = k - 1;
            while (k-- > 0) { // n이 k보다 작을 때 즉 k가 n보다 큰 수일 때. 없는 diff에서 remove를 하므로 오류가 난다.
                diff.remove(diff.size() - 1);
            }
        }

        long ans = 0;
        for (long a : diff)
            ans += a;

        System.out.println(ans);
    }
}
