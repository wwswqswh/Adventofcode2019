package com.wensen.day.two;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DealPuzzle {

	public LinkedList<Code> formatePuzzle(int[] puzzle) {
		LinkedList<Code> codeList = new LinkedList<>();
		if(puzzle == null) {
			return codeList;
		}
		for(int i=0;i<=puzzle.length-1;i++) {
			Code code = new Code();
			code.setPosition(i);
			code.setValue(puzzle[i]);
			if(i>0) {
				codeList.getLast().setNext(code);
			}
		}
		return codeList;
	}
	
	public HashMap<Integer,Integer> dealOpcodeOne(Map<Integer,Integer> puzzleMap){
		
		return null;
	}
}
