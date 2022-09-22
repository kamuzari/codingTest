package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SpecialStringReversing {
	private static final Pattern ONLY_ENGLISH = Pattern.compile("^[a-zA-Z]*$");

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String input = reader.readLine();

		char[] chars = input.toCharArray();
		int end = input.length() - 1;

		for (int i = 0; i < chars.length / 2; i++) {
			if (isEnglish(String.valueOf(chars[i]))) {
				char temp = chars[i];
				chars[i] = chars[end - i];
				chars[end - i] = temp;
			}
		}

		System.out.println(String.valueOf(chars));
	}

	private static boolean isEnglish(String val) {
		return ONLY_ENGLISH.matcher(val).matches();
	}
}
