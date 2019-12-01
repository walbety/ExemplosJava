package services;

import java.util.List;

public class CalculationService {

	// this '? super T' means 'this type or any super type that implements Comparable'
	public static <T extends Comparable<? super T>> T max(List<T> list) {
		
		if(list.isEmpty()) {
			throw new IllegalArgumentException("empty list");
		}
		
		T max = list.get(0);
		
		for (T item : list) {
			if(item.compareTo(max)>0) {
				max = item;
			}
		}
		
		
		return max;
	}
	
}
