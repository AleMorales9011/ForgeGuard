package Top10;

public class MinMaxFinder {
    public static int[] findMinMax(int[] nums) {
        int min = 0;
        int max = 0;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] result = findMinMax(array);
        System.out.println("Smallest: " + result[0]);
        System.out.println("Biggest: " + result[1]);
    }
}
