package BaekJoon.tony.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sensor {

	/**
	 * 요구사항
	 * n개중 k개의 센서를 설치해야 한다.
	 * 집중국의 수신 가능 영역의 길이의 합을 최소화 해야한다.
	 *
	 * 이해가 안된 부분
	 *  - 집중국이 어떻게 통신을 하는지 머릿속에 그려지지 않음.
	 *
	 * 고속도로 위에 K개의 집중국 세울 수 있다. (ok)
	 * 각 집중국은 센서의 수신 가능 영역을 조절할 수 있다. ?
	 * 집중국의 수신 가능 영역은 고속도로 상에서 연결된 구간으로 나타나게 된다. ?
	 * 집중국 유지비 문제로 각 집중국의 수신 가능 영역의 길이의 합을 최소화 해야한다. ?
	 *
	 * 여기서 물어보는게 집중국을 어떻게 위치시켜야 수신 가능 영역의 길이의 합을 최소로 만들 수 있는지 구하는 문제인가?
	 *  예제1번 기반으로 해본 결과 정답이 도출되었다.
	 *
	 * 문제로만 이해하기 어렵다.
	 *  1. 고속도로 위에 K개의 집중국 세울 수 있다.
	 *  2. 각 집중국은 센서의 수신 가능 영역을 조절할 수 있다. ? (무슨말이지 pass)
	 *  3. 집중국의 수신 가능 역역은 고속도로 상에서 연결된 구간으로 나타나게 된다 ? (무슨말이지? pass)
	 *  4 . 유지비 문제로 각 집중국의 수신 가능 영역의 길이의 합을 최소화 해야 한다.
	 *
	 *
	 */
	static Scanner sc=new Scanner(System.in);
	static StringTokenizer st;
	public static void main (String[] args) throws java.lang.Exception {
		st=token();
		int n = parse(next());
		st=token();
		int k = parse(next());
		st=token();

		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=parse(next());
		}

		Arrays.sort(arr);
		// print(Arrays.toString(arr));
		List<Integer> list=new ArrayList<>();

		for(int i=1; i<n; i++){
			list.add(arr[i]-arr[i-1]);
		}

		Collections.sort(list);
		// print(list.toString());

		int answer=0;
		for(int i=0; i<n-k; i++){
			answer+=list.get(i);
		}

		print(String.valueOf(answer));
	}

	static void print(String s){
		System.out.println(s);
	}

	static String line(){
		return sc.nextLine();
	}

	static StringTokenizer token(){
		return new StringTokenizer(line());
	}

	static String next(){
		return st.nextToken();
	}

	static int parse(String s){
		return Integer.parseInt(s);
	}
}
