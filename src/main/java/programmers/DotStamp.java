package programmers;

public class DotStamp {

	/**
	 * note: 한칸식 전진하는 스텝은 4개 빼고 나머지 TLE 발생
	 *  풀이: 점과 점 사이의 거리 공식을 이용하여 x축을 구하고 거기에서 y축의 최대값을 구하여 그 안에서 배수의 개수로 나누어 구함.
	 *   - 즉, x를 정해버리고 y가 될 수 있는 수를 찾음.
	 * @param k: 방향 백터 배수
	 * @param d: 원점과의 거리 제한 길이
	 * @return
	 */
	public long solution(int k, int d) {
		long answer = 0;
		long dSquare= (long)d*d; // d*d 했는데 자료형 int형 자료형 범위 overflow해서 2,3,4 .. [틀림]
		for(int i=0; i<=d; i+=k){
			long xSquare= (long) i*i; // [위와 동일한 문제 발생.]
			long maxY=(long) Math.pow((dSquare - xSquare),0.5);
			answer+=((maxY/k) + 1);
		}

		return answer;
	}

}
