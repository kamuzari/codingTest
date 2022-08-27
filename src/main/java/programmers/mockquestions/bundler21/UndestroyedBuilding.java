package programmers.mockquestions.bundler21;

public class UndestroyedBuilding {
	int b[][];
	public int solution(int[][] board, int[][] skill) {
		return getAnswer(board, skill);
	}

	/**
	 * note: 효율성 0%
	 */
	private int getAnswer(int[][] board, int[][] skill) {
		final int ATTACK=1;
		final int HEAL=2;
		b= board;

		for(int[] acts : skill){
			if(acts[0]==ATTACK){
				react(-acts[5],acts[1],acts[2],acts[3],acts[4]);
			}else if(acts[0]==HEAL){
				react(acts[5],acts[1],acts[2],acts[3],acts[4]);
			}
		}

		return getLiveBuilder();
	}

	public void react(int action, int r1,int c1,int r2,int c2){
		for(int i=r1; i<r2+1; i++){
			for(int j=c1; j<c2+1; j++){
				b[i][j]+=action;
			}
		}
	}

	public int getLiveBuilder(){
		int count=0;

		for(int i=0; i<b.length; i++){
			for(int j=0; j<b[i].length;j++){
				if(b[i][j]>0){
					count++;
				}
			}
		}

		return count;
	}
}
