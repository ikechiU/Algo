package _3_is_perfect_square;

public class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(7));
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(9));
    }

    public static boolean isPerfectSquare(long num) { // copied from baeldung
        if (num < 0) {
            return false;
        }
        switch((int)(num & 0xF)) {
            case 0: case 1: case 4: case 9:
                long n = (long)Math.sqrt(num);
                return n * n == num;
            default:
                return true;
        }
    }
}
