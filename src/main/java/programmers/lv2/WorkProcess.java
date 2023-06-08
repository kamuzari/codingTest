package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class WorkProcess {
	class Node{
		String name;
		String startTime;
		int playTime;

		public Node(String name,String time, int playTime){
			this.name=name;
			this.startTime=time;
			this.playTime=playTime;
		}

		public int toSeconds(){
			String s[] = startTime.split(":");

			return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
		}

		public String toString(){
			return String.format(" <name: %s, startTime: %s, playTime: %d> ",name, startTime, playTime);
		}

		public void minusPlayTime(int val){
			this.playTime -=val;
		}

	}
	public String[] solution(String[][] plans) {
		Stack<Node> waitings = new Stack<>(); // 가장 최근에 멈춘 과제 시작
		LinkedList<Node> works = new LinkedList<>(); // 작업 큐

		for (int i = 0; i < plans.length; i++) {
			works.add(new Node(plans[i][0], plans[i][1], parse(plans[i][2])));
		}

		Collections.sort(works, (a, b) -> a.toSeconds() - b.toSeconds());
		List<Node> answers = new ArrayList<>();
		// 핵심: 잠시 텀이 있으면 최근 과제부터 수행해야 한다.

		int cur = works.get(0).toSeconds();

		while (true) {
			boolean isOperationWaitings = true; // 대기큐를 가동시킬지

			if (!works.isEmpty()) {
				Node work = works.poll();
				if (!works.isEmpty()) {
					Node next = works.peek();
					if (work.toSeconds() + work.playTime <= next.toSeconds()) {
						answers.add(work);
						cur = work.toSeconds() + work.playTime;
					} else {
						// 최근에 들어간 작업은 대기큐에서 검사할 필요가 없기 때문에
						int diff = next.toSeconds() - work.toSeconds();
						work.minusPlayTime(diff);
						cur = next.toSeconds();
						waitings.push(work);
						isOperationWaitings = false;
					}
				} else {
					answers.add(work);
					cur = work.toSeconds() + work.playTime;
				}
			}

			if (isOperationWaitings) {
				// 다음 작업까지 여유가 있다면 웨이팅 큐에서 작업을 한다.
				while (!waitings.isEmpty()) {
					Node rest = waitings.peek();
					if (works.isEmpty()) {
						answers.add(waitings.pop());
					} else {
						Node next = works.peek();
						if (rest.playTime + cur <= next.toSeconds()) {
							answers.add(waitings.pop());
							cur = cur + rest.playTime;
						} else {

							int diff = next.toSeconds() - cur;
							rest.minusPlayTime(diff);
							cur = next.toSeconds();
							break;
						}
					}
				}
			}

			if (works.size() == 0 && waitings.size() == 0) {
				break;
			}

		}

		return answers.stream().map(answer -> answer.name).toArray(String[]::new);
	}

	void print(String s) {
		System.out.println(s);
	}

	int parse(String s) {
		return Integer.parseInt(s);
	}
}
