import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abac";
        s = "abcabcbb"; //3
//        s = "bbbbb";    //1
//        s = "pwwkew";   //3
//        s = "aabaab!bb";
        int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(result);

    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        boolean[] stop = new boolean[s.length()];
        char[] input = s.toCharArray();
        for (int i=0; i<input.length; i++) {
            if(max>=input.length-i) break;
            int length = 1;
//            Checker<Character> check = new CheckBit(input[i]);
            Set<Character> check = new HashSet<>();
            check.add(input[i]);
            for(int j=i+1; j<input.length; j++) {
                if(check.contains(input[j])){
//                    System.out.println("break; " + input[j]);
                    break;
                } else {
                    length++;
                    check.add(input[j]);
//                    System.out.println("check.add " + input[j]);
                }
            }
            if(length>max) max=length;
        }
        return max;
    }
}
/*
 * this works for only small alphabets.
 */
class CheckBit {
    private int list;
    public CheckBit (char c) {
        this.list = charToBit(c);
    }
    int charToBit(char c) {
        return 1 << ((int) c - 96);
    }
    public boolean contains(Character c) {
        return (list & charToBit(c)) > 0;
    }
    public void add(Character c) {
        this.list = this.list | charToBit(c);
    }
}
