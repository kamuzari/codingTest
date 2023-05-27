package BaekJoon.tony.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PostOffice {
	public static void main (String[] args) throws java.lang.Exception {
		Reader reader=new Reader();
		int n=reader.n;
		long x[][]=reader.arr;

		// 우체국 위치를 정하는 문제이다.
		// 각 사람들까지의 거리의 합이 최소가 되는 위치
		// 사람이 많은 마을에게 가까워야 한다.
		long total = Arrays.stream(x).map(a -> a[1]).reduce(0L,Long::sum);

		Arrays.sort(x,(a,b)->{
			if(a[0] == b[0] ){
				return (int) (b[0]- a[0]);
			}

			return (int) (a[0] -b[0]);
		});

		long sum=0;
		for(long[] vals: x){
			sum+=vals[1];

			if(sum >= (total+1)/2){ //현재 인원이 과반수 이상일 경우 현재 위치를 우체국으로 택해야 각 사람들까지의 거리의 합이 최소가 될 수 있다.
				print(String.valueOf(vals[0]));
				break;
			}
		}

	}

	static void print(String s){
		System.out.println(s);
	}

	static class Reader{
		static Scanner sc=new Scanner(System.in);
		static StringTokenizer st;
		int n;
		long [][]arr;

		public Reader(){
			n=toInt(sc.nextLine());
			arr=new long[n][2];

			for(int i=0; i<n; i++){
				createToken();
				arr[i][0]=toLong(st.nextToken());
				arr[i][1]=toLong(st.nextToken());
			}
		}

		private static int toInt(String s){
			return Integer.parseInt(s);
		}

		private static long toLong(String s){
			return Long.parseLong(s);
		}

		private static void createToken(){
			st=new StringTokenizer(sc.nextLine());
		}

	}
}
