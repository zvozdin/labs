package algorithms;

public class WhiteCrowTest1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 4};
        int position = WhiteCrow.find(nums);

        int expexted = 6;
        if (position == expexted) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
            System.out.println("Was: " + position + " but expected " + expexted);
        }
    }
}
