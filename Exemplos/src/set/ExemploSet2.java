package set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet2 {

	public static void main(String[] args) {
		
		/*
		 * atenção quanto ao Set: a comparação do Set é feito através de hashcode e equals,
		 * ou seja, se um objeto for verificado dentro de um set e ele não tiver o
		 * hashcode implementado, não será encontrado correspondência.
		 * 
		 * A treeSet exige que o objeto implemente "comparable", por se tratar de 
		 * uma collection ordenada.
		 */
		
		// construtor que recebe uma lista e trasforma em um set
		Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));
		
		// union
			//construtor que recebe outro set e cria uma copia
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println(c);
		
		// intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);

		// difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);

	}
}
