// Use a method to print a message
// CMS 167

public class FirstMethod {
    
    public static void printMessage() {
        System.out.println("Hello, there! I'm printing this from within a method.");
        System.out.println("Every you time you call printMessage, it prints these two lines.");
    }
    
    
    public static void main(String[] args) {     
        
        System.out.println("This line prints before calling the method.");
        
        printMessage();
        
        System.out.println("This line prints after returning from the method.");
        
    }

}
