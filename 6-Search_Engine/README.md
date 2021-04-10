# A Compleat Shakespearean Search Engine

## Due Thursday, April 15 (or the next day if the 15th is Fox Day)


## *“Once more search with me.” - The Merry Wives of Windsor: IV, ii*

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Edwin_Landseer_-_Scene_from_A_Midsummer_Night%27s_Dream._Titania_and_Bottom_-_Google_Art_Project.jpg/2880px-Edwin_Landseer_-_Scene_from_A_Midsummer_Night%27s_Dream._Titania_and_Bottom_-_Google_Art_Project.jpg" width="50%" />

>*Scene From a Midsummer Night's Dream. Titania and Bottom*, Edwin Landseer (1848)



We have been working on building a search engine for the plays of William Shakespeare, first as a stand-alone Java application and now as a web application using Java Spring Boot. Your task is now to finish implementing the complete search engine and add a few more necessary featurs that we didn't get to in class.

Here are the remaining tasks:

- Finish building the program described in `Instructions.md` if you didn't already complete it in class.

- Add the two other play texts from Canvas (`romeo_and_juliet.txt` and `a_midsummer_nights_dream.txt`). You will need to upload them to the `texts` directory and then add code to the `SearchEngine` constructor to incorporate them into the index.

- Modify the `lookup` method of `SearchEngine` to set the search word to lowercase before checking the index. Your engine should return reasonable results independent of the case of the search word.

- The early version of the search engine will crash with an Internal Server Error if the user enters a word that isn't in the search index. Modify the code in `Controller` to return a reasonable response message if the result of the `lookup` operation is `null`.

```
if (results == null) {
    // Return a reasonable response indicating no results    
}
```

- Apply some CSS styling to `index.html` so that it looks nice. You can make your own choices about how things should look, but it should be clear that you've put some effort into improving the appearance of the page.  Remember that you might want to host this page as an example of your work that potential employers could view! Include a relevant image at the top of the page. Put all of your CSS rules in a `<style>` block in the `<head>` of `index.html`. You don't need to incorporate any other frameworks or tools.


### *"Exit, pursued by a bear." - The Winter's Tale: III, iii*

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/John_Everett_Millais_-_Ophelia_-_Google_Art_Project.jpg/2560px-John_Everett_Millais_-_Ophelia_-_Google_Art_Project.jpg" width="50%" />

> *Ophelia*, John Everett Millais (1851-2)

The complete project is worth **five points**:

- Two points for finishing the basic engine described in `Instructions.md`.

- One point for dealing with word case.

- One point for returning a reasonable response for words that aren't in the index.

- One point for styling the page

To submit, download your directory from Mimir by right-clicking (or CTRL + clicking on Mac) on it in the left-hand file browser pane. Choose "Download..." to pull a copy of the entire `cms167-f19-java-spring-boot` directory to your local computer, then submit **the entire directory** to Canvas.
