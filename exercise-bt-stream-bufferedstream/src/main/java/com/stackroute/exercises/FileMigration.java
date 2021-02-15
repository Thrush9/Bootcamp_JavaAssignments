package com.stackroute.exercises;

import java.io.*;

public class FileMigration {

	// Write here logic to read content of first file and write it in second file
	public String fileContentDuplicator(String firstFile, String secondFile) throws IOException {
		
		String output = "Given fileName to read or write is empty, null or blank space";
		
		if (firstFile == null || firstFile == "" || firstFile == " " || secondFile == null || secondFile == "" || secondFile == " ") {
			return output;
		} else if(!firstFile.contains(".txt") || !secondFile.contains(".txt")){
			throw new IOException("Invalid File Format");
		} else {
			FileInputStream source = new FileInputStream(firstFile.trim());
			FileOutputStream target = new FileOutputStream(secondFile.trim());

			BufferedInputStream bfin = new BufferedInputStream(source);
			BufferedOutputStream bfout = new BufferedOutputStream(target);
			
			StringBuffer sb = new StringBuffer();
			BufferedReader breader = new BufferedReader(new InputStreamReader(source));
			String line = breader.readLine();
			
			while ( line != null) {
                byte[] var = line.getBytes();
				sb.append(line);
				bfout.write(var);
				line = breader.readLine();
			}
			bfin.close();
			bfout.close();
			output = sb.toString();
		}
		return output;
	}
}
