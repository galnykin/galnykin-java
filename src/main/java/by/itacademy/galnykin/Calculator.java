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

    private boolean hasIntegerOverflowInSum(int a, int b) {
        return b > 0 && a > Integer.MAX_VALUE - b;
    }

    private boolean hasIntegerUnderFlowInSum(int a, int b) {
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

    private boolean hasIntegerUnderFlowInSubtraction(int a, int b) {
        return b > 0 && a < Integer.MIN_VALUE + b;
    }

    private boolean hasIntegerOverFlowInSubtraction(int a, int b) {
        return b < 0 && a > Integer.MAX_VALUE + b;
    }

    @Override
    public int multiply(int a, int b) {
        try {
            checkForIntegerUnderFlowInMultiply(a, b);
            checkForIntegerOverFlowInMultiply(a, b);
            return a * b;
        } catch (ArithmeticException e) {
            System.err.println("Error in multiply: " + e.getMessage());
            throw e;
        }
    }

    private void checkForIntegerUnderFlowInMultiply(int a, int b) {
        if (a > 0 && b < 0 && b < Integer.MIN_VALUE / a) {
            throw new ArithmeticException("Integer underflow in multiply operation");
        }
    }

    private void checkForIntegerOverFlowInMultiply(int a, int b) {
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b) {
            throw new ArithmeticException("Integer overflow in multiply operation");
        }
        if (a < 0 && b > 0 && a < Integer.MIN_VALUE / b) {
            throw new ArithmeticException("Integer overflow in multiply operation");
        }
        if (a < 0 && b < 0 && a < Integer.MAX_VALUE / b) {
            throw new ArithmeticException("Integer overflow in multiply operation");
        }
    }

    @Override
    public double divide(int a, int b) {
        try {
            if (hasDivisionByZero(b)) {
                throw new ArithmeticException("Division by zero is not allowed");
            }
            if (hasIntegerOverFlowInDivision(a, b)) {
                throw new ArithmeticException("Integer overflow in division operation");
            }
            return (double) a / b;
        } catch (ArithmeticException e) {
            System.err.println("Error in divide: " + e.getMessage());
            throw e;
        }
    }

    private boolean hasDivisionByZero(int b) {
        return b == 0;
    }

    private boolean hasIntegerOverFlowInDivision(int a, int b) {
        return a == Integer.MIN_VALUE && b == -1;
    }
}
