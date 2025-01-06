package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d {
	public static void main(String[] args) {
		int[][] points = new int[3][2];
		Map<Integer, Integer> xMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> yMap = new HashMap<Integer, Integer>();
		
		for(int[] point: points) {
			xMap.put(point[0], xMap.getOrDefault(point[0], 0)+1);
			yMap.put(point[0], xMap.getOrDefault(point[0], 0)+1);
		}
		
		int missingX=0;
		int missingY=0;
		
		for(Map.Entry<Integer, Integer> entry : xMap.entrySet()) {
			if(entry.getValue() == 1) {
				missingX = entry.getKey();
				break;
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
			if(entry.getValue() == 1) {
				missingY = entry.getKey();
				break;
			}
		}
		
		int[] ans = new int[2];
		ans[0] = missingX;
		ans[1] = missingY;
		
		System.out.println(Arrays.toString(ans));
		
	}
}
