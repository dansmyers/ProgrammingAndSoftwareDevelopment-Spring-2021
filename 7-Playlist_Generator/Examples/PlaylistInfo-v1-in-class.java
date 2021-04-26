/**
 * Class representing information about a playlist
 * 
 */
 
 package cms121_playlist_generator;

import java.util.ArrayList;
import java.util.Random;

public class PlaylistInfo {
	
	private String id;  // Unique id string for this playlist (this will be the same as the filename)
	private ArrayList<String> tracks;  // List of track IDs for this playlist
	
	
	public PlaylistInfo(String id) {
		this.id = id;
		this.tracks = new ArrayList<String>();
	}
	
	
	public String getTitle() {
	    return this.title;
	}
		
	
	public void addTrack(String newTrackId) {
        this.tracks.add(newTrackId);
	}
	
	
	public ArrayList<String> getTracks() {
	    return this.tracks;
	}
	
	
	/**
	 * Return the id of a randomly chosen track
	 * @return
	 */
	public String randomTrack() {
        Random r = new Random();
        int index = r.nextInt(this.tracks.size());
        return this.tracks.get(index);
	}
	
	
	public String toString() {
		return this.tracks.toString();
	}
}
