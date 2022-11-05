package SelectionSort;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import Reader.FileStringGetter;

public class SelectionSortBench {

	public static void main(String args[]) throws IOException {
		FileStringGetter read = new FileStringGetter();

		List<String> list_words = read.getStringsFile("text.txt");

		int lower = 0;
		for (int i = 0; i < list_words.size(); i++) {
			lower = i;
			for (int b = i; b < list_words.size(); b++) {
				if (list_words.get(lower).compareTo(list_words.get(b)) > 0) {
					lower = b;
				}
			}
			String menor = list_words.get(lower);
			String maior = list_words.get(i);
			list_words.set(i, menor);
			list_words.set(lower, maior);

		}

		for (String each : list_words) {
			System.out.println(each);
		}

	}

}
