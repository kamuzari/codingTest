package BaekJoon.tony.implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ecosystem {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> trees = new HashMap<>();

		while (sc.hasNextLine()) {
			String tree = sc.nextLine();

			if (tree == null || tree.equals("") || tree.trim().length() == 0) {
				break;
			}

			trees.put(tree, trees.getOrDefault(tree, 0) + 1);
		}

		Integer total = trees.values().stream().reduce(0, Integer::sum);
		List<String> names = trees.keySet().stream().sorted().collect(Collectors.toList());
		names.forEach(name -> {
			Integer count = trees.get(name);
			double percent = (double)count / total * 100.0;
			String answer = String.format("%s %.4f", name, percent);
			System.out.println(answer);
		});
	}
}
