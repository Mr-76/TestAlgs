package Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStringGetter {

	/**
	 * Method reads a file, line by line and returns an array of strings,with the
	 * contends.
	 *
	 * @para name_of_file Name of the file to read.
	 * @return An array with the contends of the read file.
	 *
	 */
	public List<String> getStringsFile(String name_of_file) throws IOException {
		List<String> list = new ArrayList<String>();
		BufferedReader buffer_read = new BufferedReader(new FileReader(name_of_file));
		
		String line = "";
		while (line != null) {
			line = buffer_read.readLine();
			if (line == null) {
				continue;
			}
			list.add(line);
		}
		buffer_read.close();
		return list;
	}
}
