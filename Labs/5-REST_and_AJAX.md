# Spring Boot II: REST and AJAX

## Overview

This lab is a continuation of the previous one, which introduced the Java Spring Boot framework and the concept of client-server web applications. You're going to modify the application

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
