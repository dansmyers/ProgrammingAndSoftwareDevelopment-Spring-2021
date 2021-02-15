// An example of calling multiple methods
// CMS 167

// What is the output of this program?

public class MultipleMethods {

    public static void methodOne() {
        System.out.println("Spam.");
    }
    
    
    public static void methodTwo() {
        System.out.println("Eggs");
    }
    
    
    public static void main(String[] args) {
        methodOne();
        
        methodTwo();
        
        methodOne();
    }

}
