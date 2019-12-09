package interfaceFuncional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import comparator.Product;

public class Program {
	
	/*
	 * Interfaces funcionais s�o interfaces com apenas um m�todo definido.
	 * Este m�todo pode ser substituido por uma express�o lambda.
	 */
	
	public static void main(String[] args) {
		List<Product> lista = new ArrayList<Product>();
		
		lista.add(new Product("TV", 900.00));
		lista.add(new Product("pendrive", 35.00));
		lista.add(new Product("mousepad", 55.00));
		lista.add(new Product("tablet", 1500.00));
		
		Predicate<Product> pred = p -> p.getPrice() >= 100;
		
		lista.removeIf(pred);
		
		//ou
		
		lista.removeIf(p -> p.getPrice() >= 100);
		
		for(Product prod : lista) {
			System.out.println(prod.getName());
		}
	}

}
