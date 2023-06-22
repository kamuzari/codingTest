package BaekJoon.tony.implementation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class FiveInARow {
	static Scanner sc=new Scanner(System.in);
	static int dirs[][]={
		{-1,0},
		{-1,-1},
		{0,-1},
		{1,-1},
		{1,0},
		{1,1},
		{0,1},
		{-1,1}
	};
	static int map[][];
	static boolean v[][][]; // 중요: 3차원 배열을 하는 이유는 방문 행 위주로 탐색하는데 다른 방향에서 오면 5개가완성되어 이길수 있는 경우가 있기 때문임.
	public static void main(String[] args) {
		map=new int[19][19];
		v=new boolean[8][19][19];

		for(int i=0; i<19; i++){
			StringTokenizer st=new StringTokenizer(sc.nextLine());
			for(int j=0; j<19; j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		boolean isRunnable=true;
		int flag=0;
		int y=0,x=0;
		for(int i=0; i<19; i++){
			for(int j=0; j<19; j++){
				int target=map[j][i];
				if(target == 0) continue;
				boolean isIssue=false;

				for(int k=0; k<8; k++){
					int count=getCount(j,i,k);
					if(count == 5){
						flag=target;
						y=j+1;
						x=i+1;
						isRunnable=false;
					}
					// 6ㄱㅐ가 포함되면 해당 오목이 있는 경우는 이긴 경우를 아니게 침
					if(count>=6){
						// 이미 1,1 -> (2,1) 방향으로 6개가 있는데 (1,1) -> (2,1)로 가면 5개가 되는 오목이 이긴걸로 간주한다. 이건 될 수 없음!!에 유의해야함
						isIssue=true;
					}
				}

				if(isIssue){
					isRunnable=true;
				}

				if(!isRunnable){
					break;
				}
			}
			if(!isRunnable){
				break;
			}
		}
		print(String.valueOf(flag));
		if(flag != 0){
			print(y+" "+x);
		}
	}

	static int getCount(int y,int x,int dir){
		int target=map[y][x];
		v[dir][y][x]=true;
		int answer=1;

		while(true){
			y+=dirs[dir][0];
			x+=dirs[dir][1];

			if(isOutOf(y,x) || v[dir][y][x]){
				break;
			}

			if(map[y][x] != target){
				break;
			}

			v[dir][y][x]=true;
			answer++;
		}

		return answer;
	}

	static boolean isOutOf(int ny,int nx){
		return ny<0 || nx<0 || ny>=19 || nx>=19;
	}

	static void print(String s){
		System.out.println(s);
	}
}
