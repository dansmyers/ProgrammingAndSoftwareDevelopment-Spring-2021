// One method can call another one
// CMS 167

// What is the output of this program?

public class MethodsCallingMethods {

    public static void messageOne() {
        System.out.println("Hello.");
        messageTwo();
    }
    
    public static void messageTwo() {
        System.out.println("Is it me you're looking for?");
    }
    
    public static void main(String[] args) {
        messageOne();
    }

}
