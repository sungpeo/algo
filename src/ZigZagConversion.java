import java.util.LinkedList;

public class ZigZagConversion {

    public static void main (String[] args) {
        String s = null;
        int numRows = 0;


        s = "PAYPALISHIRING";
        numRows = 3;
        System.out.println(new ZigZagConversion().convert(s, numRows));

        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println(new ZigZagConversion().convert(s, numRows));

        s = "ABC";
        numRows = 2;
        System.out.println(new ZigZagConversion().convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        if (numRows<0) return null;
        if (numRows==1) return s;

        char[] inputChars = s.toCharArray();

        // if numRows >= 2
        LinkedList<Character>[] lists = new LinkedList[numRows];
        for (int i=0; i<numRows; i++) {
            lists[i] = new LinkedList<>();
        }
        int k = 2 * numRows - 2;
        for (int i=1; i<=inputChars.length; i++) {
            int k1 = i%k;

            if (k1==0) lists[1].add(inputChars[i-1]);
            else if (k1<=numRows) lists[k1-1].add(inputChars[i-1]);
            else lists[k-k1+1].add(inputChars[i-1]);
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i<numRows; i++) {
            //result.append("i="+i+":");
            for (Character c: lists[i]){
                result.append(c);
            }
        }
        return result.toString();
    }
}
