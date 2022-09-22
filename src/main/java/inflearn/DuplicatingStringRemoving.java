package inflearn;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicatingStringRemoving {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Set<String> chars = new LinkedHashSet<>();
		String input = in.next();

		for (int i = 0; i < input.length(); i++) {
			String ch = String.valueOf(input.charAt(i));
			chars.add(ch);
		}

		String answer = chars.stream().collect(Collectors.joining());

		System.out.println(answer);
	}
}
