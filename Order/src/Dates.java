import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date x1 = new Date(); // instancia com a data e o momento atual
		
		Date y1 = sdf1.parse("25/06/2018");
		Date y2 = sdf2.parse("25/06/2018 15:42:07");
		
		
		System.out.println(sdf2.format(y1));
		System.out.println(sdf2.format(y2));
		
	}
	
}
