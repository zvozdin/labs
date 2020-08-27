package algorithms;

import java.util.Stack;

public class Lab16Exchange {
    public static void exchange(Stack from, Stack help, Stack to, int count) {
        if (count > 0) {
            exchange(from, to, help, count - 1);
            int biggest = (int) from.pop();
            to.push(biggest);
            exchange(help, from, to, count - 1);
        }
    }
}
