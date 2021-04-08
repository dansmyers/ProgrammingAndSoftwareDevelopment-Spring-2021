# Finish the Compleat Shakespeare Search Engine

## Overview

This document will lead you through the steps required to finish the complete web-based search engine project. At the end, you'll have the following:

- An `index.html` page that displays an input box, a search button, and the results of the search. The index page will include code to automatically contact the server, which I've written for you.

- `Server` and `Controller` written using the Spring Boot framework. We started these in the previous class.

- The `SearchEngine` class that we wrote last week as a stand-alone application. The main goal of today's work is to incorporate what we've already written into the Spring Boot framework.

The steps of the project are as follows:

1. If you have not done so yet, add a route to display `index.html`.

2. Update the `/hello` route we wrote last time to take an input from the client and verify that you can pass parameterized requests between the client and server.

3. Create new Java files for `SearchEngine` and `Location`. These will be almost the same as the classes we wrote last week.

4. Upload `macbeth.txt` and put it in a location where the application can read it.

5. Add code to `Controller` to use and initialize the `SearchEngine`.

6. Add a `/search` route to `Controller`.

7. Format the output to make it nicer.


## Step 1: Serve `index.html`

(If you have already completed this part from the previous lab, you may go on to Step 2).

You probably have an `html/index.html` file already included in the repo. Open that file:

```
open html/index.html
```

Replace the contents of that file with the following:

```
<!DOCTYPE html>
<html>

    <!-- Head contains metadata on the whole document -->
    <head>
        <title>CMS 330 REST Demo</title>
    </head>

    <!-- Body contains the page's content -->
    <body>
        <h1>Greetings, Planet!</h1>

        <p>The server returns this page when your browser requests the root
        document of the site.</p>
    </body>
</html>
```

Add a new mapping to `Controller` to display the index page when the client requests the root of the site:

```
@RequestMapping("")
public String index() {
    String indexHtml = null;

    try {
        byte[] bytes = Files.readAllBytes(Paths.get("html/index.html"));
    	indexHtml = new String(bytes);
    } catch(Exception e) {
        e.printStackTrace();
    }

    return indexHtml;
}
```

This route uses two built-in classes, `Files` and `Paths`, that you'll need to import at the top of `Controller`:

```
import java.nio.file.Files;
import java.nio.file.Paths;
```

Build the application and re-run it:

```
./mvnw clean package

java -jar target/cms167-java-spring-boot-0.1.0.jar
```

Now view Port 80 and verify that you can load `index.html`.


## Step 2: Pass a parameter from the client to the server

Update `index.html` to the following:

```
<!DOCTYPE html>
<html>

    <!-- Head contains metadata on the whole document -->
    <head>
        <title>Search Engine</title>
    </head>

    <!-- Body contains the page's content -->
    <body>
        <h1>Input</h1>

        <p>Type your name in the box below and press Submit.</p>

        <input type="text" id="inputBox" />
        <button type="button" id="submitButton"> Submit </button>

        <!-- The div tag creates a named region of the page -->
        <div id="responseDiv"></div>

        <!-- script tag contains JavaScript that interacts with page elements -->
        <script>
            // Set a listener function for the button click
            document.getElementById('submitButton').onclick = function () {

                // Get the current string in the text box
                var input = document.getElementById('inputBox').value;

                // Create and send an HTTP request
                var oReq = new XMLHttpRequest();
                oReq.addEventListener("load", responseListener);
                oReq.open("GET", "/hello?name=" + input);
                oReq.send();
            }

            // Listener runs when the server's response comes back
            function responseListener() {
                document.getElementById('responseDiv').innerHTML = this.responseText;
            }
        </script>
    </body>
</html>
```

Take a moment and look carefully at this HTML. It is almost the same as the example interactive page we wrote last week, with an input box, a button, and a `div` to hold a result. The primary difference is a new feature, `XmlHttpRequest`, which is used to send a message from the client to the server. The most important line of the JavaScript code is this one:

```
oReq.open("GET", "/hello?name=" + input);
```

which specifies that the request should go to the `/hello` route with a parameter called `name` attached to it. The value of `name` is whatever the user typed in the input box, which is read a little higher up in the JS code.

Change the `/hello` route in `Controller` to the following

```
@RequestMapping("/hello")
public String hello(@RequestParam(value="name", defaultValue="World") String name) {
    return "Hello, " + name + "!";
}
```

This new version of `hello()` takes a `String` parameter called `name` as input and returns a message that uses `name`'s value.

Again, re-build and run the project to verify that these changes are working correctly.

## Step 3: Create new Java files for `SearchEngine` and `Location`

```
touch src/main/java/cms167/SearchEngine.java

touch src/main/java/cms167/Location.java
```

Put the following code in `Location.java`; the only changes from our previous version are to update the package to `cms167` and to remove the `main` method we wrote for testing.

```
package cms167;

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
  
}
```

Here is the code for `SearchEngine.java`. Again, this is almost identical to our previous version.

```
/**
 * Search Engine Project
 */

package cms167;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class SearchEngine {
	
	// Declaration of the index structure
	HashMap<String, ArrayList<Location>> index;
	
	
	/**
	 * Constructor -- initialize the index
	 */
	public SearchEngine() {
		this.index = new HashMap<String, ArrayList<Location>>();
		
    addFileToIndex("texts/macbeth.txt");
	}
	
	
	/**
	 * toString -- print the index
	 */
	public String toString() {
		return this.index.toString();
	}
	
	
	/**
	 * addFileToIndex -- Parse an input file and add its 
	 * words and lines to the index structure
	 * 
	 * @param fileName
	 */
	public void addFileToIndex(String fileName) {
		Scanner input = null;
		
		try {
			input = new Scanner(new File(fileName));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Extract the first line to be the title of the play
		String play = input.nextLine();

		String actNumber = null;
		String sceneNumber = null;
		
		// Iterate over the lines of the file
		while (input.hasNext()) {
			String line = input.nextLine();
			
			// Create a second Scanner to break the line
			// into its component words
			//
			// By default, the Scanner will break the line
			// into whitespace-delimited chunks
			
			Scanner words = new Scanner(line);
			while (words.hasNext()) {
				String word = words.next();
				
				// If the line starts with "ACT" then we should
				// read the next token and treat that as the act
				// number
				if (word.equals("ACT")) {
					actNumber = words.next();
					continue;
				}
				
				// Same idea for SCENE
				if (word.equals("SCENE")) {
					sceneNumber = words.next();
					continue;
				}
				
				// Move the word to lowercase
				word = word.toLowerCase();
				
				// Remove any punctuation marks
				word = word.replaceAll("[.,;!?:]", "");
				
				// Insert a mapping into the index
				
				// Initialize an empty ArrayList if the word is
				// not in the HashMap
				if (!this.index.containsKey(word)) {
					this.index.put(word, new ArrayList<Location>());
				}
				
				// Add the word --> line pair into the index
				ArrayList<Location> locations = this.index.get(word);
				
				Location loc = new Location(play, actNumber, sceneNumber, line);
				locations.add(loc);
				this.index.put(word, locations);
				
			}
		}
	}
	
	
	/**
	 * lookup -- return the lines associated with a word
	 * @param    word
	 * @return   The set of lines as an ArrayList<String>
	 */
	public ArrayList<Location> lookup(String word) {
		return this.index.get(word);
	}

}

```

## Step 4: Upload the play text

Use Mimir's `File --> Upload` menu to find `macbeth.txt` on your own computer and upload it to your top-level workspace directory. If you need to download it again, you can get it from Canvas. Once the upload completes, move it to a directory called `texts` at the top-level of the Spring Boot project:

```
mkdir texts

mv ~/macbeth.txt texts
```

Here, `~/macbeth.txt` is a shortcut to refer to a file named `macbeth.txt` in your top-level directory. `~` always refers to user's "home" directory on the file system.


## Step 5: Add the `SearchEngine` to `Controller`

Open up `Controller.java` and add a new variable at the top of the class:

```
private SearchEngine engine;
```

Create a contructor method, which will run when the application boots. `Controller`'s constructor can be used to initialize any parts of the application that must be configured before you can serve requests. In our case, that means settting up the `SearchEngine` object and building its index.

```
public Controller() {
    this.engine = new SearchEngine();
    
    // Print the engine to verify that it's being initialized correctly.
    System.out.println(this.engine);
}
```

Re-build and run the application. We haven't added any code to serve search requests yet, but you should verify that the search index is being constructed during the setup process.

## Step 6: Add a `/search` route

Add a new route to `Controller` to process search requests. This is almost identical to the previous `hello()` method and takes a parameter named `word` as input from the client. The method uses `this.engine.lookup` to retrieve the `ArrayList<Location>` associated with the given search word, then returns the `String` representation of the `ArrayList` to display on the client. This won't be pretty, but it will verify that we can do lookups and return results.

```
@RequestMapping("/search")
public String search(@RequestParam(value="word", defaultValue="") String word) {
    ArrayList<Location> results = this.engine.lookup(word);
        
    return results.toString();
}
```

The only remaining step is to update the client to contact the `/search` route. Find this line in `index.html`:

```
oReq.open("GET", "/hello?name=" + input);
```

Change it to contact `/search` with a `word` parameter rather than `/hello`:

```
oReq.open("GET", "/search?word=" + input);
```

Re-build and re-run the application. Refresh your `index` page and try it out! Wherefore art thou, search results?

## Step 7: Nicer output

The basic version just dumps the `ArrayList` of search locations to a `String`, which is almost unreadable. Update `search()` to the following, which loops through the `ArrayList` and formats each response as a separate paragraph using HTML `<p>` tags. Other formatting strategies are possible and could look even better.

```
    @RequestMapping("/search")
    public String search(@RequestParam(value="word", defaultValue="") String word) {
        ArrayList<Location> results = this.engine.lookup(word);
        
        String response = "";
        
        for (Location loc : results) {
            response += "<p>";
            response += loc.toString();
            response += "</p>"
        }
        
        return response;
    }
```
