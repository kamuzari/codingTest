package oneDay_twoSol.Greedy2.Grouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] crane = new Integer[n];
        for (int i = 0; i < n; i++) {
            crane[i] = sc.nextInt();
        }

        Arrays.sort(crane, Collections.reverseOrder());

        int m = sc.nextInt();
        ArrayList<Integer> box = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            box.add(sc.nextInt());
        }
        Collections.sort(box, Collections.reverseOrder());
        // logic

        int cnt = 0;
        if (crane[0] < box.get(0)) {
            System.out.println(-1);
        } else {
            while (box.size()!=0) {
                int j=0;
                for (int i = 0; i <n ; i++) {
                    if(j==box.size())
                        break;
                    if(box.get(j)<=crane[i])
                    {
                        box.remove(j);
                        continue;
                    }
                    else if(box.get(j)>crane[i])
                    {
                        j++;
                    }
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
/*
3
1 2 3
6
2 2 2 2 2 2*/
