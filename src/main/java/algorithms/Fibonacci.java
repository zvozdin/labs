package algorithms;

public class Fibonacci {
    public static int fibonacci(int n) {
        return (n <= 1) ? 1 : fibonacci(n-1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }
}
