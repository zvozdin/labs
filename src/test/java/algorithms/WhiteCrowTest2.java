package algorithms;

public class WhiteCrowTest2 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 3, 1, 2, 3};
        int position = WhiteCrow.find(nums);

        int expexted = 0;
        if (position == expexted) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
            System.out.println("Was: " + position + " but expected " + expexted);
        }
    }
}
