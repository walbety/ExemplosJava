package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.CalculationService;

public class Program2 {
	public static void main(String[] args) {
		
	
		List<Product> list = new ArrayList<>();
		
		String path = "D:\\temp\\arqs\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			Product x = CalculationService.max(list);
			System.out.println("max: " + x.getName() + " " + x.getPrice());
			
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
	
	}
}
