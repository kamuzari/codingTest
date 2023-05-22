package codeTree;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class OperatorDeploy {
	static Scanner sc=new Scanner(System.in);
	static StringTokenizer st;

	static Stack<Integer> pickOpers=new Stack<>();
	static int n;
	static int[] val,oper;
	static int min =Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		st=token();
		n=parse(next());

		val=create(n);
		oper=create(3);

		pick(0);

		print(min+" "+max);
	}

	static void pick(int cnt){
		if(cnt == n-1){
			int valIdx=0;
			int result=val[valIdx++];

			// 연산자 우선순위 무시한다.
			for(Integer oper : pickOpers){
				result = translate(oper,result,val[valIdx++]);
			}

			min=Math.min(result,min);
			max=Math.max(result,max);
			return;
		}

		for(int i=0; i<3; i++){
			if(oper[i]==0) continue;
			oper[i]--;
			pickOpers.push(i);
			pick(cnt+1);
			pickOpers.pop();
			oper[i]++;
		}


	}

	static int translate(int operIdx,int front,int back){
		switch(operIdx){
			case 0: return front+back;
			case 1: return front-back;
			case 2: return front*back;
		}

		throw new RuntimeException("translate method error...");
	}


	static int[] create(int n){
		st=token();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=parse(next());
		}

		return arr;
	}

	static void print(String s){
		System.out.println(s);
	}

	static StringTokenizer token(){
		return new StringTokenizer(sc.nextLine());
	}

	static String next(){
		return st.nextToken();
	}

	static int parse(String s){
		return Integer.parseInt(s);
	}
}
