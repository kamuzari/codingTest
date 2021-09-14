package tues_thurs_sat._202109._20210903;

import java.util.Arrays;
// https://programmers.co.kr/learn/courses/30/lessons/42884
public class CrackDownCamera {
    public static void main(String[] args) {
        int r[][]={{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        CrackDownCamera crackDownCamera = new CrackDownCamera();
        System.out.println(crackDownCamera.solution(r));

    }
    public int solution(int [][] routes)
    {
        int answer=0;
        Arrays.sort(routes,(o1, o2) -> {
            return o1[1]-o2[1];
        });
        int camPosition=-30001;
        for (int[] route : routes) {
            if(camPosition<route[0])
            {
                camPosition=route[1];
                answer++;
            }
        }
        return answer;
    }
}
