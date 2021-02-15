package com.stackroute.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class BookTitleSearcher {

	public Optional<List<String>> getBookList(List<String> list, String search) {
		
		List<String> bookList = new ArrayList<>();
		if (list != null && !list.isEmpty() && search != null && search != "") {
			for (String book : list) {
				if (book.contains(search))
					bookList.add(book);
			}
			return Optional.of(bookList);
		} else
			return Optional.empty();
		
	}

	public Optional<List<String>> searchBookNames(List<String> list, Predicate<String> pre) {
		
		List<String> bookList = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			for (String book : list) {
				if (pre.test(book))
					bookList.add(book);
			}
			return Optional.of(bookList);
		} else
			return Optional.empty();
		
	}

}
