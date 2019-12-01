package app;

import java.util.List;

import entities.Shape;

public class program4 {
	public static void main(String[] args) {
		
	}
	
	public static double totalArea(List<? extends Shape> list) {
		double sum = 0.0d;
		for (Shape shape : list) {
			sum += shape.area();
		}
		return sum;
	}
	
	public static void copy(List<? extends Number>source, List<? super Object> destiny) {
		for (Number number : source) {
			destiny.add(number);
		}
		
	}

}
