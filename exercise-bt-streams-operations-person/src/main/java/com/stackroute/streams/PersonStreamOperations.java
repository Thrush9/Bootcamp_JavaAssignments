package com.stackroute.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * This class has various methods to do stream operations on person collection
 */
public class PersonStreamOperations {

	/**
	 * sorts the person list alphabetically in uppercase Returns Empty Optional if
	 * the given list is null or empty
	 *
	 * @param personList
	 * @return
	 */
	public Optional<List<String>> getPersonListSortedByNameInUpperCase(List<String> personList) {
		List<String> searchList = null;
		if (personList == null || personList.size() == 0) {
			return Optional.empty();
		} else {
			searchList = personList.stream().filter((person) -> person.trim().length() > 0)
					.map((person) -> person.toUpperCase()).sorted().collect(Collectors.toList());
			if (searchList.isEmpty())
				return Optional.empty();
			else
				return Optional.of(searchList);
		}
	}

	/**
	 * Sorts the distinct person names in descending order Returns empty set if the
	 * given list is empty or null
	 *
	 * @param personList
	 * @return
	 */

	public Set<String> getDistinctPersonNamesSortedInDescendingOrder(List<String> personList) {
		Set<String> searchList = new HashSet<>();
		List<String> sortedList = new ArrayList<>();
		if (personList == null || personList.size() == 0) {
			return searchList;
		} else {
			sortedList = personList.stream().filter((person) -> person.trim().length() > 0)
					     .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			searchList = new LinkedHashSet<String>(sortedList);
			return searchList;
		}
	}

	/**
	 * Returns "Person found" if the person searched is available in the list or
	 * else returns "Person not found" Returns "Give proper input not null" if the
	 * given list or name to search is null
	 *
	 * @param personList
	 * @return
	 */
	public String searchPerson(List<String> personList, String nameToSearch) {
		String result = "";
		if (personList == null || personList.size() == 0 || nameToSearch == "" || nameToSearch == null) {
			return "Give proper input not null";
		} else {
			List<String> search = personList.stream().filter((person) -> person.equalsIgnoreCase(nameToSearch))
					              .collect(Collectors.toList());
			if (search.size() > 0)
				return "Person found";
			else
				return "Person not found";
		}
	}

	/**
	 * Filters the list whose name length is greater than five and sorts by name
	 * length Returns empty list if the given list is empty or null
	 *
	 * @param personList
	 * @return
	 */

	public List<String> getPersonListSortedByLengthWithNameLengthGreaterThanFive(List<String> personList) {
		List<String> searchList = new ArrayList<>();
		if (personList == null || personList.size() == 0) {
			return searchList;
		} else {
			searchList = personList.stream().filter((person) -> person.trim().length() > 5)
					.sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
			return searchList;
		}
	}

	/**
	 * Returns the person name having maximum age from the given Map<String,Integer>
	 * having name as key and age as value Returns "Give proper input not null" if
	 * the given map is empty or null
	 *
	 * @param personMap
	 * @return
	 */

	public String getPersonByMaxAge(Map<String, Integer> personMap) {
		if (personMap == null || personMap.size() == 0) {
			return "Give proper input not null";
		} else {
			String max= personMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
			return max;
		}
	}

}
