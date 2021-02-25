/**
 * A tricky program illustrating local variable interactions
 */

public class Tricky {
  
    public static int baz(int x) {
         x = 2 * x;
         return x;
    }
  
    public static int foo(int value) {
        int x = baz(value + 1);
        return x;
    }
  
    public static void main(String[] args) {
        int x = 1;
        x = foo(x);
        System.out.println(x);
    }
  
}
