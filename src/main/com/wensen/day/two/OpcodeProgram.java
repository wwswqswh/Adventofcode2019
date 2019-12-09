package com.wensen.day.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpcodeProgram {

	
	public static void main(String[] args) {
//		partOne();
		partTwo();
	}
	// Part Two
	private static void partTwo() {
		Integer[] puzzleBefore = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,19,1,19,6,23,2,6,23,27,2,27,9,31,1,5,31,35,1,35,10,39,2,39,9,43,1,5,43,47,2,47,10,51,1,51,6,55,1,5,55,59,2,6,59,63,2,63,6,67,1,5,67,71,1,71,9,75,2,75,10,79,1,79,5,83,1,10,83,87,1,5,87,91,2,13,91,95,1,95,10,99,2,99,13,103,1,103,5,107,1,107,13,111,2,111,9,115,1,6,115,119,2,119,6,123,1,123,6,127,1,127,9,131,1,6,131,135,1,135,2,139,1,139,10,0,99,2,0,14,0};
		List<Integer> pList = new ArrayList<Integer>(Arrays.asList(puzzleBefore));
		Integer[] puzzle = {};
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				puzzle = pList.toArray(new Integer[pList.size()]);
				puzzle[1]=i;
				puzzle[2]=j;
				for(int k=0;k<=puzzle.length-1;k++) {
					if(puzzle[k]==1) {
						try {
							puzzle[puzzle[k+3]] = puzzle[puzzle[k+1]] + puzzle[puzzle[k+2]];
						}catch(Exception e) {
							break;
						}
						k += 3;
					}
					if(puzzle[k]==2) {
						try {
							puzzle[puzzle[k+3]] = puzzle[puzzle[k+1]] * puzzle[puzzle[k+2]];
						}catch(Exception e) {
							break;
						}
						k += 3;
					}
					if(puzzle[k] == 99) {
						break;
					}
				}
				if(puzzle[0] == 19690720) {
					System.out.println(puzzle[1]);
					System.out.println(puzzle[2]);
					System.out.println(puzzle[1]*100+puzzle[2]);
					return;
				}
				//System.out.println(puzzle[0]);
			}
		}
	}
	//	Part 1
	private static void partOne() {
		int[] puzzle = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,19,1,19,6,23,2,6,23,27,2,27,9,31,1,5,31,35,1,35,10,39,2,39,9,43,1,5,43,47,2,47,10,51,1,51,6,55,1,5,55,59,2,6,59,63,2,63,6,67,1,5,67,71,1,71,9,75,2,75,10,79,1,79,5,83,1,10,83,87,1,5,87,91,2,13,91,95,1,95,10,99,2,99,13,103,1,103,5,107,1,107,13,111,2,111,9,115,1,6,115,119,2,119,6,123,1,123,6,127,1,127,9,131,1,6,131,135,1,135,2,139,1,139,10,0,99,2,0,14,0};
		puzzle[1]=12;
		puzzle[2]=2;
		for(int i=0;i<=puzzle.length-1;i++) {
			System.out.println(i);
			if(puzzle[i]==1) {
				puzzle[puzzle[i+3]] = puzzle[puzzle[i+1]] + puzzle[puzzle[i+2]];
				i += 3;
			}
			if(puzzle[i]==2) {
				puzzle[puzzle[i+3]] = puzzle[puzzle[i+1]] * puzzle[puzzle[i+2]];
				i += 3;
			}
			if(puzzle[i] == 99) {
				break;
			}
		}
		System.out.println(puzzle[0]);
	}
}
