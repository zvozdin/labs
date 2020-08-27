package algorithms;

public class FactorialRecurcia {
    public static int factorial(int n) {
        return  (n == 0) ? 1 : n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
}
