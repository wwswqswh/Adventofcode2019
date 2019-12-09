package com.wensen.day.fourth;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class GitProject {
	   public static void main(String[] args) {

	        int bottomBound = 382345;
	        int topBound = 843167;
	        int amountFirst = 0;
	        int amountSecond = 0;
	        List<Integer> resultList = new ArrayList<>();
	        for (int value = bottomBound; value <= topBound; value++) {
	            if (isIncreased(value) & containsDouble(value)) {
	                amountFirst++;
	            }
	            if (isIncreased(value) & containsUniqueDouble(value)) {
	            	resultList.add(value);
	                amountSecond++;
	            }
	        }
	        System.out.println("Part one: " + amountFirst);
	        System.out.println("Part two: " + amountSecond);
	        System.out.println(JSON.toJSONString(resultList));


	    }

	    private static boolean isIncreased(int digit) {
	        int[] dArray = intToArray(digit);
	        for (int i = 0; i < dArray.length - 1; i++) {
	            if (dArray[i] > dArray[i + 1]) {
	                return false;
	            }
	        }
	        return true;
	    }

	    private static boolean containsDouble(int digit) {
	        int[] dArray = intToArray(digit);
	        for (int i = 0; i < dArray.length - 1; i++) {
	            if (dArray[i] == dArray[i + 1]) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private static boolean containsUniqueDouble(int digit) {
	        int[] dArray = intToArray(digit);
	        int[] count = new int[10];
	        for (int elem : dArray) {
	            count[elem]++;
	        }
	        for (int elem : count) {
	            if (elem == 2) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private static int[] intToArray(int digit) {
	        String temp = Integer.toString(digit);
	        int[] dArray;
	        dArray = new int[temp.length()];
	        for (int i = 0; i < temp.length(); i++) {
	            dArray[i] = Integer.parseInt(temp.substring(i, i + 1));
	        }
	        return dArray;
	    }
}
