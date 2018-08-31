import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {120, -12, 12, 1, 2, 5, 5, 9, -12, 3, 100, 3, 12, 4};
//        int found1 = solution(array);
//        System.out.println("found : " + found1);

        int[] a = {1, 2, 4, 3, 6, 2, 7, 1};
        int[] b = {1, 3, 2, 3, 9, 8, 1, 5};
        int[][] c = flipFlop(a, b);
        int[] result = result(c);
        System.out.println(max(result));
    }

    public static int max(int[] value) {
        int max = 1;
        for (int item : value) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }

    public static int[] result(int[][] possibleFlipFlop) {
        int[] result = new int[possibleFlipFlop.length];
        for (int i = 0; i < possibleFlipFlop.length; i++) {
            int[] flipFlop = possibleFlipFlop[i];
            result[i] = findLowestUnsignedInteger(flipFlop, 1, false);
        }
        return result;
    }

    public static int[][] flipFlop(int[] a, int[] b) {
        int maxFlipFlop = 2 + a.length;
        int[][] newArray = new int[maxFlipFlop][a.length];
        int newArrayCounter = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                newArray[newArrayCounter] = flip(a, b, i);
                newArrayCounter += 1;
            }
        }
        newArray[newArrayCounter] = a;
        newArrayCounter += 1;
        newArray[newArrayCounter] = b;
        newArrayCounter += 1;
        int[][] newArray2 = new int[newArrayCounter][a.length];
        System.arraycopy(newArray, 0, newArray2, 0, newArrayCounter);
        return newArray2;
    }

    public static int[] flip(int[] a, int[] b, int index) {
        int[] c = new int[a.length];
        System.arraycopy(a, 0, c, 0, a.length);
        c[index] = b[index];
        return c;
    }

    private static int findLowestUnsignedInteger(int[] array, int suspect, boolean trimmed) {
        int[] newArray = !trimmed ? new int[array.length] : new int[0];
        int nextSuspect = suspect + 1;
        boolean suspectFound = false;

        int newArrayCounter = 0;
        for (int item : array) {
            if (item == suspect) {
                suspectFound = true;
            }
            if (item == nextSuspect) {
                nextSuspect += 1;
            }
            if (item > 0 && !trimmed) {
                newArray[newArrayCounter] = item;
                newArrayCounter += 1;
            }
        }
        if (suspectFound) {
            if (!trimmed) {
                int[] newArray2 = new int[newArrayCounter];
                System.arraycopy(newArray, 0, newArray2, 0, newArrayCounter);
                Arrays.sort(newArray2);
                return findLowestUnsignedInteger(newArray2, nextSuspect, true);
            }
            return findLowestUnsignedInteger(array, nextSuspect, true);
        } else {
            return suspect;
        }
    }

}
