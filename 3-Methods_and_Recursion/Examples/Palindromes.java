/**
 * Recursive method that verifies if a string is a palindrome
 */

public class Palindrome {
 
  public static boolean isPalindrome(String s) {

      // Base case: length 0 or 1 is trivially a palindrome
      if (s.length() <= 1) {
          return true;
      }

      // Other stopping case: if outer letters don't match, return false
      if (s.charAt(0) != s.charAt(s.length() - 1)) {
          return false;
      }

      // Recursive case: check if the inner substring is a palindrome
      //
      // substring(1, n) returns the substring starting at index 1 and going up to index n - 1 
      
      String inner = s.substring(1, s.length());
      return isPalindrome(inner);
  }
  
}
