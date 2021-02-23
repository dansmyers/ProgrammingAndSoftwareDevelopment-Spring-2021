/**
 * Two recursion examples using String inputs
 */
 
public class StringRecursion {
    
    
    /**
     * Test if the input string is a palindrome
     * 
     * @param    s    Input String
     * @return   The reverse of s
     */
    public static boolean isPalindrome(String s) {
    
        // Base case: Strings of length 0 or 1 are trivially palindromes
        if (s.length() <= 1) {
            return true;
        }
        
        // If the outer characters of s do not match, it can't be a palindrome
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        
        // Recursive case: if the outer characters match, test the inner substring
        // to discover if it's a palindrome
        //
        // substring(m, n) returns String starting at position m and up to but not
        // including position n
        return isPalindrome(s.substring(1, s.length() - 1))
    
    }
    
    /**
     * Reverse a string recursively
     *
     * @param    s    Input String
     * @return   true if s is a palindrome, false otherwise
     */
    public static String reverse(String s) {
    
        // Base case: String of length 0 or 1
        if (s.length() <= 1) {
            return s;
        }
        
        // Recursive case: take off the last letter, reverse the rest, then combine
        char lastChar = s.charAt(s.length() - 1);
        String rest = s.substring(0, s.length() - 1);
        
        return lastChar + reverse(rest);
    }
}
