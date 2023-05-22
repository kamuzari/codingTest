package codeTree;

import java.util.Scanner;
import java.util.StringTokenizer;

public class VirusTest {
	static Scanner sc=new Scanner(System.in);
	static StringTokenizer st;
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		int n=parse(line()); // 식당의 개수
		int customers[]=new int[n];
		st=token();
		for(int i=0; i<n; i++){
			customers[i]=parse(next());
		}
		st=token();
		int leaderMax=parse(next());
		int normalMax=parse(next());

		long answer=0;
		for(int i=0; i<n; i++){
			answer++; // 팀장

			int customer =customers[i];
			customer-=leaderMax;
			if(customer<0){
				continue;
			}

			int q= customer / normalMax;
			answer+=q;

			int rest= customer % normalMax;
			if(rest!=0){
				answer++;
			}
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
