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
	HashMap<Sttring, PlaylistInfo> playlists;
	
	
	public Recommender() {

        // Initialize track and playlist HashMaps
        this.tracks = new HashMap<String, TrackInfo>();
        this.playlists = new HashMap<String, PlaylistInfo>();
	}
	
	
	/**
	 * Add the contents of a playlist file to the graph model
	 */
	public void addFile(String fileName) {
	    
	    // Create a new playlist entry for this file
	    
	    // Open the file with a Scanner
	    
	    
	    while (input.hasNextLine()) {
	        String line = input.nextLine();
	        
	        // The fields are separate by a "," sequence
	        
	        // Carve off the first and last quote characters
	        
	        // Split on "," and separate into fields
	        
	        // Add this track to the set of tracks for the current playlist
	        
	        // Add this playlist to the set of playlists that contain the current track
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
		
		// Initialize the output HashSet
		
		// Loop while the the output size is less than playlistSize
		
		    // Loop for N iterations
		
		        // Choose a track from the current playlist
		        
		        // Choose a playlist that contains the track
		    
		    // After looping for N iterations add the last track to the output set
	}

}
