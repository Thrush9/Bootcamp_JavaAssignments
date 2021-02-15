package com.stackroute.streams;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortingMapByValueTests {

	private static final String MSG_01 = "If mapItems is null should return Error Message as Please provide valid input";
	private static final String MSG_02 = "If mapItems is empty should return Error Message as Please provide valid input";
	private static final String MSG_03 = "If order is null should return Error Message as Please provide valid input";
	private static final String MSG_04 = "If order is empty should return Error Message as Please provide valid input";
	private static final String MSG_05 = "If order doesn't matches with given input should return Error Message as Please provide valid input";
	private static final String MSG_06 = "If given order is Descending, then should return map sorted by value in descending order";
	private static final String MSG_07 = "If given order is Ascending, then should return map sorted by value in ascending order";
	private static final String MSG_08 = "If given order is Any, then should return map sorted by value";
	private static final String MSG_09 = "If given mapItems caontains same values, then should return map sorted with identical values as per given order";


	private SortingMapByValue sortingMapByValue;
	private Map<String, String> errorMap;
	private Map<String, Integer> tobeSortedMap;

	@BeforeEach
	public void setUp() {
		sortingMapByValue = new SortingMapByValue();
		errorMap = new HashMap<String, String>();
		tobeSortedMap = new HashMap<String, Integer>();
	}

	@AfterEach
	public void tearDown() {
		sortingMapByValue = null;
	}

	@Test
	public void givensortingMapByValueWithMapItemsAsNull() {
		errorMap.put("error", "Please provide valid input");
		assertEquals(errorMap, sortingMapByValue.sortByValue(null, "Descending"), MSG_01);
	}

	@Test
	public void givensortingMapByValueWithMapItemsAsEmpty() {
		Map<String, Integer> tobeSortedMap = new HashMap<>();
		errorMap.put("error", "Please provide valid input");
		assertEquals(errorMap, sortingMapByValue.sortByValue(tobeSortedMap, "Descending"), MSG_02);
	}

	@Test
	public void givensortingMapByValueWithOrderAsNull() {
		tobeSortedMap.put("A", 40);
		tobeSortedMap.put("D", 80);
		tobeSortedMap.put("B", 05);
		tobeSortedMap.put("C", 14);
		errorMap.put("error", "Please provide valid input");
		assertEquals(errorMap, sortingMapByValue.sortByValue(tobeSortedMap, null), MSG_03);
	}

	@Test
	public void givensortingMapByValueWithOrderAsEmpty() {
		tobeSortedMap.put("A", 40);
		tobeSortedMap.put("D", 80);
		tobeSortedMap.put("B", 05);
		tobeSortedMap.put("C", 14);
		errorMap.put("error", "Please provide valid input");
		assertEquals(errorMap, sortingMapByValue.sortByValue(tobeSortedMap, ""), MSG_04);
	}

	@Test
	public void givensortingMapByValueWithOrderAsOther() {
		tobeSortedMap.put("A", 40);
		tobeSortedMap.put("D", 80);
		tobeSortedMap.put("B", 05);
		tobeSortedMap.put("C", 14);
		errorMap.put("error", "Please provide valid input");
		assertEquals(errorMap, sortingMapByValue.sortByValue(tobeSortedMap, "Other"), MSG_05);
	}

	@Test
	public void givensortingMapByValueWithOrderAsDescending() {
		tobeSortedMap.put("D", 80);
		tobeSortedMap.put("A", 40);
		tobeSortedMap.put("C", 14);
		tobeSortedMap.put("B", 05);
		assertEquals("{D=80, A=40, C=14, B=5}", sortingMapByValue.sortByValue(tobeSortedMap, "Descending").toString(), MSG_06);
	}

	@Test
	public void givensortingMapByValueWithOrderAsAscending() {
		tobeSortedMap.put("B", 05);
		tobeSortedMap.put("C", 14);
		tobeSortedMap.put("A", 40);
		tobeSortedMap.put("D", 80);
		errorMap.put("error", "Please provide valid input");
		assertEquals("{B=5, C=14, A=40, D=80}", sortingMapByValue.sortByValue(tobeSortedMap, "Ascending").toString(), MSG_07);
	}

	@Test
	public void givensortingMapByValueWithOrderAsAny() {
		tobeSortedMap.put("A", 40);
		tobeSortedMap.put("B", 05);
		tobeSortedMap.put("C", 14);
		tobeSortedMap.put("D", 80);
		assertEquals("{A=40, B=5, C=14, D=80}", sortingMapByValue.sortByValue(tobeSortedMap, "Any").toString(), MSG_08);
	}
	
	@Test
	public void givensortingMapByValueWithSameValuesAndAscendingOrder() {
		tobeSortedMap.put("B", 05);
		tobeSortedMap.put("B", 05);
		tobeSortedMap.put("A", 40);
		tobeSortedMap.put("D", 80);
		assertNotNull(sortingMapByValue.sortByValue(tobeSortedMap, "Ascending").get("A"));
		assertEquals(sortingMapByValue.sortByValue(tobeSortedMap, "Ascending").size(), 3);
		assertThat(sortingMapByValue.sortByValue(tobeSortedMap, "Ascending").size(), is(3));
		assertEquals(tobeSortedMap, sortingMapByValue.sortByValue(tobeSortedMap, "Ascending"), MSG_09);
	}
	
	@Test
	public void givensortingMapByValueWithSameValuesAndDescendingOrder() {
		tobeSortedMap.put("A", 40);
		tobeSortedMap.put("C", 05);
		tobeSortedMap.put("C", 05);
		tobeSortedMap.put("D", 80);
		assertEquals("{D=80, A=40, C=5}", sortingMapByValue.sortByValue(tobeSortedMap, "Descending").toString(), MSG_09);
	}

}
