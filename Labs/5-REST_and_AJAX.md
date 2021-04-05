# Spring Boot II: REST and AJAX

## Overview

This lab is a continuation of the previous one, which introduced the Java Spring Boot framework and the concept of client-server web applications. This document focuses on enhancing your application so that it can **receive input** from the front end. Along the way, you'll be exposed to two important distributed system terms:

- **REST** - short for *Representational State Transfer*
- **AJAX** - short for *Asynchronous JavaScript and XML*

## REST

REST stands for **Representational State Transfer**. In practice, a REST API is one where each bit of code the server makes
available to clients has an associated URL. HTTP requests sent to a particular URL (typically from a client's web browser) trigger the
execution of the associated server code, which will often return an HTTP response back to the client.

As you might expect, this is a bit of simplification of REST, which in its technical description is very flexible. It doesn't have to
use HTTP; that's just the most common implementation in modern web applications.

The REST concept was developed by Roy Fielding in 2000 as part of his docotoral dissertation. He outlined six properties that a REST application should have:

1. Client-Server architecture. We've got this already. One of the major benefits of the client-server concept is that it decouples the dvelopment of the front end from the development of the back end. Both components can evolve in their own ways, but remain interoperable because they communicate through a well-defined interface.

2. Stateless. The server does not store any state or history related to its interactions with individual clients. If the client requests 
a service, it must supply all of the information that the sever needs within the request. The server can still store general data (for example, in a back-end database), but it can't maintain a memory of the requests it's received or the responses it's sent to any individual client. Statelessness improves reliability. If the sever had to maintain state on every client, recovering from failures would be extremely difficult: you'd have to reconstruct the entire chain of operations that led to each client's state at the time of the failure.

3. Cacheable. The client is allowed to cache data locally and reuse it without recontacting the server. This strategy reduces the number of messages from the client to the server. The server can supply annotations with its responses to indicate the time limit on caching each data item, or, if necessary, that data shouldn't be cached.

4. Uniform Interface. The client and server communicate through an agreed-upon protocol that isn't tied to their individual implementations. HTTP fills this role in many applications, including ours.

5. Layered System. The back-end system may actually be a collection or hierarchy of systems. For example, there may be intermediaries to implement caching closer to clients. From the client's perspective, these architectural decisions are transparent and have no effect on how it interacts with the system.

6. Code-on-Demand. Not all applications use this feature (ours doesn't). In some cases, it's beneficial to have the server send executable code to the client, which then runs on the client machine in its environment. Consider, for example, sending a bit of JavaScript that runs in the client's browser and implements some complex, customized functionality on a site.

## Interact

Update `index.html` to the following. This code introduces several new elements.

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

        <!-- The div tag creates a named region of the page -->
        <div id="responseDiv"></div>

        <!-- script tag contains JavaScript that interacts with page elements -->
        <script>
            // Set a listener function for the button click
            document.getElementById('submitButton').onclick = function () {

                // Get the current string in the text box
                var input = document.getElementById('inputBox').value;

                // Copy it to the response field
                document.getElementById('responseDiv').innerHTML = input;
            }
        </script>
    </body>
</html>
```

First, notice that there are two input elements. One is a text box and the other is a button. Each element has an `id` field, which assigns a name that can be used to interact with the element. The third page element is a `div`, which you can think of as a page division. The `div` tag creates a labeled region of the page that
has an `id`, so that you can interact with it later. This `div` is going to be used to print a response message from
the server.

The page has a `script` tag located inside the `body`. The content of the `script` is JavaScript. Notice that the commenting style
changes from HTMl to C-style comments within the tag. A basic JavaScript action is `document.getElementById`, which lets you retrieve a reference to a page element by specifying its `id` string. Notice the capitalization of `Id`; it's not `ID`!

The script illustrates three things you can do with page elements.

1. The first line assigns a function to the button element's `onclick` property. The code in this function runs when the user clicks
the button. Notice that the function is **anonymous**: it doesn't have a name. This style is very common in JavaScript programming.

2. The second call gets the current string typed in the text box by reading its `value` property in conjunction with `getElementById`.

3. The third call sets the content of the `responseDiv` element by setting its `innerHTML` property.

Clearly, this style of programming requires you to know what properties and fields are available for each element. These are standardized as part of browser specifications, but in practice you will often end up doing documentation searches to figure out exactly what field to read or set for a particular element to get the effect you want.

## Send and Receive

Now, we're going to add one more element to the JavaScript code: a call that sends information from the page to the server and receives a response.

The feature that implements this behavior is called `XmlHttpRequest`. An `XmlHttpRequest` object represents an HTTP communication with
a server. It specifies the target server URL and any body text or parameters that go along with the message. It also specifies a
listener function that will run when the client receives the server's response returns.

The style of programming that developed around `XmlHttpRequest` is called AJAX, which stands for *Asynchronous JavaScript and XML*.

- It is *asynchronous* because the client specifies a listener function that will run and handle the server's response when it arrives. The client does not have to block and wait while the request is in process. Further, it lets you process the server's response and udpate part of the interface *without reloading the entire page*.

- XML ("Extensible Markup Language") is an HTML-like markup variant that allows for arbitrary tags around data items. It is useful, but verbose. The original AJAX implementations used XML to structure data passed between clients and servers. Nowadays, there are other, more compact options for passing values. One of the most popular is *JavaScript Object Notation* (JSON), which is a text-based representation of a JavaScript object.

First, modify your `/hello` method in `Controller.java` so that it can access a parameter.

```
@RequestMapping("/hello")
public String hello(@RequestParam(value="name", defaultValue="World") String name) {
    return "Hello, " + name + "!";
}
```

Next, update `index.html` to the following:

```
<!DOCTYPE html>
<html>

    <!-- Head contains metadata on the whole document -->
    <head>
        <title>CMS 330 REST Demo</title>
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
                oReq.open("GET", "https://YOUR-MIMIR-SITE-URL/hello?name=" + input);
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

Replace `YOUR-MIMIR-SITE-URL` to the URL that Mimir generates for your site.

If your server is running, close it with `CTRL + c`, then compile and run the server again:

```
$ ./mvnw clean package
$ java -jar target/cms167-rest-example-0.1.0.jar
```

## Parameter Passing

Take a careful look at the URL in the previous example:

```
oReq.open("GET", "https://YOUR-MIMIR-SITE-URL/hello?name=" + input);
```

This line specifies that the `XmlHttpRequest` object should use HTTP's `GET` method with the given URL. Notice how the URL is extended by a `?` followed by the parameter
`name` and its value. This style of passing parmeters to web apps is very common. Google's search engine, for example, passes query strings this way. The following URL will search for the string "pointy guitars".

```
https://www.google.com/search?q=pointy+guitars
```

Here, `/search` is the URL endpoint corresponding to the search operation. The parameter `q`, the query term, is passed after a `?`. Try your own search and look at how many different parameters are passed through the URL of the search request. Most of these are conveying extra information from your browser to try and contextualize the search.



