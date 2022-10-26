package BubbleSort;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import Reader.FileStringGetter;

public class BubbleSortBench {
	public static void main(String args[]) throws IOException {

		FileStringGetter read = new FileStringGetter();

		List<String> list_words = read.getStringsFile("text.txt");

		for (int i = 1; i < list_words.size(); i++) {
			for (int b = 0; b < list_words.size() - i; b++) {
				if (list_words.get(b).compareTo(list_words.get(b + 1)) > 0) {
					String menor = list_words.get(b + 1);
					String maior = list_words.get(b);
					list_words.set(b, menor);
					list_words.set(b + 1, maior);
				}
			}
		}

		for (String each : list_words) {
			System.out.println(each);
		}

	}
}
