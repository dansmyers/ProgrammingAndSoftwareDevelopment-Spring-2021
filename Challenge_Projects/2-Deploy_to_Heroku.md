# Challenge Project: Deploy to Heroku

## Description

This project is to be completed after you finish the Search Engine project.

Suppose you want to deploy your finished Shakespeare search engine to the web so it can be publicly accessible? You have a few options:

- You could buy your own computer to use as a server, set it up to run your application and serve pages, connect it to the Internet, and configure a domain name to point to it.

- You could **rent** infrastructure from a cloud provider, like Amazon's EC2. These services allow you to deploy apps that run on **another company's** infrastructure so you don't have to undertake the overhead of mainintaing and configuring your own hardware. There is still, however, nontrivial complexity involved in getting cloud infrastructure up and running.

Heroku is a "platform as a service." It provides a simplified interface to deploy applications to Amazon EC2. Briefly, as a developer, you can write your code and then push it to Heroku's servers, which handle all of the back-end work to deploy your app on Amazon's cloud platform and make it publicly accessible. **This is very cool**.

In this project, you're going to take your search engine and deploy it to Heroku. This doesn't require any additional coding, but will allow you to get additional practice with the command line and git. At the end, you'll have a working web app tied to a URL that you can share with anyone interested in your work.

## Submission

Complete the steps below to deploy your app. At the end of the process you should have a complete version of the application running on a Heroku URL. Send me the URL and answers to the questions below on Slack. I'll check everything out and give you credit for this project.

## Setup
First, finish the search engine. You can contine to update your app after it's deployed to Heroku, but it will be easier if you have all of the funtionality in place before you complete the steps below. In particular, make sure that you can successfully build the project using `./mvnw clean package`.

Next, sign up for a Heroku account. This is **free** for personal development projects &ndash; Heroku allows a basic account to run apps for about 1000 hours per month and pauses your apps once they go idle for 30 minutes.

The first major step is to install Heroku's tools. Within Mimir, download and install the Heroku command-line interface (CLI). The command below pulls the CLI from Heroku's servers and installs it to your local Mimir session. The local session is cleared when your Mimir workspace shuts down, so you'll need to re-run this command to reinstall the CLI if you want to use it later.

```
curl https://cli-assets.heroku.com/install.sh | sh
```

Log in to Heroku from the command line and enter your credentials:

```
heroku login -i
```

## Version Control and Git

There are multiple ways to deploy a Heroku application. We're going to take advantage of the fact that the search engine is already in a Git repo and use Heroku's support for Git-based deployment.

Before proceeding, read the following articles and answer these questions about Git and version control systems.

- https://www.atlassian.com/git/tutorials/what-is-version-control
- https://guides.github.com/introduction/git-handbook/ (The first three sections, up to and including "Basic Git Commands." You don't have to memorize the commands.)

- What are three primary benefits of version control systems in general?
- Name at least two other version control sytsems besides Git.
- What does it mean to say that Git is a "distributed version control system?" How is that different from a non-distibuted system?
- What is a Git repository?
- Give general definitions of the terms "commit" and "merge" as they apply to Git.

## Deploy

### Git repos

You can now `cd` into your project directory.

```
cd cms167-f19-java-spring-boot
```

Recall that we created this directory by cloning it from a Git repository hosted on GitHub. You can verify that this directory is a Git repo by looking for a special `.git` subdirectory. Names that start with `.` are considered "hidden" by the Linux shell, which only means that they don't show up in the output of a regular `ls` command. To view "hidden" files and directories use

```
ls -a
```

**Question**: Do some research to discover the purpose of the `.git` folder. What does it contain, in general terms?

### Heroku project

Create a new Heroku project.

```
heroku create
```

This command will assign you a new project URL on Heroku's domain. It will also create a connection to a remote Git repository stored on Heroku's servers that you will use as the deployment point for your code in a moment.

### Commit and push

Git, like all version control systems, exists to track changes to projects. However, **Git does not automatically track every change you make to a file in the repo**. Instead, you must manually **commit** your changes to make Git record them. Therefore, all of the changes you have made since you downloaded the initial `cms167-f19-java-spring-boot` directory must be committed before you can send the complete app to Heroku.

To commit, you must first **stage** the new and updated files. Use the following command to stage all changes made within the repo:

```
git add .
```

You can view the list of staged changes with 

```
git status
```

Commit the changes to the local repository. The `-m` flag specifies a message describing the nature and purpose of the commit and is required.

```
git commit -m "Search engine app"
```

You will see some output showing that Git has incorporated your changes into the local repository, modifying some files and creating others.

To deploy, **push** the contents of your Git repo on Mimir to the remote Git repo on Heroku. When you do this, Heroku's machinery will kick in to build the project and automatically deploy it to the web:

```
git push heroku master
```

You should see a ot of output indicating that Heroku is building the project. If your project compiled with `./mvnw` then the build should succeed. If it does fail, examine the output to learn what caused the error. When the build finishes, your completed app will be running at the Heroku URL. Check it out and verify that it works!

### Making further changes

You may want to continue making updates to the application. This is easy.

- You **don't** need to create a new Heroku project. Keep using the same project.
- Make and test your changes on Mimir, just as you did when originally building the app.
- When you have the app working the way you want, repeat the Git commands given above to add, commit, and push the project changes.
- There's no limit to how many times you can update the app, but Heroku will only build and deploy one new version at a time.
