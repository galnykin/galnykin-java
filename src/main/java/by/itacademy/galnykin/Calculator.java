package by.itacademy.galnykin;

public class Calculator implements ICalculator {

    @Override
    public int sum(int a, int b) {
        try {
            if (hasIntegerOverflowInSum(a, b)) {
                throw new ArithmeticException("Integer overflow in sum operation");
            }
            if (hasIntegerUnderFlowInSum(a, b)) {
                throw new ArithmeticException("Integer underflow in sum operation");
            }
            return a + b;
        } catch (ArithmeticException e) {
            System.err.println("Error in sum: " + e.getMessage());
            throw e;
        }
    }

    private static boolean hasIntegerOverflowInSum(int a, int b) {
        return b > 0 && a > Integer.MAX_VALUE - b;
    }

    private static boolean hasIntegerUnderFlowInSum(int a, int b) {
        return b < 0 && a < Integer.MIN_VALUE - b;
    }

    @Override
    public int subtract(int a, int b) {
        try {
            if (hasIntegerOverFlowInSubtraction(a, b)) {
                throw new ArithmeticException("Integer overflow in subtract operation");
            }
            if (hasIntegerUnderFlowInSubtraction(a, b)) {
                throw new ArithmeticException("Integer underflow in subtract operation");
            }
            return a - b;
        } catch (ArithmeticException e) {
            System.err.println("Error in subtract: " + e.getMessage());
            throw e;
        }
    }

    private static boolean hasIntegerUnderFlowInSubtraction(int a, int b) {
        return b > 0 && a < Integer.MIN_VALUE + b;
    }

    private static boolean hasIntegerOverFlowInSubtraction(int a, int b) {
        return b < 0 && a > Integer.MAX_VALUE + b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public double divide(int a, int b) {
        return (double) a / b;
    }
}
