package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class app {
	public static void main(String[] args) {

		List<Product> lista = new ArrayList<>();
		
		lista.add(new Product("TV", 990.00));
		lista.add(new Product("Notebook", 5990.00));
		lista.add(new Product("tablet", 2990.00));
		
		//classe anonima
		Comparator<Product> comp = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};
		
		// abaixo está a mesma implementação com expressão lambda
		
		Comparator<Product> comp2 = (p1, p2) -> {
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		};
		
		Comparator<Product> comp3 = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

		lista.sort(comp);
		
		// ou simplesmente colocar a expressao no lugar do parametro

		lista.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
	}

}
