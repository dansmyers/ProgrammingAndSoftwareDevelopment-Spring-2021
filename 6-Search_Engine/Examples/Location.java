package searchEngine;

public class Location {
	
	private String play;
	private String act;
	private String scene;
	private String line;
	
	public Location(String play, String act, String scene, String line) {
		this.play = play;
		this.act = act;
		this.scene = scene.toLowerCase();
		this.line = line;
	}

	public String toString() {
		
		// MACBETH: I, ii
		// line
		
		String output = "";
		output = output + this.play + ": ";
		output = output + this.act + ", ";
		output = output + this.scene;
		output = output + "\n" + this.line;
		
		return output;
	}
	
	public static void main(String[] args) {
		Location loc = new Location("MACBETH", "I", "I", "When shall we three meet again?");
		System.out.println(loc);
	}
}
