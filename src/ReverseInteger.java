public class ReverseInteger {
    public static void main (String[] args) {
        System.out.println(new ReverseInteger().reverse(123));
        System.out.println(new ReverseInteger().reverse(-123));
        System.out.println(new ReverseInteger().reverse(120));

        // 0
        System.out.println(new ReverseInteger().reverse(1534236469));

    }

    //Note:
    //Assume we are dealing with an environment
    // which could only store integers within the 32-bit signed integer range:
    // [−231,  231 − 1].
    //For the purpose of this problem,
    // assume that your function returns 0 when the reversed integer overflows.
    public int reverse(int x) {
        int rev = 0;
        while (x!=0) {
            int pop = x % 10;
            x /= 10;

            int new_rev = rev * 10 + pop;
            if ((new_rev-pop)/10 != rev) return 0;
            else rev = new_rev;
        }
        return rev;
    }
}
