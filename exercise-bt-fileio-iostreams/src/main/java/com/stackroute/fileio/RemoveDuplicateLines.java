package com.stackroute.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLines {
	// write logic to read data from input.txt and write result to output.txt
	public void removeDuplicateLines() throws IOException {

		String firstFile = "input.txt";
		String secondFile = "output.txt";
		FileInputStream source = new FileInputStream(firstFile);
		FileOutputStream target = new FileOutputStream(secondFile);

		BufferedReader br = new BufferedReader(new InputStreamReader(source));
		String line1 = br.readLine();
		Set<String> lines = new HashSet<String>();
		while (line1 != null) {
			if (lines.add(line1)) {
				line1 += "\n";
				byte[] x = line1.getBytes();
				target.write(x);
			}
			line1 = br.readLine();
		}
		br.close();
		target.close();
	}
}
