package Basic.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RotateQueue {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        for (int i = 1; i < n + 1; i++) {
            arr.add(i);
        }
        String str2[] = br.readLine().split(" ");
        int x[] = new int[str2.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = Integer.parseInt(str2[i]);
        }
        int cnt = 0;
        int mid = arr.size() / 2;

        for (int i = 0; i < x.length; i++) {
            while (true) {
                int search_id = arr.indexOf(x[i]);
                if (search_id == 0) {
                    arr.remove(0);
                    mid = arr.size() / 2;
                    break;

                } else if (search_id > mid) {
                    arr.add(0, arr.get(arr.size() - 1));
                    arr.remove(arr.size() - 1);
                    cnt++;
                } else if (search_id <= mid) {
                    arr.add(arr.get(0));
                    arr.remove(0);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
