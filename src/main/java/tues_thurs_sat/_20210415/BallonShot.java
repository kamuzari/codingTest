package tues_thurs_sat._20210415;

import java.util.HashSet;

public class BallonShot {
    public static void main(String[] args) {

    }
    // 왼쪽 오른쪽 끝에 위치한 값은 무조건 살아남는다.
    // 중간에서 좌우가 중간값이 좌우에 있는 값보다 작다면 살아남을 수 없다.

    public int solution(int[] a) {
        int answer = 0;
        HashSet<Integer> set=new HashSet<>();
        int min=a[0];
        for (int i = 1; i < a.length; i++) {
            set.add(min);
            min=Math.min(min,a[i]);
        }
        min=a[a.length-1];
        for (int i = a.length-2; i >-1; i--) {
            set.add(min);
            min=Math.min(min,a[i]);
        }
        return set.size();
    }
}
