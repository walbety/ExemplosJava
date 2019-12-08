package set;

import java.util.HashSet;
import java.util.Set;

public class ExemploSet {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		set.add("Tv");
		set.add("Notebook");
		set.add("tablet");
		
//		set.remove("Tv");
		set.removeIf(x -> x.charAt(0) == 'T');
		
		for (String string : set) {
			System.out.println(string);
		}

	}
}
