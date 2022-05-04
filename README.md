# ToDoList
Basic implementation of a RESTful "to do list" application in accordance with SOLID, created in Java Spring Boot using H2  in memory database. This project is built by response request pattern and result architecture. These patterns and architectures are key points for SOLID principles. 
First, the entities were created.
After that, data access objects were created.
After that, core level were created to contain model mapper, constant messages to replace magic strings, a custom Business Exceptions class and result classes for result type implementation.
After that, business package was created containing abstracts, concretes, dtos, requests and security packages. Abstracts package contains the interface service implementation for manager classes that are containing in concretes package. Dtos and requests contain classes to List the required objects or to take them as arguments of CRUD operation methods. For user manager classes, unit tests using Mockito were applied. Security includes basic Spring boot authentication and the "csrf" is disabled to give access of any kind of roles to use the application.
Controllers package contains the api controllers to communicate with Swagger on port 8080.
