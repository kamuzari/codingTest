package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class EducationArchitect {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String answer = "YES";
		String preRequisites = reader.readLine();
		String input = reader.readLine();

		Queue<Character> requiredSubjects = new LinkedList<>();

		for (char subject : preRequisites.toCharArray()) {
			requiredSubjects.offer(subject);
		}

		for (char next : input.toCharArray()) {
			if (requiredSubjects.contains(next)) {
				if (requiredSubjects.poll() != next) {
					answer = "NO";
					break;
				}
			}
		}

		if (!requiredSubjects.isEmpty()) {
			answer = "NO";
		}

		System.out.println(answer);
	}
}
