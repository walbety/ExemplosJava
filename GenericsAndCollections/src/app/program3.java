package app;

import java.util.Arrays;
import java.util.List;

public class program3 {
	public static void main(String[] args) {
		
		List<Integer> listInt = Arrays.asList(2,45,3,1,5);
		printList(listInt);
		
		List<String> listString = Arrays.asList("maria", "joao", "gloria");
		printList(listString);
		
	}
	
	// method that can print any list
	public static void printList(List<?> list) {
		// list.add(3) <- compilation error
		for (Object object : list) {
			System.out.println(object);
		}
	}

}
