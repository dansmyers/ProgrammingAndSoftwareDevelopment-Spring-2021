# Intro to Web Programming and Java Spring Boot

## Overview

**Web programming** is the body of techniques that make it possible to deliver high-quality software through a web browser over the
Internet.

For a company, web-based software has a lot of advantages:

- The software runs on the company's own servers, in its own datacenter (or in a datacenter where the company has rented machines). There
are no issues with managing different versions of the application installed across a huge user base.

- Updates and bug fixes are easier, since the developers can just push them to the production servers in the datacenter. Of course, you 
need a robust testing infrastructure to make sure that new features don't break any existing features.

- Web-based delivery naturally lends itself to selling **Software as a Service** (SaaS) on a subscription model. The economics of growing
a SaaS business beyond the entry level are very favorable to companies, so most high-value startups have followed this approach.

There are **many** different frameworks that have been created to support web programming, in pretty much every language you can think of
plus some that you can't.

In this series of labs, we're going to practice developing some web apps using Spring Boot, a web programmming framework for Java.
Spring is a set of tools and classes in Java for building Big Freaking Enterprise Software Applications. Spring Boot is a
"batteries included" subset of Spring that's intended to help you get a new application off the ground quickly. For that reason, some
things in Spring Boot **just are the way they are**.

This project is going to introduce several new concepts:

- Using a build system and a configuration file
- Using packages to organize source code
- Building executable JAR files
- Running a web server
- Creating a controller with HTTP routes
- Creating and formatting web pages

## Web App Architecture

All of our programs so far have been developed, compiled, and run on one computer. Now we're going to introduce the idea of 
**distributed computing**, where the functions of an application can be spread over multiple computers.

The big division in a web app is between the **client side** (or **front end**) of the application and the **server side** (or **back end**) 
of the application.

- The client side is the user's computer, running a web browser. The interface to the application is a web page, displaying whatever
elements the app needs to display to interact with the user.

- The server side is one or more computers running in a datacenter somewhere in the world. The front-end client sends requests to the
back-end servers over the Internet, using the HTTP protocol (I'll say more about HTTP in a future class). The server receives the HTTP
requests, processes them according to the logic of the application, then returns an appropriate response back to the client.

Consider, for example, a Google web search:

- The front end is a basic web page with a box to type a search query.

- When you type a query and press ENTER, your request is sent over the Internet (using HTTP) to a set of servers running in a Google
datacenter.

- The Google servers receive your request message, unpack your query, and do all of the very complicated processing required
to pull search results from the Google index, rank them, and combine the results with things like ads.

- At the end of the search process, the result is a web page containing your ordered search results plus ads. The Google servers send
this back to your computer as an HTTP response message and your web browser displays the updated page.

The client-server approach creates a **division of labor** within the application:

- The front end is responsible for displaying pages, collecting user input, and generating requests to the server, but it doesn't have to
manage complex data or do computationally intensive processing.

- The back end is responsible for complex data processing and information management that could never be handled by the client's own
computer.

- The Internet provides the communication medium that lets the client and the server exchange requests and responses.


## Getting the Lab Files

Alright, let's dig in to the lab.

You need a bunch of things to establish the Spring Boot app, so I've collected them for you in a GitHub repository. You're going to **clone**
repo to your work space.

```
git clone https://github.com/rollinscs/cms167-f19-java-spring-boot
```

That command will pull files from a GitHub repository and create a new directory named `cms167-f19-java-spring-boot`. Change to it:

```
cd cms167-f19-java-spring-boot
```

Use `ls` to view files:

```
ls
```

## Build Tools

We used `javac` to manually build all of our previous programs. Building complex applications by hand is undesirable, so Spring uses
a dedicated **build tool** to manage the compilation process.

Spring Boot projects use one of two build tools: **Maven** or **Gradle**. We're going to use Maven because it's the first one that
I got to work. These tools can be finicky. Just warning you.

`mvnw` is the actual Maven application.

The rules to build the project are in the `pom.xml` file. **DO NOT EDIT THIS FILE UNDER ANY CIRCUMSTANCES**.
You can view it with `cat`:

```
cat pom.xml
```

XML (the eXtensible Markup Language) is like HTML: it uses a hierarchy of tags to structure information. Right now, we don't really
care about anything that's in this file. One thing you can notice is the `artifactId` tag that appears near the top of the file: it
controls the name of the resulting application.

## The Source

The actual project code is in a series of subdirectories under `src`, which stands for "source code". Spring, as you might expect,
has some rules about where it expects to find the files that it compiles. Open the `Hello.java` file:

```
open src/main/java/cms167/Hello.java
```

The class is a basic Hello World program.

Notice that it's been placed in `package cms167`, because it's located in the `cms167` directory. Spring requires that every file it
builds be labeled with a `package` that matches its directory.

## Can We Build It?

Bulid the project:

```
./mvnw clean package
```

This will download, like, 100 billion files.


When it finishes, the application it built will be in the `target` directory as a `jar` archive. `jar` files are Java executables.
Each `jar` is an archive that packs up all of the classes for a project into a single file that the Java Virtual Machine (JVM) can
run.

Run the program:

```
java -jar target/cms167-java-spring-boot-0.1.0.jar
```

The program prints `Hello, World!` to the terminal.

## Take a REST

Create two new files: `Server.java` and `Controller.java` in the same directory as `Hello.java`.

```
touch src/main/java/cms167/Server.java
```

```
touch src/main/java/cms167/Controller.java
```

Code for `Server.java`:

```
package cms167;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server {

    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}
```

Code for `Controller.java`:

```
package cms167;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Friend!";
    }
}

```

Save both files, then compile and run the application again.

```
./mvnw clean package
```
```
java -jar target/cms167-java-spring-boot-0.1.0.jar
```

You will see the program print out a large amount of text to the program: this time, it's actually starting up a web server. The `Server`
class takes care of all that for you.

In your Mimir IDE, go to `View --> View Port --> Port 80`. This will open up a new browser tab with an address like

```
https://distracted-mimir_80.ide.mimir.io
```

The actual name will be the name of your Mimir workspace. You will see an error page the first time you open the window, saying something like "Whitelabel Error Page". **This is fine**.

**To view your page**, change the URL address by adding `/hello` to the end:

```
https://distracted-mimir_80.ide.mimir.io/hello
```

If everything worked, you should see the hello message printed in your browser window.

## What's Going On?

Let's talk about the `Controller` class and what it's doing.

- Every method inside `Controller` is associated with a web address through the `@RequestMapping` annotation. The `hello` method is associated with the `/hello` web address.

- When the server receives an HTTP request for the `/hello` URL, it redirects the flow of control to the appropriate method in `Controller`, which is `hello` in this case.

- The `hello` code runs and returns a `String`.

- The Spring framework automatically packs that `String` into an HTTP response message and sends it back to the client, where it appears in the client's web browser.

A **route** is an association between a web URL and a piece of server code.

## New Routes

Try adding a route for the `/goodbye` URL. Your code should look like the `hello` example, including an `@RequestMapping` annotation.

**Stop the server using ctrl + C**, then rebuild the project

```
./mvnw clean package
```

Run the server again

```
java -jar target/cms167-java-spring-boot-0.1.0.jar
```

And navigate to the goodbye route:

```
https://distracted-mimir_80.ide.mimir.io/goodbye
```

You should see your goodbye message appear in the browser.

Try adding a few more routes. You can add a default route for the base web page using `RequestMapping("")`.

## Page

Okay, let's do some practical stuff.

Create a top-level directory called `html` and add a file to it called `index.html`. **This goes in the top-level directory**, not in the `src` subdirectories.

```
mkdir html
```

```
touch html/index.html
```

Put the following HTML code into `index.html`:

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

Next, add a new mapping to `Controller.java`. This mapping will load and return the contents of `index.html` when the user requests the root page of the application. You need to add two imports to the top of the file.
```
import java.nio.file.Files;
import java.nio.file.Paths;
```

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

The snippet of code loads the contents of `index.html` as a `byte` array, then converts the array to a `String` and returns it. The Spring framework does all the word of turning that return value into an HTTP response and routing it back to the client.

Build your app and run it from the command line.

```
./mvnw clean package
```

```
java -jar target/cms167-java-spring-boot-0.1.0.jar
```

When the server starts, reload your page by going to `View --> View Ports --> Port 80`. You should see the page load in your browser window.
