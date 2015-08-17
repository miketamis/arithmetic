import java.util.Scanner;
import java.util.regex.*;

/**
 * Created with IntelliJ IDEA.
 * User: mtamis
 * Date: 8/17/15
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			System.out.println(sanitize(input.nextLine()));
		} 
		input.close();
	}

	public static String sanitize(String s) {
		String pattern = "(\\d+) ([\\+\\-\\*\\/\\<\\>\\=]|gcd) (\\d+)";
		Pattern p;
		Matcher m;
		
		try {
			if (s.charAt(0) == '#') { // If it is a comment
				return "";
			}
		} catch (IndexOutOfBoundsException e) {
			/*System.err.println("IndexOutOfBoundsException: " +
				e.getMessage());*/
			return "Syntax error";
		}

		p = Pattern.compile(pattern);
		m = p.matcher(s);
		if (m.matches()) {
			return s;
		} else {
			return "Syntax error";
		}
			
	}	

}
