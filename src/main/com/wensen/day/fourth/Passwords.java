package com.wensen.day.fourth;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ToStringSerializer;

public class Passwords {

	/**
	 * PartOne
	 * 1. from left to right numbers must be increase
	 * 2. include as least two same numbers adjacent
	 * 3. range from 382345 to 843167
	 * Q:How many different passwords within the range given to you?
	 * 
	 * PartTwo
	 * 1. the two adjacent matching digits are not part of a larger group of matching digits.
	 * Q:How many different passwords within the range given to you?
	 * @param args
	 */
	public static void main(String[] args) {
		int min = 382345;
		int max = 843167;
		List<String> resultList = new ArrayList<>();
		// PartOne
		for(int candidate = min;candidate <= max; candidate++) {
			if(!ruleOne(String.valueOf(candidate)))continue;
			if(!ruleTwo(String.valueOf(candidate)))continue;
			resultList.add(String.valueOf(candidate));
		}
		System.out.println(resultList.size());
		System.out.println(JSON.toJSONString(resultList));
		
		// PartTwo
		ruleThree(resultList);
	}
	
	/*
	 * contains unique double
	 * 只要有2个一模一样
	 */
	private static void ruleThree(List<String> resultList) {
		List<String> partTworesult = new ArrayList<>();
		resultList.forEach(item -> {
			if(dealwithCandidate(item)) {
				partTworesult.add(item);
			}
		});
		System.out.println(partTworesult.size());
		System.out.println(JSON.toJSONString(partTworesult));
	}

	private static boolean dealwithCandidate(String item) {
		List<String> numbers = new ArrayList<>();
		StringBuffer tempNum = new StringBuffer();
		tempNum.append(item.charAt(0));
		for(int i=1;i<item.length();i++) {
			if(item.charAt(i-1) != item.charAt(i)) {
				numbers.add(tempNum.toString());
				tempNum.delete(0, tempNum.length());
				tempNum.append(item.charAt(i));
			}else {
				tempNum.append(item.charAt(i));
			}
		}
		numbers.add(tempNum.toString());
		for(String number : numbers) {
			if(number.length() == 2) {
				return true;
			}
		}
		return false;
	}

	private static boolean ruleTwo(String candidate) {
		
		for(int i = 0;i<candidate.length()-1;i++) {
			if(candidate.charAt(i) == candidate.charAt(i+1)) {
				return true;
			}
		}
		return false;
	}


	private static boolean ruleOne(String candidate) {
		
		for(int i = 1;i<candidate.length();i++) {
			if(Integer.valueOf(candidate.charAt(i)) < Integer.valueOf(candidate.charAt(i-1))) {
				return false;
			}
		}
		return true;
	}
}
