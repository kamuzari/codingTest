package programmers.mockquestions.bundle23;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PressDownKeyPad {
	class Node{
		private int y,x;

		public Node(int y,int x){
			this.y=y;
			this.x=x;
		}

		public int getDist(Node comp){
			return Math.abs(this.y-comp.y)+Math.abs(this.x - comp.x);
		}

		@Override
		public String toString(){
			return this.y +", "+this.x;
		}
	}
	private Map<String,Node> positions=new HashMap<>();
	private Set<String> lefts=Set.of("1","4","7","*");
	private Set<String> rights=Set.of("3","6","9","#");

	public String solution(int[] numbers, String hand) {
		positions.put("1",new Node(0,0));
		positions.put("4",new Node(1,0));
		positions.put("7",new Node(2,0));
		positions.put("*",new Node(3,0));

		positions.put("2",new Node(0,1));
		positions.put("5",new Node(1,1));
		positions.put("8",new Node(2,1));
		positions.put("0",new Node(3,1));

		positions.put("3",new Node(0,2));
		positions.put("6",new Node(1,2));
		positions.put("9",new Node(2,2));
		positions.put("#",new Node(3,2));

		StringBuilder answer=new StringBuilder();

		Node curLeft=positions.get("*");
		Node curRight=positions.get("#");

		for(int val: numbers){
			String key=Integer.toString(val);

			if(lefts.contains(key)){
				curLeft=positions.get(key);
				answer.append("L");
			}else if(rights.contains(key)){
				curRight=positions.get(key);
				answer.append("R");
			}else{
				Node willPad=positions.get(key);

				int dist1 = curLeft.getDist(willPad);
				int dist2 = curRight.getDist(willPad);

				if(dist1>dist2){
					curRight=willPad;
					answer.append("R");
				}else if(dist1<dist2){
					curLeft=willPad;
					answer.append("L");
				}else{
					System.out.println(hand);
					if(hand.equals("right")){
						curRight=willPad;
						System.out.println("right");
						answer.append("R");
					}else if(hand.equals("left")){
						curLeft=willPad;
						answer.append("L");
					}else{
						System.out.println("ssibal");
					}
				}
			}
		}

		return answer.toString();
	}
}
