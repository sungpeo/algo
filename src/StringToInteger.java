import java.util.Arrays;

public class StringToInteger {
    public static void main (String[] args) {
        System.out.println(new StringToInteger().myAtoi("42"));
        System.out.println(new StringToInteger().myAtoi("  -42"));
        System.out.println(new StringToInteger().myAtoi("4183 with words"));
        System.out.println(new StringToInteger().myAtoi("word and 987"));
        System.out.println(new StringToInteger().myAtoi("-91283472332"));
        System.out.println(new StringToInteger().myAtoi("-"));
        System.out.println(new StringToInteger().myAtoi("+"));
        System.out.println(new StringToInteger().myAtoi("  0000000000012345678"));
        System.out.println(new StringToInteger().myAtoi("000000000000000000"));
        System.out.println(new StringToInteger().myAtoi("2147483646"));
        System.out.println(new StringToInteger().myAtoi("-2147483648"));
        System.out.println(new StringToInteger().myAtoi("1095502006p8") == 1095502006);
        System.out.println(new StringToInteger().myAtoi("-2147483647") == -2147483647);

        // regex로 하면 쉬을 듯.
        // 기왕 string 처리한 김에 하다보니 케이스를 너무 많이 빼먹거나 실수하게 되네. ㅡㅡ
    }

    static int C_PLUS = 43;
    static int C_MINUS = 45;
    static int C_ZERO = 48;
    static int C_NINE = 57;
    static char[] INT_MAX = String.valueOf(Integer.MAX_VALUE).toCharArray();
    static char[] INT_MIN = String.valueOf(Integer.MIN_VALUE).substring(1).toCharArray();
    static int INT_LEN = INT_MAX.length;


    public int myAtoi(String str) {
        char[] string = swipeHeadWhitespaces(str.toCharArray());
        if (string == null || string.length==0) return 0;
        StringBuilder resultString = new StringBuilder();

        int i = 0;
        boolean sign = true;
        if (isSign(string[0])) {
            sign = string[0] == C_PLUS;
            i++;
        }

        boolean integerStarted = false;
        for (;i<string.length; i++) {
            if ( !isNumeric(string[i]) ) {
                if (!integerStarted) return 0;
                else break;
            } else {
                if (!integerStarted) {
                    if (string[i] == C_ZERO) continue;
                    else integerStarted = true;
                }
                resultString.append(string[i]);
            }
        }
//        System.out.println("resultString="+resultString.toString());
        if (isOverflowed(sign, resultString.toString().toCharArray())) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (resultString.length()==0) resultString.append(0);

            if (sign) resultString.insert(0, '+');
            else resultString.insert(0, '-');

            return Integer.valueOf(resultString.toString());
        }
    }
    private boolean isSign(char c) {
        return c == C_PLUS || c == C_MINUS;
    }
    private boolean isNumeric(char c) {
        return c >= C_ZERO && c <= C_NINE;
    }
    private boolean isOverflowed(boolean sign, char[] integer) {
        if (integer.length == INT_LEN) {
            if (sign) {
                for (int i=0; i<INT_LEN; i++) {
                    if (INT_MAX[i] != integer[i]) return INT_MAX[i] < integer[i];
                }
            } else {
                for (int i=0; i<INT_LEN; i++) {
                    if (INT_MIN[i] != integer[i]) return INT_MIN[i] < integer[i];
                }
            }
            return false;
        } else {
           return integer.length > INT_LEN;
        }
    }

    private char[] swipeHeadWhitespaces(char[] str) {
        for (int i=0; i<str.length; i++) {
            if (str[i] != ' ') {
                if (i==0) return str;
                else return Arrays.copyOfRange(str, i, str.length);
            }
        }
        return null;
    }
}
