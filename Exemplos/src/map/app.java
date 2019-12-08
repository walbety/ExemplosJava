package map;

import java.util.Map;
import java.util.TreeMap;

public class app {

	public static void main(String[] args) {
		Map<String, String> cookies = new TreeMap<>();
		
		cookies.put("username", "Maria");
		cookies.put("email", "maria@gmail");
		cookies.put("telefone", "990789");
		// como um map não aceita repetições, caso seja adicionado outro chave-valor com
		// a mesma chave, o valor será sobrescrito
		
		cookies.remove("email");
		
		
		System.out.println("ALL COOKIES: ");
		
		for(String key : cookies.keySet()) {
			// o metodo .keySet() retorna um set, podendo percorre-lo no for
			
			System.out.println(key + ": " + cookies.get(key));
		}
		
		
		
	}

}
