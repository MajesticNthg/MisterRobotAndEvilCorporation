import java.util.Arrays;

public class Level1 {
    public static boolean MisterRobot(int N, int[] data) {
        int[] copyData = Arrays.copyOf(data, N);
        Arrays.sort(copyData);
        int[] sortData = Arrays.copyOf(data, N);

        for (int x = 1; x < N - 1; x++) {
            int[] copyResult = Arrays.copyOf(sort(sortData, sortData[x - 1], sortData[x], sortData[x + 1]), 4);
            sortData[x - 1] = copyResult[0];
            sortData[x] = copyResult[1];
            sortData[x + 1] = copyResult[2];
            if (copyResult[3] != 0) x = 0;
        }

        boolean isEqual = Arrays.equals(copyData, sortData);
        if (isEqual) return true;
        return false;
    }

    public static int[] sort(int[] data, int x1, int x2, int x3) {
        int f = 0;

        while (x1 > x2 || x1 > x3) {
            f = x3;
            x3 = x1;
            x1 = x2;
            x2 = f;
        }

        int[] result = {x1, x2, x3, f};
        return result;

    }
}

