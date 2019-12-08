package linguagemFuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import comparator.Product;

public class Program {

	public static int compareProducts(Product p1, Product p2) {
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
	}

	public static void main(String[] args) {

		List<Product> lista = new ArrayList<>();

		lista.add(new Product("TV", 990.00));
		lista.add(new Product("Notebook", 5990.00));
		lista.add(new Product("tablet", 2990.00));
		
		
		// sintaxe para referenciar uma fun��o/m�todo de uma classe.
		// algumas fun��es recebem outra fun��o como par�metro.
		// muito comum em programa��o funcional
		lista.sort(Program::compareProducts);
		
		// ---------------------------
		/*
		 * Expressividade / c�digo conciso
		 * 
		 */
		
		Integer sum = 0;
		List<Integer> list = Arrays.asList(0,3,4,1,2,7,4);
		for(Integer x : list) {
			sum += x;
		}
		// ou
		sum = list.stream().reduce(0, Integer::sum);

	}

}
