package com.stackroute.commonjavaclasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBNValidator {

	public ISBNValidator() {

	}

	public Integer validateISBNNumber(String source) throws NumberFormatException {

		if (source == "" || source == null) {
			return -1;
		} else {
			int len = source.length();
			Pattern format = Pattern.compile("^[0-9]*$");
			Matcher matcher = format.matcher(source);
			boolean matches = matcher.matches();

			if (!matches) {
				throw new NumberFormatException("Invalid Format");
			} else {
				if (len == 10 && matches) {
					String[] a = source.split("");
					int total = 0, result, x;
					for (String s : a) {
						x = Integer.parseInt(s);
						total = total + len * x;
						len--;
					}
					result = ((total % 11) == 0 ? 1 : 0);
					return result;
				} else
					return 0;
			}
		}
	}
}
