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
		String sanitised;
		Calculation c;
		while(input.hasNextLine()) {
			sanitised = sanitise(input.nextLine());
			if (!Character.isDigit(sanitised.charAt(0))) {
				;
			} else {
				c = makeCalc(sanitised);
				System.out.println("# " + doCalc(c));
			}
		} 
		input.close();
	}

	public static String sanitise(String s) {
		String pattern = "(\\d+) ([\\+\\-\\*\\/\\<\\>\\=]|gcd) (\\d+)";
		Pattern p;
		Matcher m;
		
		try {
			if (s.charAt(0) == '#') { // If it is a comment
				return "#";
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

	public static Calculation makeCalc(String s) {
		Calculation c;
		int i, j=0;
		String first = null, operand = null, last = null;
		int psi = 0;
		for (i=0; i<s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (j == 0) {
					first = s.substring(psi, i);
					psi = i+1;
					j++;
				} else if (j == 1) {
					operand = s.substring(psi, i);
					psi = i+1;
				}
			}
		}
		last = s.substring(psi, s.length());
		/*System.err.println("first: " + first + "\nlast: " + last +
			"\noperand: " + operand);*/
		return c = new Calculation(first, operand, last);
	}

	public static String doCalc(Calculation c) {
		char function = c.getOp().charAt(0);
		BigInteger first = new BigInteger(c.getFirst());
		BigInteger last = new BigInteger(c.getLast());
		String result = null;
		switch (function) {
			case '+':
				first = first.plus(last);
				result = first.toString();
				break;
			case '-':
				break;
			case '*':
				break;
			case '/':
				break;
			case '<':
				break;
			case '>':
				break;
			case '=':
				break;
			case 'g':
				break;
		}
		return result;
	}

}
