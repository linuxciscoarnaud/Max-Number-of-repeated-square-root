/**
 * 
 */
package com.square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arnaud
 *
 */
public class SquareBetweenInterval {

	/**
	 * @param args
	 */
	
	List <Integer> startFromList = new ArrayList<Integer>();
	Map <Integer, List<Integer>> startFrom_ListSquareRoot_Map = new HashMap<Integer, List<Integer>>();
	
	private void getExistingSubSquarest(int B) {
		List <Integer> tmpList = new ArrayList<Integer>();
		int tmpVal = B;
		while (B - ((int) Math.sqrt(B) * (int) Math.sqrt(B)) == 0) {
			B = (int) Math.sqrt(B);
			tmpList.add(B);
		}
		startFrom_ListSquareRoot_Map.put(tmpVal, tmpList);
	}
	
	public void solution(int A, int B) {
		
		for (int i = A; i <= B; i++) {
			for (int k = 1; k * k <= i; k++) {
				if (k * k == i) {
					this.startFromList.add(i);
				}				
			}
		}
		
		for (Integer num : startFromList) {
			getExistingSubSquarest(num);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SquareBetweenInterval allQquares = new SquareBetweenInterval();

		allQquares.solution(6000, 7000);
		System.out.println("Number(s): " + allQquares.startFromList);
		System.out.println();
		for (Integer elt : allQquares.startFrom_ListSquareRoot_Map.keySet()) {
			System.out.println("Starting from " + elt+ ", we have " + 
		                       allQquares.startFrom_ListSquareRoot_Map.get(elt).size() + 
		                       " square root as follow: " + 
		                       allQquares.startFrom_ListSquareRoot_Map.get(elt));
		}
	}
}
