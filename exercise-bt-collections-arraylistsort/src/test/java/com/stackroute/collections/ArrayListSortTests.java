package com.stackroute.collections;

import com.stackroute.collections.ArrayListSort;
import org.junit.jupiter.api.*;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArrayListSortTests {
    private ArrayListSort arrayListSort;

    private static final String MESSAGE = "Check the logic of your arrayListSortDesc method";

    @BeforeEach
    public void setUp() {
        arrayListSort = new ArrayListSort();
    }

    @AfterEach
    public void tearDown() {
        arrayListSort = null;
    }

    @Test
    public void givenArrayListWithNumbersThenReturnResult() {
        ArrayList<BigInteger> list = new ArrayList<>();
        list.add(new BigInteger("988"));
        list.add(new BigInteger("3284"));
        list.add(new BigInteger("21"));
        list.add(new BigInteger("4"));
        list.add(new BigInteger("31"));
        list.add(new BigInteger("0"));
        ArrayList<BigInteger> output = new ArrayList<>();
        output.add(new BigInteger("3284"));
        output.add(new BigInteger("988"));
        output.add(new BigInteger("31"));
        output.add(new BigInteger("21"));
        output.add(new BigInteger("4"));
        output.add(new BigInteger("0"));
        assertEquals(output, arrayListSort.arrayListSortDesc(list), MESSAGE);
    }

    @Test
    public void givenArrayListWithLargerNumbersThenReturnResult() {
        ArrayList<BigInteger> list = new ArrayList<>();
        list.add(new BigInteger("34682832947923943298579834759843798592387839234325432"));
        list.add(new BigInteger("981234098240983298490321256847923049302843098932"));
        list.add(new BigInteger("734276432493298562374932487239434372445483594757"));
        list.add(new BigInteger("324497239490234093248092304203480932840328049832"));
        list.add(new BigInteger("1231323432143254354656765879045902945092835093853294879"));
        ArrayList<BigInteger> output = new ArrayList<>();
        output.add(new BigInteger("1231323432143254354656765879045902945092835093853294879"));
        output.add(new BigInteger("34682832947923943298579834759843798592387839234325432"));
        output.add(new BigInteger("981234098240983298490321256847923049302843098932"));
        output.add(new BigInteger("734276432493298562374932487239434372445483594757"));
        output.add(new BigInteger("324497239490234093248092304203480932840328049832"));
        assertEquals(output, arrayListSort.arrayListSortDesc(list), MESSAGE);
    }

    @Test
    public void givenArrayListWithNegativeNumbersThenReturnResult() {
        ArrayList<BigInteger> list = new ArrayList<>();
        list.add(new BigInteger("-346"));
        list.add(new BigInteger("-981"));
        list.add(new BigInteger("-42"));
        list.add(new BigInteger("-44"));
        list.add(new BigInteger("-50"));
        list.add(new BigInteger("-1"));
        ArrayList<BigInteger> output = new ArrayList<>();
        output.add(new BigInteger("-1"));
        output.add(new BigInteger("-42"));
        output.add(new BigInteger("-44"));
        output.add(new BigInteger("-50"));
        output.add(new BigInteger("-346"));
        output.add(new BigInteger("-981"));
        assertEquals(output, arrayListSort.arrayListSortDesc(list), MESSAGE);
    }

    @Test
    public void givenArrayListWithLargerNegativeNumbersThenReturnResult() {
        ArrayList<BigInteger> list = new ArrayList<>();
        list.add(new BigInteger("-346903832747329847"));
        list.add(new BigInteger("-981245739712973472"));
        list.add(new BigInteger("-4213435316436243256423"));
        list.add(new BigInteger("-4413243241451325"));
        list.add(new BigInteger("-50613631463165134561346"));
        list.add(new BigInteger("-53214534534561"));
        ArrayList<BigInteger> output = new ArrayList<>();
        output.add(new BigInteger("-53214534534561"));
        output.add(new BigInteger("-4413243241451325"));
        output.add(new BigInteger("-346903832747329847"));
        output.add(new BigInteger("-981245739712973472"));
        output.add(new BigInteger("-4213435316436243256423"));
        output.add(new BigInteger("-50613631463165134561346"));
        assertEquals(output, arrayListSort.arrayListSortDesc(list), MESSAGE);
    }

    @Test
    public void givenEmptyArrayListThenReturnResult() {
        ArrayList<BigInteger> list = new ArrayList<>();
        ArrayList<BigInteger> output = new ArrayList<>();
        assertEquals(output, arrayListSort.arrayListSortDesc(list), MESSAGE);
    }

    @Test
    public void givenArrayListThenReturnResultNotNull() {
        ArrayList<BigInteger> list = new ArrayList<>();
        assertNotNull(arrayListSort.arrayListSortDesc(list), MESSAGE);
    }
}
