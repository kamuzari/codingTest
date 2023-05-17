package BaekJoon.tony.simulation;

import java.util.Scanner;
import java.util.StringTokenizer;

class RollDice {
	static Scanner sc=new Scanner(System.in);
	static StringTokenizer st;
	static int dice[]={0,0,0,0,0,0}; // 위 앞 오 왼 뒤 아래
	/**
	 *  동쪽으로 굴리면
	 */
	static int dirs[][]={
		{0,1}, // 동
		{0,-1}, // 서
		{-1,0}, // 북
		{1,0} // 남
	};
	static int n,m;
	public static void main (String[] args) throws java.lang.Exception {

		st=token();
		n=parse(next());
		m=parse(next());
		int y=parse(next());
		int x=parse(next());
		int cmd=parse(next());
		int[][] arr=new int[n][m];

		for(int i=0; i<n; i++){
			st=token();
			for(int j=0; j<m; j++){
				arr[i][j]=parse(next());
			}
		}

		int[] cmds=new int[cmd];
		st=token();
		for(int i=0; i<cmd; i++){
			cmds[i]=parse(next());
		}

		for(int dir: cmds){
			dir--;

			y=y+dirs[dir][0];
			x=x+dirs[dir][1];

			if(isOutOfRange(y,x)) {
				y=y-dirs[dir][0];
				x=x-dirs[dir][1];
				continue;
			}

			int temp=0;
			//  0. 1  2. 3. 4. 5
			// 위 앞 오 왼 뒤 아
			if(dir==0){ // 동쪽으로 굴리기
				int newArr[]= new int[dice.length];
				newArr[0] = dice[3];
				newArr[1]= dice[1];
				newArr[2]= dice[0];
				newArr[3]= dice[5];
				newArr[4]= dice[4];
				newArr[5]= dice[2];
				dice=newArr;
			}else if(dir==1){ // 서쪽으로 굴리기
				int newArr[]= new int[dice.length];
				newArr[0] = dice[2];
				newArr[1]= dice[1];
				newArr[2]= dice[5];
				newArr[3]= dice[0];
				newArr[4]= dice[4];
				newArr[5]= dice[3];
				dice=newArr;
			}else if(dir==2){ // 남쪽으로 굴리기
				int newArr[]= new int[dice.length];
				newArr[0] = dice[1];
				newArr[1]= dice[5];
				newArr[2]= dice[2];
				newArr[3]= dice[3];
				newArr[4]= dice[0];
				newArr[5]= dice[4];
				dice=newArr;
			}else if(dir==3){ // 북쪽으로 굴리기
				int newArr[]= new int[dice.length];
				newArr[0] = dice[4];
				newArr[1]= dice[0];
				newArr[2]= dice[2];
				newArr[3]= dice[3];
				newArr[4]= dice[5];
				newArr[5]= dice[1];
				dice=newArr;
			}else
				throw new RuntimeException("??");

			//  print("dice ==> "+ Arrays.toString(dice));

			if(arr[y][x] == 0){
				// 좌표에 쓰기
				arr[y][x]=dice[5];
			}else{
				// 바닥 숫자 흡수
				dice[5]=arr[y][x];
				arr[y][x]=0;
			}

			print(String.valueOf(dice[0]));
		}

	}

	static boolean isOutOfRange(int ny,int nx){
		return ny<0 || nx<0 || ny>=n || nx>=m;
	}

	static String next(){
		return st.nextToken();
	}

	static StringTokenizer token(){
		return new StringTokenizer(line());
	}

	static void print(String s){
		System.out.println(s);
	}

	static String line(){
		return sc.nextLine();
	}

	static int parse(String s){
		return Integer.parseInt(s);
	}
}
