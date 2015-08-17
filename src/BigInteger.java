import java.util.ArrayList;

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(isNegative) {
            sb.append('-');
        }

        for(int value : values) {
            sb.append(value);
        }

        return sb.toString();
    }

    public BigInteger plus(BigInteger other) {
        return null;
    }

    public BigInteger minus(BigInteger other) {
        return null;
    }

    public BigInteger divideBy(BigInteger other) {
        return null;
    }

    public BigInteger multiplyBy(BigInteger other) {
        return null;
    }

    public boolean greaterThan(BigInteger other) {
        return false;
    }

    public boolean lessThan(BigInteger other) {
        return other.greaterThan(this);
    }

    /* Greatest Common Divisor */
    public BigInteger gcd(BigInteger other) {
        return null;
    }
}
