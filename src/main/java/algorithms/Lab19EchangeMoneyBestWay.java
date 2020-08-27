package algorithms;

public class Lab19EchangeMoneyBestWay {
    private static final int[] coinNominals = new int[]{1, 2, 5, 10, 25, 50};

    public static int getCombinations(int sum) {
        if (sum <= 0) {
            return 0;
        }

        int nominalsCount = coinNominals.length;
        int[][] combinations = new int[sum + 1][nominalsCount];

        for (int i = 0; i < nominalsCount; i++) {
            combinations[0][i] = 1;
        }

        for (int number = 1; number <= sum; number++) {
            for (int nominalsIndex = 0; nominalsIndex < nominalsCount; nominalsIndex++) {
                int current = 0;
                if (number >= coinNominals[nominalsIndex]) {
                    int rest = number - coinNominals[nominalsIndex] ;
                    current = combinations[rest][nominalsIndex];
                }
                int previous = 0;
                if (nominalsIndex >= 1) {
                    previous = combinations[number][nominalsIndex - 1];
                }
                combinations[number][nominalsIndex] = current + previous;
//                debug(combinations);
            }
        }
        return combinations[sum][nominalsCount - 1];
    }

    private static void debug(int[][] cache) {
        String result = "\t\t";

        for (int x = 0; x < coinNominals.length; x++) {
            result += coinNominals[x] + "\t";
        }
        result += '\n';

        for (int y = 0; y < cache.length; y++) {
            result += "[" + y + "] \t";
            for (int x = 0; x < coinNominals.length; x++) {
                result += cache[y][x] + "\t";
            }
            result += '\n';
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println(getCombinations(50));
    }
}
