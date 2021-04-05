# Spring Boot III: Returning an Object from the Server

## Description

This lab is the final part of the Spring Boot journey. In the previous labs we created a server and gave it the ability to respond to user input from a front-end web page. All of the server's responses, however, were either plain text or an HTML-formatted string. Now, we're going to create a server method that returns **an object**, which is a useful way of passing more complex information back to the client.

Our example will be a `/status` method, which the client can contact to get an update on the server's internal state. In this case, the server is going to track the number of requests it has satisfied and return counter value in a `Status` object, which we'll need to write.

## 

Put the following code into `Controller.java`. Most of this is the same as the previous version, with two new elements:

1. A new `/status` mapping and method.

2. A `count` class member that keeps track of the number of satisfied requests.

```
package cms330;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class Controller {

    int count;  // Number of times server has been contacted

    // Constructor initializes class members
    public Controller() {
        this.count = 0;
    }


    @RequestMapping("/")
    public String index() {
        this.count++;

        String indexHtml = null;

        try {
            byte[] bytes = Files.readAllBytes(Paths.get("html/index.html"));
    	    indexHtml = new String(bytes);
        } catch(Exception e) {
            e.printStackTrace();
        }

    	return indexHtml;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue="World") String name) {
        this.count++;
        return "<p>Hello,</p> <p>" + name + "!</p>";
    }


    // Return an object reporting the status of the server
    // Demonstrates returning an object from a REST endpoint and using class
    // members to track persistent state
    @RequestMapping("/status")
    public Status status() {
        this.count++;
        return new Status(this.count);
    }
}
```

Next, create a `Status.java` class in `src/main/java/cms167`. `Status` is a simple data blob object that wraps around a `count` variable. In practice, of course, we could add more data members to the class for other things that we want to track.

**IMPORTANT POINT**: Any object that's used to return a value from a `Controller` method **must have `get` methods for its class members**! The
Spring framework uses the getters to convert the object to a text representation prior to HTTP transmission.

```
package cms167;

/*** A state blob reporting the status of the server ***/

public class Status {
    int count;

    public Status(int count) {
        this.count = count;
    }

    /*** Classes returned via REST must have get methods for class members ***/

    public int getCount() {
        return this.count;
    }
}
```

## Test

Compile and run the project

```
./mvnw clean package

java -jar target/cms167-rest-example-0.1.0.jar
```

Now, navigate to `https://YOUR-MIMIR-WORKSPACE-URL/status`. You should see a string like the following:

```
{"count":0}
```

Refresh the page and you should see the count increment.


## JSON

Let's break down what you're seeing in that response. The controller code for the `/status` endpoint looks like this:

```
@RequestMapping("/status")
public Status status() {
    this.count++;
    return new Status(this.count);
}
```

When `status()` returns the `Status` object, the Spring Boot framework kicks in behind the scenes to convert the Java object into a **text-based representaton** that can be sent back to the client in the HTTP response. The output of that process is a list of the object's fields and their values enclosed in curly brackets, which in this case is the `count` variable and its current value.

```
{"count":0}
```

This style of passing object data is called **JavaScript Object Notation** or **JSON** and is the **most common format** for exchanging complex data between clients and servers in web applications. As its name implies, JSON was originally developed to encode text representations of objects in the JavaScript language. JS objects are collections of key-value pairs, like Java's HashMaps.  In most applications, the client will receive the JSON-encoded data, then unpack it to get the values of the individual parameters and do whatever is necessary to update the front-end page.

## Aside: What About XML?

You may have noticed that several of our terms in this lab series have referenced XML: `XmlHttpRequest` and *Asynchronous JavaScript and XML* (AJAX). XML is the *eXtensible Markup Language*. Like HTML, it uses tags in angle brackets to represent data, but XML tag names aren't restricted to a limited set like HTML tags are. XML was widely used in the early days of interactive web applications, but has mostly been supplanted by JSON. XML had the advantages of flexibility and language-independence, but was hard to parse and tended to be verbose.

## Formatting the Response on the Front End

## Front-End

Suppose that you want to present the status information as formatted HTML. You have two options:

1. Format the response data into HTML on the **server side** as a `String` and return it as a `String`. If you do this, the `String`
must be valid HTML to display properly, not plain text. In particular, you have to use `<p>` and `<br>` tags to implement paragraphs
and line breaks.

2. Return the JSON object to the client side and format it there.

Option 1 is straightforward Java text processing. Here's an example of how to implement option 2 on the front end:

```
<!DOCTYPE html>
<html>

    <!-- Head contains metadata on the whole document -->
    <head>
        <title>CMS 121 REST Demo</title>
    </head>

    <!-- Body contains the page's content -->
    <body>
        <h1>Input</h1>

        <p>Type your name in the box below and press Submit.</p>

        <input type="text" id="inputBox" />
        <button type="button" id="submitButton"> Submit </button>
        <button type="button" id="statusButton"> Status </button>

        <!-- The div tag creates a named region of the page -->
        <div id="responseDiv"></div>

        <!-- script tag contains JavaScript that interacts with page elements -->
        <script>
            // Set a listener function for the button click
            document.getElementById('submitButton').onclick = function () {

                // Get the current string in the text box
                var input = document.getElementById('inputBox').value;

                var oReq = new XMLHttpRequest();
                oReq.addEventListener("load", responseListener);
                oReq.open("GET", "https://YOUR-MIMIR-WEBSITE-URL/hello?name=" + input);
                oReq.send();
            }

            // Listener function for the status button
            document.getElementById('statusButton').onclick = function () {

                var oReq = new XMLHttpRequest();
                oReq.addEventListener("load", statusListener);
                oReq.open("GET", "https://YOUR-MIMIR-WEBSITE-URL/status");
                oReq.send();
            }

            function responseListener() {
                document.getElementById('responseDiv').innerHTML = this.responseText;
            }

            function statusListener() {
                // Convert the text body of the response to a JavaScript object
                var obj = JSON.parse(this.responseText);

                var str = 'Number of requests: ' + obj['count'];
                document.getElementById('responseDiv').innerHTML = str;
            }


        </script>
    </body>
</html>
```

Take a look at what's changed.

- There is another button with `id=statusButton`.

- This button has an `onclick` function that creates a `XMLHttpRequest` to the `/status` URL. Note that `/status` does not take
any input arguments, so nothing is appended to the URL.

- The return listener for the status request is set to `statusListener`.

- The `statusListener` function uses the built-in `JSON.parse` method to convert the JSON response string to an object, named `obj`. The
count value is now accessible using `obj['count']` (this is similar to Python's dictionaries). The rest of the method formats a string
and puts that string into the `innerHTML` property of the `responseDiv` element.

