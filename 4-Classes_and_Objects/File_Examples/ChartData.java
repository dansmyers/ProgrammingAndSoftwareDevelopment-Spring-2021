import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ChartData {

	public static void main(String[] args) {
		Scanner fileInput = null;
		
		try {
			fileInput = new Scanner(new File("billboard_chart_data.txt"));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (fileInput.hasNext()) {
			String line = fileInput.nextLine();
			
			// Make a second Scanner to process the line
			Scanner s = new Scanner(line);
			
			// Tell Scanner s to use ; as its delimiter
			s.useDelimiter(";");
			
			// Read through the five entries on each line
			String artist = s.next();
			String title = s.next();
			int year = s.nextInt();
			int maxChartPos = s.nextInt();
			int weeks = s.nextInt();
			
			if (artist.equals("Prince")) {
				System.out.println(title);
			}
			
		}
 
	}

}
