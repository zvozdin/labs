package algorithms;

public class Quiz10 {
    public static void main(String[] args) {
        System.out.println(f(5, 3));
    }
    public static int f(int a, int b) {
        return (b == 0) ? a : 1 + f(a, b - 1);
    }
}
