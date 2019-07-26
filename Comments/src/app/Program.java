package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Comments;
import entities.Post;

public class Program {
	
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


	public static void main(String[] args) throws ParseException {
		Comments c1 = new Comments("comentario 1");
		Comments c2 = new Comments("comentario 2");

		Post post1 = new Post("viajei", 2, DATE_FORMAT.parse("22/02/1992 13:33:00"));
		post1.addComment(c1);
		post1.addComment(c2);
		
		System.out.println(post1);
	}
	
}
