package com.stackroute.collections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class NumComp implements Comparator<BigInteger>{
	
	@Override
	public int compare(BigInteger one, BigInteger two) {
		int status = one.compareTo(two);
		int result =0;
		if (status == 0) {
			result = 0;
		}else if (status == 1) {
			result = -1;
		} else if (status == -1) {
			result= 1;
		}
		return result;	
	}
} 

public class ArrayListSort {
    //write logic to sort given list in descending order
    public static ArrayList<BigInteger> arrayListSortDesc(ArrayList<BigInteger> list) {
    	
    	//Collections.sort(list, Collections.reverseOrder());
    	Collections.sort(list, new NumComp());    	
    	return list;
    	
    } 
}
