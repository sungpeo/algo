import java.util.Arrays;
import java.util.HashSet;

public class LongestPalindromicsubstring {

  public static void main(String[] args) {
    String s = "babad";
    System.out.println(new LongestPalindromicsubstring().longestPalindrome(s));
    s = "cbbd";
    System.out.println(new LongestPalindromicsubstring().longestPalindrome(s));
    s = "";
    System.out.println(new LongestPalindromicsubstring().longestPalindrome(s));
    s = "ac";
    System.out.println(new LongestPalindromicsubstring().longestPalindrome(s));
    s = "abb";
    System.out.println(new LongestPalindromicsubstring().longestPalindrome(s));
    s = "vaomxdtiuwqlwhgutkhxxhccsgvyoaccuicgybnqnslogtqhblegfudagpxfvjdacsxgevvepuwthdtybgflsxjdmmfumyqgpxatvdypjmlapccaxwkuxkilqqgpihyepkilhlfkdrbsefinitdcaghqmhylnixidrygdnzmgubeybczjceiybowglkywrpkfcwpsjbkcpnvfbxnpuqzhotzspgebptnhwevbkcueyzecdrjpbpxemagnwmtwikmkpqluwmvyswvxghajknjxfazshsvjkstkezdlbnkwxawlwkqnxghjzyigkvqpapvsntojnxlmtywdrommoltpbvxwqyijpkirvndwpgufgjelqvwffpuycqfwenhzrbzbdtupyutgccdjyvhptnuhxdwbmdcbpfvxvtfryszhaakwshrjseonfvjrrdefyxefqfvadlwmedpvnozobftnnsutegrtxhwitrwdpfienhdbvvykoynrsbpmzjtotjxbvemgoxreiveakmmbbvbmfbbnyfxwrueswdlxvuelbkrdxlutyukppkzjnmfmclqpkwzyylwlzsvriwomchzzqwqglpflaepoxcnnewzstvegyaowwhgvcwjhbbstvzhhvghigoazbjiikglbqlxlccrwqvyqxpbtpoqjliziwmdkzfsrqtqdkeniulsavsfqsjwnvpprvczcujihoqeanobhlsvbzmgflhykndfydbxatskf";
    System.out.println(new LongestPalindromicsubstring().longestPalindrome(s));
    //System.out.println(s.substring(1,3));
  }
  public String longestPalindrome(String s) {
    return approach2_bruteForce(s);
  }

  private boolean isPalindrome(char[] chars) {
    for (int i=0; i<chars.length/2 +1; i++) {
      if (chars[i] != chars[chars.length-1-i]) return false;
    }
    return true;
  }

  // timeout for vaomxdt...
  public String approach2_bruteForce(final String s) {

    char[] chars = s.toCharArray();

    // 1.added
    if (s.trim().isEmpty()) return "";
    if (isPalindrome(chars)) return s;

    for (int j=chars.length; j>1; j--) {
      // 3.added (=)
      for (int i=0; i+j<=chars.length; i++) {
        //String sub = s.substring(i, j+i);
        char[] subChars = Arrays.copyOfRange(chars, i, j+i);
        if ( isPalindrome( subChars ) ) {
            return String.valueOf(subChars);
        }
      }
    }
    // 2.added
    return s.substring(0,1);
  }
}
