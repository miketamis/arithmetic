import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mtamis
 * Date: 8/17/15
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class BigInteger {

    private ArrayList<Integer> values;
    boolean isNegative;

    public BigInteger() {
        this(0);
    }

    public BigInteger(int i) {
        values = new ArrayList<Integer>();
        if(i < 0) {
            isNegative = true;
            values.add(-i);
        } else {
            isNegative = false;
            values.add(i);
        }
    }
}
