package BaekJoon.tony.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class CleanUpFolder {

	private static Map<String, Set<String>> folders;
	private static Map<String, Set<String>> files;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		int folderCount = Integer.parseInt(st.nextToken());
		int fileCount = Integer.parseInt(st.nextToken());

		folders = new HashMap<>();
		folders.put("main", new HashSet<>());
		files = new HashMap<>();
		files.put("main", new HashSet<>());

		for (int i = 0; i < fileCount + folderCount; i++) {
			String[] command = reader.readLine().split(" ");
			String upper = command[0];
			String putTarget = command[1];
			int type = Integer.parseInt(command[2]);

			if (type == 1) {
				if (!folders.containsKey(upper)) {
					folders.put(upper, new HashSet<>());
				}

				folders.get(upper).add(putTarget);

			} else if (type == 0) {
				if (!files.containsKey(upper)) {
					files.put(upper, new HashSet<>());
				}

				files.get(upper).add(putTarget);
			}
		}

		StringBuilder answers = new StringBuilder();
		int questionCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < questionCount; i++) {
			String[] searchTree = reader.readLine().split("/");

			String target = searchTree[searchTree.length - 1];
			notDuplicateFiles = new HashSet<>();
			totalFileCount = 0;
			Set<String> file = files.get(target);
			if (file != null) {
				totalFileCount = file.size();
				notDuplicateFiles.addAll(file);
			}
			search(target);
			answers.append(notDuplicateFiles.size()).append(" ").append(totalFileCount).append(System.lineSeparator());
		}

		System.out.println(answers);
	}

	static Set<String> notDuplicateFiles;
	static int totalFileCount = 0;

	static void search(String target) {
		if (!folders.containsKey(target)) {
			return;
		}

		for (String nextFolder : folders.get(target)) {
			if (files.containsKey(nextFolder)) {
				Set<String> fileList = files.get(nextFolder);
				totalFileCount += fileList.size();
				notDuplicateFiles.addAll(fileList);
			}
			
			search(nextFolder);
		}
	}
}
