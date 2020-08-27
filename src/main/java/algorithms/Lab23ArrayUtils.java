package algorithms;

public class Lab23ArrayUtils {
    public static int[][][] rotateClockwise(int[][][] arg) {
        if (arg == null) {
            return null;
        } else if (arg.length == 0) {
            return null;
        }
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] == null) {
                return null;
            } else if (arg[i].length == 0) {
                return null;
            } else if (arg.length != arg[i].length) {
                return null;
            }
            for (int j = 0; j < arg[0].length; j++) {
                if (arg[i][j] == null) {
                    return null;
                } else if (arg[i][j].length == 0) {
                    return null;
                } else if (arg[i].length != arg[i][j].length) {
                    return null;
                }
            }
        }

        int[][][] argCopy = new int[arg.length][arg[0].length][arg[0][0].length];

        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[0].length; j++) {
                for (int h = 0; h < arg[0][0].length; h++) {
                    argCopy[i][h][j] = arg[j][i][h];
                }
            }
        }
        return argCopy;
    }
}
