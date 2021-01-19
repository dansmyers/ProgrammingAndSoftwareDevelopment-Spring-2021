// Exchanging two variables using a temporary value
// CMS 121

public class SwapExample {

    public static void main(String[] args) {
        int firstValue = 1000;
        int secondValue = 1;
    
        int temp = firstValue;
    
        firstValue = secondValue;
        secondValue = temp;
    }
  
}
