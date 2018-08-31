public class Main2 {

    public static void main(String[] args) {
        int[] c = {1, 4, 3, 23, 13, -1, 3, 2};
        System.out.println(solution(c));

        System.out.println(solution4(5, 8));
    }

    public static int solution(int[] A) {
        int count = 0;
        for (int item: A) {
            count += 1;
            if (item == -1) {
                return count + 1;
            }
        }
        return count;
    }

    public static int solution4(int A, int B) {
        int C = A * B;
        int bit1Count = 0;
        while (C != 0) {
            if (C % 2 == 1) {
                bit1Count += 1;
            }
            C = C / 2;
        }
        return bit1Count;
    }

}
