/**
 * Echo using a loop until the user types "stop"
 *
 * @author CMS 167
 */
 
import java.util.Scanner;
 
public class Echo {

    /**
     * Main
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        boolean echoing = true;
        
        while(echoing) {
            String line = input.nextLine();
            System.out.println(line);
            
            if (line.equals("stop")) {
                echoing = false;
            }
        }
    }
    
}
