import java.util.ArrayList;

public class BigInteger {

    private ArrayList<Integer> values;
    boolean isNegative;
    public static final int NUMBER_CHAR = 5;
    public static final int MAX = 99999;//(10 ^ NUMBER_CHAR) - 1;

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

    public BigInteger(String input) {
        values = new ArrayList<Integer>();
        for(int i = input.length(); i >= 0; i -= 5) {
            int to = i - 5;
            if(to < 0) {
                to = 0;
            }
            int toAdd = Integer.parseInt(input.substring(to, i));
            values.add(toAdd);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(isNegative) {
            sb.append('-');
        }

        for(int i = values.size() - 1; i >= 0; i--) {
            sb.append(values.get(i));
        }

        return sb.toString();
    }

    public BigInteger plus(BigInteger other) {
        int smallest = values.size();
        if(smallest > other.values.size()) {
            smallest = other.values.size();
        }

        for(int i = 0; i < smallest; i++) {
            int newValue = values.get(i) + other.values.get(i);
            if(newValue > MAX) {
                newValue -= MAX;
                values.set(i + 1, values.get(i + 1));
            }
            values.set(i, newValue);
        }
        return this;
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
