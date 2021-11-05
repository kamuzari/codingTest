package Programmers.ProgrammersKit.SummerIntern;

public class BaseStationInstall {
    public static void main(String[] args) {
//        System.out.println(solution(11,new int[]{4,11},1));
        System.out.println(solution(16,new int[]{9},2));
    }
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;//기지국을 설치 idx
        int idx = 0;//존재하는 기지국 인덱스

        while(location <= n) {//위치가 전체 갯수보다 작거나 같을 때까지

            //현재 위치가 설치된 기지국의 범위보다 클 때,
            if (idx < stations.length && location >= stations[idx]-w) {

                location = stations[idx]+w+1;//설치된 기지국의 오른쪽 범위보다 +1 큰 위치로 이동
                idx++;
            } else {//설치된 기지국 범위 밖일 때,

                location += 2*w+1;//양쪽으로 범위를 가질 최댓값 +1을 해준다.  위에 if 문에서 설치 location을 재 정의 하므로 재정의값을 기지국 거리의 오른쪽 범위보다 1큰 곳으로 옮긴다.
                answer++;//기지국을 설치했으므로, 결과값을 추가
            }
        }

        return answer;
    }
}
