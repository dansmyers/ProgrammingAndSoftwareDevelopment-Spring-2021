package cms121_playlist_generator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Recommender {
	
	// Declare HashMap<String, TrackInfo> and HashMap<String, PlaylistInfo>
	// to represent the graph model
	
	HashMap<String, TrackInfo> tracks;
	HashMap<String, PlaylistInfo> playlists;
	
	
	public Recommender() {

        // Initialize track and playlist HashMaps
        this.tracks = new HashMap<String, TrackInfo>();
        this.playlists = new HashMap<String, PlaylistInfo>();
        
        // Add the playlist files to the graph model
        // Add as many lines here as you need to for your own data
        addFile("playlists/90s_boy_bands.csv");
	}
	
	
	/**
	 * Add the contents of a playlist file to the graph model
	 */
	public void addFile(String fileName) {
	    
	    // Create a new playlist entry for this file
	    String playlistId = fileName;
	    PlaylistInfo pl = new PlaylistInfo(playlistId);
	    this.playlists.put(playlistId, pl);
	    
	    
	    // Open the file with a Scanner
	    Scanner input = null;
	    try {
	        input = new Scanner(new File(fileName));
	    } catch(FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    // Read and ignore the first line -- it contains the field identifiers
	    input.nextLine();
	    
	    
	    while (input.hasNextLine()) {
	        String line = input.nextLine();
	        System.out.println(line);
	        
	        // The fields are separate by a "," sequence
	        
	        // Carve off the first and last quote characters
	        // This statement pulls out the substring from position 1
	        // up to but not including the last character in the string
	        line = line.substring(1, line.length() - 1);
	        
	        // Split on "," and separate into fields
	        String[] fields = line.split(",");
	        
	        String trackId = fields[0];  // unique track identifier
	        String title = fields[1];  // track title
	        String artistId = fields[2];  // unique artist identifier
	        String artist = fields[3];  // name of artist
	        
	        // Add this track to the set of tracks for the current playlist
	        this.playlists.get(playlistId).addTrack(trackId);
	        
	        // Add this playlist to the set of playlists that contain the current track
	        if (!this.tracks.containsKey(trackId)) {
	            TrackInfo newTrack = new TrackInfo(trackId, title, artist);
	            this.tracks.put(trackId, newTrack);
	        }
	        
	        this.tracks.get(trackId).addPlaylist(playlistId);
	    }
	    
	}
	
	
	/**
	 * Perform a series of random walks on the bipartite graph to
	 * return a randomly generated playlist
	 * 
	 * @return  HashSet<String> containing the IDs of the selected tracks
	 * 
	 * HashSet disallows duplicates, which means the same song can't be
	 * included multiple times
	 */ 
	public HashSet<String> randomWalk(int playlistSize) {
		
		// Set a starting playlist
		String pl = "playlists/90s_boy_bands.csv";
		String nextTrack = null;
		
		// Initialize the output HashSet
		// HashSet is like HashMap, but it implements a set of values
		// HashSet does not allow duplicates
		// If the same song gets picked more than once, the HashSet
		// will automatically reject putting in duplicates
		HashSet<String> output = new HashSet<String>();
		
		// Loop while the the output size is less than playlistSize
		while (output.size() < playlistSize) {
		
		    // Loop for N iterations
		    for (int i = 0 ; i < 100; i++) {
		
		        // Choose a track from the current playlist
		        nextTrack = this.playlists.get(pl).randomTrack();
		        
		        // Choose a playlist that contains the track
		        pl = this.tracks.get(nextTrack).randomPlaylist();
		        
		    }
		    
		    // After looping for N iterations add the last track to the output set
		    output.add(nextTrack);
		}
		
		return output;
	}

}
