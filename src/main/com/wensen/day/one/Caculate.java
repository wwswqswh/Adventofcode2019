package com.wensen.day.one;

public class Caculate {

	int compute(int mass){
		return compute(mass, 0);
	}
	
	int compute(int massToCalculate, int sum){
		int fuel = Math.floorDiv(massToCalculate, 3) - 2;
		if (fuel < 1) {			
			return sum;
		}
		else {
			sum += fuel;
			return compute(fuel, sum);
		}
	}
	
	public static void main(String[] args) {
		Caculate cal = new Caculate();
		System.out.println(cal.compute(100756));
	}
}
