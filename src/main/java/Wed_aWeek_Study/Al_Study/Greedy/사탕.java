package Wed_aWeek_Study.Al_Study.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 사탕 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        while (T-- > 0) {
            String str[] = sc.nextLine().split(" ");
            int candy = Integer.parseInt(str[0]);
            int box = Integer.parseInt(str[1]);
            while (box-- > 0) {
                String boxStr[] = sc.nextLine().split(" ");
                int capacity = Integer.parseInt(boxStr[0]) * Integer.parseInt(boxStr[1]);
                arr.add(capacity);
            }
            Collections.sort(arr);
            Collections.reverse(arr);
            int i=0;
            while (candy>0)
            {
                candy-=arr.get(i);
                i+=1;
            }
            System.out.println(i);
            arr.clear();
        }
    }
}
